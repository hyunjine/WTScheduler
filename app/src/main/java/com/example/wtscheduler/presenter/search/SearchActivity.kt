package com.example.wtscheduler.presenter.search

import android.content.ClipDescription
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.wtscheduler.common.base.BaseActivity
import com.example.wtscheduler.common.extension.DEFAULT
import com.example.wtscheduler.common.extension.setOnSingleClickListener
import com.example.wtscheduler.common.util.log
import com.example.wtscheduler.databinding.ActivitySearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : BaseActivity<ActivitySearchBinding>({ ActivitySearchBinding.inflate(it) }) {
    companion object {
        const val INTENT_KEY_SEARCH_NAME: String = "INTENT_KEY_SEARCH_NAME"
        const val INTENT_KEY_SEARCH_LINK: String = "INTENT_KEY_SEARCH_LINK"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            binding.etLink.setText(getClipboardText())
        }
    }
    private fun getClipboardText(): String {
        return runCatching {
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            return if (clipboard.hasPrimaryClip()) {
                val clip = clipboard.primaryClip
                if (clipboard.primaryClipDescription?.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN) == true) {
                    clip?.getItemAt(0)?.coerceToText(context)?.toString() ?: String.DEFAULT
                } else {
                    clip?.getItemAt(0)?.coerceToHtmlText(context) ?: String.DEFAULT
                }
            } else {
                String.DEFAULT
            }
        }.getOrDefault(String.DEFAULT)
    }

    override fun onClickEvent() = binding.run {
        btnComplete.setOnSingleClickListener {
            val resultIntent = Intent().apply {
                putExtra(INTENT_KEY_SEARCH_NAME, etName.text.toString())
                putExtra(INTENT_KEY_SEARCH_LINK, etLink.text.toString())
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}