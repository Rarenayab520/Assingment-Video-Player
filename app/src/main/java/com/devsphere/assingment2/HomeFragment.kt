package com.devsphere.assingment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.devsphere.assingment2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RecyclerView
        binding.homeVideoRecycler.layoutManager = LinearLayoutManager(requireContext())

        // -----------------------------
        // ⭐ FULL VIDEO LIST FOR HADIA
        // -----------------------------
        val videos = listOf(

            // ENTERTAINMENT
            VideoModel(
                "Haseen Song Lyrics",
                R.raw.haseen,
                R.drawable.haseen_thumb,
                "Entertainment"
            ),

            VideoModel(
                "Sahiba Song",
                R.raw.sahiba,
                R.drawable.sahiba_thumb,
                "Entertainment"
            ),

            // EDUCATION
            VideoModel(
                "Data Science Intro",
                R.raw.data_science,
                R.drawable.data_science_thumb,
                "Education"
            ),

            VideoModel(
                "Education Module 1",
                R.raw.education_1,
                R.drawable.edu_1_thumb,
                "Education"
            ),

            VideoModel(
                "Education Module 2",
                R.raw.education_2,
                R.drawable.edu_2_thumb,
                "Education"
            ),

            // MOTIVATION
            VideoModel(
                "Daily Motivation Boost",
                R.raw.motivation,
                R.drawable.motivation_thumb,
                "Motivation"
            )
        )

        // Adapter set
        binding.homeVideoRecycler.adapter = VideoAdapter(videos) { selectedVideo ->

            // Show video container
            val container = requireActivity().findViewById<View>(R.id.video_player_container)
            container.visibility = View.VISIBLE

            // Open player
            val fragment = VideoPlayerFragment().apply {
                arguments = Bundle().apply {
                    putInt("videoRes", selectedVideo.videoRes)
                    putString("title", selectedVideo.title)
                }
            }

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.video_player_container, fragment)
                .addToBackStack("video_player")
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
