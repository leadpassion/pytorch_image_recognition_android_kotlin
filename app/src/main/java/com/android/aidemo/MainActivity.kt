package com.android.aidemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.navigateUp

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // IMPORTANT: this ID must be the actual ID of your FragmentContainerView
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val drawer = findViewById<androidx.drawerlayout.widget.DrawerLayout>(R.id.drawer_layout)
        val navView = findViewById<com.google.android.material.navigation.NavigationView>(R.id.nav_view)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_home, R.id.nav_imageRecognition, R.id.nav_objectDetection),
            drawer
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
