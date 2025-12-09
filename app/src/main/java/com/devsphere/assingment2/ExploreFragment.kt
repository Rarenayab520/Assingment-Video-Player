package com.devsphere.assingment2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.devsphere.assingment2.databinding.FragmentExploreBinding

class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // -----------------------------
        //  CARD CLICK ACTIONS
        // -----------------------------

        // Entertainment → Funny YouTube video
        binding.cardEntertainment.setOnClickListener {
            showMsg("Opening Entertainment Videos...")
            openVideo("https://youtube.com/playlist?list=PLJuI8TslmruBvak82j9n7hNDEUIOkWjeF&si=TvXCzrlRvPAn0yrd")
        }

        // Education → Coding tutorial
        binding.cardEducation.setOnClickListener {
            showMsg("Opening Education Content...")
            openVideo("https://youtube.com/playlist?list=PLRKyZvuMYSIMW3-rSOGCkPlO1z_IYJy3G&si=VTi3GGsJhKzs51vE")
        }

        // Songs → Punjabi song
        binding.cardSongs.setOnClickListener {
            showMsg("Opening Songs Playlist...")
            openVideo("https://youtube.com/playlist?list=PLO7-VO1D0_6M1xUjj8HxTxskouWx48SNw&si=IMUE3gan0oiXRItA")
        }
    }

    // -----------------------------
    // Helper → Open YouTube link
    // -----------------------------
    private fun openVideo(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    // -----------------------------
    // Helper → Show Toast
    // -----------------------------
    private fun showMsg(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
