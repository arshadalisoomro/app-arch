package pk.inlab.app.apparch

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val LOG_TAG: String = "ArchKotlin"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        Log.i(LOG_TAG, "OnCreate()")

    }

    override fun onStart() {
        super.onStart()
        Log.i(LOG_TAG, "OnStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(LOG_TAG, "OnResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(LOG_TAG, "OnPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(LOG_TAG, "OnStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(LOG_TAG, "OnDestroy()")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
