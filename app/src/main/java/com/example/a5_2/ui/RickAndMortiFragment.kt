package com.example.a5_2

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.a5_2.data.RemoteRepository
import com.example.a5_2.databinding.FragmentRickAndMortiBinding
import com.example.a5_2.model.Characters
import com.example.a5_2.ui.CharacterAdapter

@Suppress("DEPRECATION")
class CharactersFragment : Fragment() {
    private lateinit var binding: FragmentRickAndMortiBinding
    private lateinit var adapter: CharacterAdapter
    private val repository = RemoteRepository()
    private var page = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentRickAndMortiBinding.inflate(LayoutInflater.from(context), container, false)
        initMethod()
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.nextBtn.setOnClickListener {
            ++page
            initMethod()
        }
    }

    private fun initMethod() {
        repository.getCharacters(page, this::onSuccess, this::onFailure)
    }


    private fun onSuccess(characters: Characters) {
        Log.e("TAG", "onSuccess: $characters")
        adapter = CharacterAdapter(characters, this::onCLick)
        binding.rvFragmentRickMort.adapter = adapter
    }

    private fun onCLick(id: Int) {
        findNavController().navigate(R.id.detailFragment)
    }


    private fun onFailure(message: String) {
        Log.e("bmv", "onFailure:$message")
    }
}


