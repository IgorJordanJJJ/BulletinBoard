package com.jordan.bulletin_board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.jordan.bulletin_board.databinding.ActivityMainBinding
import com.jordan.bulletin_board.dialoghelper.DialogConst
import com.jordan.bulletin_board.dialoghelper.DialogHelper

class MainActivity : AppCompatActivity(), OnNavigationItemSelectedListener {

    private lateinit var rootElement: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var toolbar: Toolbar
    private lateinit var navigationView: NavigationView
    private lateinit var tvAccount: TextView

    private val dialogHelper = DialogHelper(this)
    val myAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootElement = ActivityMainBinding.inflate(layoutInflater) //Инициализация экрана
        val view = rootElement.root
        setContentView(view)
        init()
    }

    override fun onStart() {
        super.onStart()
        uiUpdate(myAuth.currentUser)
    }

    private fun init() {
        // Инициализация DrawerLayout и Toolbar
        drawerLayout = rootElement.drawerLayout
        toolbar = rootElement.mainContent.toolbar
        navigationView = rootElement.navView
        tvAccount = navigationView.getHeaderView(0).findViewById(R.id.tvAccountEmail)

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

            R.id.id_sing_up -> {
                dialogHelper.createSignDialog(DialogConst.SIGN_UP_STATE)
            }

            R.id.id_sing_in -> {
                dialogHelper.createSignDialog(DialogConst.SIGN_IN_STATE)
            }

            R.id.id_sing_out -> {
                uiUpdate(null)
                myAuth.signOut()
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun uiUpdate(user: FirebaseUser?) {
        tvAccount.text = if(user == null){
            resources.getString(R.string.not_reg)
        }else{
            user.email
        }

    }


}