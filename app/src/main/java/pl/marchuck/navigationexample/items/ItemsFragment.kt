package pl.marchuck.navigationexample.items

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import pl.marchuck.navigationexample.CustomPojo
import pl.marchuck.navigationexample.R
import pl.marchuck.navigationexample.fromJson

class ItemsFragment : Fragment() {

    companion object {
        fun newInstance() = ItemsFragment()
    }

    private lateinit var viewModel: ItemsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val vju = inflater.inflate(R.layout.items_fragment, container, false)

        val args = ItemsFragmentArgs.fromBundle(arguments?:Bundle())
        val a: Int = args.itemsCount
        val b: Int = args.bgColor
        val c: CustomPojo? = args.customSerializable.fromJson(CustomPojo::class.java)

        vju.findViewById<TextView>(R.id.t1).text = "first arg: " + a
        vju.findViewById<TextView>(R.id.t2).text = "second arg: " + b
        vju.findViewById<TextView>(R.id.t2).text = "third arg: $c"
        vju.setBackgroundColor(b)


        val opts = NavOptions.Builder()
                .setEnterAnim(android.R.anim.fade_in)
                .setExitAnim(android.R.anim.fade_out)
                .setPopEnterAnim(android.R.anim.fade_out)
                .setPopEnterAnim(android.R.anim.fade_in)
                .build()

        vju.findViewById<Button>(R.id.remove).setOnClickListener {
            Navigation.findNavController(vju).navigate(R.id.removeItemFragment, null, opts)
        }

        vju.findViewById<Button>(R.id.detail).setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.itemDetailFragment
                )
        )

        return vju
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ItemsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
