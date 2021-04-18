package com.umbrellait.geekbrainsnavigation.screens.right

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.umbrellait.geekbrainsnavigation.MainActivity
import com.umbrellait.geekbrainsnavigation.databinding.FragmentRightBinding
import com.umbrellait.geekbrainsnavigation.model.TextModel
import com.umbrellait.geekbrainsnavigation.presenter.RightFragmentPresenter
import com.umbrellait.geekbrainsnavigation.view.IRightFragmentView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RightFragment : MvpAppCompatFragment(), IRightFragmentView {

    private var _binding: FragmentRightBinding? = null
    private val binding get() = _binding!!
    private val textModel = TextModel()


    private val presenter by moxyPresenter {
        RightFragmentPresenter(textModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRightBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity() as MainActivity
        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity.router.exit()
            }
        })
        presenter.getText()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun setText(text: String) {
        binding.rightFragmentTextView.text = text
    }
}