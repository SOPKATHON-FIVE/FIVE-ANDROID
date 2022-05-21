package org.sopt.sopkathon5.andorid.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.databinding.ItemTodoCheckBinding

class MyPageTodoCheckAdapter :
    RecyclerView.Adapter<MyPageTodoCheckAdapter.MyPageTodoCheckViewHolder>() {
    private val _data = mutableListOf<String>()
    var data: List<String> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    class MyPageTodoCheckViewHolder(
        private val binding: ItemTodoCheckBinding
    ) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun onBind(data: String) {
            with(binding) {
                tvTodo.text = data
                ibCheck.isSelected = !ibCheck.isSelected
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageTodoCheckViewHolder {
        val binding: ItemTodoCheckBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_todo_check, parent, false
        )
        return MyPageTodoCheckViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyPageTodoCheckViewHolder, position: Int) {
        holder.onBind(_data[position])
    }

    override fun getItemCount(): Int = _data.size
}
