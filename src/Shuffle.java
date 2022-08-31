import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Shuffle {
    public static void main(String[] args) throws IOException, CsvException {
        int HOUR_IN_MILLS = 3600000;
        List<Song> playlist = readIn();
        Song Finale = fin(playlist);

//        for (Song s : playlist){
//            System.out.println(s.toString());
//        }
//        System.out.println("");
//        System.out.println("");

        List<Song> workoutPlaylist = shufflePlaylist(playlist, Finale, HOUR_IN_MILLS);

        for (Song s : workoutPlaylist){
            System.out.println(s.toString());
        }
    }

    public static List readIn() throws IOException, CsvValidationException {
        List<Song> p = new ArrayList<Song>();

        String file = "C:\\Users\\steph\\IdeaProjects\\WorkoutShuffle\\src\\workout.csv";
        FileReader filereader = new FileReader(file);
        CSVReader csvReader = new CSVReader(filereader);
        String[] nextRecord;

        while ((nextRecord = csvReader.readNext()) != null) {
            String n = nextRecord[0];
            int l = Integer.parseInt(nextRecord[1]);
            boolean f = Boolean.parseBoolean(nextRecord[2]);
            p.add(new Song(n, l, f));
        }

//        for (Song s : playlist) {
//            System.out.println(s.toString());
//        }

        return p;
    }

    public static Song fin(List<Song> l) {
        Song temp = new Song("", 1, false);

        for (Song s : l) {
            if (s.isFinale()) {
                return s;
            }
        }
        return temp;
    }

    public static List<Song> shufflePlaylist(List<Song> p, Song f, int l) {
        int len = l - f.getLength();
        System.out.println(len);
        int count = 1;
        int finalLen = 0;
        List<Song> wl = new ArrayList<Song>();
        Random random = new Random();

        while (len >= 0 & count < p.size()) {
            int val = random.nextInt(p.size());
            Song ss = p.get(val);
            if (!ss.isSelected() & !ss.getName().equals(f.getName()) ){
                ss.setSelected(true);
                wl.add(ss);
                len -= ss.getLength();
                finalLen += ss.getLength();
                count++;
            }
        }
        wl.add(f);
        finalLen += f.getLength();
        System.out.println(finalLen);
        return wl;
    }
}