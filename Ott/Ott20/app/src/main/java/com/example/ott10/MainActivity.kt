package com.example.ott10

import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val PREF_NAME = "Ott_me"
    private val PRIVATE_MODE = 0
    private val KEY2 = "Key2"


    private var currentString = ""
    private var wirttenString = ""
    var demiString = ""
    var mainIndex = 0
    var ttIndex: Int = 0
    var startTextView = true
    var horOffset = 0.0
    var verOffset = 0.0
    var counterLetter = 0
    var widthPd = 0.0
    var heightPd = 0.0
    var widthOfDevice = 0
    var heightOfDevice = 0
    var endBorder = 0
    var beginBorder=0
    var mainCounter=0
    var jumpLine=false


    var letterImage: AppCompatImageButton? = null


    lateinit var mainArray: ArrayList<LetterImage>
    lateinit var currentLettersArray: ArrayList<MyLetterImage>

    lateinit var sharePref: SharedPreferences

    // var ttLettersArrary: ArrayList<LetterLocation>? = null


    var baseH = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharePref = getSharedPreferences(PREF_NAME, PRIVATE_MODE)

       //  create_letterArray()





        start.setOnClickListener {

          //  init()

                            val avd = image.drawable as AnimatedVectorDrawable
                avd.start()
        }
    }


    private fun init() {
        baseH = 250.0
        verOffset = 0.0
        counterLetter = 0
        load_mainArray()
        startTextView = true
        currentString = ""
        wirttenString = ""
        getDeviceDim()

        demi_word(0, "מ")
      //  demi_word(0, "מה קורה גבכבר")

//        tryIt()
    }


    private fun demi_word(ind: Int, st: String) {
        var st = st
        var s: String
        mainCounter = 0
        st = st.trim { it <= ' ' }
        demiString = st
        if (ind == 0) start_from_the_begininig_of_the_line(0)
       /* for (i in 0 until demiString.length) {
            s = demiString.substring(i, i + 1)
            if (s == " ") {
                currentString = "$currentString "
                horOffset = horOffset + baseH * 0.3
                wirttenString = ""
            } else {
                activateCurrentLettter(s)
            }
        }*/
    }
    fun activateCurrentLettter(st: String) {
        jumpLine = false
        currentString += st
        wirttenString = wirttenString + st

        var currentLetter = st

        val char = st.single()
        mainIndex = char.toInt() - 1487;
        make_letterImage(0)

        if (!jumpLine) {
            letterImage!!.setImageResource(getAnimation(st))
          //  image.addView(letterImage)
            val d = letterImage!!.drawable


         //   val avd: AnimatedVectorDrawableCompat = d as AnimatedVectorDrawableCompat




            val avd = d as AnimatedVectorDrawable



            avd.start()



            startTextView = false
        }
        ttIndex = mainIndex
        jumpLine = false

    }
    private fun start_from_the_begininig_of_the_line(ind: Int) {
     //   if (ind == 0) letterLayout.removeAllViews()
        startTextView = true
        horOffset = beginBorder.toDouble()
        verOffset = 0.0
        currentString = ""
        wirttenString = ""
        counterLetter = 0
    }

   private fun getDeviceDim() {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        heightOfDevice = displayMetrics.heightPixels
        widthOfDevice = displayMetrics.widthPixels
        endBorder = widthOfDevice - 5
        beginBorder = 2
    }

    private fun load_mainArray() {

        val response = sharePref.getString(KEY2, "")
        mainArray = ArrayList()
        val gson = Gson()
        mainArray = gson.fromJson(
            response,
            object : TypeToken<List<LetterImage?>?>() {}.type
        )
        // init_horOffsetArray();
    }

    private fun save_mainArray() {
        val editor = sharePref.edit()
        val gson = Gson()
        val json: String = gson.toJson(mainArray)
        // editor.remove(key2).commit()
        editor.putString(KEY2, json)
        editor.commit()
    }



    fun make_letterImage(ind: Int) {
        var ww = 0
        var hh = 0
        var pl = 0
        var pu = 0
        var pr = 0
        var pd = 0
        var ml = 0
        var mu = 0
        var md = 0
        var mr = 0
        var ho = 0
        var ho1 = 0.0
        var mr1 = 0.0
        if (startTextView) {

            horOffset = 0.0
            counterLetter = 0
        } else {
            ho1 = mainArray?.get(mainIndex)?.horOffset!!.get(ttIndex)
            ho = (ho1 * baseH).toInt()
            if (ind == 0) ho = 0
            if (startTextView) {
                ho = 0
                horOffset = 0.0
                startTextView = false
            }
            // update_data();
            with(mainArray!![mainIndex]) {
                ww = (wight * baseH).toInt()
                hh = (hight * baseH).toInt()
                pl = (paddingLeft * baseH).toInt()
                pu = (paddingUp * baseH).toInt()
                pr = (paddingRight * baseH).toInt()
                pd = (paddingDown * baseH).toInt()
                ml = (mainArray!![mainIndex].marginLeft * baseH).toInt()
                mu = (mainArray!![mainIndex].marginUp * baseH).toInt()
                md = (mainArray!![mainIndex].marginDown * baseH).toInt()
                mr1 = (mainArray!![mainIndex].marginRight * baseH)
            }
            mr = (mr1 + horOffset - ho).toInt()
        }

        letterImage = AppCompatImageButton(this)
        var letterParam = RelativeLayout.LayoutParams(ww, hh)
        letterParam.setMargins(ml, mu, mr, md);
        horOffset = horOffset + ww;
        letterImage!!.setLayoutParams(letterParam)
        letterImage!!.setPadding(pl, pu, pr, pd);
        letterImage!!.setScaleType(ImageView.ScaleType.CENTER_CROP);
        val sx = mainArray?.get(mainIndex)?.scaleX
        val sy = mainArray?.get(mainIndex)?.scaleY
        letterImage!!.setScaleX(sx!!);
        letterImage!!.setScaleY(sy!!);
        letterImage!!.setBackgroundColor(Color.TRANSPARENT)

    }

