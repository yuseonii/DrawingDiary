package com.example.drawing

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.drawing.databinding.ActivityDrawingPageBinding
import com.example.drawing.databinding.ActivityShowDiaryBinding


class Drawing_page : AppCompatActivity(){
    val binding by lazy { ActivityDrawingPageBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val showDiary = Intent(this, showDiary::class.java)

        binding.goDrawing.setOnClickListener { // 버튼 클릭시 할 행동
            showDiary.putExtra("titleText", binding.titleEditText.text.toString())
            startActivity(showDiary)  // 화면 전환하기


        }

        binding.backButton.setOnClickListener {
            val intent = Intent(this, com.example.drawing.MainActivity::class.java)
            startActivity(intent)
        }

        binding.boldButton.setOnClickListener {
            binding.contentEditText.getText().setSpan(StyleSpan(Typeface.BOLD), 0, binding.contentEditText.getText().length, Spanned.SPAN_EXCLUSIVE_INCLUSIVE)

        }

        binding.underlindButton.setOnClickListener {
            binding.contentEditText.getText().setSpan(
                    UnderlineSpan(),
                    0,
                    binding.contentEditText.getText().length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }





        binding.redButton.setOnClickListener {
            binding.chooseColor.setImageResource(com.example.drawing.R.drawable.show_color_red)
            binding.contentEditText.getText().setSpan(
                    ForegroundColorSpan(Color.parseColor("#FFD481")),
                    0,
                    binding.contentEditText.getText().length,
                    Spanned.SPAN_INTERMEDIATE
            )
        }


        binding.orangeButton.setOnClickListener {
            binding.chooseColor.setImageResource(com.example.drawing.R.drawable.show_color_orange)
            binding.contentEditText.getText().setSpan(
                    ForegroundColorSpan(Color.parseColor("#FF9C9C")),
                    0,
                    binding.contentEditText.getText().length,
                    Spanned.SPAN_INTERMEDIATE
            )
        }

        binding.yellowButton.setOnClickListener {
            binding.chooseColor.setImageResource(com.example.drawing.R.drawable.show_color_yellow)
            binding.contentEditText.getText().setSpan(
                    ForegroundColorSpan(Color.parseColor("#FFF388")),
                    0,
                    binding.contentEditText.getText().length,
                    Spanned.SPAN_INTERMEDIATE
            )
        }

        binding.greenButton.setOnClickListener {
            binding.chooseColor.setImageResource(com.example.drawing.R.drawable.show_color_green)
            binding.contentEditText.getText().setSpan(
                    ForegroundColorSpan(Color.parseColor("#B2EA85")),
                    0,
                    binding.contentEditText.getText().length,
                    Spanned.SPAN_INTERMEDIATE
            )
        }
        binding.blueButton.setOnClickListener {
            binding.chooseColor.setImageResource(com.example.drawing.R.drawable.show_color_blue)
            binding.contentEditText.getText().setSpan(
                    ForegroundColorSpan(Color.parseColor("#9DB9FF")),
                    0,
                    binding.contentEditText.getText().length,
                    Spanned.SPAN_INTERMEDIATE
            )
        }

        binding.purpleButton.setOnClickListener {
            binding.chooseColor.setImageResource(com.example.drawing.R.drawable.show_color_purple)
            binding.contentEditText.getText().setSpan(
                    ForegroundColorSpan(Color.parseColor("#D8A7FF")),
                    0,
                    binding.contentEditText.getText().length,
                    Spanned.SPAN_INTERMEDIATE
            )
        }

        binding.pinkButton.setOnClickListener {
            binding.chooseColor.setImageResource(com.example.drawing.R.drawable.show_color_hotpink)
            binding.contentEditText.getText().setSpan(
                    ForegroundColorSpan(Color.parseColor("#FD95FF")),
                    0,
                    binding.contentEditText.getText().length,
                    Spanned.SPAN_INTERMEDIATE
            )
        }

        binding.lightpinkButton.setOnClickListener {
            binding.chooseColor.setImageResource(com.example.drawing.R.drawable.show_color_pink)
            binding.contentEditText.getText().setSpan(
                    ForegroundColorSpan(Color.parseColor("#FF93C0")),
                    0,
                    binding.contentEditText.getText().length,
                    Spanned.SPAN_INTERMEDIATE
            )
        }

        binding.blackButton.setOnClickListener {
            binding.chooseColor.setImageResource(com.example.drawing.R.drawable.show_color_red)
            binding.contentEditText.getText().setSpan(
                    ForegroundColorSpan(Color.parseColor("#000000")),
                    0,
                    binding.contentEditText.getText().length,
                    Spanned.SPAN_INTERMEDIATE
            )
        }


    }

}