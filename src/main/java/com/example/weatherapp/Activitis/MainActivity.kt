package com.example.weatherapp.Activities

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.Activities.FutureActivity
import com.example.weatherapp.Domains.Hourly
import com.example.weatherapp.R
import com.example.weatherapp.Adapters.HourlyAdapters

class MainActivity : AppCompatActivity() {

    private lateinit var adapterHourly: HourlyAdapters
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        initRecyclerView()

        // Set up animations
        setVariable()

        // Add animation to RecyclerView items
        recyclerView.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
    }

    private fun setVariable() {
        val next7dayBtn: TextView = findViewById(R.id.nextBtn)

        // Load fade-in animation for the button
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        next7dayBtn.startAnimation(fadeInAnimation)  // Start the fade-in animation

        next7dayBtn.setOnClickListener {
            // Navigate to FutureActivity
            val intent = Intent(this@MainActivity, FutureActivity::class.java)

            startActivity(intent)
            // Apply activity transition animation
            overridePendingTransition(R.anim.enter, R.anim.exit)
        }
    }

    private fun initRecyclerView() {
        // Prepare data for the adapter
        val items = arrayListOf(
            Hourly(28, "cloudy", "9 PM"),
            Hourly(29, "sunny", "11 PM"),
            Hourly(30, "windy", "12 PM"),
            Hourly(27, "rainy", "1 AM"),
            Hourly(29, "storm", "2 AM")
        )

        // Initialize RecyclerView and set its layout manager
        recyclerView = findViewById(R.id.view1) // Ensure ID matches your XML layout
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Set up adapter
        adapterHourly = HourlyAdapters(items)
        recyclerView.adapter = adapterHourly
    }

    // Override transition for activity switching
    override fun finish() {
        super.finish()
        // Optional: Set a custom exit animation when returning to MainActivity
        overridePendingTransition(R.anim.enter, R.anim.exit)
    }
}