package com.fancylab.memoryleak

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        leak_button.setOnClickListener(::createSampleLeak)
        jump_button.setOnClickListener(::intentToSecondActivity)
    }

    override fun onDestroy() {
        Toast.makeText(this, "${this.localClassName} onDestroy", Toast.LENGTH_LONG).show()
        super.onDestroy()
    }

    private fun createSampleLeak(any: Any) {
        SampleLeak.instance(this)
        Toast.makeText(this, "Memory leaked", Toast.LENGTH_SHORT).show()
    }

    private fun intentToSecondActivity(any: Any) {
        startActivity(Intent(this, SecondActivity::class.java))
        finish()
    }
}
