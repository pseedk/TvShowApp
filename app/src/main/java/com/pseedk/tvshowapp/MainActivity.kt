package com.pseedk.tvshowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pseedk.tvshowapp.adapter.TvShowAdapter
import com.pseedk.tvshowapp.databinding.ActivityMainBinding
import com.pseedk.tvshowapp.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: TvShowViewModel by viewModels()
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        setUpRv()
    }

    private fun setUpRv() {
        tvShowAdapter = TvShowAdapter()
        binding.recyclerView.apply {
            adapter = tvShowAdapter
            layoutManager =
                LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            setHasFixedSize(true)
        }

        binding.rvEpisodes.apply {
            adapter = tvShowAdapter
            layoutManager =
                LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            setHasFixedSize(true)
        }

        binding.rvRecentlyAdded.apply {
            adapter = tvShowAdapter
            layoutManager =
                LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            setHasFixedSize(true)
        }
        viewModel.responseTvShow.observe(this) { listTvShows ->

            tvShowAdapter.tvShows = listTvShows

        }
    }
}