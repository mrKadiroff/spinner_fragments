package com.example.spinnner

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.spinnner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var names: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment1Action = fragment1()
        val fragment2Action = fragment2()
        val fragment3Action = fragment3()

        val names: ArrayList<String> = ArrayList<String>()
        names.add("Android")
        names.add("Java")
        names.add("Php")
        names.add("C++")


        val arrayAdapter  =  ArrayAdapter(this,R.layout.item,names)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = arrayAdapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, i: Int, p3: Long) {

                when (i){
                    0->
                        selectFragment(fragment1Action)
                    1->
                        selectFragment(fragment2Action)
                    2->
                        selectFragment(fragment3Action)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
//        binding.spinner.setOnItemClickListener { adapterView, view, i, l ->
//
//
//           when (i){
//               1->
//                selectFragment(fragment1Action)
//               2->
//                   selectFragment(fragment2Action)
//               3->
//                   selectFragment(fragment3Action)
//           }
//        }


    }

    private fun selectFragment(fragment : Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.FrameLayout,fragment)
        fragmentTransaction.commit()
    }


}