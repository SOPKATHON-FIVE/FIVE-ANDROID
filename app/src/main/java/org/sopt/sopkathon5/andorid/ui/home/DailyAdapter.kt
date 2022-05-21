package org.sopt.sopkathon5.andorid.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.data.model.DailyData
import org.sopt.sopkathon5.andorid.databinding.ItemDailyListBinding
import kotlin.math.log

class DailyAdapter(private val itemClick: (() -> (Unit))? = null, private val logoutClickListener: (() -> Unit)? = null) : RecyclerView.Adapter<DailyAdapter.DailyViewHolder>() {
    val itemList = mutableListOf<DailyData>()

    class DailyViewHolder(
        private val binding: ItemDailyListBinding,
        private val itemClick: (() -> Unit)?
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: DailyData, logoutClickListener: (() -> Unit)?) {
            binding.data = data
            binding.tvLogout.setOnClickListener {
                logoutClickListener?.invoke()
            }
            val todoAdapter = TodoAdapter()
            binding.rvTodo.adapter = todoAdapter

            binding.btnPoint.setOnClickListener {  //호출시 itemclick 람다함수실행함
                itemClick?.invoke()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val binding = DataBindingUtil.inflate<ItemDailyListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_daily_list,
            parent,
            false
        )
        return DailyViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        holder.onBind(itemList[position], logoutClickListener)
    }

    override fun getItemCount(): Int = itemList.size
}