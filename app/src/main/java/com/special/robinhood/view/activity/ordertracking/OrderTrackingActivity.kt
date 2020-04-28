package com.special.robinhood.view.activity.ordertracking

import android.os.Bundle
import com.special.robinhood.R
import com.special.robinhood.view.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_order_tracking.*

class OrderTrackingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_tracking)

        val json = "https://raw.githubusercontent.com/airbnb/lottie-android/master/LottieSample/src/main/res/raw/lottielogo.json"
        ivGiftAnimation.setAnimationFromUrl(json, null)
    }

}