package com.home.designpatternsamplesappdemo.common

import android.os.*
import androidx.preference.PreferenceManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.home.designpatternsamplesappdemo.R
import com.home.designpatternsamplesappdemo.view.activity.SettingsActivity

internal abstract class BaseActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setTheme() {
        val preferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val themeValue = preferences.getString(
            getString(R.string.theme_preference_key),
            SettingsActivity.BRIGHT_BLUE_GREEN_THEME_VALUE
        )
        when (themeValue) {
            SettingsActivity.BRIGHT_BLUE_GREEN_THEME_VALUE -> setTheme(R.style.BrightBlueGreenTheme)
            SettingsActivity.MAGENTA_YELLOW_THEME_VALUE -> setTheme(R.style.MagentaYellowTheme)
            SettingsActivity.URBAN_SKYLINE_THEME_VALUE -> setTheme(R.style.UrbanSkylineTheme)
        }
    }
}
