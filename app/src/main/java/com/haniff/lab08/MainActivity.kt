package com.haniff.lab08

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.haniff.lab08.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val pizzaSize = arrayOf("Small", "Medium", "Large", "Extra Large")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.SeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            //bila seekbar di ubah, code ini akan di panggil
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.sizeTextView.text = pizzaSize[p1]

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                print("Start tracking")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                print("Stop tracking")
            }

        })

        binding.scheduleBtn.setOnClickListener {

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", binding.nameEditText.text.toString())
            intent.putExtra("phone", binding.phoneEditText.text.toString())
            intent.putExtra("size", binding.sizeTextView.text.toString())
            intent.putExtra("date", binding.dateTextView.text.toString())
            intent.putExtra("time", binding.timeTextView.text.toString())

            startActivity(intent)

        }

        binding.dateBtn.setOnClickListener {
            //dapatkan tarikh hari ini
            val c = Calendar.getInstance()
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)

            val myDatePicker = DatePickerDialog(this,
                android.R.style.ThemeOverlay,
                //i3 = day, i2 = month, i = year
                //'->' letakkan tarikh yg di pilih
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->

                    binding.dateTextView.text = "$i3/${i2 + 1}/$i"
                }, year, month, day
            )
            myDatePicker.show()
        }

        binding.timeBtn.setOnClickListener {
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)

            val myTimePicker = TimePickerDialog(this,
                TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                    binding.timeTextView.text = "$i:$i2"
                }, hour, minute, false
            )
            myTimePicker.show()
        }
    }
}
