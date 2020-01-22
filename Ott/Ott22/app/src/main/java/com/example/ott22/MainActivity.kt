package com.example.ott22

import android.animation.*
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.View
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Animator.AnimatorListener {
  // for XMl
    lateinit var animatorSet: Animator
    lateinit var animator: Animator
    //for CODE
    lateinit var objectAnimatorSet: ObjectAnimator
    lateinit var objectAnimator: ObjectAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val avd = ottImage.drawable as AnimatedVectorDrawable
        avd.start()

    }

    fun ahlfaOn_Onclick(view: View) {
        animator = AnimatorInflater.loadAnimator(this, R.animator.ahlfa_it)
        animator?.apply {
            setTarget(ottImage)
            addListener(this@MainActivity)
            start()
        }
    }

    fun scale_Onclick(view: View) {
        //XML
       /* animator = AnimatorInflater.loadAnimator(this, R.animator.scale_it)
        animator?.apply {
            setTarget(ottImage)
            addListener(this@MainActivity)
            start()
        }*/
        //CODE
        objectAnimator= ObjectAnimator.ofFloat(ottImage,"scaleX",1.0f,0.0f)
        objectAnimator?.apply {
            duration=2000
            repeatCount=5
            repeatMode=ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }

    }

    fun transfer_Onclick(view: View) {
        animatorSet =
            AnimatorInflater.loadAnimator(this, R.animator.transfer_it) as AnimatorSet
        animatorSet?.apply {
            setTarget(ottImage)
            addListener(this@MainActivity)
            start()
        }
    }

    fun rotate_Onclick(view: View) {
        //For XML
       /* animator = AnimatorInflater.loadAnimator(this, R.animator.rotate_it)
        animator?.apply {
            setTarget(ottImage)
            addListener(this@MainActivity)
            start()
        }*/
        //CODE
        objectAnimator= ObjectAnimator.ofFloat(ottImage,"rotation",0.0f,-180.0f)
        objectAnimator?.apply {
            duration=2000
            repeatCount=4
            repeatMode=ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }

    }
    fun setOn_Onclick(view: View) {
        //XML
      /*  //animator = AnimatorInflater.loadAnimator(this, R.animator.set_of_scale)
        animator = AnimatorInflater.loadAnimator(this, R.animator.set_of_rotate_and_scale)
        animator?.apply {
            setTarget(ottImage)
            addListener(this@MainActivity)
            start()
        }*/
        //CODE
// Root Animator Set
        val rootSet = AnimatorSet()

        // Flip Animation
        val flip = ObjectAnimator.ofFloat(ottImage, "rotationX", 0.0f, 360.0f)
        flip.duration = 500

        // Child Animator Set
        val childSet = AnimatorSet()

        // Scale Animations
        val scaleX = ObjectAnimator.ofFloat(ottImage, "scaleX", 1.0f, 1.5f)
        scaleX.duration = 500
       // scaleX.interpolator=BounceInterpolator()
        scaleX.interpolator=OvershootInterpolator()

        val scaleY = ObjectAnimator.ofFloat(ottImage, "scaleY", 1.0f, 1.5f)
        scaleY.duration = 500
      //  scaleY.interpolator=BounceInterpolator()
        scaleY.interpolator=OvershootInterpolator()

       /* rootSet.playSequentially(flip,childSet)
        childSet.playTogether(scaleX,scaleY)*/

        /*// another option of orderring
        rootSet.playSequentially(childSet,flip)
        childSet.playTogether(scaleX,scaleY)*/

        // another option of writting
        rootSet.play(childSet).after(flip)
        childSet.play(scaleX).with(scaleY)

        rootSet.start()
    }
    fun test_Onclick(view: View) {
        val rootSet = AnimatorSet()
        val avd = ottImage.drawable as AnimatedVectorDrawable

        val childSet = AnimatorSet()
        val scaleX = ObjectAnimator.ofFloat(ottImage, "scaleX", 1.0f, 1.5f)
        scaleX.duration = 500
        val scaleY = ObjectAnimator.ofFloat(ottImage, "scaleY", 1.0f, 1.5f)
        scaleY.duration = 500
    }

    fun start_Onclick(view: View) {
        startBtn.setOnClickListener {
            val avd = ottImage.drawable as AnimatedVectorDrawable
            var mLoop=true
            kotlin.run {
                while (mLoop){
                    if (!avd.isRunning){
                        Toast.makeText(this," avd IS FINISH",Toast.LENGTH_SHORT).show()
                        mLoop=false
                    }

                }
            }

            avd.start()
        }
    }

    override fun onAnimationRepeat(animation: Animator?) {
        Toast.makeText(this, " Its  ***  REPEAT  *** ", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationEnd(animation: Animator?) {
        Toast.makeText(this, " Its  ***  END  *** ", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationCancel(animation: Animator?) {
        Toast.makeText(this, " Its  ***  CANCEL  *** ", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationStart(animation: Animator?) {
        Toast.makeText(this, " Its  ***  START  *** ", Toast.LENGTH_SHORT).show()
    }

    fun viewPropertyAnimator_Onclick(view: View) {
        val vpa=ottImage.animate()
        vpa.apply {  //all the animation in the same time
            rotationX(360f)
            scaleX(1.5f)
            scaleY(1.5f)
            duration=1000
            interpolator=BounceInterpolator()
            start()
        }
    }

    fun viewHolder_Onclick(view: View) {

          val flip = PropertyValuesHolder.ofFloat("rotationX", 0.0f, 360.0f)
        val scaleX = PropertyValuesHolder.ofFloat( "scaleX", 1.0f, 1.5f)
        val scaleY = PropertyValuesHolder.ofFloat( "scaleY", 1.0f, 1.5f)

        val objAnim=ObjectAnimator.ofPropertyValuesHolder(ottImage,flip,scaleX,scaleY)  //all the animation in the same time
        objAnim.apply {
            duration=1000
            interpolator=BounceInterpolator()
            start()
        }



    }


}




