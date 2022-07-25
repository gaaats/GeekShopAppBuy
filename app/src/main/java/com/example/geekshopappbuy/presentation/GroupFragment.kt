package com.example.geekshopappbuy.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ListAdapter
import com.example.geekshopappbuy.R
import com.example.geekshopappbuy.data.RetrofotIstance
import com.example.geekshopappbuy.databinding.FragmentGroupBinding
import com.example.geekshopappbuy.databinding.FragmentItemsInsideGroupBinding
import com.example.geekshopappbuy.domain.entitys.GeekGroupUI
import com.example.geekshopappbuy.presentation.adapters.GroupsListAdapter
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
@FragmentScoped
class GroupFragment : Fragment() {

    private lateinit var converted: List<GeekGroupUI>

    @Inject
    lateinit var groupAdapter: GroupsListAdapter

    private var _binding: FragmentGroupBinding? = null
    private val binding get() = _binding?: throw RuntimeException("ActivityMainBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGroupBinding.inflate(inflater, container, false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        lifecycleScope.launch(Dispatchers.IO) {
            val result = RetrofotIstance.api.getAllGroups()
            if (result.isSuccessful){
                Log.d("MY_TAG", "good")
                result.body()!!.groups!!.forEach {
                    Log.d("MY_TAG", "parent id ${it!!.parentGroupId}")
                    Log.d("MY_TAG", "name ${it!!.name}")
                }
                converted = result.body()!!.groups!!.map {
                    it!!.mapToUiModel()
                }
                val res = converted.filter {
                    it.parentGroupId == 98516684
                }.shuffled()
//                converted.forEach {
//                    Log.d("MY_TAG", "id ${it.id}")
//                    Log.d("MY_TAG", "id ${it.name}")
//                    Log.d("MY_TAG", "parent ${it.parentGroupId}")
//                }
                groupAdapter.submitList(res)
                withContext(Dispatchers.Main){
                    binding.recViev.adapter = groupAdapter
                }
            }
            else{
                Log.d("MY_TAG", "error")
                Log.d("MY_TAG", "${result.code()}")
            }
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}