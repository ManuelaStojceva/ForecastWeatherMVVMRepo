package ch.protonmail.android.protonmailtest.ui.forecast

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
import ch.protonmail.android.protonmailtest.databinding.FragmentUpcomingBinding
import ch.protonmail.android.protonmailtest.interfaces.ForecastDataInterface
import ch.protonmail.android.protonmailtest.models.GetUpcomingDayListResponseItem
import ch.protonmail.android.protonmailtest.widgets.displayInfoMsg
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by ProtonMail on 2/25/19.
 * changed by MAnuela Stojcheva on 10/31/2020
 * Shows the upcoming list of days returned by the API in order of day
 **/
class UpcomingFragment : Fragment(), ForecastDataInterface {
    private val viewModel by viewModel<ViewModelForecast>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        SettingsBindingAdapter.listener = this
        val binding : FragmentUpcomingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_upcoming, container, false)
        binding.viewmodel= viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getUpcomingDayList()
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer { error->
            context?.displayInfoMsg(error)
        })

    }

    override fun onItemClick(data : GetUpcomingDayListResponseItem) {
        navigateToDetailPage(data)
    }

    private fun navigateToDetailPage(data: GetUpcomingDayListResponseItem) {
        val bundle = bundleOf(Constants.bundleDetailData to data)
        findNavController().navigate(R.id.navigation_to_detail, bundle)
    }
}