package ch.protonmail.android.protonmailtest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import ch.protonmail.android.protonmailtest.R
import ch.protonmail.android.protonmailtest.interfaces.HottestDataInterface
import ch.protonmail.android.protonmailtest.models.GetLessRainingOrderedDaysResponseItem

class HottestAdapter(
    private val data : List<GetLessRainingOrderedDaysResponseItem>,
    private val layoutId : Int,
    private val listener : HottestDataInterface
) : MyBaseAdapter(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.item_hottest, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
        holder.binding.root.setOnClickListener { listener.onHottestItemClick(item) }
    }
    override fun getObjForPosition(position: Int): Any {
        return data[position]
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return layoutId
    }

    override fun getItemCount(): Int {
        return data.size
    }

}