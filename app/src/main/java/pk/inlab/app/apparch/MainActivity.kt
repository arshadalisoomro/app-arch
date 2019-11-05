package pk.inlab.app.apparch

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import pk.inlab.app.apparch.util.ResetObserver
import pk.inlab.app.apparch.viewmodel.DiceViewModel

class MainActivity : AppCompatActivity(), ResetObserver {

    // Using view model
    private lateinit var viewModel: DiceViewModel
    private var roundCounter: Int = 1
    private var finalSum: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // init observers
        setUpObservers()

        // with it anonymous argument
        btn_roll.text = getString(R.string.roll_it)
        btn_roll.setOnClickListener {
            // restricting to only six rounds
            if (roundCounter <= 6){
                viewModel.rollDice(roundCounter)
            }
            roundCounter++;
        }

        // Restart Button
        btn_restart.text = getString(R.string.play_again)
        btn_restart.setOnClickListener {

            viewModel.isCont.removeObservers(this)
            viewModel.sum.removeObservers(this)
            viewModel.valueInt.removeObservers(this)

            // re-set random value & sum in ViewModel
            viewModel.resetValues()

            // re-set round counter
            roundCounter = 0

            // call resetObserver here we are resetting observers
            resetObserver()

            //show Roll it Button
            btn_roll.visibility = View.VISIBLE
            tv_dice_score.text = getString(R.string.msg_score, 0)
            btn_restart.visibility = View.GONE
        }

        // AppCompat Class implements Lifecycle Owner and
        // lifecycle property comes from there now add custom
        // Lifecycle Observer AppLifecycleObserver()
        lifecycle.addObserver(AppLifecycleObserver())

    }

    private fun setUpObservers() {

        Log.e(LOG_TAG, "setUpObserver()")
        //Using view model
        viewModel = ViewModelProviders.of(this).get(DiceViewModel::class.java)
        viewModel.sum.observe(this, Observer { sum ->
            finalSum = sum
        })

        viewModel.isCont.observe(this, Observer { isCont ->
            if (isCont) {
                // formatted string in string resources
                tv_dice_score.text = getString(R.string.msg_score, finalSum)
            } else {
                btn_roll.visibility = View.GONE
                tv_dice_score.text = getString(R.string.msg_final, finalSum)
                btn_restart.visibility = View.VISIBLE
            }
        })

        viewModel.valueInt.observe(this, Observer {
            updateDisplay(it)
        })
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

    // from ResetObserver interface
    override fun resetObserver() {
        // re - init observers
        setUpObservers()
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
