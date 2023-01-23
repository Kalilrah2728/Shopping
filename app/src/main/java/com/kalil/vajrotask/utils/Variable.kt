package com.twinkle.ncsl.projectutils

import androidx.lifecycle.MutableLiveData

interface Variable {
    companion object {

        var InternetAvailable = MutableLiveData<Boolean>()

        //API URL
        const val BASE_URL = "https://www.mocky.io/v2/5def7b172f000063008e0aa2/"

        const val username = "dummy"
        const val password = "dummy"

    }
}