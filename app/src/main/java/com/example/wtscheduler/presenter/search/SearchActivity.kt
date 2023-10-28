package com.example.wtscheduler.presenter.search

import android.content.Intent
import com.example.wtscheduler.common.base.BaseActivity
import com.example.wtscheduler.common.extension.setOnSingleClickListener
import com.example.wtscheduler.databinding.ActivitySearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : BaseActivity<ActivitySearchBinding>({ ActivitySearchBinding.inflate(it) }) {
    companion object {
        const val INTENT_KEY_SEARCH_NAME: String = "INTENT_KEY_SEARCH_NAME"
        const val INTENT_KEY_SEARCH_LINK: String = "INTENT_KEY_SEARCH_LINK"
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