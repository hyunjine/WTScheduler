package com.hyunjine.common_android.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.hyunjine.common_android.component.AppBar
import com.hyunjine.common_android.extension.dpToPx
import com.hyunjine.common_android.extension.pxToDp
import kotlin.reflect.KClass

abstract class BasePureActivity<T: ViewBinding>(private val bindingFactory: (LayoutInflater) -> T): AppCompatActivity() {
    protected lateinit var binding: T
    protected val context: Context get() = this
    protected val activity: BasePureActivity<T>
        get() = this

    /**
     * @property px 값을 px로 인식하고 dp단위로 변경하는 변수입니다,
     */
    protected val Int.dp
        get() = this.pxToDp(activity)

    /**
     * @property px 값을 dp로 인식하고 px단위로 변경하는 변수입니다,
     */
    protected val Int.px
        get() = this.dpToPx(activity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindingFactory(layoutInflater).also { binding = it }.root)
        setOnBackPressedListener()
        onClickEvent()
    }

    protected open fun setOnBackPressedListener() {
        this.onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                onBack()
            }
        })
    }

    protected open fun onClickEvent() { }

    protected open fun onBack() {
        finish()
    }

    protected fun <T: Activity> startActivity(target: KClass<T>, block: Intent.() -> Unit = { }) {
        val intent = Intent(this, target.java)
        block(intent)
        startActivity(intent)
    }

    /**
     * AppBar클래스를 파라미터로 받으면 왼쪽 image view 클릭 시 자동으로 onBack()을 호출하는 함수입니다.
     */
    protected fun injectAppBar(appBar: AppBar) {
        appBar.onBackClickListener = {
            onBack()
        }
    }
}