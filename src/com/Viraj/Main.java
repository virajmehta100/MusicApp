package com.Viraj;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {



        Album album = new Album("BreakUp","Arijit");
        album.addSong("Mein Dhoondhne ko Zamaane Mein",4.5);
        album.addSong("Pal Ek Pal",3.5);
        album.addSong("Pachtaoge",3.6);
        album.addSong("Ae Dil Hai Mushkil",3.7);

        albums.add(album);

        album = new Album("Soulful","Jubin");
        album.addSong("Kuch to bata",5);
        album.addSong("Haripa",4.5);

        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Pal Ek Pal",playList_1);
        albums.get(0).addToPlayList("Pachtaoge",playList_1);
        albums.get(0).addToPlayList("Ae Dil Hai Mushkil",playList_1);
        albums.get(1).addToPlayList("Kuch to bata",playList_1);

        play(playList_1);



    }

    private static void play(LinkedList<Song> playList){

    }


}
