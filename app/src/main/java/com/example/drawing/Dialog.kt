package com.example.drawing

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import java.security.AccessControlContext

class Dialog(context: Context) {

    private val dialog = Dialog(context)

    fun myModal(){
        dialog.show()
        dialog.setContentView(R.layout.activity_dialog)
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
    }
}