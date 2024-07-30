package com.minthanhtike.swipeablewithframlayout

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.minthanhtike.swipeablewithframlayout.databinding.ActivityMainBinding
import kotlin.math.abs


class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(mainBinding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dataList = ArrayList<String>()
        for (i in 0..5) {
            dataList.add("Item " + (i + 1))
        }
        val viewPager = mainBinding.viewPager
        val adapter = MyPagerAdapter(dataList)
        viewPager.adapter = adapter

        viewPager.offscreenPageLimit = 3

        viewPager.setPageTransformer { page, position ->
            page.apply {
                ViewCompat.setElevation(page, -abs(position))
                Log.d("PagePosition", "onCreate: $position")
                val scaleFactor = -SCALE_FACTOR * position + DEFAULT_SCALE
                mainBinding.pagerItemPosition.text = scaleFactor.toString()
                when (position) {
                    in 0f..<3f -> {
                        //change the size of the page view. enlarge the page but
                        // don't change its position within the ViewPager.
                        scaleX = scaleFactor
                        scaleY = scaleFactor
                        //shifts the page horizontally. By applying a negative translationX to the second page,
                        //sliding it to the left,
                        //allowing it to peek out from beneath the first page.
                        translationX = -(width / (DEFAULT_TRANSLATION_FACTOR / 1.5f)) * position
                    }

                    else -> {
                        translationX = DEFAULT_TRANSLATION_X
                        scaleX = DEFAULT_SCALE
                        scaleY = DEFAULT_SCALE
                    }
                }
                alpha = if (position < -1f) {
                    Log.d("Position", "onCreate: true")
                    0f
                } else {
                    Log.d("Position", "onCreate: false")
                    1f
                }
            }
        }
    }

    companion object {
        private const val DEFAULT_TRANSLATION_X = .0f
        private const val DEFAULT_TRANSLATION_FACTOR = 1.46f

        // A constant that controls how quickly the page shrinks as it moves away from the center.
        private const val SCALE_FACTOR = .1f
        private const val DEFAULT_SCALE = 1f
    }
}