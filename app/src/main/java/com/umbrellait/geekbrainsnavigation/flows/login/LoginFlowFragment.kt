package com.umbrellait.geekbrainsnavigation.flows.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.terrakok.cicerone.NavigatorHolder
import com.umbrellait.geekbrainsnavigation.MainActivity
import com.umbrellait.geekbrainsnavigation.screens.Screens
import com.umbrellait.geekbrainsnavigation.databinding.FragmentContainerBinding
import com.umbrellait.geekbrainsnavigation.base.FlowFragment
import com.umbrellait.geekbrainsnavigation.base.FlowRouter
import com.umbrellait.geekbrainsnavigation.utils.setLaunchScreen

class LoginFlowFragment(
    override var flowRouter: FlowRouter,
    override var navigationHolder: NavigatorHolder
) : FlowFragment() {

    private var _binding: FragmentContainerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (childFragmentManager.fragments.isEmpty()) {
            navigator.setLaunchScreen(Screens.Login)
        }
    }
}