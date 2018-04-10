package com.example.demo.soundsystem;

import java.util.List;

/**
 * Created by OL-PC on 2018/03/22.
 */
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public void play() {
        for (int i = 0;i < tracks.size();i++){
            playTrack(i);
        }
    }
    @Override
    public void playTrack(int trackNum){
        System.out.println("track : " + tracks.get(trackNum));
    }
}
