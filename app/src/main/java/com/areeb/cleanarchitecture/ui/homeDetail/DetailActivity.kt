package com.areeb.cleanarchitecture.ui.homeDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.areeb.cleanarchitecture.MainActivity
import com.areeb.cleanarchitecture.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : MainActivity() {
    companion object {
        private const val TAG = " detailActivity"
        fun newIntent(context: Context, postId: Int?) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("postId", postId)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpNavigationGraph()
    }

    private fun setUpNavigationGraph() {
        val postId = intent.getIntExtra("postId", 0)

        val bundle = Bundle()
        bundle.putInt("postId", postId)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.detail_navigation)

        navController.setGraph(navGraph, bundle)
    }
}
