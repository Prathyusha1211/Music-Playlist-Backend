package com.example.demo.songs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongsService {

    SongsRepository songsRepository;



    @Autowired
    public SongsService(SongsRepository songsRepository) {
        this.songsRepository=songsRepository;
    }

    public List<Song> getAllSongs() {
        return songsRepository.findAll();
    }
}
