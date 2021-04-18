package com.umbrellait.geekbrainsnavigation.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.umbrellait.geekbrainsnavigation.MainActivity
import com.umbrellait.geekbrainsnavigation.databinding.FragmentSignInBinding
import com.umbrellait.geekbrainsnavigation.base.FlowFragment
import com.umbrellait.geekbrainsnavigation.utils.NavigationInterface

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as MainActivity

        val navigationInterface: NavigationInterface = activity

        binding.signInButton.setOnClickListener {
            navigationInterface.toBottomFlow()
        }

        binding.backButton.setOnClickListener {
            (parentFragment as FlowFragment).flowRouter.finishFlow()
        }

        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                (parentFragment as FlowFragment).flowRouter.finishFlow()
            }
        })
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}