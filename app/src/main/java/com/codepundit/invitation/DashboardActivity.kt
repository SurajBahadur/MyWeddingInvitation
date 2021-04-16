
package com.codepundit.invitation

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.viewpager.widget.ViewPager
import com.codepundit.invitation.ui.main.SectionsPagerAdapter
import com.codepundit.invitation.ui.menu.ContactActivity
import com.codepundit.invitation.ui.menu.DirectionActivity
import com.codepundit.invitation.ui.menu.VenueActivity
import com.google.android.material.tabs.TabLayout

class DashboardActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        drawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        /*val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_venue, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)*/

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.dashboard, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_like->{
                openPlayStoreIntent()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                val intent = Intent(this, DashboardActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
            R.id.nav_venue -> {
                startActivity(Intent(this, VenueActivity::class.java))
            }
            /*R.id.nav_direction -> {
                startActivity(Intent(this, DirectionActivity::class.java))
            }*/
            R.id.nav_contact -> {
                startActivity(Intent(this, ContactActivity::class.java))
            }
            R.id.nav_share -> {
                share()

            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun share() {
        val builder = StringBuilder()
        builder.append("💗 Wedding Invitation 💗")
        builder.append("\n")
        builder.append(
            "In this little life, we are always ready to hunt down happiness. I am here to invite you to be a reason for much" +
                    "more happiness at my wedding and give me one more reason to smile"
        )
        builder.append("\n")
        builder.append("\n")
        builder.append("Invitation App")
        builder.append("\n")
        builder.append("\n")
        builder.append("https://play.google.com/store/apps/details?id=${packageName}")
        showShareDialog(builder.toString())
    }


    fun openPlayStoreIntent() {
        val appPackageName = packageName // getPackageName() from Context or Activity object
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=$appPackageName")
                )
            )
        } catch (anfe: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                )
            )
        }
    }

    private fun showShareDialog(dataToShare: String) {
        val intent = Intent()
        intent.action = "android.intent.action.SEND"
        intent.putExtra("android.intent.extra.TEXT", dataToShare)
        intent.type = "text/plain"
        startActivity(intent)
    }
}