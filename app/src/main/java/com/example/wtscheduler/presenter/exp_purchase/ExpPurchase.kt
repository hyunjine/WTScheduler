package com.example.wtscheduler.presenter.exp_purchase

import com.example.wtscheduler.common.extension.DEFAULT

data class ExpPurchase(
    val seq: Long = Long.DEFAULT,
    val name: String = String.DEFAULT,
    val link: String = String.DEFAULT,
    val dueDate: Long = Long.DEFAULT
)
