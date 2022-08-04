package com.example.geekshopappbuy.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.geekshopappbuy.R
import com.example.geekshopappbuy.data.RetrofotIstance
import com.example.geekshopappbuy.databinding.FragmentWelcomeBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
@FragmentScoped
class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding?: throw RuntimeException("ActivityMainBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRequest.setOnClickListener {
//            lifecycleScope.launch(Dispatchers.IO) {
//                val result = RetrofotIstance.api.getAllGroups()
//
//                if (result.isSuccessful){
//                    Log.d("MY_TAG", "good")
//                    Log.d("MY_TAG", "result is ${result}")
//                    val a = result.body()!!.groups!!.map {
//                        it!!.image?.replace("w200_h200","w500_h500" )
//                    }
//                    a.forEach {
//                        Log.d("MY_TAG", "result is ${a}")
//                    }
//                }
//                else{
//                    Log.d("MY_TAG", "error")
//                    Log.d("MY_TAG", "${result.code()}")
//                    Log.d("MY_TAG", result.message())
//                }
//            }
            findNavController().navigate(R.id.action_welcomeFragment_to_groupFragment)
        }
        binding.btnStartScreenContactUs.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_contactsFragment)
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}