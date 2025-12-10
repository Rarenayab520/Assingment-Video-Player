package com.devsphere.assingment2

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.fragment.app.Fragment

class VideoPlayerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_video_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val videoView = view.findViewById<VideoView>(R.id.videoView)
        val titleText = view.findViewById<TextView>(R.id.videoTitle)
        val btnClose = view.findViewById<View>(R.id.btnClose)

        val videoRes = requireArguments().getInt("videoRes")
        val title = requireArguments().getString("title")

        titleText.text = title

        val uri = Uri.parse("android.resource://${requireContext().packageName}/$videoRes")

        val controller = MediaController(requireContext())
        controller.setAnchorView(videoView)

        videoView.setMediaController(controller)
        videoView.setVideoURI(uri)
        videoView.start()

        // CLOSE BUTTON FUNCTION
        btnClose.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
            requireActivity().findViewById<View>(R.id.video_player_container).visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        requireActivity().findViewById<View>(R.id.video_player_container).visibility = View.GONE
    }
}
