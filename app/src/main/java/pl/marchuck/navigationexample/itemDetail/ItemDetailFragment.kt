package pl.marchuck.navigationexample.itemDetail

import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

import pl.marchuck.navigationexample.R
import pl.marchuck.navigationexample.items.ItemsFragmentArgs

class ItemDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ItemDetailFragment()
    }

    private lateinit var viewModel: ItemDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val vju = inflater.inflate(R.layout.item_detail_fragment, container, false)

        return vju
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ItemDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
