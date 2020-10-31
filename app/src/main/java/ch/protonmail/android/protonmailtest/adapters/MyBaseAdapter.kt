package ch.protonmail.android.protonmailtest.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.view.LayoutInflater

abstract class MyBaseAdapter : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ViewDataBinding  = DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val obj = getObjForPosition(position)
        holder.bind(obj)
    }
    protected abstract fun getObjForPosition(position: Int): Any

    protected abstract fun getLayoutIdForPosition(position: Int): Int

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}