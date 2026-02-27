package com.example.dailycooking

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailycooking.adapter.TipAdapter
import com.example.dailycooking.data.TipDataSource
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val tips = TipDataSource.loadTips()

        val adapter = TipAdapter(tips) { tip ->
            val intent = Intent(this, TipDetailActivity::class.java)
            intent.putExtra(TipDetailActivity.EXTRA_DAY_NUMBER, tip.dayNumber)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
