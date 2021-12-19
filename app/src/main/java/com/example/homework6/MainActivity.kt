package com.example.homework6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewParent
import android.widget.TableLayout
import com.example.homework6.adapter.ViewPagerFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewpager2 : ViewParent
    private lateinit var tableLayout: TableLayout
    private lateinit var viewPagerFragmentAdapter: ViewPagerFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        viewpager2.adapter = ViewPagerFragmentAdapter
        TabLayoutMediator(tablayout, viewpager2){tab,position->
            Tab.text = "tab ${
                position + 1
            }"
        }.attach()

    }
    private fun init(){
        viewpager2 = findViewById(R.id.viewpager2)
        tableLayout = findViewById(R.id.tablelayout)
        viewPagerFragmentAdapter = ViewPagerFragmentAdapter(this)
    }
}