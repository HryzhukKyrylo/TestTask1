package com.natife.testtask1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import com.natife.testtask1.databinding.ActivityMainBinding
import com.natife.testtask1.utils.Const
import com.natife.testtask1.utils.CustomService
import com.natife.testtask1.utils.PreferenceHelper

class MainActivity : AppCompatActivity() {
    private lateinit var preferences: SharedPreferences
    private lateinit var binding: ActivityMainBinding

    private val myIntent: Intent by lazy {
        Intent(this, CustomService::class.java)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPreference()
        startMyIntent()
        checkArg()
    }

    private fun checkArg() {
        val idArg = intent.extras?.getInt(Const.RECEIVE_VAL)
        if (idArg != 20 && idArg != null) {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            val navController = navHostFragment.navController
            navController.navigate(
                R.id.navigateToDescriptionScreen,
                bundleOf(Const.BUNDLE_VAL to idArg)
            )
        }
    }

    private fun initPreference() {
        preferences = PreferenceHelper.customPreference(this, Const.CUSTOM_PREF_NAME)
    }

    private fun startMyIntent() {
        startService(myIntent)
    }
}
