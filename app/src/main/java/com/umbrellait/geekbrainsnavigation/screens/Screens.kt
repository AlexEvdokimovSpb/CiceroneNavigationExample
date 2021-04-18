package com.umbrellait.geekbrainsnavigation.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.Creator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.umbrellait.geekbrainsnavigation.base.FlowRouter
import com.umbrellait.geekbrainsnavigation.flows.bottom.BottomFlowFragment
import com.umbrellait.geekbrainsnavigation.flows.left.LeftFlowFragment
import com.umbrellait.geekbrainsnavigation.flows.list.ListFlowFragment
import com.umbrellait.geekbrainsnavigation.flows.login.LoginFlowFragment
import com.umbrellait.geekbrainsnavigation.flows.right.RightFlowFragment
import com.umbrellait.geekbrainsnavigation.screens.samples.AFragment
import com.umbrellait.geekbrainsnavigation.screens.samples.BFragment
import com.umbrellait.geekbrainsnavigation.screens.login.LoginFragment
import com.umbrellait.geekbrainsnavigation.screens.list.ListFragment
import com.umbrellait.geekbrainsnavigation.screens.login.SignInFragment
import com.umbrellait.geekbrainsnavigation.screens.login.SignUpFragment
import com.umbrellait.geekbrainsnavigation.screens.right.RightFragment

object Screens {

    object A :
            FragmentScreen(AFragment::class.java.name, object : Creator<FragmentFactory, Fragment> {
                override fun create(argument: FragmentFactory): Fragment = AFragment()
            })

    object B :
            FragmentScreen(BFragment::class.java.name, object : Creator<FragmentFactory, Fragment> {
                override fun create(argument: FragmentFactory): Fragment = BFragment()
            })

    object List :
            FragmentScreen(ListFragment::class.java.name, object : Creator<FragmentFactory, Fragment> {
                override fun create(argument: FragmentFactory): Fragment = ListFragment()
            })

    object Login :
            FragmentScreen(LoginFragment::class.java.name, object : Creator<FragmentFactory, Fragment> {
                override fun create(argument: FragmentFactory): Fragment = LoginFragment()
            })

    object SignIn : FragmentScreen(
            SignInFragment::class.java.name,
            object : Creator<FragmentFactory, Fragment> {
                override fun create(argument: FragmentFactory): Fragment = SignInFragment()
            })

    object SignUp : FragmentScreen(
            SignUpFragment::class.java.name,
            object : Creator<FragmentFactory, Fragment> {
                override fun create(argument: FragmentFactory): Fragment = SignUpFragment()
            })

    object Right : FragmentScreen(
            RightFragment::class.java.name,
            object : Creator<FragmentFactory, Fragment> {
                override fun create(argument: FragmentFactory): Fragment = RightFragment()
            })

    class LeftFlow(
            val flowRouter: FlowRouter,
            var navigationHolder: NavigatorHolder
    ) : FragmentScreen(
            LeftFlowFragment::class.java.name,
            object : Creator<FragmentFactory, Fragment> {
                override fun create(argument: FragmentFactory): Fragment =
                        LeftFlowFragment(flowRouter, navigationHolder)
            })

    class ListFlow(
            val flowRouter: FlowRouter,
            var navigationHolder: NavigatorHolder
    ) : FragmentScreen(
            ListFlowFragment::class.java.name,
            object : Creator<FragmentFactory, Fragment> {
                override fun create(argument: FragmentFactory): Fragment =
                        ListFlowFragment(flowRouter, navigationHolder)
            })

    class RightFlow(
            val flowRouter: FlowRouter,
            var navigationHolder: NavigatorHolder
    ) : FragmentScreen(
            RightFlowFragment::class.java.name,
            object : Creator<FragmentFactory, Fragment> {
                override fun create(argument: FragmentFactory): Fragment =
                        RightFlowFragment(flowRouter, navigationHolder)
            })

    class LoginFlow(
            val flowRouter: FlowRouter,
            val navigationHolder: NavigatorHolder
    ) : FragmentScreen(
            LoginFlowFragment::class.java.name,
            object : Creator<FragmentFactory, Fragment> {
                override fun create(argument: FragmentFactory): Fragment =
                        LoginFlowFragment(flowRouter, navigationHolder)
            })

    class BottomFlow(
            val flowRouter: FlowRouter,
            val navigationHolder: NavigatorHolder
    ) : FragmentScreen(
            BottomFlowFragment::class.java.name,
            object : Creator<FragmentFactory, Fragment> {
                override fun create(argument: FragmentFactory): Fragment =
                        BottomFlowFragment(flowRouter, navigationHolder)
            })
}