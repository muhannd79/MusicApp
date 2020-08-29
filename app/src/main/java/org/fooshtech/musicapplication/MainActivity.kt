package org.fooshtech.musicapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.fooshtech.musicapplication.adapter.MyPagerAdapter
import org.fooshtech.musicapplication.model.MusicResponse
import org.fooshtech.musicapplication.request.RetrofitNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val fragAdapter= MyPagerAdapter(supportFragmentManager)
        viewPager.adapter=MyPagerAdapter(supportFragmentManager)
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)?.setIcon(R.drawable.ic_rock)
        tabs.getTabAt(1)?.setIcon(R.drawable.ic_classic)
        tabs.getTabAt(2)?.setIcon(R.drawable.ic_pop)


    }





}


