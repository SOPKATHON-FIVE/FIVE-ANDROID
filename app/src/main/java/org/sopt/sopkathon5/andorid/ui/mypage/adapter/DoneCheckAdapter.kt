package org.sopt.sopkathon5.andorid.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.databinding.ItemTodoSingleLineBinding

class DoneCheckAdapter : RecyclerView.Adapter<DoneCheckAdapter.DoneCheckViewHolder>() {
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

    inner class DoneCheckViewHolder(private val binding: ItemTodoSingleLineBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: String) {
            binding.tvTodo.text = data

            binding.ivCheck.isSelected = completeData.contains(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoneCheckViewHolder {
        val binding = DataBindingUtil.inflate<ItemTodoSingleLineBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_todo_single_line,
            parent,
            false
        )
        return DoneCheckViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DoneCheckViewHolder, position: Int) {
        holder.onBind(_missionData[position])
    }

    override fun getItemCount(): Int = _missionData.size
}