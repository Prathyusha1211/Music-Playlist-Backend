package com.example.demo.playlists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
@CrossOrigin(origins = "http://localhost:3002")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public List<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlistRequest) {
        Playlist playlist = playlistService.createPlaylist(playlistRequest.getPlaylistName());
        return new ResponseEntity<>(playlist, HttpStatus.CREATED);
    }


    @PostMapping("/{playlistId}/songs")
    public ResponseEntity<Object> addSongToPlaylist(@PathVariable Long playlistId, @RequestBody AddSongRequest addSongRequest) {
        Long songId = addSongRequest.getSongId();
        return playlistService.addSongToPlaylist(playlistId, songId);
    }

    @GetMapping("/{playlistId}")
    public Playlist getPlaylistById(@PathVariable Long playlistId) {
        return playlistService.getPlaylistById(playlistId);
    }
}

