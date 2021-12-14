package com.Viraj;

import java.util.*;

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
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size()==0){
            System.out.println("This Playlist have no song");
        }
        else{
            System.out.println("Now Playing " + listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch(action){
                case 0:
                    System.out.println("PlayList complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now Playing " + listIterator.next().toString());
                    }else{
                        System.out.println("No Song available, reached to the end of the list");
                        forward=false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();

                        }
                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now Playing " + listIterator.previous().toString());
                    }else{
                        System.out.println("We are at the first song");
                        forward=false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now Playing " + listIterator.previous().toString());
                            forward=false;
                        }else{
                            System.out.println("We are at the start of the list");

                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing " + listIterator.next().toString());
                            forward = true;
                        }else{
                            System.out.println("We have reached to the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing " + listIterator.next().toString());
                            //forward = true;
                        }
                        else{
                            if(listIterator.hasPrevious())
                            System.out.println("Now Playing " + listIterator.previous().toString());
                        }
                    }

            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to play the current song\n" +
                "4 - list of all songs \n" +
                "5 - print all available options\n" +
                "6 - delete current song");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("------------------------");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-------------------------");
    }


}
