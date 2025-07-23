package com.nezammohandesi.hamrehenazer

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.nezammohandesi.hamrehenazer.ui.theme.HamreheNazerTheme
import com.nezammohandesi.hamrehenazer.databinding.FragmentMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: FragmentMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val moveDistance = -24f
        val selectedButtonBackground = R.drawable.btn_background
        val defaultButtonBackground = R.drawable.btn_background_default
        val buttons = listOf(binding.btn1, binding.btn2, binding.btn3)
        val customMenu = binding.customMenu
        val btn1 = binding.btn1
        val btn2 = binding.btn2
        val btn3 = binding.btn3
        fun resetAllButtons() {
            buttons.forEach {
                it.translationX = 0f
                it.setBackgroundResource(defaultButtonBackground)  // پس‌زمینه پیش‌فرض
            }
            customMenu.translationX = 0f
        }

        // کلیک کردن روی دکمه‌ها
        btn1.setOnClickListener {
            resetAllButtons()
            // تغییر موقعیت دکمه‌ها و منوی آبی به سمت داخل
            btn1.translationX = moveDistance
            customMenu.translationX = moveDistance
            // تغییر پس‌زمینه دکمه انتخاب شده
            btn1.setBackgroundResource(selectedButtonBackground)
            //loadFragment(ProfileFragment())  // بارگذاری Fragment در صورت نیاز
        }

        btn2.setOnClickListener {
            resetAllButtons()
            // تغییر موقعیت دکمه‌ها و منوی آبی به سمت داخل
            btn2.translationX = moveDistance
            customMenu.translationX = moveDistance
            // تغییر پس‌زمینه دکمه انتخاب شده
            btn2.setBackgroundResource(selectedButtonBackground)
            //loadFragment(FormFragment())  // بارگذاری Fragment در صورت نیاز
        }

        btn3.setOnClickListener {
            resetAllButtons()
            // تغییر موقعیت دکمه‌ها و منوی آبی به سمت داخل
            btn3.translationX = moveDistance
            customMenu.translationX = moveDistance
            // تغییر پس‌زمینه دکمه انتخاب شده
            btn3.setBackgroundResource(selectedButtonBackground)
            //loadFragment(WalletFragment())  // بارگذاری Fragment در صورت نیاز
        }

// بارگذاری اولیه اولین دکمه (همانند کد قبلی)
        btn1.performClick()
    }


    private fun loadFragment(fragment: Fragment) {
     /*   // لود کردن فرگمنت
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()*/
    }
}
