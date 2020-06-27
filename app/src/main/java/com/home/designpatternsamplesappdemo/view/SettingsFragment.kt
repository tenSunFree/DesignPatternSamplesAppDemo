package com.home.designpatternsamplesappdemo.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import com.home.designpatternsamplesappdemo.R
import com.home.designpatternsamplesappdemo.view.activity.SettingsActivity

internal class SettingsFragment : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {

    private var preference: ListPreference? = null
    private val key: String by lazy {
        getString(R.string.theme_preference_key)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.theme_preferences, rootKey)
        preference = findPreference(key)
        setPreference()
        preferenceManager.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if (key == this.key) {
            val intent = requireContext().packageManager.getLaunchIntentForPackage(
                requireContext().packageName
            )!!
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        preferenceManager.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
        super.onDestroy()
    }

    private fun setPreference() {
        val themeOptionsArray = resources.getStringArray(R.array.theme_options_array)
        preference?.entries = themeOptionsArray
        val sharedPreferences = preferenceManager.sharedPreferences
        val defaultValue = getString(R.string.theme_preference_default_value)
        val themeValue = sharedPreferences.getString(key, defaultValue)
        preference?.icon = getDrawable(requireContext(), getIcon(themeValue))
    }

    @DrawableRes
    private fun getIcon(themeValue: String?): Int {
        return when (themeValue) {
            SettingsActivity.BRIGHT_BLUE_GREEN_THEME_VALUE -> R.drawable.ic_baseline_looks_one_24
            SettingsActivity.MAGENTA_YELLOW_THEME_VALUE -> R.drawable.ic_baseline_looks_two_24
            SettingsActivity.URBAN_SKYLINE_THEME_VALUE -> R.drawable.ic_baseline_looks_3_24
            else -> R.drawable.ic_baseline_looks_one_24
        }
    }
}