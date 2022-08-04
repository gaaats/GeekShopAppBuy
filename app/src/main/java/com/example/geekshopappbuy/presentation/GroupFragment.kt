package com.example.geekshopappbuy.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.geekshopappbuy.R
import com.example.geekshopappbuy.databinding.FragmentGroupBinding
import com.example.geekshopappbuy.domain.entitys.GeekGroupUI
import com.example.geekshopappbuy.presentation.adapters.GroupsListAdapter
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@AndroidEntryPoint
@FragmentScoped
class GroupFragment : Fragment() {

    private lateinit var converted: List<GeekGroupUI>

    @Inject
    lateinit var groupAdapter: GroupsListAdapter

    private val mainViewModel by activityViewModels<MainVievModel>()

    private var _binding: FragmentGroupBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("ActivityMainBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGroupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        mainViewModel.navigateToGoods.observe(viewLifecycleOwner){
            findNavController().navigate(R.id.action_groupFragment_to_productsFragment)
        }

        initOnGroupClickListener()
        binding.recViev.adapter = groupAdapter
        mainViewModel.sortGroupsByParentId()
        mainViewModel.listGroupCurrent.observe(viewLifecycleOwner) {
            groupAdapter.submitList(it)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initOnGroupClickListener() {
        groupAdapter.setOnItemClickListener {
            Toast.makeText(requireContext(), "group id: ${it}", Toast.LENGTH_SHORT).show()
//            lifecycleScope.launch {
//                mainViewModel.loadProductsByGroupId(it)
//            }

            // it`s good vork
            mainViewModel.sortGroupsByParentId(it)
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}