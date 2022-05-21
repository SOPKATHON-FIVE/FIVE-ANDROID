package org.sopt.sopkathon5.andorid.ui.mypage

import android.os.Bundle
import android.view.View
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.databinding.FragmentMyDailyBinding
import org.sopt.sopkathon5.andorid.ui.home.DailyAdapter
import org.sopt.sopkathon5.andorid.ui.mypage.adapter.MyPageTodoCheckAdapter
import org.sopt.sopkathon5.andorid.util.base.BaseFragment

class MyDailyFragment : BaseFragment<FragmentMyDailyBinding>(R.layout.fragment_my_daily) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        binding.rvMyDaily.adapter = DailyAdapter().apply {

        }
    }
}
