package org.sopt.sopkathon5.andorid.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.data.model.DailyData
import org.sopt.sopkathon5.andorid.databinding.ItemDailyListBinding

class DailyAdapter : RecyclerView.Adapter<DailyAdapter.DailyViewHolder>() {
    val itemList = mutableListOf<DailyData>()

    class DailyViewHolder(private val binding: ItemDailyListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: DailyData) {
            binding.data = data
            val todoAdapter = TodoAdapter()
            binding.rvTodo.adapter = todoAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val binding = DataBindingUtil.inflate<ItemDailyListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_daily_list,
            parent,
            false
        )
        return DailyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}