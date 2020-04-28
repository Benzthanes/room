package com.special.robinhood.view.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.special.robinhood.R
import com.special.robinhood.databinding.CustomViewBinding

class CustomView @JvmOverloads constructor(
        context: Context, private val attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var binding: CustomViewBinding

    init {
        initView()
    }

    private fun initView() {
        binding = CustomViewBinding.inflate(LayoutInflater.from(context), this, true)
        setAttributes(context, attrs)
        binding.apply {
            tvHeader.text = "MENU"
            tvTitle.text = "KFC"
            tvDetail.text = "CHICKEN"
            ivMenu.setImageResource(R.drawable.ic_launcher_background)
        }
    }

    private fun setAttributes(context: Context, attrs: AttributeSet?) {
        val typeAttribute = context.obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0)
        val titleColor = typeAttribute.getColor(R.styleable.CustomView_titleColor,
                ContextCompat.getColor(context, R.color.colorPrimary))
        val detailColor = typeAttribute.getColor(R.styleable.CustomView_detailColor,
                ContextCompat.getColor(context, R.color.colorPrimary))
        binding.tvTitle.setTextColor(titleColor)
        binding.tvDetail.setTextColor(detailColor)
        typeAttribute.recycle()
    }

}