package com.example.studyfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.studyfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

// creating custom function for Fragment class
fun Fragment.navigate(fragmentClass: Class<Fragment>, bundle: Bundle? = null){
    requireActivity().supportFragmentManager.commit {
        add(R.id.container, fragmentClass, bundle, fragmentClass.name)
    }
}