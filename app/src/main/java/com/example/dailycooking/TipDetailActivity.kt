package com.example.dailycooking

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dailycooking.data.TipDataSource
import com.google.android.material.appbar.MaterialToolbar

class TipDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DAY_NUMBER = "extra_day_number"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip_detail)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_detail)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { finish() }

        val dayNumber = intent.getIntExtra(EXTRA_DAY_NUMBER, 1)
        val tip = TipDataSource.loadTips().first { it.dayNumber == dayNumber }

        toolbar.title = getString(R.string.day_label, tip.dayNumber)

        val textDay = findViewById<TextView>(R.id.text_detail_day)
        val textTitle = findViewById<TextView>(R.id.text_detail_title)
        val imageDetail = findViewById<ImageView>(R.id.image_detail_tip)
        val textDescription = findViewById<TextView>(R.id.text_detail_description)

        textDay.text = getString(R.string.day_label, tip.dayNumber)
        textTitle.text = getString(tip.titleResId)
        imageDetail.setImageResource(tip.imageResId)
        textDescription.text = getString(tip.fullDescriptionResId)
    }
}
