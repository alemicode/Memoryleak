package com.mohamad.memoryleak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_leak_canary_over_view.*

class LeakCanaryOverViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leak_canary_over_view)

        btn_1.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
