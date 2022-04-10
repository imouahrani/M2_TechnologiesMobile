package com.github.imouahrani.breakingbad.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.imouahrani.breakingbad.databinding.FragmentCharacterDetailsBinding
import com.github.imouahrani.breakingbad.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CharacterDetailsFragment : Fragment() {

    private val viewModel: HomeViewModel by sharedViewModel()

    private lateinit var binding: FragmentCharacterDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.selectedCharacter.observe(viewLifecycleOwner) {
            binding.model = it
            binding.executePendingBindings()
        }
    }
}