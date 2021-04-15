package com.codepundit.invitation.ui.menu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.codepundit.invitation.R
import com.codepundit.invitation.databinding.ActivityVenueBinding

class VenueActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVenueBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_venue)
        binding.toolbar2.title = "Venue"
        setSupportActionBar(binding.toolbar2)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setClickListeners()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setClickListeners() {
        binding.btnNavigate.setOnClickListener {
            openGoogleMap(30.695936, 76.873698)
        }
    }


    private fun openGoogleMap(lat: Double, lng: Double) {
        val gmmIntentUri = Uri.parse("google.navigation:q=$lat,$lng&mode=d")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}