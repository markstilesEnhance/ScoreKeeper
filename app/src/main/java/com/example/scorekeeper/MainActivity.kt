package com.example.scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mScore1 = 0
    private var mScore2 = 0
    val STATE_SCORE_1 = "Team 1 Score"
    val STATE_SCORE_2 = "Team 2 Score"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt((STATE_SCORE_1))
            mScore2 = savedInstanceState.getInt((STATE_SCORE_2))
            score_1.text = mScore1.toString()
            score_2.text = mScore2.toString()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
        {
            if (menu != null) {
                menu.findItem(R.id.night_mode).title = "Day Mode"
                //With the switch from Java to Kotlin I couldn't figure out how to make it work
                //R.string.day_mode gave a type mismatch returning Int where a charSequence was expected
                //Adding toString() resulted in it just displaying a number that I assume is some kind of internal id?
            }
        }
        else {
            if (menu != null) {
                menu.findItem(R.id.night_mode).title = "Night Mode"
            }
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.night_mode) {
            if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            recreate()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(STATE_SCORE_1, mScore1)
        outState.putInt(STATE_SCORE_2, mScore2)
        super.onSaveInstanceState(outState)
    }

    fun decreaseScore(view: View) {
        when(view.id) {
            R.id.decreaseTeam1 -> {
                mScore1--
                score_1.text = mScore1.toString()
            }
            R.id.decreaseTeam2 -> {
                mScore2--
                score_2.text = mScore2.toString()
            }
        }
    }
    fun increaseScore(view: View) {
        when(view.id) {
            R.id.increaseTeam1 -> {
                mScore1++
                score_1.text = mScore1.toString()
            }
            R.id.increaseTeam2 -> {
                mScore2++
                score_2.text = mScore2.toString()
            }
        }
    }
}
