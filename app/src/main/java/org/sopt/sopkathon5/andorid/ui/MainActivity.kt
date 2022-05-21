package org.sopt.sopkathon5.andorid.ui

import android.content.Intent
import android.os.Bundle
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.databinding.ActivityMainBinding
import org.sopt.sopkathon5.andorid.ui.home.HomeFragment
import org.sopt.sopkathon5.andorid.ui.mypage.MyPageFragment
import org.sopt.sopkathon5.andorid.ui.write.WriteActivity
import org.sopt.sopkathon5.andorid.util.base.BaseActivity
import org.sopt.sopkathon5.andorid.util.ext.replace

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBottomNavigation()
        replace<HomeFragment>(R.id.container_main)
        binding.fabWrite.setOnClickListener {
            startActivity(Intent(this, WriteActivity::class.java))
        }
    }

    private fun initBottomNavigation() {
        binding.bnvMain.setOnItemSelectedListener {
            replaceFragment(it.itemId)
            true
        }
    }

    private fun replaceFragment(itemId: Int) {
        when (itemId) {
            R.id.item_home -> replace<HomeFragment>(R.id.container_main)
            else -> replace<MyPageFragment>(R.id.container_main)
        }
    }
}
