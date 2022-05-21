package org.sopt.sopkathon5.andorid.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.data.model.DailyData
import org.sopt.sopkathon5.andorid.databinding.FragmentHomeBinding
import org.sopt.sopkathon5.andorid.util.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var detailAdapter: DailyAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter(){
        detailAdapter = DailyAdapter()
        binding.rvDaily.adapter = detailAdapter
        
    }
}
