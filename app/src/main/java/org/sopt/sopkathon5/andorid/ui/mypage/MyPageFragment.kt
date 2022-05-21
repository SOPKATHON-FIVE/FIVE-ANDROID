package org.sopt.sopkathon5.andorid.ui.mypage

import android.os.Bundle
import android.view.View
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.databinding.FragmentMyPageBinding
import org.sopt.sopkathon5.andorid.ui.mypage.adapter.MyPageViewPagerAdapter
import org.sopt.sopkathon5.andorid.util.base.BaseFragment

class MyPageFragment : BaseFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvMyDaily.isSelected = true
        initViewPager()
    }

    private fun initViewPager() {
        with(binding) {
            vpMypage.adapter = MyPageViewPagerAdapter(requireActivity()).apply {
                fragmentList = listOf(
                    MyDailyFragment(),
                    YourDailyFragment()
                )
            }

            vpMypage.isUserInputEnabled = false

            tvMyDaily.setOnClickListener {
                it.isSelected = true
                tvYourDaily.isSelected = false
                binding.vpMypage.currentItem = 0
            }

            tvYourDaily.setOnClickListener {
                it.isSelected = true
                tvMyDaily.isSelected = false
                binding.vpMypage.currentItem = 1
            }
        }
    }
}
