package com.example.geekshopappbuy.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geekshopappbuy.data.RetrofotIstance
import com.example.geekshopappbuy.data.entity.groups.ResultGroupSearch
import com.example.geekshopappbuy.domain.entitys.GeekGroupUI
import com.example.geekshopappbuy.domain.entitys.GeekProductUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainVievModel @Inject constructor(private val application: Application) : ViewModel() {

    private var _finishApp = MutableLiveData<Unit>()
    val finishApp: LiveData<Unit>
        get() = _finishApp

    private var _navigateToGoods = MutableLiveData<Unit>()
    val navigateToGoods: LiveData<Unit>
        get() = _navigateToGoods

    private var _listAllGroups = MutableLiveData<List<GeekGroupUI>>()
    val listAllGroups: LiveData<List<GeekGroupUI>>
        get() = _listAllGroups

    private var _listProductsByGroup = MutableLiveData<List<GeekProductUI>>()
    val listProductsByGroup: LiveData<List<GeekProductUI>>
        get() = _listProductsByGroup

    private var _listGroupCurrent = MutableLiveData<List<GeekGroupUI>>()
    val listGroupCurrent: LiveData<List<GeekGroupUI>>
        get() = _listGroupCurrent

    private val _isSplashScreenActive = MutableStateFlow(true)
    val isSplashScreenActive = _isSplashScreenActive.asStateFlow()

    private var _myResponse = MutableLiveData<Response<ResultGroupSearch>>()
    val myResponse: LiveData<Response<ResultGroupSearch>>
        get() = _myResponse

    init {
        viewModelScope.launch {
            loadListGroup()
            delay(600)
            _isSplashScreenActive.value = false
        }
    }

    private suspend fun loadListGroup() {
        val result = RetrofotIstance.api.getAllGroups()
        if (result.isSuccessful) {
            Log.d("MY_TAG", "good")
            result.body()!!.groups!!.forEach {
                Log.d("MY_TAG", "parent id ${it!!.parentGroupId}")
                Log.d("MY_TAG", "name ${it!!.name}")
            }
            val converted = result.body()!!.groups!!.map {
                it!!.mapToUiModel()
            }
            _listAllGroups.postValue(converted)
        } else {
            // error
            Log.d("MY_TAG", "error")
            Log.d("MY_TAG", "${result.code()}")
        }
    }

    fun sortGroupsByParentId(parentId: Int = PARENT_MAIN_GROUP_ID) {
        val preList = mutableListOf<GeekGroupUI>().apply {
            addAll(listAllGroups.value!!)
        }
        _listGroupCurrent.value = preList!!.filter {
            it.parentGroupId == parentId
        }
        if (_listGroupCurrent.value.isNullOrEmpty()) {
            Log.d("MY_TAG", "empty, there no more groups inside")
            _navigateToGoods.value = Unit
        } else {
            Log.d("MY_TAG", "there YES groups inside")
        }
    }

    suspend fun loadProductsByGroupId(groupId: Int) {
        val result = RetrofotIstance.api.getProductsByGroupID(groupId)
        if (result.isSuccessful) {
            result.body()!!.products!!.forEach {
                Log.d("MY_TAG", "Product name: ${it!!.name}, group id is ${it!!.group!!.id}")
            }

        } else {
            Log.d("MY_TAG", "error")
            Log.d("MY_TAG", "${result.code()}")
        }
    }

    suspend fun chechIsThereGroupsInside(groupId: Int) {

    }


    companion object {
        private const val PARENT_MAIN_GROUP_ID = 98516684
        private const val PARENT__GROUP_ID_MARVEL_DC = 99009780
    }
}