package com.areeb.cleanarchitecture.ui.homeDetail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.areeb.cleanarchitecture.data.models.PostDto
import com.areeb.cleanarchitecture.databinding.FragmentDeatilsBinding
import com.areeb.cleanarchitecture.ui.homeDetail.viewModel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeatilsFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModels()
    private var _fragmentBinding: FragmentDeatilsBinding? = null
    private val fragmentBinding get() = _fragmentBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentBinding = FragmentDeatilsBinding.inflate(layoutInflater, container, false)
        return _fragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.saveBundlesArguments(arguments)
        setObserver()
    }

    private fun setObserver() {
        viewModel.photoDetail.observe(viewLifecycleOwner) {
            setDetailsData(it)
        }
    }

    private fun setDetailsData(photo: PostDto?) {
        if (photo != null) {
            fragmentBinding.nameTextView.text = photo.title
            fragmentBinding.detailTextView.text = photo.url
        }
    }
}
