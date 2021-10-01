package com.sabin.sastofurniture

import android.content.Intent
import android.content.SharedPreferences
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.Handler
import android.os.PowerManager
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.android.volley.toolbox.Volley
import com.google.android.material.navigation.NavigationView
import com.sabin.sastofurniture.Fragments.*


class DashboardActivity : AppCompatActivity() {
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var coordinatorLayout: CoordinatorLayout
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var frameLayout: FrameLayout
    private lateinit var navigationView: NavigationView
    private var previousMenuItem: MenuItem? = null
    private lateinit var preferences: com.sabin.sastofurniture.Preferences
    private lateinit var sharedPrefs: SharedPreferences


    private lateinit var sensorManager: SensorManager
    private var sensorAccelerometer: Sensor? = null
    private var sensorProximity: Sensor? = null
    private var sensorGyroscope: Sensor? = null
    private var acclValue = 0f
    private var lastAcclValue: Float = 0f
    private var shake: Float = 0f
    private var powerManager: PowerManager? = null
    private var wakeLock: PowerManager.WakeLock? = null
    private var field = 0x00000020

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        if (!checkSensor()) {
            Toast.makeText(this, "Sensor Not Available", Toast.LENGTH_SHORT).show()
        } else {
            sensorAccelerometer =  sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
            sensorProximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
            sensorGyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        }
        try {
            // Yeah, this is hidden field.
            field = PowerManager::class.java.javaClass.getField("PROXIMITY_SCREEN_OFF_WAKE_LOCK").getInt(null)
        } catch (ignored: Throwable) {
            powerManager = getSystemService(POWER_SERVICE) as PowerManager;
            wakeLock = powerManager!!.newWakeLock(field, getLocalClassName());
        }

        preferences = com.sabin.sastofurniture.Preferences(this@DashboardActivity)
        sharedPrefs = this@DashboardActivity.getSharedPreferences(
            preferences.PREF_NAME,
            preferences.PRIVATE_MODE
        )

        drawerLayout=findViewById(R.id.drawerLayout)
        coordinatorLayout=findViewById(R.id.coordinatorLayout)
        toolbar= findViewById(R.id.toolbar)
        frameLayout=findViewById(R.id.frameLayout)
        navigationView=findViewById(R.id.navigationView)

        setUpToolbar()
        openAllFurniture()

// for creating a toogle icon
        val actionBarDrawerToggle = ActionBarDrawerToggle(this@DashboardActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer,
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        navigationView.setNavigationItemSelectedListener {
// this is done to check the fragment which the user is cuurently working at
            if(previousMenuItem != null){
                previousMenuItem?.isChecked=false
            }
            it.isCheckable=true
            it.isChecked=true
            previousMenuItem = it

            val mPendingRunnable = Runnable { drawerLayout.closeDrawer(GravityCompat.START) }
            Handler().postDelayed(mPendingRunnable, 100)




// thw following code is for transfer of a fragment to another fragment
            when(it.itemId){
                R.id.menuHome -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frameLayout,

                            ProductFragment()
                        ).commit()
                    supportActionBar?.title=" All Restaurants"
                    drawerLayout.closeDrawers()
                }
                R.id.menuMyProfile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frameLayout,
                            MyProfile()
                        ).commit()
                    supportActionBar?.title="My Profile"
                    drawerLayout.closeDrawers()
                }

                R.id.menufavouriteRestaurants-> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frameLayout,
                            FavouriteFurniture()
                        ).commit()
                    supportActionBar?.title="My Favourite Furniture"
                    drawerLayout.closeDrawers()
                }

                R.id.menuLogout->{
//                  if the user wishes to log out we show a alert dialog box
                    val builder = AlertDialog.Builder(this@DashboardActivity)
                    builder.setTitle("Confirmation")
                        .setMessage("Are you sure you want exit?")
                        .setPositiveButton("Yes") { _, _ ->
                            preferences.setLogin(false)
                            sharedPrefs.edit().clear().apply()
                            startActivity(Intent(this@DashboardActivity, LoginActivity::class.java))
                            Volley.newRequestQueue(this).cancelAll(this::class.java.simpleName)
                            ActivityCompat.finishAffinity(this)
                        }
                        .setNegativeButton("No") { _, _ ->
                            openAllFurniture()
                        }
                        .create()
                        .show()
                    drawerLayout.closeDrawers()
                }

                R.id.googlemap -> {
                    supportFragmentManager.beginTransaction()
                      R.id.frameLayout
                    startActivity(Intent(this@DashboardActivity, MapsActivity::class.java))
                    supportActionBar?.title = "Location"
                    drawerLayout.closeDrawers()
                }





                R.id.menuFAQs-> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frameLayout,
                            FAQs()
                        ).commit()
                    supportActionBar?.title="Frequently Asked Questions?"
                    drawerLayout.closeDrawers()
                }
            }
            return@setNavigationItemSelectedListener true
        }


        val headerView = LayoutInflater.from(this@DashboardActivity).inflate(R.layout.fragment_header_,null)
        navigationView.addHeaderView(headerView)







    }
    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = " Toolbar Title "
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)// for displaying the default icon
    }


    // this function for showing what happens when a toggle icon is pressed which is present at the menu bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if(id==android.R.id.home){


