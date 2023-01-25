package com.example.a5_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.a5_2.databinding.FragmentDetailBinding

class CharacterDetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentDetailBinding.inflate(LayoutInflater.from(context),container,false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.tvGoBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}