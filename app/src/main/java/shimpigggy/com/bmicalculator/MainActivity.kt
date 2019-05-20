package shimpigggy.com.bmicalculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_btn_result.setOnClickListener {
            //다음 activity로 넘어감
            /*val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("weight", main_edit_weight.text.toString())
            intent.putExtra("height", main_edit_height.text.toString())
            startActivity(intent)*/

            //anko 라이브러리 적용함
            startActivity<ResultActivity>(
                "weight" to main_edit_weight.text.toString(),
                "height" to main_edit_height.text.toString()
            )
        }
    }
}
