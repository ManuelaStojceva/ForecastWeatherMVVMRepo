package ch.protonmail.android.protonmailtest.ui.forecast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ch.protonmail.android.protonmailtest.Constants
import ch.protonmail.android.protonmailtest.R
import ch.protonmail.android.protonmailtest.databinding.FragmentDetailsBinding
import ch.protonmail.android.protonmailtest.models.GetUpcomingDayListResponseItem
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private val viewModel by viewModel<ViewModelForecast>()
    private var detailData : GetUpcomingDayListResponseItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { arg->
            detailData = arg.getParcelable(Constants.bundleDetailData)
        }
        detailData?.let { data-> viewModel.setDetailData(data) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}