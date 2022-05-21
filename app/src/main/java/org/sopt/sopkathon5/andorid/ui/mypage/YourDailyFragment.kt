package org.sopt.sopkathon5.andorid.ui.mypage

import android.os.Bundle
import android.view.View
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.databinding.FragmentYourDailyBinding
import org.sopt.sopkathon5.andorid.util.base.BaseFragment

class YourDailyFragment : BaseFragment<FragmentYourDailyBinding>(R.layout.fragment_your_daily) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            layoutDaily.isBookmarkNotVisible = true
            layoutDaily.isLogoutVisible = true
        }
    }

    private fun initAdapter() {
        binding.rvDone.adapter
        binding.layoutDaily.rvTodo.adapter
    }
}
