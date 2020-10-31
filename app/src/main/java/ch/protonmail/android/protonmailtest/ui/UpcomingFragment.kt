package ch.protonmail.android.protonmailtest.ui

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import ch.protonmail.android.protonmailtest.R
import ch.protonmail.android.protonmailtest.adapters.SettingsBindingAdapter
import ch.protonmail.android.protonmailtest.databinding.FragmentUpcomingBinding
import ch.protonmail.android.protonmailtest.interfaces.ForecastDataInterface
import ch.protonmail.android.protonmailtest.widgets.displayInfoMsg
import org.koin.android.viewmodel.ext.android.viewModel
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by ProtonMail on 2/25/19.
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

    override fun onItemClick() {

    }
}