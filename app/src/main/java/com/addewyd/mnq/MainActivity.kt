package com.addewyd.mnq

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import android.view.*
import android.content.Intent
import android.widget.TextView
import android.preference.Preference
import android.content.SharedPreferences
import android.preference.PreferenceManager

class MainActivity : AppCompatActivity() {

    var tv:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val linLayout = LinearLayout(this)
        linLayout.orientation = LinearLayout.VERTICAL
        val linLayoutParam = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        setContentView(linLayout, linLayoutParam)

        val lpView = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT)

        PreferenceManager.setDefaultValues(this, R.xml.pref_general, false)

        tv = TextView(this)
        tv?.height = 102
        tv?.text = "TextView"
        tv?.layoutParams = lpView
        linLayout.addView(tv)

        var mSettings = PreferenceManager.getDefaultSharedPreferences(this)

        if (mSettings?.contains("save_path") ?: false) {

            var gf = mSettings.getString("save_path", "")
            tv?.setText("Save path: $gf")

        } else {

            tv?.text = "Save path: None"
        }

        // setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0, 1, 0, "Empty")
        menu?.add(0, 2, 0, "Settings")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            1 -> Toast.makeText(this, "empty", Toast.LENGTH_LONG).show()
            2 -> {
                //Toast.makeText(this, "settings", Toast.LENGTH_LONG).show()

                val intent:Intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)

            }
        }
        return super.onOptionsItemSelected(item)
    }

}
