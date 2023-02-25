package com.example.asanbekov.ui.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.asanbekov.data.local.Pref
import com.example.asanbekov.databinding.FragmentOnBoardingBinding
import com.example.asanbekov.ui.onBoard.adapter.OnBoardingAdapter
import me.relex.circleindicator.CircleIndicator3


class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding
    private lateinit var pref: Pref


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardingBinding.inflate(inflater,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref =Pref(requireContext())
        val adapter = OnBoardingAdapter(){
            pref.saveUserSeen()
            findNavController().navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToNavigationHome2())
        }
        binding.viewPager.adapter = adapter
        indicator()
    }

    private fun indicator() {
        val indicator:CircleIndicator3 = binding.indicator
        val viewPager = binding.viewPager
        indicator.setViewPager(viewPager)
    }

}

