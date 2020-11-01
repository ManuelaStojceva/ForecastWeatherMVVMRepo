package ch.protonmail.android.protonmailtest.interfaces

import ch.protonmail.android.protonmailtest.models.GetLessRainingOrderedDaysResponseItem

/*
 interface to handle on hottest item clicked
 */
interface HottestDataInterface {
    fun onHottestItemClick(data : GetLessRainingOrderedDaysResponseItem)
}