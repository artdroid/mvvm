package com.ngalaware.blog.mvvmsample

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var mUser:User
    var mLoginUser = MutableLiveData<User>()

    init {
        mUser = User("android art", "artdroidindonesia@gmail.com", "Male", "Yogyakarta")
    }

    fun performLogin(){
        mLoginUser.value = mUser
    }
}