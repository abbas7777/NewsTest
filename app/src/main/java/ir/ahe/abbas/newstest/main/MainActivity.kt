package ir.ahe.abbas.newstest.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import ir.ahe.abbas.newstest.R
import ir.ahe.abbas.newstest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root as View)

        setUpViews()
    }

    private fun setUpViews() {
        val bnvMain=binding.btmMainActivityMenu
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.action_hostFragment_to_homeFragment)

        bnvMain.setOnItemSelectedListener {

            when(it.itemId){

                R.id.bnav_home ->{
                    navController.navigate(R.id.action_hostFragment_to_homeFragment)
                    true
                }
                R.id.bnav_cat -> {
                    navController.navigate(R.id.action_hostFragment_to_homeFragment)
                    true
                }
                else -> {
                    false
                }
            }
        }

    }
}