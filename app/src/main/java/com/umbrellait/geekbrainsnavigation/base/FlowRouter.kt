package com.umbrellait.geekbrainsnavigation.base

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen

class FlowRouter(private val parentRouter: Router) : Router() {

    fun startFlow(screen: FragmentScreen) = parentRouter.navigateTo(screen)


    fun newRootFlow(screen: FragmentScreen) = parentRouter.newRootScreen(screen)


    fun replaceFlow(screen: FragmentScreen) = parentRouter.replaceScreen(screen)


    fun finishFlow() = parentRouter.exit()

    override fun toString(): String =  "${super.toString()} with parent: $parentRouter"

}