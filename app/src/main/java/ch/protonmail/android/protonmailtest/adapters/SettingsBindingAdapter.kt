package ch.protonmail.android.protonmailtest.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import ch.protonmail.android.protonmailtest.R
import ch.protonmail.android.protonmailtest.interfaces.ForecastDataInterface
import ch.protonmail.android.protonmailtest.models.GetUpcomingDayListResponseItem
import com.squareup.picasso.Picasso

object SettingsBindingAdapter {
    var listener : ForecastDataInterface? = null

    @BindingAdapter("forecastData")
    @JvmStatic
    fun bindData(recyclerView: RecyclerView, data : List<GetUpcomingDayListResponseItem>?){
        recyclerView.adapter = data?.let { listener?.let { it1 ->
            data.let { it2 ->
                ForecastAdapter(
                    it2,  R.layout.item_forecast,
                    it1
                ).apply {
                    setViewDivider(recyclerView)
                    notifyDataSetChanged() }
            }
        } }
    }
    private fun setViewDivider(recyclerView: RecyclerView) {
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )
    }
    @BindingAdapter("downloadImg")
    @JvmStatic
    fun downloadImage(imageView: ImageView, url : String?){
        url?.let {
            Picasso.get().load(it).placeholder(R.drawable.ic_launcher_background).into(imageView)
        }
    }
    @BindingAdapter("upcomingDay")
    @JvmStatic
    fun setUpcomingDay(textView: TextView, day : String?){
        day?.let {
            textView.text = textView.context.getString(R.string.text_upcoming_day, it)
        }
    }
}