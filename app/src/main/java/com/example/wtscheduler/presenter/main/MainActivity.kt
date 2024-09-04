package com.example.wtscheduler.presenter.main

import com.example.wtscheduler.common.base.BaseActivity
import com.example.wtscheduler.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {

}