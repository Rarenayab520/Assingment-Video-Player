package com.devsphere.assingment2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devsphere.assingment2.databinding.ItemVideoBinding

class VideoAdapter(
    private val videoList: List<VideoModel>,
    private val onVideoClick: (VideoModel) -> Unit
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    inner class VideoViewHolder(val binding: ItemVideoBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = ItemVideoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = videoList[position]

        // Bind data
        holder.binding.videoTitle.text = video.title
        holder.binding.videoThumbnail.setImageResource(video.thumbnailRes)
        holder.binding.videoCategory.text = video.category

        // Handle click
        holder.itemView.setOnClickListener {
            onVideoClick(video)
        }
    }

    override fun getItemCount() = videoList.size
}
