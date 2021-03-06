package com.slicedwork.slicedwork.presentation.viewmodel.registeruser

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.slicedwork.slicedwork.util.validator.UserValidator
import javax.inject.Inject

class GetEmailViewModel @Inject constructor() : ViewModel() {
    var enabledNextLiveData: MutableLiveData<Boolean> = MutableLiveData()
    var emailLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        enabledNextLiveData.value = false
        emailLiveData.value = ""
    }

    fun afterTextChanged(editable: Editable) {
        enabledNextLiveData.value =
            UserValidator().validateEmail(emailLiveData.value.toString())
    }
}