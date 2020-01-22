package com.example.ott46

import android.content.res.Resources
import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.word1_layout.*
import kotlinx.android.synthetic.main.word2_layout.*
import kotlinx.android.synthetic.main.word3_layout.*
import kotlinx.android.synthetic.main.word4_layout.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    var contor = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Main).launch {
            firstWord()
            secondWord()
            thirdWord()
            fourthWord()
        }


    }

    private suspend fun fourthWord() {
        delay(5000)

        contor = 22
        setParams(worldLayout4, 150, 365, 0, 530, 0, 0)
        // worldLayout4.background = ContextCompat.getDrawable(this, R.drawable.ic_launcher_background)
        creadAVD(23, "ה")
        creadAVD(24, "ו")
        creadAVD(25, "א")

        creadAVD(26, "מ")
        creadAVD(27, "ק")
        creadAVD(28, "ו")
        creadAVD(29, "ם")

        creadAVD(30, "ב")
        creadAVD(31, "ל")
        creadAVD(32, "י")

        creadAVD(33, "א")
        creadAVD(34, "ו")
        creadAVD(35, "ר")

    }

    private suspend fun thirdWord() {
        delay(15000)

        contor = 17
        setParams(worldLayout3, 150, 360, 0, 350, 0, 0)
        //  worldLayout3.background = ContextCompat.getDrawable(this, R.drawable.ic_launcher_background)

        CoroutineScope(IO).launch {
            creadAVD(18, "ה")
            creadAVD(19, "ח")
            creadAVD(20, "ו")
            creadAVD(21, "ש")
            creadAVD(22, "ך")
        }
    }

    private suspend fun secondWord() {
        delay(5000)
        contor = 4
        setParams(worldLayout2, 150, 380, 0, 0, 0, 300)

        //  worldLayout2.background = ContextCompat.getDrawable(this, R.drawable.ic_launcher_background)

        CoroutineScope(IO).launch {
            creadAVD(5, "ה")
            creadAVD(6, "ו")
            creadAVD(7, "א")

            creadAVD(8, "מ")
            creadAVD(9, "ע")
            creadAVD(10, "ש")
            creadAVD(11, "ה")

            creadAVD(12, "ב")
            creadAVD(13, "ר")
            creadAVD(14, "א")
            creadAVD(15, "ש")
            creadAVD(16, "י")
            creadAVD(17, "ת")

        }


    }


    private fun individiualPatam(view: View) {
        when (contor) {
            1 -> setParams(view, 150, 150, 0, 0, 15, 35)
            2 -> setParams(view, 180, 180, 0, 0, 110, 55)
            3 -> setParams(view, 170, 170, 0, 0, 170, 50)
            4 -> setParams(view, 160, 160, 0, 0, 230, 10)

            5 -> setParams(view, 50, 50, 0, 0, 10, 10)
            6 -> setParams(view, 50, 50, 0, 0, 30, 10)
            7 -> setParams(view, 55, 55, 0, 0, 50, 15)

            8 -> setParams(view, 50, 50, 0, 0, 90, 10)
            9 -> setParams(view, 40, 40, 0, 0, 120, 15)
            10 -> setParams(view, 40, 40, 0, 0, 137, 10)
            11 -> setParams(view, 50, 50, 0, 0, 155, 10)

            12 -> setParams(view, 50, 50, 0, 0, 205, 15)
            13 -> setParams(view, 50, 50, 0, 0, 230, 5)
            14 -> setParams(view, 55, 55, 0, 0, 260, 15)
            15 -> setParams(view, 45, 45, 0, 0, 290, 8)
            16 -> setParams(view, 50, 50, 0, 0, 307, 10)
            17 -> setParams(view, 50, 50, 0, 0, 330, 5)

            18 -> setParams(view, 120, 120, 0, 0, 15, 35)
            19 -> setParams(view, 140, 140, 0, 0, 75, 20)
            20 -> setParams(view, 120, 120, 0, 0, 135, 38)
            21 -> setParams(view, 110, 110, 0, 0, 175, 25)
            22 -> setParams(view, 120, 120, 0, 15, 230, 0)

            23 -> setParams(view, 50, 50, 0, 0, 0, 20)
            24 -> setParams(view, 50, 50, 0, 0, 20, 20)
            25 -> setParams(view, 55, 55, 0, 0, 40, 25)

            26 -> setParams(view, 55, 55, 0, 0, 80, 20)
            27 -> setParams(view, 55, 55, 0, 0, 113, 0)
            28 -> setParams(view, 50, 50, 0, 0, 135, 20)
            29 -> setParams(view, 45, 45, 0, 0, 157, 15)

            30 -> setParams(view, 55, 55, 0, 0, 200, 25)
            31 -> setParams(view, 50, 50, 0, 0, 230, 20)
            32 -> setParams(view, 50, 50, 0, 0, 248, 25)

            33 -> setParams(view, 55, 55, 0, 0, 285, 25)
            34 -> setParams(view, 50, 50, 0, 0, 305, 20)
            35 -> setParams(view, 50, 50, 0, 0, 323, 12)

        }

    }


    private fun firstWord() {

        setParams(worldLayout1, 250, 380, 0, 0, 0, 500)

        //  worldLayout1.background = ContextCompat.getDrawable(this, R.drawable.ic_launcher_background)

        CoroutineScope(IO).launch {
            creadAVD(1, "ה")
            creadAVD(2, "א")
            creadAVD(3, "ו")
            creadAVD(4, "ר")


        }

    }

    private fun setParams(
        view: View,
        scaleX: Int,
        scaleY: Int,
        mLeft: Int,
        mTop: Int,
        mRight: Int,
        mBottom: Int
    ) {
        if (scaleX > 0) {
            view.layoutParams.height = scaleX.toPx()
            view.layoutParams.width = scaleY.toPx()
        }
        val param = view.layoutParams as ConstraintLayout.LayoutParams
        param.setMargins(mLeft.toPx(), mTop.toPx(), mRight.toPx(), mBottom.toPx())
        view.layoutParams = param
        view.requestLayout()
    }


    private suspend fun creadAVD(index: Int, letter: String) {
        contor++
        val view = getView(index) as ImageView
        val address = Helper(this).getAnimation(letter)
        individiualPatam(view)



        withContext(Main) {

            delay(1000)

            view.setImageResource(address)
            val avd = view.drawable as AnimatedVectorDrawable
            avd.start()
        }

    }

    fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()


    private fun setWordLayout(worldLayout: ConstraintLayout?, mTop: Int) {
        setParams(worldLayout1, 0, 0, 0, mTop, 0, 0)

    }


    fun getView(index: Int): View {
        var view: View
        when (index) {
            1 -> view = imageView1
            2 -> view = imageView2
            3 -> view = imageView3
            4 -> view = imageView4

            5 -> view = imageView10
            6 -> view = imageView11
            7 -> view = imageView12
            8 -> view = imageView13
            9 -> view = imageView14
            10 -> view = imageView15
            11 -> view = imageView16
            12 -> view = imageView17
            13 -> view = imageView18
            14 -> view = imageView19
            15 -> view = imageView20
            16 -> view = imageView21
            17 -> view = imageView22

            18 -> view = imageView30
            19 -> view = imageView31
            20 -> view = imageView32
            21 -> view = imageView33
            22 -> view = imageView34

            23 -> view = imageView40
            24 -> view = imageView41
            25 -> view = imageView42
            26 -> view = imageView43
            27 -> view = imageView44
            28 -> view = imageView45
            29 -> view = imageView46
            30 -> view = imageView47
            31 -> view = imageView48
            32 -> view = imageView49
            33 -> view = imageView491
            34 -> view = imageView492
            35 -> view = imageView493

            else -> view = imageView1
        }
        return view
    }
}
