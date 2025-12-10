package com.devsphere.assingment2

data class VideoModel(
    val title: String,
    val videoRes: Int,        // video from /res/raw
    val thumbnailRes: Int,    // drawable thumbnail
    val category: String      // Entertainment / Education / Songs
)
