package com.example.letter20

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var avd: AnimatedVectorDrawable
    private lateinit var avd1: AnimatedVectorDrawable
    private lateinit var avd2: AnimatedVectorDrawable
    private lateinit var avd3: AnimatedVectorDrawable
    private lateinit var avd4: AnimatedVectorDrawable
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prepareImageview(0)
        prepare_avd()
        actUpon()
    }

    private fun actUpon() {
        prepareImageview(1)
        GlobalScope.launch { draw_image1() }
        GlobalScope.launch { draw_image2() }
        GlobalScope.launch { draw_image3() }
        GlobalScope.launch { draw_image4() }
        GlobalScope.launch { removeWord() }



    }

    private suspend fun draw_image1() {
        avd1.start()
    }

    private suspend fun draw_image2() {
        delay(1000)
        avd2.start()
    }
    private suspend fun draw_image3() {
        delay(2000)
        avd3.start()
    }
    private suspend fun draw_image4() {
        delay(3000)
        avd4.start()
    }
    private suspend fun removeWord(){
        delay(6000)
        word1Layout.visibility= View.INVISIBLE
    }

    private fun prepareImageview(ind: Int) {
        if (ind == 0) {
            imageView1.visibility = View.INVISIBLE
            imageView2.visibility = View.INVISIBLE
            imageView3.visibility = View.INVISIBLE
            imageView4.visibility = View.INVISIBLE
        } else {
            imageView1.visibility = View.VISIBLE
            imageView2.visibility = View.VISIBLE
            imageView3.visibility = View.VISIBLE
            imageView4.visibility = View.VISIBLE
        }
    }
    private fun prepare_avd() {

        imageView1.setImageResource(R.drawable.alleff)
        avd1 = imageView1.drawable as AnimatedVectorDrawable
        imageView2.setImageResource(R.drawable.bet)
        avd2 = imageView2.drawable as AnimatedVectorDrawable
        imageView3.setImageResource(R.drawable.gimel)
        avd3 = imageView3.drawable as AnimatedVectorDrawable
        imageView4.setImageResource(R.drawable.dalet)
        avd4 = imageView4.drawable as AnimatedVectorDrawable
    }


}
