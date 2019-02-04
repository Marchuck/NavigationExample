package pl.marchuck.navigationexample.removeItem

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import pl.marchuck.navigationexample.R

class RemoveItemFragment : Fragment() {

    companion object {
        fun newInstance() = RemoveItemFragment()
    }

    private lateinit var viewModel: RemoveItemViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.remove_item_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RemoveItemViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
