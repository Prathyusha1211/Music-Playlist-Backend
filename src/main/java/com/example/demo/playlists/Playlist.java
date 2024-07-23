package com.example.demo.playlists;

import com.example.demo.playlistSong.PlaylistSong;
import com.example.demo.songs.Song;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playlistId;

    private String playlistName;

    public Long getPlaylistId() {
        return playlistId;
    }

    //    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Long> songIds = new HashSet<>();
//
//    public void setPlaylistId(Long playlistId) {
//        this.playlistId = playlistId;
//    }
    @ElementCollection
    @CollectionTable(name = "playlist_song", joinColumns = @JoinColumn(name = "playlist_id"))
    @Column(name = "song_id")
    private Set<Long> songIds = new HashSet<>();

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public Set<Long> getSongIds() {
        return songIds;
    }

    public void setSongIds(Set<Long> songIds) {
        this.songIds = songIds;
    }


    public PlaylistSong addSong(Song song) {
        PlaylistSong playlistSong = new PlaylistSong();
        playlistSong.setPlaylist(this);
        playlistSong.setSong(song);
        this.songIds.add(song.getSongId());
        return playlistSong;
    }


    @Override
    public String toString() {
        return "Playlist{" +
                "playlistId=" + playlistId +
                ", playlistName='" + playlistName + '\'' +
                ", songIds=" + songIds +
                '}';
    }
}
