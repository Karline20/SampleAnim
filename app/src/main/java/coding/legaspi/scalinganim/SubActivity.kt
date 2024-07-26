package coding.legaspi.scalinganim

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.animation.AccelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import androidx.cardview.widget.CardView

class SubActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animatedView: ImageView = findViewById(R.id.animated_view)
        val cardview: CardView = findViewById(R.id.cardview)
        val start : Button = findViewById(R.id.start)

        start.setOnClickListener {
            // Start the animation
            animatedView.post {
                cardview.visibility = GONE
                //startAnimation(animatedView)
                startNewAnimation(animatedView)
                //startCardToImageAnimation(cardview, animatedView)
            }
        }
    }

    private fun startAnimation(view: ImageView) {
        val startX = view.x
        val startY = view.y

        val endX = 0f
        val endY = 0f

        val translateX = ObjectAnimator.ofFloat(view, "translationX", startX, endX)
        val translateY = ObjectAnimator.ofFloat(view, "translationY", startY, endY)

        val scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f)
        val scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f)

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(translateX, translateY, scaleX, scaleY)
        animatorSet.duration = 3000 // 3 second
        animatorSet.interpolator = AccelerateInterpolator()
        animatorSet.start()
    }

    private fun startNewAnimation(view: View) {

//        // Get the center of the screen
//        val display = windowManager.defaultDisplay
//        val size = Point()
//        display.getSize(size)
//        val centerX = (size.x / 2).toFloat()
//        val centerY = (size.y / 2).toFloat()
//
//        // Set the view to the center of the screen
//        view.x = centerX - (view.width / 2)
//        view.y = centerY - (view.height / 2)
//
//        // Calculate the end position (top-left corner of the screen)
//        val endX = 0f
//        val endY = 0f
//
//        // Create translation animations
//        val translateX = ObjectAnimator.ofFloat(view, "translationX", 0f, endX - view.x)
//        val translateY = ObjectAnimator.ofFloat(view, "translationY", 0f, endY - view.y)
//
//        // Create scale animations
//        val scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f)
//        val scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f)
//
//        // Combine the animations
//        val animatorSet = AnimatorSet()
//        animatorSet.playTogether(translateX, translateY, scaleX, scaleY)
//        animatorSet.duration = 1000 // 1 seconds
//        animatorSet.interpolator = AccelerateInterpolator()
//        animatorSet.start()

        // Calculate the end position (top-left corner of the screen)
//        val endX = 0f
//        val endY = 0f
//
//        // Create translation animations based on the view's current position
//        val translateX = ObjectAnimator.ofFloat(view, "translationX", view.translationX, endX - view.x)
//        val translateY = ObjectAnimator.ofFloat(view, "translationY", view.translationY, endY - view.y)
//
//        // Create scale animations
//        val scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f)
//        val scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f)
//
//        // Combine the animations
//        val animatorSet = AnimatorSet()
//        animatorSet.playTogether(translateX, translateY, scaleX, scaleY)
//        animatorSet.duration = 1000 // 1 second
//        animatorSet.interpolator = AccelerateInterpolator()
//        animatorSet.start()

        // Calculate the end position (top-left corner of the screen)
        val endX = 0f
        val endY = 0f

        // Create translation animations based on the view's current position
        val translateX = ObjectAnimator.ofFloat(view, "x", view.x, endX)
        val translateY = ObjectAnimator.ofFloat(view, "y", view.y, endY)

        // Create scale animations
        val scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f)
        val scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f)

        // Combine the animations
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(translateX, translateY, scaleX, scaleY)
        animatorSet.duration = 1000 // 1 second
        animatorSet.interpolator = AccelerateInterpolator()
        animatorSet.start()
    }

    private fun startCardToImageAnimation(cardView: CardView, imageView: ImageView) {
        // Get the center of the screen
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val centerX = (size.x / 2).toFloat()
        val centerY = (size.y / 2).toFloat()

        // Set initial positions for cardView and imageView
        cardView.x = centerX - (cardView.width / 2)
        cardView.y = centerY - (cardView.height / 2)
        imageView.x = centerX - (imageView.width / 2)
        imageView.y = centerY - (imageView.height / 2)

        // Prepare the imageView (initially hidden)
        imageView.visibility = View.VISIBLE
        imageView.alpha = 1f
        imageView.scaleX = 1f
        imageView.scaleY = 1f

        // Create the cardView animations
        val cardViewFadeOut = ObjectAnimator.ofFloat(cardView, "alpha", 1f, 0f)
        val cardViewScaleX = ObjectAnimator.ofFloat(cardView, "scaleX", 1f, 0f)
        val cardViewScaleY = ObjectAnimator.ofFloat(cardView, "scaleY", 1f, 0f)

        // Create the imageView animations
        val imageViewScaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 0.5f)
        val imageViewScaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 1f, 0.5f)
        val imageViewTranslateX = ObjectAnimator.ofFloat(imageView, "translationX", 0f, -centerX)
        val imageViewTranslateY = ObjectAnimator.ofFloat(imageView, "translationY", 0f, -centerY)

        // Combine the animations for cardView
        val cardViewAnimatorSet = AnimatorSet().apply {
            playTogether(cardViewFadeOut, cardViewScaleX, cardViewScaleY)
            duration = 1000 // 2 seconds
            interpolator = AccelerateInterpolator()
        }

        // Combine the animations for imageView
        val imageViewAnimatorSet = AnimatorSet().apply {
            playTogether(imageViewScaleX, imageViewScaleY, imageViewTranslateX, imageViewTranslateY)
            duration = 2000 // 2 seconds
            interpolator = AccelerateInterpolator()
        }

        // Start imageView animation with a slight delay
        imageViewAnimatorSet.startDelay = 1000 // Delay of 1 second

        // Start animations
        cardViewAnimatorSet.start()
        imageViewAnimatorSet.start()
    }

}