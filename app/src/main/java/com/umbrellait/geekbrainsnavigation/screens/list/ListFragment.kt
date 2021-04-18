package com.umbrellait.geekbrainsnavigation.screens.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.umbrellait.geekbrainsnavigation.MainActivity
import com.umbrellait.geekbrainsnavigation.databinding.FragmentListBinding
import com.umbrellait.geekbrainsnavigation.screens.detail.DetailFragment
import com.umbrellait.geekbrainsnavigation.screens.list.adapter.ListAdapter
import com.umbrellait.geekbrainsnavigation.utils.Mock

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as MainActivity

        with(binding.recycleView) {
            adapter = ListAdapter(Mock.getStringList()).apply {
                onClickListener = { item ->
                    DetailFragment.create(item).show(parentFragmentManager, DetailFragment.TAG)
                }
            }
            layoutManager = LinearLayoutManager(requireContext())
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