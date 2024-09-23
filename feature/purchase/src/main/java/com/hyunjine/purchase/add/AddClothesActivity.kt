package com.hyunjine.purchase.add

import android.R
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.activity.viewModels
import com.hyunjine.common_android.base.BaseActivity
import com.hyunjine.purchase.databinding.ActivityAddClothesBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddClothesActivity : BaseActivity<ActivityAddClothesBinding, AddClothesViewModel>({ ActivityAddClothesBinding.inflate(it) }) {
    override val viewModel: AddClothesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.root.setOnClickListener {
            val a = getClipData()
            binding.tvLink.text = a
        }
        listenToViewTreeObserver()
    }

    override fun onResume() {
        super.onResume()

    }

    fun getClipData(): String {
        // ClipboardManager 객체를 가져옵니다.
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        // 클립보드에 데이터가 있는지 확인하고, 있다면 데이터를 가져옵니다.
        return clipboard.primaryClip?.getItemAt(0)?.text.toString()
    }

    private fun listenToViewTreeObserver() {
        val vto = binding.root.viewTreeObserver
        vto.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                // do something now when the object is loaded
                // e.g. find the real size of it etc
                val a = getClipData()
                binding.tvLink.text = a
                binding.root.viewTreeObserver.removeOnGlobalLayoutListener(
                    this
                )
            }
        })
    }
}