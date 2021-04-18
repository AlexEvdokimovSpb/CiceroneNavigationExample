package com.umbrellait.geekbrainsnavigation.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umbrellait.geekbrainsnavigation.screens.Screens
import com.umbrellait.geekbrainsnavigation.databinding.FragmentLoginBinding
import com.umbrellait.geekbrainsnavigation.base.FlowFragment

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val parentFlowFragment = (parentFragment as FlowFragment)

        binding.signInButton.setOnClickListener {
            parentFlowFragment.flowRouter.startFlow(Screens.SignIn)
        }

        binding.signUpButton.setOnClickListener {
            parentFlowFragment.flowRouter.startFlow(Screens.SignUp)
        }
    }
}