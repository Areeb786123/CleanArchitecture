package com.areeb.cleanarchitecture.ui.homeDetail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.areeb.cleanarchitecture.databinding.FragmentDeatilsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeatilsFragment : Fragment() {

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
}
