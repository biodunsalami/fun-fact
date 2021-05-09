package com.biodun.funfact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.biodun.funfact.databinding.ActivityMainBinding
import com.biodun.zurifunfact.DummyData

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    var adapter: FactAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setUpFact()
    }

    private fun setUpFact(){

        adapter = FactAdapter(this, DummyData.funFact)
        binding?.factsListView?.adapter = adapter
    }

    override fun onDestroy(){
        super.onDestroy()
        binding = null
    }
}