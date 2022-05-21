package org.sopt.sopkathon5.andorid.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.databinding.ItemTodoCheckBinding

class ItemTodoCheckAdapter : RecyclerView.Adapter<ItemTodoCheckAdapter.ItemTodoCheckViewHolder>() {
    private val _missionData = mutableListOf<String>()
    var missionData: List<String> = _missionData
        set(value) {
            _missionData.clear()
            _missionData.addAll(value)
            notifyDataSetChanged()
        }

    private val _completeData = mutableListOf<String>()
    var completeData: List<String> = _completeData
        set(value) {
            _completeData.clear()
            _completeData.addAll(value)
        }

    inner class ItemTodoCheckViewHolder(private val binding: ItemTodoCheckBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: String) {
            binding.tvTodo.text = data
            binding.ibCheck.isSelected = completeData.contains(data)

            binding.ibCheck.setOnClickListener {
                it.isSelected = !it.isSelected
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTodoCheckViewHolder {
        val binding = DataBindingUtil.inflate<ItemTodoCheckBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_todo_check,
            parent,
            false
        )
        return ItemTodoCheckViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemTodoCheckViewHolder, position: Int) {
        holder.onBind(_missionData[position])
    }

    override fun getItemCount(): Int = _missionData.size
}