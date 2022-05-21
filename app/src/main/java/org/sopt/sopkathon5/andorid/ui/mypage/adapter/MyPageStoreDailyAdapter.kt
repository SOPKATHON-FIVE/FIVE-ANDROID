package org.sopt.sopkathon5.andorid.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.data.model.response.ResponseDailyStore
import org.sopt.sopkathon5.andorid.databinding.ItemDoneBinding

class MyPageStoreDailyAdapter :
    RecyclerView.Adapter<MyPageStoreDailyAdapter.MyPageStoreDailyViewHolder>() {
    private val _data = mutableListOf<ResponseDailyStore.Data>()
    var data: List<ResponseDailyStore.Data> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    class MyPageStoreDailyViewHolder(
        private val binding: ItemDoneBinding
    ) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun onBind(data: ResponseDailyStore.Data) {
            with(binding) {
                tvPercent.text = "${(((data.completeMissions.size.toFloat() /data.dailyId.missions.size.toFloat())*100).toInt())}%"
                tvTitle.text = data.dailyId.dailyName
                binding.rvTodo.adapter = DoneCheckAdapter().apply {
                    completeData = data.completeMissions
                    missionData = data.dailyId.missions
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageStoreDailyViewHolder {
        val binding: ItemDoneBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_done, parent, false
        )
        return MyPageStoreDailyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyPageStoreDailyViewHolder, position: Int) {
        holder.onBind(_data[position])
    }

    override fun getItemCount(): Int = _data.size
}
