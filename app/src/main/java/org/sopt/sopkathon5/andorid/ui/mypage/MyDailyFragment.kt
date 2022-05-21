package org.sopt.sopkathon5.andorid.ui.mypage

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.data.ServiceCreator
import org.sopt.sopkathon5.andorid.data.model.DailyData
import org.sopt.sopkathon5.andorid.databinding.FragmentMyDailyBinding
import org.sopt.sopkathon5.andorid.ui.home.DailyAdapter
import org.sopt.sopkathon5.andorid.util.base.BaseFragment

class MyDailyFragment : BaseFragment<FragmentMyDailyBinding>(R.layout.fragment_my_daily) {
    private lateinit var detailAdapter: DailyAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        detailAdapter = DailyAdapter(isBookmarkNotVisible = true)
        binding.rvMyDaily.adapter = detailAdapter
        lifecycleScope.launch {
            runCatching { ServiceCreator.myPageService.getMyDaily() }
                .onSuccess {
                    detailAdapter.itemList.clear()
                    detailAdapter.itemList.addAll(
                        it.data.map { data ->
                            DailyData(data.dailyName, data.missions)
                        }
                    )
                    detailAdapter.notifyDataSetChanged()
                }
                .onFailure {
                    Log.d("실패", it.message.toString())
                }
        }
    }
}
