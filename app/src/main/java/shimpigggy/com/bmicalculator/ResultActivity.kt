package shimpigggy.com.bmicalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.toast

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //값 꺼내기기
       val height = intent.getStringExtra("height").toInt()
       val weight = intent.getStringExtra("weight").toInt()

       val bmi = weight / Math.pow(height / 100.0, 2.0)
        result_tv_value.text = bmi.toString()

        when {
            bmi >= 35 -> result_tv_state.text = "고도 비만"
            bmi >= 30 -> result_tv_state.text = "2단계 비만"
            bmi >= 25 -> result_tv_state.text = "1단계 비만"
            bmi >= 23 -> result_tv_state.text = "과체중"
            bmi >= 18.5 -> result_tv_state.text = "정상"
            else -> result_tv_state.text = "저체중"
       }

      //Toast.makeText(this, "$bmi", Toast.LENGTH_SHORT).show()
        //anko library
        toast("$bmi")

    }
}
