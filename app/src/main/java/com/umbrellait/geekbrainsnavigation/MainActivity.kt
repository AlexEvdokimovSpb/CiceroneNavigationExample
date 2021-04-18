package com.umbrellait.geekbrainsnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.umbrellait.geekbrainsnavigation.databinding.ActivityMainBinding
import com.umbrellait.geekbrainsnavigation.base.FlowRouter
import com.umbrellait.geekbrainsnavigation.screens.Screens
import com.umbrellait.geekbrainsnavigation.utils.NavigationInterface

class MainActivity : AppCompatActivity(), NavigationInterface {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    lateinit var router: Router

    var cicerone: Cicerone<Router> = Cicerone.create()

    private val navigator = object : AppNavigator(
        this,
        R.id.container,
        supportFragmentManager
    ) {

        override fun setupFragmentTransaction(
            fragmentTransaction: FragmentTransaction,
            currentFragment: Fragment?,
            nextFragment: Fragment?
        ) {
            fragmentTransaction.setReorderingAllowed(true)
            if (currentFragment != null) {
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            }
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        cicerone.getNavigatorHolder().setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        cicerone.getNavigatorHolder().removeNavigator()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        router = cicerone.router

        toLoginFlow()
    }

    override fun toBottomFlow() = router.newRootScreen(
        Screens.BottomFlow(
            FlowRouter(cicerone.router),
            cicerone.getNavigatorHolder()
        )
    )

    override fun toLoginFlow() = router.newRootScreen(
        Screens.LoginFlow(
            FlowRouter(router),
            cicerone.getNavigatorHolder()
        )
    )
}