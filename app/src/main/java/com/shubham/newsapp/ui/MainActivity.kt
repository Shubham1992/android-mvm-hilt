package com.shubham.newsapp.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.shubham.learnhilt.R
import com.shubham.learnhilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var job: Job
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        //test()
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun test() {

        val handler = CoroutineExceptionHandler { _, throwable ->
            println("exception...")
        }

        job = CoroutineScope(Dispatchers.IO + handler).launch {
            fun1()

            try {
                launch { fun2() }
            } catch (e: java.lang.Exception) {

            }


        }

    }

    private suspend fun fun1() {
        delay(3000L)
        Log.e("fun 1", "fun 1 .....")
        withContext(Dispatchers.Main) {
            Toast.makeText(
                this@MainActivity,
                "message",
                Toast.LENGTH_SHORT
            ).show()
        }
        //job.cancel()

    }

    private fun fun2() {
        //delay(3000L)
        Log.e("fun 2", " fun 2.....")

        throw java.lang.Exception("Some exception")


    }
}