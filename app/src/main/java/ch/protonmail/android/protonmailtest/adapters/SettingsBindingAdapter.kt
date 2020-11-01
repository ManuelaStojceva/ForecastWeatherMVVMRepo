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
import java.text.SimpleDateFormat
import java.util.*

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
    @BindingAdapter("sunrisesunset")
    @JvmStatic
    fun setSunriseAndSunset(textView: TextView, timestamp : Long?){
        timestamp?.let {
            textView.text = convertTimestampToLocalTime(it)
        }
    }
    private fun convertTimestampToLocalTime(timestamp : Long):String{
        val cal: Calendar = Calendar.getInstance()
        val tz: TimeZone = cal.timeZone

        val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        sdf.timeZone = tz

        return sdf.format(Date(timestamp*1000))
    }
    @BindingAdapter("rain")
    @JvmStatic
    fun setRainAbility(textView: TextView, rain : Float?){
        rain?.let {
            textView.text = textView.context.getString(R.string.text_chance_rain, toPercentage(it))
        }
    }
    private fun toPercentage(n: Float): String? {
        return String.format("%.0f", n * 100) + "%"
    }
    @BindingAdapter(value = ["hightemp", "lowtemp"])
    @JvmStatic
    fun setTemperatureText(textView: TextView, high : Int?, low : Int?){
       high?.let { hTemp->
           low?.let { lTemp->
               textView.text = textView.context.getString(R.string.text_weather_temperature, lTemp.toString(), hTemp.toString())
           }
       }
    }
}