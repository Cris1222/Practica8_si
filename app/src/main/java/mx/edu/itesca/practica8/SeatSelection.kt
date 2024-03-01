package mx.edu.itesca.practica8

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)
        val row1: RadioGroup=findViewById(R.id.row1)
        val row2: RadioGroup=findViewById(R.id.row2)
        val row3: RadioGroup=findViewById(R.id.row3)
        val row4: RadioGroup=findViewById(R.id.row4)
        val title: TextView = findViewById(R.id.titleSeats)
        var posMovie=-1
        var confirm2:Boolean
        var seats=20
        val bundle = intent.extras
        if(bundle!=null) {
            title.setText(bundle.getString("name"))
            posMovie =bundle.getInt ("id")
        }
        val confirm: Button =findViewById(R.id.confirm)
        confirm.setOnClickListener{
            if (row1.checkedRadioButtonId == -1 &&
                row2.checkedRadioButtonId == -1 &&
                row3.checkedRadioButtonId == -1 &&
                row4.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Please select a seat!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Enjoy the movie! :D", Toast.LENGTH_LONG).show()


                finish()
            }
        }
        row1.setOnCheckedChangeListener { group, checkedId->
            if(checkedId>-1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
            }
        }
        row2.setOnCheckedChangeListener { group, checkedId->
            if(checkedId>-1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                row2.check(checkedId)
            }
        }
        row3.setOnCheckedChangeListener { group, checkedId->
            if(checkedId>-1){
                row1.clearCheck()
                row2.clearCheck()
                row4.clearCheck()
                row3.check(checkedId)
            }
        }
        row4.setOnCheckedChangeListener { group, checkedId->
            if(checkedId>-1){
                row1.clearCheck()
                row2.clearCheck()
                row3.clearCheck()
                row4.check(checkedId)
            }
        }
    }
}