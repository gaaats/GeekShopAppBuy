package com.example.geekshopappbuy.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geekshopappbuy.data.entity.groups.ResultGroupSearch
import com.example.retrofitrequestsimpletest1.api.response.GeekResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainVievModel @Inject constructor(private val application: Application) : ViewModel() {

    private val _isSplashScreenActive = MutableStateFlow(true)
    val isSplashScreenActive = _isSplashScreenActive.asStateFlow()

    private var _myResponse = MutableLiveData<Response<ResultGroupSearch>>()
    val myResponse: LiveData<Response<ResultGroupSearch>>
        get() = _myResponse

    init {
        viewModelScope.launch {
            delay(600)
            _isSplashScreenActive.value = false
        }
    }
}