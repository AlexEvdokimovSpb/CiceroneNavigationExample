package com.umbrellait.geekbrainsnavigation.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.umbrellait.geekbrainsnavigation.screens.Screens
import com.umbrellait.geekbrainsnavigation.databinding.FragmentSignUpBinding
import com.umbrellait.geekbrainsnavigation.base.FlowFragment

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val parentFlowFragment = (parentFragment as FlowFragment)

        binding.signUpButton.setOnClickListener {
            parentFlowFragment.flowRouter.replaceFlow(Screens.SignIn)
        }

        binding.backButton.setOnClickListener {
            parentFlowFragment.flowRouter.finishFlow()
        }

        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                parentFlowFragment.flowRouter.finishFlow()
            }
        })
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}