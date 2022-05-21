package org.sopt.sopkathon5.andorid.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.data.ServiceCreator.apiService
import org.sopt.sopkathon5.andorid.data.model.DailyData
import org.sopt.sopkathon5.andorid.databinding.FragmentHomeBinding
import org.sopt.sopkathon5.andorid.util.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var detailAdapter: DailyAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        detailAdapter = DailyAdapter()
        binding.rvDaily.adapter = detailAdapter
        lifecycleScope.launch {
            runCatching { apiService.daily() }
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

                }
        }
    }
}
