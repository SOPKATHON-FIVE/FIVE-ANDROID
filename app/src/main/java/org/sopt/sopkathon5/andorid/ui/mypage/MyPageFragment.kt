package org.sopt.sopkathon5.andorid.ui.mypage

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.databinding.FragmentMyPageBinding
import org.sopt.sopkathon5.andorid.databinding.LayoutCompleteDialogBinding
import org.sopt.sopkathon5.andorid.ui.mypage.adapter.MyPageViewPagerAdapter
import org.sopt.sopkathon5.andorid.util.DialogUtil
import org.sopt.sopkathon5.andorid.util.base.BaseFragment

class MyPageFragment : BaseFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {
    private lateinit var completeDialog: Dialog
    private lateinit var layoutCompleteDialogBinding: LayoutCompleteDialogBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvMyDaily.isSelected = true
        initDialogBinding()
        initDialog()
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

    private fun initDialogBinding() {
        layoutCompleteDialogBinding = DataBindingUtil.inflate(
            LayoutInflater.from(requireContext()),
            R.layout.layout_complete_dialog,
            null,
            false
        )
    }

    private fun initDialog() {
        requireContext().apply {
            completeDialog = DialogUtil.makeDialog(this)
        }

        layoutCompleteDialogBinding.btnComplete.setOnClickListener {
            completeDialog.dismiss()
        }

        DialogUtil.setDialog(completeDialog, layoutCompleteDialogBinding.root)
    }
}
