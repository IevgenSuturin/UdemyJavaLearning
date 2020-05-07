package com.yevhensuturin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dev on 18/09/15.
 */
public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song song = songs.findSong(trackNumber);
        if (song != null) {
            playList.add(song);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = songs.findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    public void addSong(String title, double duration){
        songs.addSong(title, duration);
    }

    private class SongList {
        private List<Song> songList = new ArrayList<>();

        public void addSong(String title, double duration) {
            if (findSong(title) == null) {
                songList.add(new Song(title, duration));
            }
        }

        public void addSong(Song song){
            if(findSong(song.getTitle()) ==  null){
                songList.add(song);
            }
        }

        private Song findSong(String title) {
            for (Song song : songList) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }
            return null;
        }

        public Song findSong(int treckNumber) {
            int index = treckNumber-1;
            if ((index >=  0) && (index <= songList.size())) {
                return songList.get(index);
            };
            return null;
        }
    }
}
