package com.example.new_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.new_app.cliente.ClienteNoticias
import com.example.new_app.databinding.ActivityMainBinding
import com.example.new_app.viewmodel.ViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navegador: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

    binding.bottomNav.setOnItemSelectedListener {
        when (it.itemId) {
            R.id.home_menu-> navController.navigate(R.id.listaFragment)
            R.id.search_menu-> navController.navigate(R.id.buscarFragment)

            }
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navegador, null);
    }}
