package com.areeb.cleanarchitecture.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.areeb.cleanarchitecture.databinding.FragmentHomeFragmentsBinding
import com.areeb.cleanarchitecture.ui.home.adapters.HomeAdapter
import com.areeb.cleanarchitecture.ui.home.viewModels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragments : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private var _fragmentBinding: FragmentHomeFragmentsBinding? = null
    private val fragmentBinding get() = _fragmentBinding!!
    private var homeAdapter: HomeAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentBinding = FragmentHomeFragmentsBinding.inflate(layoutInflater, container, false)

        return _fragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getPosts()
        init()
        setObserver()
    }

    private fun setObserver() {
        viewModel.posts.observe(viewLifecycleOwner) {
            homeAdapter?.submitList(it)
        }
    }

    private fun init() {
        homeAdapter = HomeAdapter()
        fragmentBinding.homeRecyclerView.adapter = homeAdapter
    }
}
