package ru.practicum.android.diploma.filter.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.practicum.android.diploma.R
import ru.practicum.android.diploma.databinding.FragmentPlacesOfWorkBinding
import ru.practicum.android.diploma.filter.presentation.view_model.PlaceOfWorkViewModel


class PlacesOfWorkFragment : Fragment() {

    private var _binding: FragmentPlacesOfWorkBinding? = null
    private val binding get() = _binding!!

    private val vM: PlaceOfWorkViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlacesOfWorkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ibArrowBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.tvCountryClear.setOnClickListener {
            findNavController().navigate(R.id.action_placesOfWorkFragment_to_countrySelectionFragment)
        }

        binding.tvRegionClear.setOnClickListener {
            findNavController().navigate(R.id.action_placesOfWorkFragment_to_choosingRegionFragment)
        }

        binding.clCountry.setOnClickListener {
            findNavController().navigate(R.id.action_placesOfWorkFragment_to_countrySelectionFragment)
        }

        binding.clRegion.setOnClickListener {
            findNavController().navigate(R.id.action_placesOfWorkFragment_to_choosingRegionFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun buttonAcceptVisibility() {
        binding.btnChoose.isVisible = (binding.tvCountryClear.isVisible
                || binding.tvCountryClear.isVisible)
    }

    companion object {
        fun newInstance() = PlacesOfWorkFragment()
    }
}