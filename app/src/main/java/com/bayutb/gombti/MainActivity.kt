package com.bayutb.gombti

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bayutb.gombti.databinding.ActivityMainBinding
import com.bayutb.gombti.ui.main.AccountFragment
import com.bayutb.gombti.ui.main.HomeFragment
import com.bayutb.gombti.ui.main.PersonalityFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(HomeFragment())

        binding.apply {
            bottomNav.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        loadFragment(HomeFragment())
                        true
                    }
                    R.id.personality -> {
                        loadFragment(PersonalityFragment())
                        true
                    }
                    R.id.account -> {
                        loadFragment(AccountFragment())
                        true
                    }
                    else -> { true }
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.commit()
    }
}