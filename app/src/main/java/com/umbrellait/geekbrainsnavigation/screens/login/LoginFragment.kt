package com.umbrellait.geekbrainsnavigation.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umbrellait.geekbrainsnavigation.base.FlowFragment
import com.umbrellait.geekbrainsnavigation.databinding.FragmentLoginBinding
import com.umbrellait.geekbrainsnavigation.model.TextModel
import com.umbrellait.geekbrainsnavigation.presenter.LoginFragmentPresenter
import com.umbrellait.geekbrainsnavigation.screens.Screens
import com.umbrellait.geekbrainsnavigation.view.ILoginFragmentView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class LoginFragment : MvpAppCompatFragment(), ILoginFragmentView {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val textModel = TextModel()

    private val presenter by moxyPresenter {
        LoginFragmentPresenter(textModel)
    }

    private var textStartView = "New text"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        binding.editText.setOnClickListener {
            textStartView = binding.editText.getText().toString()
            presenter.setText(textStartView)
        }
    }
}