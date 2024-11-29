package com.example.weatherapp.Activities

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.Adapters.FutureAdapter
import com.example.weatherapp.Domains.FutureDomain
import com.example.weatherapp.R

class FutureActivity : AppCompatActivity() {

    private lateinit var adapterTomorrow: FutureAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_future)

        // Initialize RecyclerView
        initRecyclerView()

        // Set up animations
        setVariable()

        // Add animation to RecyclerView items
        recyclerView.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
    }

    private fun setVariable() {
        val backbtn: ImageView = findViewById(R.id.backbtn)

        // Load fade-in animation for the back button
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        backbtn.startAnimation(fadeInAnimation) // Start the fade-in animation

        backbtn.setOnClickListener {
            // Navigate back to MainActivity
            val intent = Intent(this@FutureActivity, MainActivity::class.java)
            startActivity(intent)

            // Apply activity transition animation
            overridePendingTransition(R.anim.enter, R.anim.exit)
        }
    }

    private fun initRecyclerView() {
        val items = ArrayList<FutureDomain>()

        // Add sample data to the list
        items.add(FutureDomain("Sat", "rainy", "Rainy", 25, 10))
        items.add(FutureDomain("Sun", "sunny", "Sunny", 28, 15))
        items.add(FutureDomain("Mon", "cloudy", "Overcast", 22, 12))
        items.add(FutureDomain("Tue", "rainy", "Showers", 20, 14))
        items.add(FutureDomain("Wed", "storm", "Stormy", 18, 9))
        items.add(FutureDomain("Thu", "sunny", "Sunny", 26, 16))

        recyclerView = findViewById(R.id.recyclerViewHourlyWeather)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapterTomorrow = FutureAdapter(items)
        recyclerView.adapter = adapterTomorrow
    }

    // Override transition for activity switching
    override fun finish() {
        super.finish()
        // Optional: Set a custom exit animation when returning to MainActivity
        overridePendingTransition(R.anim.enter, R.anim.exit)
    }
}


