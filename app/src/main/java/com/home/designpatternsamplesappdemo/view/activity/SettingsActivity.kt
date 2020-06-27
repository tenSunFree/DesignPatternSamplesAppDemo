package com.home.designpatternsamplesappdemo.view.activity

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.home.designpatternsamplesappdemo.R
import com.home.designpatternsamplesappdemo.common.BaseActivity
import com.home.designpatternsamplesappdemo.databinding.ActivitySettingsBinding
import com.mikepenz.aboutlibraries.util.getThemeColor

internal class SettingsActivity : BaseActivity() {

    companion object {
        const val BRIGHT_BLUE_GREEN_THEME_VALUE = "BrightBlueGreenTheme"
        const val MAGENTA_YELLOW_THEME_VALUE = "MagentaYellowTheme"
        const val URBAN_SKYLINE_THEME_VALUE = "UrbanSkylineTheme"
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        val binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.constraintLayoutRoot.setBackgroundColor(
            getThemeColor(R.attr.view_root_background)
        )
    }
}