//      learnt online to delay the functionality which is good practice for making motions smooth

            val mPendingRunnable = Runnable {
                drawerLayout.openDrawer(GravityCompat.START,)
                }
            Handler().postDelayed(mPendingRunnable, 100)
        }
        return super.onOptionsItemSelected(item)


    }


    private fun checkSensor(): Boolean {
        var flag = true
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) == null) {
            flag = false        }
        else if (sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) == null) {
            flag = false        }
        return flag    }


    // function used so that whenever we want to open the restaurants fragments we can do so using a function
    private fun openAllFurniture(){
        val fragment = ProductFragment()
        val fragmentManager = supportFragmentManager.beginTransaction()// supportFragmentManager is used as intent
        fragmentManager.replace(R.id.frameLayout,fragment)
        fragmentManager.commit()
        supportActionBar?.title="Furniture Items"
        navigationView.setCheckedItem(R.id.menuHome)// for showing the shade of the item selected in navigation view
    }
    // function which decides the functionality of the back button
    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frameLayout)
        when(frag) {
            !is ProductFragment -> openAllFurniture()
            else -> {
                Volley.newRequestQueue(this).cancelAll(this::class.java.simpleName)
                ActivityCompat.finishAffinity(this@DashboardActivity)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(
                accelerometerEventListener,
                sensorAccelerometer,
                SensorManager.SENSOR_DELAY_NORMAL
        )
        sensorManager.registerListener(
                proximityEventListener,
                sensorProximity,
                SensorManager.SENSOR_DELAY_NORMAL
        )
        sensorManager.registerListener(
                gyroEventListener,
                sensorGyroscope,
                SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(accelerometerEventListener)
        sensorManager.unregisterListener(proximityEventListener)
       sensorManager.unregisterListener(gyroEventListener)
    }

    private val accelerometerEventListener: SensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]
            lastAcclValue = acclValue
            acclValue = Math.sqrt((x * x + y * y + z * z).toDouble()).toFloat()
            val delta = acclValue - lastAcclValue
            shake = shake * 0.9f + delta
            if (shake > 12) {
                 val builder = AlertDialog.Builder(this@DashboardActivity)
                    builder.setTitle("Confirmation")
                        .setMessage("Are you sure you want exit?")
                        .setPositiveButton("Yes") { _, _ ->
                            preferences.setLogin(false)
                            sharedPrefs.edit().clear().apply()
                            startActivity(Intent(this@DashboardActivity, LoginActivity::class.java))
                            Volley.newRequestQueue(applicationContext).cancelAll(this::class.java.simpleName)
                            ActivityCompat.finishAffinity(this@DashboardActivity)
                        }
                        .setNegativeButton("No") { _, _ ->
                            openAllFurniture()
                        }
                        .create()
                        .show()
//                Toast.makeText(
//                        this@DashboardActivity,
//                        "Successfully Logged Out",
//                        Toast.LENGTH_SHORT
//                ).show()
            }
        }

        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
    }
    private val proximityEventListener: SensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            val values = event.values[0]
            if (values <= 4) {
                if (!wakeLock?.isHeld!!) {
                    wakeLock?.acquire();
                } else {
                    if (wakeLock!!.isHeld) {
                        wakeLock!!.release();
                    }
                }
            } else {
                if (wakeLock!!.isHeld) {
                    wakeLock!!.release()
                }
            }
        }

        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
    }

    private val gyroEventListener: SensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            val values = event!!.values[1]
            if (values < 0){
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            else if (values > 0) {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
    }
}




