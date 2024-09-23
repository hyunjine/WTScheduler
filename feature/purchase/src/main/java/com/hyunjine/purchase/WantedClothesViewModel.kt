package com.hyunjine.purchase

import androidx.lifecycle.viewModelScope
import com.hyunjine.common_android.base.BaseViewModel
import com.hyunjine.common_android.util.DLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import javax.inject.Inject

@HiltViewModel
class WantedClothesViewModel @Inject constructor(): BaseViewModel() {
    private val _listItems: MutableStateFlow<List<WantedClothesModel>> = MutableStateFlow(emptyList())
    val listItems: StateFlow<List<WantedClothesModel>> = _listItems.asStateFlow()

    init {
        getThumbnailUrl(listOf(
//            "https://www.jogunshop.com/shop/shopdetail.html?branduid=29767&search=&xcode=071&mcode=000&scode=&GfDT=bm11W14%3D",
//            "https://www.jogunshop.com/shop/shopdetail.html?branduid=30094&search=&xcode=014&mcode=004&scode=&special=7&GfDT=bmt7W14%3D",
//            "https://bymono.com/product/%EB%A0%88%EC%98%B9-%EC%98%A4%EB%B2%84-%EB%A7%A8%ED%88%AC%EB%A7%A8xl-2xl3xl4xl5xl/34324/category/597/display/2/",
//            "https://bymono.com/product/%EB%A0%88%EC%98%B9-%EC%98%A4%EB%B2%84-%EB%A7%A8%ED%88%AC%EB%A7%A8xl-2xl3xl4xl5xl/34324/category/597/display/2/",
//            "https://smartstore.naver.com/ryeol_oh/products/10776477849?n_media=8753&n_query=%EB%82%A8%EC%9E%90%ED%81%AC%EB%A1%AD%EA%B0%80%EB%94%94%EA%B1%B4&n_rank=2&n_ad_group=grp-a001-02-000000044446880&n_ad=nad-a001-02-000000317457810&n_campaign_type=2&n_mall_id=ncp_1ocs1r_01&n_mall_pid=10776477849&n_ad_group_type=2&n_match=3#DEFAULT"
            "https://smartstore.naver.com/keep_glan/products/10200057559?NaPm=ct%3Dm0pg8xh4%7Cci%3D0za0003pNXzAGv8ideXW%7Ctr%3Dpla%7Chk%3Dfe8e09cad90e57f92497ccb86c3fe6754e05ecbb%7Cnacn%3D9Xk6BMARcWesB"
        ))
    }

    private fun getThumbnailUrl(urls: List<String>) {
        _listItems.value = urls.map { WantedClothesModel(link = it) }
    }
}