package com.home.designpatternsamplesappdemo.view.activity

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.RequiresApi
import com.home.designpatternsamplesappdemo.R
import com.home.designpatternsamplesappdemo.common.BaseActivity
import com.home.designpatternsamplesappdemo.common.navigateTo
import com.home.designpatternsamplesappdemo.databinding.ActivityMainBinding
import com.mikepenz.aboutlibraries.util.getThemeColor

internal class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.constraintLayoutRoot.setBackgroundColor(getThemeColor(R.attr.view_root_background))
        binding.textView.setTextColor(getThemeColor(R.attr.default_text_color))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                navigateTo<SettingsActivity>()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}