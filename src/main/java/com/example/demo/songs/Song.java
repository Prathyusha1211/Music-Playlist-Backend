package com.example.demo.songs;
import com.example.demo.playlistSong.PlaylistSong;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="songs")
public class Song {

    @Id
    @Column(name = "song_id")
    private Long SongId;

    @Column(name = "song_name")
    private String SongName;

    public Song() {
    }

    public Song(Long songId, String songName) {
        this.SongId = songId;
        this.SongName = songName;
    }

    public Long getSongId() {
        return SongId;
    }

    public void setSongId(Long songId) {
        SongId = songId;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }



    @Override
    public String toString() {
        return "Song{" +
                "SongId=" + SongId +
                ", SongName='" + SongName + '\'' +
                '}';
    }
}
