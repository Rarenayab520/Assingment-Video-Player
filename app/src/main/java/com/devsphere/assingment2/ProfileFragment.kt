package com.devsphere.assingment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.devsphere.assingment2.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // SET PROFILE DATA
        binding.profileName.text = "Hadia Safdar"
        binding.profileEmail.text = "hadia@example.com"

        // ---------------------------
        // BUTTON CLICK ACTIONS
        // ---------------------------

        binding.btnEditProfile.setOnClickListener {
            Toast.makeText(requireContext(), "Edit Profile clicked", Toast.LENGTH_SHORT).show()
        }

        binding.btnSettings.setOnClickListener {
            Toast.makeText(requireContext(), "Settings clicked", Toast.LENGTH_SHORT).show()
        }

        binding.btnLogout.setOnClickListener {
            Toast.makeText(requireContext(), "Logged out", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
