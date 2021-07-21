package com.android.projet_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.android.projet_android.R
import com.android.projet_android.databinding.ActivityMainBinding
import com.android.projet_android.ui.home_page.HomePage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_view, HomePage())
            .commitAllowingStateLoss()*/
        /*val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)*/

       /* if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<Classement>(R.id.container_view)
            }
        }*/
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<HomePage>(R.id.container_view)
            }
        }
    }
}