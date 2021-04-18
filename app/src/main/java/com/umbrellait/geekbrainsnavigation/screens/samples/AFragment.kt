package com.umbrellait.geekbrainsnavigation.screens.samples

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.umbrellait.geekbrainsnavigation.MainActivity
import com.umbrellait.geekbrainsnavigation.screens.Screens
import com.umbrellait.geekbrainsnavigation.databinding.FragmentABinding
import com.umbrellait.geekbrainsnavigation.base.FlowFragment

class AFragment : Fragment() {

    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as MainActivity

        binding.button.setOnClickListener {
            (parentFragment as FlowFragment).flowRouter.startFlow(Screens.B)
        }

        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity.router.exit()
            }
        })
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}