package com.example.teta_gradle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.feature1.Feature1
import com.example.feature2.Feature2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Feature1().printFeatureName()
        Feature2().printFeatureName()
    }
}