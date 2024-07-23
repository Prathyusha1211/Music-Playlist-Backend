package com.example.demo.playlistSong;

import com.example.demo.playlists.Playlist;
import com.example.demo.songs.Song;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="playlist_song")
public class PlaylistSong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;

    public PlaylistSong() {
    }

    public PlaylistSong(Playlist playlist, Song song) {
        this.playlist = playlist;
        this.song = song;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaylistSong that = (PlaylistSong) o;
        return Objects.equals(playlist, that.playlist) && Objects.equals(song, that.song);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlist, song);
    }
}
