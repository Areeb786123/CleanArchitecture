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
        fun newIntent(context: Context, postDetailTitle: String) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("postTitle", postDetailTitle)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpNavigationGraph()
    }

    private fun setUpNavigationGraph() {
        val postTitle = intent.getStringExtra("postTitle")

        val bundle = Bundle()
        bundle.putString("postTitle", postTitle)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.detail_navigation)

        if (postTitle.isNullOrEmpty()) {
            navController.graph = navGraph
        } else {
            navController.setGraph(navGraph, bundle)
        }
    }
}
