package com.hyunjine.purchase

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import com.hyunjine.common_android.base.BaseActivity
import com.hyunjine.common_android.util.DLog
import com.hyunjine.common_android.util.GridSpacingItemDecoration
import com.hyunjine.common_android.util.ItemTouchHelperCallback
import com.hyunjine.purchase.adapter.WantedClothesAdapter
import com.hyunjine.purchase.databinding.ActivityWantedClothesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WantedClothesActivity : BaseActivity<ActivityWantedClothesBinding, WantedClothesViewModel>({ ActivityWantedClothesBinding.inflate(it) }) {
    private val rvAdapter: WantedClothesAdapter = WantedClothesAdapter()
    override val viewModel: WantedClothesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectAppBar(binding.appBar)
        setRecyclerView()
    }

    private fun setRecyclerView() = binding.rvItem.apply {
        adapter = rvAdapter
        layoutManager = GridLayoutManager(activity, 2)
        val touchHelper = ItemTouchHelper(ItemTouchHelperCallback(rvAdapter))
        touchHelper.attachToRecyclerView(this)
        addItemDecoration(GridSpacingItemDecoration(spanCount = 2, spacing = 16.px))
    }

    override fun observeViewModel() = lifecycleScope.launch {
        launch {
            viewModel.listItems.collectLatest {
                rvAdapter.submitList(it)
            }
        }
    }
}