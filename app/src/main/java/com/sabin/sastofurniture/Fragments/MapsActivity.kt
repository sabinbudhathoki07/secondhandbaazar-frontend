package com.sabin.sastofurniture.Fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sabin.sastofurniture.R
import com.sabin.sastofurniture.entity.LatitudeLongitude

class MapsActivity :  AppCompatActivity(), OnMapReadyCallback  {

    private lateinit var mMap: GoogleMap

    private var lstLatitudeLongitude = ArrayList<LatitudeLongitude>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        lstLatitudeLongitude.add(LatitudeLongitude(26.659429, 87.637525, "Sasto Furniture"))
        lstLatitudeLongitude.add(LatitudeLongitude(26.665392, 87.638205, " Sasto Furniture branch"))

        for (location in lstLatitudeLongitude) {
            mMap.addMarker(
                MarkerOptions().position(LatLng(location.latitude, location.longitude))
                    .title(location.markerName)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
            )
        }
        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(LatLng(26.659429, 87.637525),16F), 4000, null
        )
        mMap.uiSettings.isZoomControlsEnabled = true
    }
}



