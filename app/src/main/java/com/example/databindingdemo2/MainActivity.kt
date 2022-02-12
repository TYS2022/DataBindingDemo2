package com.example.databindingdemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databindingdemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.studIDtv.text =  "all"
        binding.studNametv.text =  "12345"

        val s:Student = Student("12345", "Ali")
        binding.student = s

        binding.updateBtn.setOnClickListener(){
            s.name = "Alex"
            binding.apply {
                invalidateAll()
            }
        }
        //binding.studIDtv.text = s.id
        //binding.studNametv.text = s.name
    }
}