package com.example.scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mScore1 = 0
    private var mScore2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
