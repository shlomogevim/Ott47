package com.example.ott46

import android.content.Context

class Helper(val context: Context) {




    fun getAnimation(st: String) = when (st) {
        "א" -> R.drawable.l2_101_allef
        "ב" -> R.drawable.l2_102_bet;
        "ג" -> R.drawable.l2_103_gimel
        "ד" -> R.drawable.l2_104_daled
        "ה" -> R.drawable.l2_105_haii
        "ו" -> R.drawable.l2_106_vav
        "ז" -> R.drawable.l2_107_zain
        "ח" -> R.drawable.l2_108_kait
        "ט" -> R.drawable.l2_109_tet
        "י" -> R.drawable.l2_110_yod
        "כ" -> R.drawable.l2_111_kaaf
        "ל" -> R.drawable.l2_112_lamed
        "מ" -> R.drawable.l2_113_mem
        "נ" -> R.drawable.l2_114_non
        "ס" -> R.drawable.l2_115_shamech
        "ע" -> R.drawable.l2_116_aahin
        "פ" -> R.drawable.l2_117_phaii
        "צ" -> R.drawable.l2_118_zadik
        "ק" -> R.drawable.l2_119_koof;
        "ר" -> R.drawable.l2_120_reash
        "ש" -> R.drawable.l2_121_sheen
        "ת" -> R.drawable.l2_122_taf
        "ם" -> R.drawable.l2_123_mem_shofit
        "ן" -> R.drawable.l2_124_non_shofit
        "ץ" -> R.drawable.l2_125_zhadik_shofit
        "ף" -> R.drawable.l2_126_pai_shofit
        "ך" -> R.drawable.l2_127_chaff_sofit

        else -> R.drawable.l2_101_allef

    }


}
/*fun getAnimation(st: String): Int {
    var re = 0
    if (st.equals("א")) re = R.drawable.l2_1_allef
    if (st.equals("ב")) re = R.drawable.l2_2_bet;
    if (st.equals("ג")) re = R.drawable.l2_3_gimel
    if (st.equals("ד")) re = R.drawable.l2_4_daled
    if (st.equals("ה")) re = R.drawable.hai0
    if (st.equals("ו")) re = R.drawable.vav0
    if (st.equals("ז")) re = R.drawable.zain0
    if (st.equals("ח")) re = R.drawable.kait0
    if (st.equals("ט")) re = R.drawable.tet0
    if (st.equals("י")) re = R.drawable.yod0

    if (st.equals("ל")) re = R.drawable.lamed0


    if (st.equals("נ")) re = R.drawable.non0



    if (st.equals("ר")) re = R.drawable.reash0

    return re;
}*/

/*  if (st.equals("ז")) re = R.drawable.zain;
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
  if (st.equals("ך")) re = R.drawable.chaff_sofit;*/
//}

