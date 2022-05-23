package com.example.task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    YouTubePlayerView youTubePlayerView;
    private YouTubePlayer youTubePlayer;
    AbstractYouTubePlayerListener abstractYouTubePlayerListener;
    Button shuffle;
//    Random r = new Random();
    int i=0;
    String[] arr= {"IEF6mw7eK4s", "8CEJoCr_9UI", "344u6uK9qeQ", "3-nM3yNi3wg", "RlcY37n5j9M", "nB7nGcW9TyE"};
    private YouTubePlayer yt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shuffle=findViewById(R.id.shufflebutton);
        youTubePlayerView=findViewById(R.id.youtube_player_view);
        play(arr[i++]);



    }


    public void play(String vid) {

        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer2) {
                youTubePlayer=youTubePlayer2;

                String videoId = vid;
                youTubePlayer.loadVideo(videoId, 0);
            }

        });


        shuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i>=arr.length)
                    i=0;
                String videoId= arr[i++];
                youTubePlayer.loadVideo(videoId, 0);

            }
        });
    }

//    public void play(View view) {
//

//        play(arr[rand]);
//        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
//            @Override
//            public void onVideoId(YouTubePlayer youTubePlayer, String videoId) {
//                super.onVideoId(youTubePlayer, videoId);
//            }
//        })
//        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
//            @Override
//            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
//
////                String videoId = pass;
//                youTubePlayer.loadVideo(arr[1], 0);
//            }
//        });
//    }

    public void next(View view) {
        Intent i = new Intent(getApplicationContext(), form.class);
        startActivity(i);
    }
}