package ch.protonmail.android.protonmailtest.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ch.protonmail.android.protonmailtest.HottestFragment
import ch.protonmail.android.protonmailtest.R
import ch.protonmail.android.protonmailtest.adapters.TabsAdapter
import ch.protonmail.android.protonmailtest.ui.forecast.UpcomingFragment
import kotlinx.android.synthetic.main.fragment_view_pager.*

class PagerViewFragment : Fragment() {
    private val tabTitles = arrayOf(
        R.string.tab_forecast,
        R.string.tab_hottest
    )
    private var tabTitle: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setPagerView()
    }

    private fun setPagerView() {
        val tabAdapter =TabsAdapter(childFragmentManager, tabLayout.tabCount)
        for(i in tabTitles.indices){
            val tabName = getString(tabTitles[i])
            tabLayout.addTab(tabLayout.newTab().setText(tabName))
            tabTitle.add(tabName)
            tabAdapter.addFragment(addFragment(i), tabName)
        }
        pager.adapter = tabAdapter
        tabLayout.setupWithViewPager(pager)
    }

    private fun addFragment(
        pos: Int
    ): Fragment {

        return if(pos == 1)
            HottestFragment()
        else
            UpcomingFragment()
    }
}