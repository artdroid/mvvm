package com.ngalaware.blog.mvvmsample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.ngalaware.blog.mvvmsample.databinding.ActivityMainBinding


// Activity represent View in MVVM Concept
class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    lateinit var mUserObserver:Observer<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.activity = this
        binding.mainvm = mainViewModel

        initObserver()
    }


    fun initObserver(){
        mUserObserver = Observer {user ->
            if (user != null){
                Log.e("TAG", "user : $user")
                showUserInfo(user)
            }
        }
        mainViewModel.mLoginUser.observe(this, mUserObserver)
    }

    fun login(v: View){
        mainViewModel.performLogin()
    }

    fun showUserInfo(user : User){
        Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show()
    }
}