/*
    horOffset = mr + ww.toDouble()
    mu = (mu + verOffset) as Int
    if (horOffset > endBorder) {
        move_all_word_to_the_next_row()
        jumpLine = true
    } else {
        create_Image(ww, hh, ml, mu, mr, md, pl, pu, pr, pd)
        startTextView = false
    }
}*/


    fun getAnimation(st: String): Int {
        var re = 0
        if (st.equals("א")) re = R.drawable.alleff;
        if (st == "ב") re = R.drawable.bet;
        if (st.equals("ג")) re = R.drawable.gimel;
        if (st.equals("ד")) re = R.drawable.dalet;
        if (st.equals("ה")) re = R.drawable.hai;
        if (st.equals("ו")) re = R.drawable.vav;
        if (st.equals("ז")) re = R.drawable.zain;
        if (st.equals("ח")) re = R.drawable.kait;
        if (st.equals("ט")) re = R.drawable.tet;
        if (st.equals("י")) re = R.drawable.yod;
        if (st.equals("כ")) re = R.drawable.kaaf;
        if (st.equals("ל")) re = R.drawable.lamed;
        if (st.equals("מ")) re = R.drawable.mem;
        if (st.equals("נ")) re = R.drawable.non;
        if (st.equals("ס")) re = R.drawable.shmech;
        if (st.equals("ע")) re = R.drawable.aahin;
        if (st.equals("פ")) re = R.drawable.phaii;
        if (st.equals("צ")) re = R.drawable.zadik;
        if (st.equals("ק")) re = R.drawable.koof;
        if (st.equals("ר")) re = R.drawable.reash;
        if (st.equals("ש")) re = R.drawable.sheen;
        if (st.equals("ת")) re = R.drawable.taf;
        if (st.equals("ם")) re = R.drawable.mem_shofit;
        if (st.equals("ן")) re = R.drawable.non_shofit;
        if (st.equals("ץ")) re = R.drawable.zhadik_shofit;
        if (st.equals("ף")) re = R.drawable.pai_shofit;
        if (st.equals("ך")) re = R.drawable.chaff_sofit;
        return re;
    }

    private fun create_letterArray() {
        var hor = DoubleArray(0)
        init_letterArray()
        mainArray = ArrayList()
        for (i in 0 until currentLettersArray.size) {
            val instance = currentLettersArray.get(i)
            hor = DoubleArray(28)
            for (i1 in 0..27) {
                hor[i] = 0.13
            }
            with(instance) {
                val le = LetterImage(
                    letter,
                    wight,
                    hight,
                    paddingUp,
                    paddingDown,
                    paddingRight,
                    paddingLeft,
                    marginRight,
                    marginLeft,
                    marginUp,
                    marginDown,
                    scaleX,
                    scaleY,
                    hor
                )
                mainArray.add(le)
            }

        }
        save_mainArray()
    }


    private fun init_letterArray() {
        val m0 = MyLetterImage(
            "stam", widthPd, 0.0,
            0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
            0.0, 1f, 1f, 1.0, 1.0
        )
        val m1 = MyLetterImage(
            "א", 0.60 * baseH, baseH,
            0.0, 0.0, 0.15 * baseH, 0.0,
            0.0, 0.0, 0.0, 0.0,
            0.9f, 1.0f, 0.13 * baseH, 0.00 * baseH
        )
        val m2 = MyLetterImage(
            "ב", 0.6 * baseH, baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.80f, 1.00f, 0.13 * baseH, 0.00 * baseH
        )
        val m3 = MyLetterImage(
            "ג", 0.6 * baseH, baseH,
            0.01 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.90f, 1.00f, 0.13 * baseH, 0.00 * baseH
        )
        val m4 = MyLetterImage(
            "ד", 0.6 * baseH, baseH,
            0.13 * baseH, 0.10 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            1.05f, 0.91f, 0.13 * baseH, 0.00 * baseH
        )
        val m5 = MyLetterImage(
            "ה", 0.6 * baseH, baseH,
            0.06 * baseH, 0.14 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.96f, 0.93f, 0.13 * baseH, 0.00 * baseH
        )
        val m6 = MyLetterImage(
            "ו", 0.26 * baseH, baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            1.00f, 1.00f, 0.13 * baseH, 0.00 * baseH
        )
        val m7 = MyLetterImage(
            "ז", 0.6 * baseH, baseH,
            0.00 * baseH, 0.00 * baseH, 0.10 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.90f, 0.92f, 0.13 * baseH, 0.00 * baseH
        )
        val m8 = MyLetterImage(
            "ח", 0.6 * baseH, baseH,
            0.02 * baseH, 0.20 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            1.26f, 1.15f, 0.13 * baseH, 0.00 * baseH
        )
        val m9 = MyLetterImage(
            "ט", 0.6 * baseH, baseH,
            0.01 * baseH, 0.00 * baseH, 0.00 * baseH, 0.02 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.88f, 0.80f, 0.13 * baseH, 0.00 * baseH
        )
        val m10 = MyLetterImage(
            "י", 0.26 * baseH, baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            1.00f, 1.00f, 0.13 * baseH, 0.00 * baseH
        )
        val m11 = MyLetterImage(
            "ך", 0.6 * baseH, baseH,
            0.00 * baseH, 0.35 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.20 * baseH,
            1.45f, 1.23f, 0.13 * baseH, 0.00 * baseH
        )
        val m12 = MyLetterImage(
            "כ", 0.6 * baseH, baseH,
            0.00 * baseH, 0.20 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            1.30f, 1.10f, 0.13 * baseH, 0.00 * baseH
        )
        val m13 = MyLetterImage(
            "ל", 0.6 * baseH, baseH,
            0.10 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            1.00f, 0.85f, 0.13 * baseH, 0.00 * baseH
        )
        val m14 = MyLetterImage(
            "ם", 0.7 * baseH, baseH,
            0.15 * baseH, 0.23 * baseH, 0.04 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.92f, 0.93f, 0.13 * baseH, 0.00 * baseH
        )
        val m15 = MyLetterImage(
            "מ", 0.6 * baseH, baseH,
            0.04 * baseH, 0.10 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            1.05f, 1.10f, 0.13 * baseH, 0.00 * baseH
        )
        val m16 = MyLetterImage(
            "ן", 0.24 * baseH, baseH,
            0.10 * baseH, 0.20 * baseH, 0.00 * baseH, 0.0,
            0.0, 0.10 * baseH, 0.0, 0.0,
            1.4f, 1.00f, 0.13 * baseH, 0.00 * baseH
        )
        val m17 = MyLetterImage(
            "נ", 0.6 * baseH, baseH,
            0.00 * baseH, 0.05 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.92f, 0.90f, 0.13 * baseH, 0.00 * baseH
        )
        val m18 = MyLetterImage(
            "ס", 0.6 * baseH, baseH,
            0.01 * baseH, 0.20 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.92f, 0.98f, 0.13 * baseH, 0.00 * baseH
        )
        val m19 = MyLetterImage(
            "ע", 0.6 * baseH, baseH,
            0.00 * baseH, 0.00 * baseH, 0.02 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.93f, 0.75f, 0.13 * baseH, 0.00 * baseH
        )
        val m20 = MyLetterImage(
            "ף", 0.6 * baseH, baseH,
            0.08 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.85f, 0.75f, 0.13 * baseH, 0.00 * baseH
        )
        val m21 = MyLetterImage(
            "פ", 0.6 * baseH, baseH,
            0.00 * baseH, 0.15 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.90f, 0.87f, 0.13 * baseH, 0.00 * baseH
        )
        val m22 = MyLetterImage(
            "ץ", 0.6 * baseH, baseH,
            0.05 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.80f, 0.75f, 0.13 * baseH, 0.00 * baseH
        )
        val m23 = MyLetterImage(
            "צ", 0.6 * baseH, baseH,
            0.00 * baseH, 0.00 * baseH, 0.03 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.90f, 0.80f, 0.13 * baseH, 0.00 * baseH
        )
        val m24 = MyLetterImage(
            "ק", 0.6 * baseH, baseH,
            0.00 * baseH, 0.32 * baseH, 0.02 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            1.27f, 1.34f, 0.13 * baseH, 0.00 * baseH
        )
        val m25 = MyLetterImage(
            "ר", 0.6 * baseH, baseH,
            0.00 * baseH, 0.22 * baseH, 0.01 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            1.23f, 1.10f, 0.13 * baseH, 0.00 * baseH
        )
        val m26 = MyLetterImage(
            "ש", 0.6 * baseH, baseH,
            0.04 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            1.03f, 1.00f, 0.13 * baseH, 0.00 * baseH
        )
        val m27 = MyLetterImage(
            "ת", 0.6 * baseH, baseH,
            0.00 * baseH, 0.25 * baseH, 0.05 * baseH, 0.00 * baseH,
            0.00 * baseH, 0.00 * baseH, 0.00 * baseH, 0.00 * baseH,
            1.10f, 0.97f, 0.13 * baseH, 0.00 * baseH
        )
        currentLettersArray = ArrayList()

        currentLettersArray.add(m0)
        currentLettersArray.add(m1)
        currentLettersArray.add(m2)
        currentLettersArray.add(m3)
        currentLettersArray.add(m4)
        currentLettersArray.add(m5)
        currentLettersArray.add(m6)
        currentLettersArray.add(m7)
        currentLettersArray.add(m8)
        currentLettersArray.add(m9)
        currentLettersArray.add(m10)
        currentLettersArray.add(m11)
        currentLettersArray.add(m12)
        currentLettersArray.add(m13)
        currentLettersArray.add(m14)
        currentLettersArray.add(m15)
        currentLettersArray.add(m16)
        currentLettersArray.add(m17)
        currentLettersArray.add(m18)
        currentLettersArray.add(m19)
        currentLettersArray.add(m20)
        currentLettersArray.add(m21)
        currentLettersArray.add(m22)
        currentLettersArray.add(m23)
        currentLettersArray.add(m24)
        currentLettersArray.add(m25)
        currentLettersArray.add(m26)
        currentLettersArray.add(m27)
    }


}

