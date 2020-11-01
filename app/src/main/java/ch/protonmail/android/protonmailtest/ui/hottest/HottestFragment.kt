package ch.protonmail.android.protonmailtest.ui.hottest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import ch.protonmail.android.protonmailtest.Constants
import ch.protonmail.android.protonmailtest.R
import ch.protonmail.android.protonmailtest.adapters.SettingsBindingAdapter
import ch.protonmail.android.protonmailtest.databinding.FragmentHottestBinding
import ch.protonmail.android.protonmailtest.interfaces.HottestDataInterface
import ch.protonmail.android.protonmailtest.models.GetLessRainingOrderedDaysResponseItem
import ch.protonmail.android.protonmailtest.widgets.displayInfoMsg
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by ProtonMail on 2/25/19.
 * changed by MAnuela Stojcheva on 11/1/2020
 * Shows any days that have less than a 50% chance of rain, ordered hottest to coldest
 * */
class HottestFragment : Fragment(), HottestDataInterface {

    private val viewModel by viewModel<ViewModelHottest>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        SettingsBindingAdapter.hottestListener = this
        val binding : FragmentHottestBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_hottest, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getDaysLessChangeOfRainOrderedByHottest()
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer { error->
            context?.displayInfoMsg(error)
        })

    }

    override fun onHottestItemClick(data: GetLessRainingOrderedDaysResponseItem) {
        navigateToDetailPage(data)
    }

    private fun navigateToDetailPage(data: GetLessRainingOrderedDaysResponseItem) {
        val bundle = bundleOf(Constants.EXTRA_HOTTEST_DETAIL_DATA to data)
        findNavController().navigate(R.id.navigation_to_hottest_detail, bundle)
    }
}