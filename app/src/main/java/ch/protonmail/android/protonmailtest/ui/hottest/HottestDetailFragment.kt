package ch.protonmail.android.protonmailtest.ui.hottest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ch.protonmail.android.protonmailtest.Constants
import ch.protonmail.android.protonmailtest.R
import ch.protonmail.android.protonmailtest.databinding.HottestDetailLayoutBinding
import ch.protonmail.android.protonmailtest.models.GetLessRainingOrderedDaysResponseItem
import org.koin.android.viewmodel.ext.android.viewModel

/*
 fragment to display detail hottest data
 */
class HottestDetailFragment : Fragment() {

    private val viewModel by viewModel<ViewModelHottest>()
    private var detailData : GetLessRainingOrderedDaysResponseItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { arg->
            detailData = arg.getParcelable(Constants.EXTRA_HOTTEST_DETAIL_DATA)
        }
        detailData?.let { data-> viewModel.setDetailData(data) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : HottestDetailLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.hottest_detail_layout, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}