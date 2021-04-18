package com.umbrellait.geekbrainsnavigation.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.umbrellait.geekbrainsnavigation.R
import com.umbrellait.geekbrainsnavigation.databinding.FragmentContainerBinding

abstract class FlowFragment : Fragment() {

    private var _binding: FragmentContainerBinding? = null
    private val binding get() = _binding!!

    abstract var flowRouter: FlowRouter

    abstract var navigationHolder: NavigatorHolder

    open val navigator: Navigator by lazy {
        object : AppNavigator(
                requireActivity(),
                R.id.fragmentContainer,
                childFragmentManager) {

            override fun setupFragmentTransaction(
                    fragmentTransaction: FragmentTransaction,
                    currentFragment: Fragment?,
                    nextFragment: Fragment?) {
                fragmentTransaction.setReorderingAllowed(true)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentContainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        super.onPause()
    }
}