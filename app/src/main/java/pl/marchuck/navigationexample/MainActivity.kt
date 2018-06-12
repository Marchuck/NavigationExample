package pl.marchuck.navigationexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





    }

    override fun onSupportNavigateUp() = findNavController(this, R.id.landingFragment).navigateUp()





}
