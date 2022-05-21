package org.sopt.sopkathon5.andorid.ui.mypage

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.data.ServiceCreator.myPageService
import org.sopt.sopkathon5.andorid.databinding.FragmentYourDailyBinding
import org.sopt.sopkathon5.andorid.databinding.LayoutCompleteDialogBinding
import org.sopt.sopkathon5.andorid.ui.mypage.adapter.ItemTodoCheckAdapter
import org.sopt.sopkathon5.andorid.ui.mypage.adapter.MyPageStoreDailyAdapter
import org.sopt.sopkathon5.andorid.util.DialogUtil
import org.sopt.sopkathon5.andorid.util.base.BaseFragment

class YourDailyFragment : BaseFragment<FragmentYourDailyBinding>(R.layout.fragment_your_daily) {
    private lateinit var myPageStoreDailyAdapter: MyPageStoreDailyAdapter
    private lateinit var itemTodoCheckAdapter: ItemTodoCheckAdapter
    private lateinit var completeDialog: Dialog
    private lateinit var layoutCompleteDialogBinding: LayoutCompleteDialogBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDialogBinding()
        initDialog()
        with(binding) {
            layoutDaily.isBookmarkNotVisible = true
            layoutDaily.isLogoutVisible = true
            layoutDaily.ivMain.setBackgroundResource(R.drawable.ic_bear)
            layoutDaily.tvLogout.setOnClickListener {
                completeDialog.show()
            }
        }
        initAdapter()
        initData()
    }

    private fun initData() {
        lifecycleScope.launch {
            runCatching {
                myPageService.getStoredDaily()
            }.onSuccess {
                binding.layoutDaily.apply {
                    tvTitle.text = it.data[it.data.size - 1].dailyId.dailyName
                }
                layoutCompleteDialogBinding.name = it.data[it.data.size - 1].dailyId.userName
                layoutCompleteDialogBinding.tvPercent.text = "오늘은 ${it.data[it.data.size - 1].dailyId.userName}으로\n${(((it.data[it.data.size - 1].completeMissions.size.toFloat() /it.data[it.data.size - 1].dailyId.missions.size.toFloat())*100).toInt())}% 살아봤어요"
                itemTodoCheckAdapter.completeData = it.data[it.data.size - 1].completeMissions
                itemTodoCheckAdapter.missionData = it.data[it.data.size - 1].dailyId.missions
                myPageStoreDailyAdapter.data = it.data
            }.onFailure {

            }
        }
    }

    private fun initAdapter() {
        itemTodoCheckAdapter = ItemTodoCheckAdapter()
        binding.layoutDaily.rvTodo.adapter = itemTodoCheckAdapter
        myPageStoreDailyAdapter = MyPageStoreDailyAdapter()
        binding.rvDone.adapter = myPageStoreDailyAdapter
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
            binding.tvProgress.visibility = View.GONE
            binding.tvLivingLife.visibility = View.GONE
            binding.layoutDaily.clItem.visibility = View.GONE
        }

        DialogUtil.setDialog(completeDialog, layoutCompleteDialogBinding.root)
    }
}
