package com.empresa.vclaminationsmantenimiento

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.empresa.vclaminationsmantenimiento.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import android.content.Intent
import android.view.View
import androidx.core.view.isVisible
import com.google.firebase.auth.FirebaseAuth
import com.empresa.vclaminationsmantenimiento.ui.gallery.GalleryFragment
import com.empresa.vclaminationsmantenimiento.ui.Opcion1preventivo
import com.empresa.vclaminationsmantenimiento.ui.Opcion2correctivo

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            startActivity(Intent(this, reporte2::class.java))
            Snackbar.make(view, "Abriendo ReporteActivity", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    // login ----------------------------------------------------------------------------------------------------------
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                FirebaseAuth.getInstance().signOut()
                startActivity(Intent(this, LoginEmail::class.java))
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    // ------------------------------------------------------------------------------------------------------------------

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    // ======================================================
    // MANEJO DE SUBMENÚS (VERSIÓN OPTIMIZADA)
    // ======================================================

    /**
     * Función genérica para mostrar/ocultar cualquier submenú
     * @param viewId ID de la vista del submenú (ej: R.id.home_submenu)
     */
    private fun toggleSubmenu(viewId: Int) {
        val submenu = findViewById<View>(viewId) ?: return
        submenu.visibility = if (submenu.isVisible) View.GONE else View.VISIBLE
    }

    /**
     * Versiones específicas que llaman a la función genérica
     * (Mantienen la misma firma para compatibilidad con onClick en XML)
     */
    fun toggleHomeMenu(view: View) = toggleSubmenu(R.id.home_submenu)
    fun toggleHomeOption1Menu(view: View) = toggleSubmenu(R.id.home_option1_submenu)
    fun toggleHomeOption2Menu(view: View) = toggleSubmenu(R.id.home_option2_submenu)
    fun toggleHomeOption3Menu(view: View) = toggleSubmenu(R.id.home_option3_submenu)
    fun toggleHomeOption4Menu(view: View) = toggleSubmenu(R.id.home_option4_submenu)
    fun toggleGalleryMenu(view: View) = toggleSubmenu(R.id.gallery_submenu)
    fun toggleGalleryOption1Menu(view: View) = toggleSubmenu(R.id.gallery_option1_submenu)
    fun toggleGalleryOption2Menu(view: View) = toggleSubmenu(R.id.gallery_option2_submenu)
    fun toggleSlideshowMenu(view: View) = toggleSubmenu(R.id.slideshow_submenu)
    fun navigateToSlideshowOption1(view: View) = navigateToActivity(view)
    fun navigateToSlideshowOption2(view: View) = navigateToActivity(view)


    // ======================================================
    // MANEJO DE NAVEGACIÓN (VERSIÓN UNIFICADA)
    // ======================================================

    /**
     * Función unificada para navegar a actividades
     * @param view Vista que dispara la navegación (se usa view.id para determinar destino)
     */
    fun navigateToActivity(view: View) {
        val destination = when (view.id) {
            // Home
            R.id.btn_home_option1_item1 -> HomeOption1Item1Activity::class.java
            // Gallery
            R.id.btn_gallery_option1_item1 -> GalleryOption1Item1Activity::class.java
            // Slideshow
            R.id.btn_slideshow_option1 -> SlideshowOption1Activity::class.java
            R.id.btn_slideshow_option2 -> SlideshowOption2Activity::class.java
            // Default
            else -> DefaultActivity::class.java
        }
        startActivity(Intent(this, destination))
    }
    // ======================================================
    // FIN DE LAS SECCIONES DE MANEJO DE MENÚS Y NAVEGACIÓN
    // ======================================================
}