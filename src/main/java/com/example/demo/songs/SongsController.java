package com.example.demo.songs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/songs")
@CrossOrigin(origins = "http://localhost:3002")
public class SongsController {
    @Autowired
    SongsService songsService;

    @GetMapping
    public List<Song> getAllSongs() {
        return songsService.getAllSongs();
    }
}
