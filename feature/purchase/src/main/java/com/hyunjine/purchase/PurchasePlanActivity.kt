package com.hyunjine.purchase

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.hyunjine.common_android.base.BaseActivity
import com.hyunjine.common_android.util.DLog
import com.hyunjine.purchase.databinding.ActivityPurchasePlanBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.jsoup.Jsoup

@AndroidEntryPoint
class PurchasePlanActivity : BaseActivity<ActivityPurchasePlanBinding>({ ActivityPurchasePlanBinding.inflate(it) }) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val url = "https://m.blog.naver.com/leemonpai/222979719515"  // 웹 링크

        val result = lifecycleScope.async(Dispatchers.IO) {
            fetchThumbnailUrl(url)
        }
        lifecycleScope.launch {
            val thumbnailUrl = result.await()
            DLog.r(thumbnailUrl)
            thumbnailUrl?.let {
                Glide.with(this@PurchasePlanActivity)
                    .load(it)
                    .into(binding.ivThumbnail)
            }
        }
    }

    private fun fetchThumbnailUrl(url: String): String? {
        return try {
            DLog.r(Thread.currentThread())
            val document = Jsoup.connect(url).get()
            // Open Graph 태그에서 og:image 속성의 값 추출
            val ogImage = document.select("meta[property=og:image]").first()?.attr("content")
            ogImage ?: document.select("link[rel=image_src]").first()?.attr("href")
        } catch (e: Exception) {
            DLog.r(e)
            e.printStackTrace()
            null
        }
    }
}