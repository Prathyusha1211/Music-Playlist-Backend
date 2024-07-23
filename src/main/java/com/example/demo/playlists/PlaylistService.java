package com.example.demo.playlists;
import com.example.demo.playlistSong.PlaylistSong;
import com.example.demo.playlistSong.PlaylistSongRepository;
import com.example.demo.songs.Song;
import com.example.demo.songs.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private SongsRepository songRepository;

    @Autowired
    private PlaylistSongRepository playlistSongRepository;

    public Playlist createPlaylist(String playlistName) {
        Playlist playlist = new Playlist();
        playlist.setPlaylistName(playlistName);
        return playlistRepository.save(playlist);
    }

    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public ResponseEntity<Object> addSongToPlaylist(Long playlistId, Long songId) {
        Optional<Playlist> playlistOpt = playlistRepository.findById(playlistId);
        Optional<Song> songOpt = songRepository.findById(songId);

        if (playlistOpt.isPresent() && songOpt.isPresent()) {
            Playlist playlist = playlistOpt.get();
            Song song = songOpt.get();
            PlaylistSong playListSong = playlist.addSong(song);
            playlistSongRepository.save(playListSong);

            return new ResponseEntity<>(playListSong, HttpStatus.CREATED);
        }

        throw new RuntimeException("Playlist or Song not found");
    }



    public Playlist getPlaylistById(Long playlistId) {
        return playlistRepository.findById(playlistId).orElseThrow(() -> new RuntimeException("Playlist not found"));
    }
}
