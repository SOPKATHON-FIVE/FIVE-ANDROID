package org.sopt.sopkathon5.andorid.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.data.model.DailyData
import org.sopt.sopkathon5.andorid.databinding.ItemDailyListBinding
import org.sopt.sopkathon5.andorid.databinding.ItemTodoListBinding

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    val todoList = mutableListOf<String>()

    class TodoViewHolder(private val binding: ItemTodoListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: String) {
            binding.tvTodo.text = data

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = DataBindingUtil.inflate<ItemTodoListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_todo_list,
            parent,
            false
        )
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.onBind(todoList[position])
    }

    override fun getItemCount(): Int = todoList.size
}