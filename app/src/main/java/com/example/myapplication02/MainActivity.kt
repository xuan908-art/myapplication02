package com.example.myapplication02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear)    //实验1 线性布局
        //setContentView(R.layout.activity_table)       //实验2 表格布局
        //setContentView(R.layout.activity_calc)     //实验3 计算器约束布局
        //setContentView(R.layout.activity_space)     //实验4 太空约束布局
    }
}