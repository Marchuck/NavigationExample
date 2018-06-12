package pl.marchuck.navigationexample.landing

import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import pl.marchuck.navigationexample.CustomPojo
import pl.marchuck.navigationexample.R
import pl.marchuck.navigationexample.items.ItemsFragmentArgs
import pl.marchuck.navigationexample.toJson

class LandingFragment : Fragment() {

    companion object {
        fun newInstance() = LandingFragment()
    }

    private lateinit var viewModel: LandingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.landing_fragment, container, false)

        v.findViewById<Button>(R.id.landing_button).setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.itemsFragment,
                        ItemsFragmentArgs.Builder()
                                .setBgColor(Color.CYAN)
                                .setItemsCount(33)
                                .setCustomSerializable(CustomPojo().apply {
                                    name = "Joe"
                                    surname = "Doe"
                                    age = 54
                                    child = CustomPojo().apply {
                                        name = "Joe Jr"
                                        surname = "Doe"
                                        age = 19
                                        child = null
                                    }
                                }.toJson())
                                .build()
                                .toBundle()
                )
        )

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LandingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
