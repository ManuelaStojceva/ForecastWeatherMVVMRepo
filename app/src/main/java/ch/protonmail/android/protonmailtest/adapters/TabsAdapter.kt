package ch.protonmail.android.protonmailtest.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Created by ProtonMail on 2/25/19.
 * changed by Manuela Stojcheva on 10/31/2020
 *
 *  A [FragmentStatePagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class TabsAdapter(fragmentManager: FragmentManager, numOfTabs : Int) : FragmentStatePagerAdapter(fragmentManager, numOfTabs) {
    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    fun addFragment(
        fragment: Fragment,
        title: String
    ) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }
}