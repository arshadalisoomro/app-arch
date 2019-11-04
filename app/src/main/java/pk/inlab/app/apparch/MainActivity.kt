package pk.inlab.app.apparch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import pk.inlab.app.apparch.viewmodel.DiceViewModel

class MainActivity : AppCompatActivity() {

    // Using view model
    private lateinit var viewModel: DiceViewModel

    private val LOG_TAG: String = "ArchKotlin"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //Using view model
        viewModel = ViewModelProviders.of(this).get(DiceViewModel::class.java)
        viewModel.sum.observe(this, Observer {
            tv_dice_score.text = "Your score is $it"
        })

        viewModel.valueInt.observe(this, Observer {
            updateDisplay(it)
        })

        // with it anonymous argument
        btn_roll.text = "Roll'em"
        btn_roll.setOnClickListener {
            viewModel.rollDice()
        }

        // AppCompat Class implements Lifecycle Owner and
        // lifecycle property comes from there now add custom
        // Lifecycle Observer AppLifecycleObserver()
        lifecycle.addObserver(AppLifecycleObserver())

    }

    private fun updateDisplay(randInt: Int) {
        val drawableResource = when(randInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        iv_dice.setImageResource(drawableResource)
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
