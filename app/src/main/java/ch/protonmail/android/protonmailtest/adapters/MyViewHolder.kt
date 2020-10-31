package ch.protonmail.android.protonmailtest.adapters

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import ch.protonmail.android.protonmailtest.BR


class MyViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(obj : Any){
        binding.setVariable(BR.viewmodel, obj)
        binding.executePendingBindings()
    }
}