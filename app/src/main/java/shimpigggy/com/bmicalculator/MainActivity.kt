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

        loadData()

        main_btn_result.setOnClickListener {
            //다음 activity로 넘어감
            /*val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("weight", main_edit_weight.text.toString())
            intent.putExtra("height", main_edit_height.text.toString())
            startActivity(intent)*/

            SharedPreferenceUtil.saveDate(
                this,
                main_edit_weight.text.toString().toInt(),
                main_edit_height.text.toString().toInt()
            )

            //anko 라이브러리 적용함
            startActivity<ResultActivity>(
                "weight" to main_edit_weight.text.toString(),
                "height" to main_edit_height.text.toString()
            )
        }

        main_btn_reset.setOnClickListener {
            SharedPreferenceUtil.removeDataAll(this)
            main_edit_height.setText("")
            main_edit_weight.setText("")
        }
    }

    private fun loadData(): Unit{
        val height = SharedPreferenceUtil.loadHeight(this)
        val weight = SharedPreferenceUtil.loadWeight(this)

        if (height != 0) {
            main_edit_height.setText(height.toString())
        }

        if (weight != 0) {
            main_edit_weight.setText(weight.toString())
        }
    }
}
