package com.hyunjine.purchase.adapter

import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.hyunjine.common_android.base.BaseRecyclerViewHolder
import com.hyunjine.common_android.util.DLog
import com.hyunjine.purchase.WantedClothesModel
import com.hyunjine.purchase.databinding.ItemWantedClothesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class WantedClothesViewHolder(
    private val binding: ItemWantedClothesBinding
): BaseRecyclerViewHolder<ItemWantedClothesBinding>(binding) {

    fun bind(model: WantedClothesModel) = binding.run {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val document = Jsoup.connect("${model.link}")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36")
                    .get()
                val thumbnailUrl = document.select("meta[property=og:image]").first()?.attr("content")
                    ?: document.select("link[rel=image_src]").first()?.attr("href")
                val title = document.select("meta[property=og:title]").first()?.attr("content")
                    ?: document.title()
                DLog.r(model.link)
                if (model.link.contains("smart")) {
                    DLog.r(thumbnailUrl, title)
                }
                withContext(Dispatchers.Main) {
                    tvTitle.text = title
                    Glide.with(context)
                        .load(thumbnailUrl)
                        .listener(object : RequestListener<Drawable> {
                            override fun onLoadFailed(
                                e: GlideException?,
                                model: Any?,
                                target: Target<Drawable>?,
                                isFirstResource: Boolean
                            ): Boolean {
                                return false
                            }

                            override fun onResourceReady(
                                resource: Drawable?,
                                model: Any?,
                                target: Target<Drawable>?,
                                dataSource: DataSource?,
                                isFirstResource: Boolean
                            ): Boolean {
                                cancel()
                                return false
                            }

                        })
                        .into(ivThumbnail)
                }
            } catch (e: Exception) {
                DLog.r(e)
                cancel()
            }
        }
    }
}