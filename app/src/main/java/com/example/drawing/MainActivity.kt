package com.example.drawing



import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.os.Environment
import android.os.SystemClock
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import layout.MediaScanner
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList




class MainActivity : AppCompatActivity() {
    companion object{
        //saveTest.
        var bitmap : Bitmap? = null
    }

    inner class Point(//x 함수
            var x: Float, //y 함수
            var y: Float, // true or false
            var check: Boolean,
            var color: Int,
            var line: Float)
    var line = 13F

    internal inner class MyView(context: Context?) : View(context) {
        override fun onDraw(canvas: Canvas) {


            val p = Paint()



            //선 부드럽게 해줌
            p.strokeJoin = Paint.Join.ROUND
            p.isAntiAlias = true
            p.strokeCap = Paint.Cap.ROUND


            for (i in 1 until points.size) {
                p.color = points[i].color //
                p.strokeWidth = points[i].line //선
                if (!points[i].check) continue
                canvas.drawLine(points[i - 1].x, points[i - 1].y, points[i].x, points[i].y, p)
            }


        }
        override fun onTouchEvent(event: MotionEvent): Boolean {
            val x = event.x
            val y = event.y
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    points.add(Point(x, y, false, color, line))
                    points.add(Point(x, y, true, color, line))
                }
                MotionEvent.ACTION_MOVE -> points.add(Point(x, y, true, color, line))
                MotionEvent.ACTION_UP -> {
                }
            }
            invalidate()
            return true
        }
    }

    var points = ArrayList<Point>()
    lateinit var clearbtn: ImageButton
    lateinit var drawlinear: LinearLayout
    var color: Int = Color.BLACK

    fun Request_Capture(view: View?, title: String){
        if(view==null){ //Null Point Exception ERROR 방지
            System.out.println("::::ERROR:::: view == NULL");
            return;
        }

        /* 캡쳐 파일 저장 */
        view.buildDrawingCache(); //캐시 비트 맵 만들기
        //사진정
        val bitmap : Bitmap = view.getDrawingCache();
        val fos : FileOutputStream
        Log.d("로그","bitmap : $bitmap")
       /* val image = findViewById<LinearLayout>(R.id.draw_linear)
        image.setImageBitmap(bitmap)*/

        MainActivity.bitmap = bitmap

        /* 저장할 폴더 Setting */
        val uploadFolder = Environment.getExternalStoragePublicDirectory("/DCIM/Camera/"); //저장 경로 (File Type형 변수)



        if (!uploadFolder.exists()) { //만약 경로에 폴더가 없다면
            uploadFolder.mkdir(); //폴더 생성
        }

        /* 파일 저장 */
        val Str_Path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera/"; //저장 경로 (String Type 변수)

        try{
            fos = FileOutputStream(Str_Path + title + ".jpg"); // 경로 + 제목 + .jpg로 FileOutputStream Setting
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fos);
        }catch (e: Exception){
            e.printStackTrace();
        }

        //캡쳐 파일 미디어 스캔 (https://hongdroid.tistory.com/7)

        val ms : MediaScanner = MediaScanner.newInstance(getApplicationContext());



        try {
            ms.mediaScanning(Str_Path + title + ".jpg");
        }catch (e: Exception) {
            e.printStackTrace();
            println("::::ERROR:::: " + e);
        }

    }//End Function

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val m = MyView(this)

        val capture_target_Layout = findViewById<LinearLayout>(R.id.draw_linear); //캡쳐할 영역의 레이아웃

        val capture_btn_Button = findViewById<ImageButton>(R.id.capture_btn)


        val sdf = SimpleDateFormat("yyyyMMddHHmmss"); //년,월,일,시간 포멧 설정
        val time = Date(SystemClock.currentThreadTimeMillis()); //파일명 중복 방지를 위해 사용될 현재시간
        val current_time = sdf.format(time); //String형 변수에 저장


        capture_btn_Button.setOnClickListener {


            Request_Capture(
                    capture_target_Layout,
                    current_time + "_capture"
            ); //지정한 Layout 영역 사진첩 저장 요청
        }

        val canvas = Canvas()
        val p = Paint()

        findViewById<Button>(R.id.nextButton).setOnClickListener {
            val nextIntent = Intent(this, Drawing_page::class.java)
            startActivity(nextIntent)
        }


        //선택한 색으로 변경
        findViewById<View>(R.id.draw_red_btn).setOnClickListener{
            color = Color.rgb(255, 156, 156)
            findViewById<ImageView>(R.id.chooseColor).setImageResource(R.drawable.show_color_red)
        }

        findViewById<View>(R.id.draw_orange_btn).setOnClickListener{
            color = Color.rgb(255, 212, 129)
            findViewById<ImageView>(R.id.chooseColor).setImageResource(R.drawable.show_color_orange)

        }

        findViewById<View>(R.id.draw_yellow_btn).setOnClickListener{
            color = Color.rgb(255, 243, 136)
            findViewById<ImageView>(R.id.chooseColor).setImageResource(R.drawable.show_color_yellow)

        }

        findViewById<View>(R.id.draw_green_btn).setOnClickListener{
            color = Color.rgb(178, 234, 133)
            findViewById<ImageView>(R.id.chooseColor).setImageResource(R.drawable.show_color_green)
        }

        findViewById<View>(R.id.draw_blue_btn).setOnClickListener {
            color = Color.rgb(157, 185, 255)
            findViewById<ImageView>(R.id.chooseColor).setImageResource(R.drawable.show_color_blue)
        }

        findViewById<View>(R.id.draw_purple_btn).setOnClickListener{
            color = Color.rgb(216, 167, 255)
            findViewById<ImageView>(R.id.chooseColor).setImageResource(R.drawable.show_color_purple)
        }

        findViewById<View>(R.id.draw_pink_btn).setOnClickListener{
            color = Color.rgb(253, 149, 255)
            findViewById<ImageView>(R.id.chooseColor).setImageResource(R.drawable.show_color_hotpink)
        }

        findViewById<View>(R.id.draw_lightpink_btn).setOnClickListener{
            color = Color.rgb(255, 147, 192)
            findViewById<ImageView>(R.id.chooseColor).setImageResource(R.drawable.show_color_pink)
        }

        findViewById<View>(R.id.draw_black_btn).setOnClickListener {
            color = Color.BLACK
            findViewById<ImageView>(R.id.chooseColor).setImageResource(R.drawable.show_color_black)
        }

        findViewById<View>(R.id.eraser_btn).setOnClickListener {
            color = Color.WHITE
            findViewById<ImageView>(R.id.chooseColor).setImageResource(R.drawable.show_color_white)
        }

        findViewById<View>(R.id.size_light).setOnClickListener{
            line = 5F
        }
        findViewById<View>(R.id.size_nomal).setOnClickListener{
            line = 13F
        }
        findViewById<View>(R.id.size_big).setOnClickListener {
            line = 23F
        }
        findViewById<View>(R.id.size_v_big).setOnClickListener {
            line = 36F
        }



        clearbtn = findViewById(R.id.clear_btn) //clear 버튼 액티비티에서 아이디로 찾아서 값 전달
        drawlinear = findViewById(R.id.draw_linear)
        clearbtn.setOnClickListener{
            points.clear()
            m.invalidate()
        }
        drawlinear.addView(m)



    }



}