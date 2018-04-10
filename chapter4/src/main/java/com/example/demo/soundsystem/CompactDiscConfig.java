package com.example.demo.soundsystem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OL-PC on 2018/03/22.
 */
@Configuration
@EnableAspectJAutoProxy
public class CompactDiscConfig {

    @Bean
    public BlankDisc blankDisc(){
        BlankDisc blankDisc = new BlankDisc();
        blankDisc.setArtist("xiaoming");
        blankDisc.setTitle("first");
        List<String> tracks = new ArrayList<>();
        tracks.add("111111");
        tracks.add("222222");
        tracks.add("333333");
        blankDisc.setTracks(tracks);
        return blankDisc;
    }
    @Bean
    public TrackCounter trackCounter(){
        return new TrackCounter();
    }
}
