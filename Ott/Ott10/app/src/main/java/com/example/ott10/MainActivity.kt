package com.example.ott10

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
*/



        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            start.setOnClickListener {
                val avd = image.drawable as AnimatedVectorDrawable
                avd.start()
            }
    }


/*
 // from udemy course Animation 3/1/2020 name Vector
    start.setOnClickListener {
        val avd = image.drawable as AnimatedVectorDrawable
        avd.start()
    }
}*/







    fun getAnimation(st:String):Int{
         var re=0
        if (st.equals ("א")) re = R.drawable.alleff;
        if (st.equals ("ב")) re = R.drawable.bet;
        if (st.equals ("ג")) re = R.drawable.gimel;
        if (st.equals ("ד")) re = R.drawable.dalet;
        if (st.equals ("ה")) re = R.drawable.hai;
        if (st.equals ("ו")) re = R.drawable.vav;
        if (st.equals ("ז")) re = R.drawable.zain;
        if (st.equals ("ח")) re = R.drawable.kait;
        if (st.equals ("ט")) re = R.drawable.tet;
        if (st.equals ("י")) re = R.drawable.yod;
        if (st.equals ("כ")) re = R.drawable.kaaf;
        if (st.equals ("ל")) re = R.drawable.lamed;
        if (st.equals ("מ")) re = R.drawable.mem;
        if (st.equals ("נ")) re = R.drawable.non;
        if (st.equals ("ס")) re = R.drawable.shmech;
        if (st.equals ("ע")) re = R.drawable.aahin;
        if (st.equals ("פ")) re = R.drawable.phaii;
        if (st.equals ("צ")) re = R.drawable.zadik;
        if (st.equals ("ק")) re = R.drawable.koof;
        if (st.equals ("ר")) re = R.drawable.reash ;
        if (st.equals ("ש")) re = R.drawable.sheen;
        if (st.equals ("ת")) re = R.drawable.taf ;
        if (st.equals ("ם")) re = R.drawable.mem_shofit;
        if (st.equals ("ן")) re = R.drawable.non_shofit;
        if (st.equals ("ץ")) re = R.drawable.zhadik_shofit;
        if (st.equals ("ף")) re = R.drawable.pai_shofit;
        if (st.equals ("ך")) re = R.drawable.chaff_sofit;
        return re;
    }
}

fun activateCurrentLettter(st:String){

   var currentLetter = st

    val char = st.single()
     var  mainIndex = char.toInt() - 1487;

    make_letterImage()




}

fun make_letterImage() {

}


/*private open fun make_letterImage() {
    val ww: Int
    val hh: Int
    val pl: Int
    val pu: Int
    val pr: Int
    val pd: Int
    val ml: Int
    var mu: Int
    val md: Int
    val mr: Int
    val ho: Int
    val ho1: Double
    val mr1: Double
    if (startTextView) {
        ho = 0
        horOffset = 0.0
        counterLetter = 0
    } else {
        ho1 = mainArray.get(mainIndex).getHorOffset().get(ttIndex)
        ho = (ho1 * baseH) as Int
    }
    counterLetter++
    ww = (mainArray.get(mainIndex).getWight() * baseH)
    hh = (mainArray.get(mainIndex).getHight() * baseH)
    pl = (mainArray.get(mainIndex).getPaddingLeft() * baseH)
    pu = (mainArray.get(mainIndex).getPaddingUp() * baseH)
    pr = (mainArray.get(mainIndex).getPaddingRight() * baseH)
    pd = (mainArray.get(mainIndex).getPaddingDown() * baseH)
    ml = (mainArray.get(mainIndex).getMarginLeft() * baseH)
    mu = (mainArray.get(mainIndex).getMarginUp() * baseH)
    md = (mainArray.get(mainIndex).getMarginDown() * baseH)
    mr1 = (mainArray.get(mainIndex).getMarginRight() * baseH) as Int.toDouble()
    mr = (mr1 + horOffset - ho)
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


/*
*  private  void  activateCurrentLetter(String st){
        jumpLine=false;
        currentString=currentString+st;
        wirttenString=wirttenString+st;
        currentLetter = st;
        char ch = currentLetter.charAt ( 0 );
        mainIndex = (int) ch - 1487;
        make_letterImage();
        if (!jumpLine) {
            letterImage.setImageResource ( getAnimation ( st ) );
            letterLayout.addView ( letterImage );
            Drawable d = letterImage.getDrawable ();
            AnimatedVectorDrawableCompat avd = (AnimatedVectorDrawableCompat) d;
            avd.start ();
            startTextView = false;
        }
        ttIndex = mainIndex;
        jumpLine=false;
    }

    private int getAnimation(String st){
        int re=0;
        if (st.equals ("א")) re = R.drawable.alleff;
        if (st.equals ("ב")) re = R.drawable.bet;
        if (st.equals ("ג")) re = R.drawable.gimel;
        if (st.equals ("ד")) re = R.drawable.dalet;
        if (st.equals ("ה")) re = R.drawable.hai;
        if (st.equals ("ו")) re = R.drawable.vav;
        if (st.equals ("ז")) re = R.drawable.zain;
        if (st.equals ("ח")) re = R.drawable.kait;
        if (st.equals ("ט")) re = R.drawable.tet;
        if (st.equals ("י")) re = R.drawable.yod;
        if (st.equals ("כ")) re = R.drawable.kaaf;
        if (st.equals ("ל")) re = R.drawable.lamed;
        if (st.equals ("מ")) re = R.drawable.mem;
        if (st.equals ("נ")) re = R.drawable.non;
        if (st.equals ("ס")) re = R.drawable.shmech;
        if (st.equals ("ע")) re = R.drawable.aahin;
        if (st.equals ("פ")) re = R.drawable.phaii;
        if (st.equals ("צ")) re = R.drawable.zadik;
        if (st.equals ("ק")) re = R.drawable.koof;
        if (st.equals ("ר")) re = R.drawable.reash ;
        if (st.equals ("ש")) re = R.drawable.sheen;
        if (st.equals ("ת")) re = R.drawable.taf ;
        if (st.equals ("ם")) re = R.drawable.mem_shofit;
        if (st.equals ("ן")) re = R.drawable.non_shofit;
        if (st.equals ("ץ")) re = R.drawable.zhadik_shofit;
        if (st.equals ("ף")) re = R.drawable.pai_shofit;
        if (st.equals ("ך")) re = R.drawable.chaff_sofit;
          return re;
    }*/
