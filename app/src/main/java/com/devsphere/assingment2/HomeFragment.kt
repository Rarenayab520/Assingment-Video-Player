package com.devsphere.assingment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devsphere.assingment2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // -------------------------------
        // CARD CLICKS → OPEN DIFFERENT TABS
        // -------------------------------

        // Entertainment Card Click
        binding.cardEntertainment.setOnClickListener {
            // Jump to Categories Tab (index 2)
            (activity as MainActivity).goToTab(2)
        }

        // Education Card Click
        binding.cardEducation.setOnClickListener {
            (activity as MainActivity).goToTab(1)
        }

        // Songs Card Click
        binding.cardSongs.setOnClickListener {
            (activity as MainActivity).goToTab(2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
