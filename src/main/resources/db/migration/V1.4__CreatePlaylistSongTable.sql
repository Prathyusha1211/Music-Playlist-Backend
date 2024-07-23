CREATE TABLE playlist_song (
    id BIGSERIAL PRIMARY KEY,
    playlist_id BIGINT NOT NULL,
    song_id BIGINT NOT NULL,
    FOREIGN KEY (playlist_id) REFERENCES playlists (playlist_id) ON DELETE CASCADE,
    FOREIGN KEY (song_id) REFERENCES songs (song_id) ON DELETE CASCADE,
    UNIQUE (playlist_id, song_id)
);