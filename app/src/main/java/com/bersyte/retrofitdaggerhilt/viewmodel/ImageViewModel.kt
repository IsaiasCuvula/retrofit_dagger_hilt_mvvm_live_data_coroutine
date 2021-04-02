package com.bersyte.retrofitdaggerhilt.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bersyte.retrofitdaggerhilt.model.ImageItem
import com.bersyte.retrofitdaggerhilt.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewModel
@Inject
constructor(private val repository: ImageRepository) : ViewModel() {

    private val _response = MutableLiveData<List<ImageItem>>()

    val responseImages: LiveData<List<ImageItem>>
        get() = _response


    init {
        getAllImages()
    }

    private fun getAllImages() = viewModelScope.launch {

        repository.getAllImages().let { response ->

            if (response.isSuccessful) {
                _response.postValue(response.body())
            }else{
                Log.d("your tag",
                    "getAllImages Error: ${response.errorBody()}")
            }

        }

    }


}
























