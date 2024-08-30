package com.jordan.bulletin_board

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener

class MainActivity : AppCompatActivity(), OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var toolbar: Toolbar
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        // Инициализация DrawerLayout и Toolbar
        drawerLayout = findViewById(R.id.drawerLayout)
        toolbar = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.navView)

        // Устанавливаем Toolbar в качестве ActionBar
        //setSupportActionBar(toolbar)

        // Инициализация ActionBarDrawerToggle
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)

        // Добавляем синхронизацию состояния
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_my_ads -> {
                Toast.makeText(this, "Press id_my_ads", Toast.LENGTH_LONG).show()
            }

            R.id.id_car -> {
                Toast.makeText(this, "Press id_car", Toast.LENGTH_LONG).show()
            }

            R.id.id_pc -> {
                Toast.makeText(this, "Press id_pc", Toast.LENGTH_LONG).show()
            }

            R.id.id_smartphone -> {
                Toast.makeText(this, "Press id_smartphone", Toast.LENGTH_LONG).show()
            }

            R.id.id_dm -> {
                Toast.makeText(this, "Press id_dm", Toast.LENGTH_LONG).show()
            }

            R.id.id_sing_in -> {
                Toast.makeText(this, "Press id_sing_in", Toast.LENGTH_LONG).show()
            }

            R.id.id_sing_up -> {
                Toast.makeText(this, "Press id_sing_up", Toast.LENGTH_LONG).show()
            }

            R.id.id_sing_out -> {
                Toast.makeText(this, "Press id_sing_out", Toast.LENGTH_LONG).show()
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


}