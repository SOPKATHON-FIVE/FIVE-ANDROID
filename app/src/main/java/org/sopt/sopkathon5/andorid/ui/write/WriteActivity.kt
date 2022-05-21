package org.sopt.sopkathon5.andorid.ui.write

import android.os.Bundle
import android.view.View
import android.widget.Toast
import org.sopt.sopkathon5.andorid.R
import org.sopt.sopkathon5.andorid.databinding.ActivityWriteBinding
import org.sopt.sopkathon5.andorid.util.base.BaseActivity
import retrofit2.Call

class WriteActivity : BaseActivity<ActivityWriteBinding>(R.layout.activity_write) {
    private var cnt = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addList()
        finishView()

        binding.btnWriteRegister.setOnClickListener {
            if (binding.etWriteList01.text.isNullOrBlank() || binding.etWriteList02.text.isNullOrBlank() || binding.etWriteList03.text.isNullOrBlank()) {
                Toast.makeText(this@WriteActivity, "일상을 최소 3가지 공유해주세요", Toast.LENGTH_SHORT).show()
            } else {
                finish()
            }
        }
    }

    private fun addList() {
        binding.btnWriteAddList.setOnClickListener {
            when (cnt) {
                0 -> {
                    binding.ivWrite4.visibility = View.VISIBLE
                    binding.isVisible4 = true
                    ++cnt
                }
                else -> {
                    binding.isVisible5 = true
                    binding.ivWrite5.visibility = View.VISIBLE
                    binding.btnWriteAddList.visibility = View.GONE
                    ++cnt
                }
            }
        }
    }

    private fun finishView() {
        binding.btnWriteFinish.setOnClickListener {
            finish()
        }
    }


    private fun writeNetWork() {

    }


}
