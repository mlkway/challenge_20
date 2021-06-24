package com.raywenderlich.articles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.raywenderlich.articles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: Myadapter

    private val viewModel: ArticlesViewModel by  viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.isLoader.observe(this){
            binding.progressBar.isVisible = it
            }
        bindRec()
        binding.searchImgView.setOnClickListener{
            search()
        }






    }




    private fun search(){
        binding.apply {
            searchEditText.isVisible = true
            searchEditText.doOnTextChanged { text, _, _, _  ->

            }
        }
    }


    private fun bindRec(){
        viewModel.loader()
        adapter = Myadapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerView.adapter = adapter
        viewModel.data.observe(this){
            adapter.data = it.toTypedArray().toMutableList()
            adapter.notifyDataSetChanged()
        }

    }

}