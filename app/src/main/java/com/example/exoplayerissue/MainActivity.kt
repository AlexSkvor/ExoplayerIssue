package com.example.exoplayerissue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.MediaMetadata
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.ui.StyledPlayerView

class MainActivity : AppCompatActivity() {

    private val videoView by lazy { findViewById<StyledPlayerView>(R.id.portrait_view_player_view) }

    private val player by lazy {
        ExoPlayer.Builder(this).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView.player = player

        val mediaItem = MediaItem.Builder()
            .setUri("https://github.com/AlexSkvor/video_samples/blob/master/video.mp4?raw=true")
            .setMediaMetadata(MediaMetadata.EMPTY)
            .build()

        player.setMediaItem(mediaItem)
        player.prepare()
    }

    override fun onPause() {
        super.onPause()
        player.pause()
    }
}