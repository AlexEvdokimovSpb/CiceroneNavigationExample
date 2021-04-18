package com.umbrellait.geekbrainsnavigation.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.DialogFragment
import com.umbrellait.geekbrainsnavigation.R
import com.umbrellait.geekbrainsnavigation.databinding.FragmentDetailBinding
import com.umbrellait.geekbrainsnavigation.base.FlowFragment

class DetailFragment : DialogFragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.title.text = arguments?.getString(ARG_DATA)

        binding.backButton.setOnClickListener {
            dismiss()
        }
    }

    override fun getTheme(): Int = R.style.FullScreenDialog

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    companion object {

        const val TAG = "DetailFragment"

        private const val ARG_DATA = "arg_data"

        fun create(data: String): DetailFragment = DetailFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_DATA, data)
            }
        }
    }
}