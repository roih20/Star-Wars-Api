package com.rodrigo.starwars.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rodrigo.starwars.StarWarsApplication
import com.rodrigo.starwars.databinding.FragmentPeopleBinding
import com.rodrigo.starwars.viewModel.StarWarsFactory
import com.rodrigo.starwars.viewModel.StarWarsRv
import com.rodrigo.starwars.viewModel.StarWarsViewModel

class FragmentPeople: Fragment() {

    private val starWarsFactory by lazy {
        val app = requireActivity().application as StarWarsApplication
        StarWarsFactory(app.repository)
    }

    private val starWarsViewModel: StarWarsViewModel by viewModels{
        starWarsFactory
    }

    private var _binding: FragmentPeopleBinding ?= null
    private val binding get () = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPeopleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = starWarsViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val rvAdapter = StarWarsRv()

        val rv = binding.starWarsRv.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        starWarsViewModel.getCharacters()

        starWarsViewModel.characterList.observe(viewLifecycleOwner){ response ->
            if (response.isSuccessful){
                response.body()?.let {
                    rvAdapter.setData(it)
                }
            }

        }
    }
}