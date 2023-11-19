package com.example.wtscheduler.presenter.exp_purchase

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.wtscheduler.common.base.BaseActivity
import com.example.wtscheduler.common.extension.DEFAULT
import com.example.wtscheduler.common.extension.setOnSingleClickListener
import com.example.wtscheduler.databinding.ActivityExpPurchaseBinding
import com.example.wtscheduler.presenter.search.SearchActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExpPurchaseActivity: BaseActivity<ActivityExpPurchaseBinding>({ ActivityExpPurchaseBinding.inflate(it) }) {
    companion object {
        const val INTENT_KEY_EXP_PURCHASE_SEARCH_TITLE: String = "INTENT_KEY_EXP_PURCHASE_SEARCH_TITLE"
    }
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    private val rvPurchaseAdapter: ExpPurchaseAdapter by lazy {
        ExpPurchaseAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setResultSearchActivity()
        onClickEvent()
        setAdapter()
        rvPurchaseAdapter.submitItem(ExpPurchase(name = "하나!", link = "www.naver.com"),)
    }

    private fun setResultSearchActivity() {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data ?: return@registerForActivityResult
                val name = data.getStringExtra(SearchActivity.INTENT_KEY_SEARCH_NAME) ?: String.DEFAULT
                val link = data.getStringExtra(SearchActivity.INTENT_KEY_SEARCH_LINK) ?: String.DEFAULT
                rvPurchaseAdapter.submitItem(ExpPurchase(name = name, link = link))
            }
        }
    }

    override fun onClickEvent() = binding.run {
        ivAdd.setOnSingleClickListener {
            val titleIntent = Intent(this@ExpPurchaseActivity, SearchActivity::class.java).apply {
                putExtra(INTENT_KEY_EXP_PURCHASE_SEARCH_TITLE, "구매 예정 항목 추가")
            }
            resultLauncher.launch(titleIntent)
        }
    }

    private fun setAdapter() = binding.rvPurchaseList.apply {
        adapter = rvPurchaseAdapter
        layoutManager = LinearLayoutManager(this@ExpPurchaseActivity, LinearLayoutManager.VERTICAL, false)
    }
}