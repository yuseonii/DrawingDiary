package com.example.drawing

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.drawing.databinding.ActivityShowDiaryBinding
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class showDiary : AppCompatActivity() {
    val binding by lazy { ActivityShowDiaryBinding.inflate(layoutInflater) }

    @RequiresApi(Build.VERSION_CODES.O)
    val now = LocalDateTime.now()
    @RequiresApi(Build.VERSION_CODES.O)
    val formatDate = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")
    @RequiresApi(Build.VERSION_CODES.O)
    val nowDate = now.format(formatDate)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.seeImage.setImageBitmap(MainActivity.bitmap)
        binding.textDate.text = nowDate //오늘 날짜 보여주기

        val drawingMain = Intent(this, MainActivity::class.java) // 인텐트를 생성

        binding.goDrawingMainButton.setOnClickListener { // 버튼 클릭시 할 행동
            startActivity(drawingMain)  // 화면 전환하기
        }

        var intent = getIntent()
        var title = intent.getStringExtra("titleText")

        binding.textTitle.text = "제목 : $title"

    }

}