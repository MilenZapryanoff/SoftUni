package S6_Objects_and_Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04Songs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        List<Song> listSongs = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("_");

            Song currentSong = new Song(inputArr[0], inputArr[1], inputArr[2]);
            listSongs.add(currentSong);

        }
        String command = scanner.nextLine();
        if (command.equals("all")) {
            for (int i = 0; i < listSongs.size(); i++) {
                System.out.println(listSongs.get(i).getName());
            }
        } else {
            for (int i = 0; i < listSongs.size(); i++) {
                if (listSongs.get(i).getTypeList().equals(command)) {
                    System.out.println(listSongs.get(i).getName());
                }
            }
        }
    }

    public static class Song {
        private String typeList;
        private String name;
        private String time;

        public Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getTypeList() {
            return this.typeList;
        }
        public String getName() {
            return this.name;
        }
        public String getTime() {
            return this.time;
        }
    }
}
