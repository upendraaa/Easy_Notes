package d4static.dev999.easynotes.dashboard

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import d4static.dev999.easynotes.R
import kotlinx.android.synthetic.main.layout_appbar.*


class DashboardActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemReselectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setSupportActionBar(toolbar)
        loadFragment(DashBoardFragment())

    }

    override fun onNavigationItemReselected(item: MenuItem) {
        var fragment: Fragment? = null

        when (item.itemId) {
            R.id.screen1 -> fragment = DashBoardFragment()
            R.id.screen2 -> fragment = DashBoardFragment()
            R.id.screen3 -> fragment = DashBoardFragment()
            R.id.screen4 -> fragment = DashBoardFragment()
        }

        return loadFragment(fragment)
    }

    private fun loadFragment(fragment: Fragment?) { //switching fragment
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }
    }

}
