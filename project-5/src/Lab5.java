import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;

public class Lab5 {
    public static void main(String[] args) {

        // create a linked list to store objects of the Star class
        LinkedList<Star> stars = new LinkedList<Star>();

        // read data from input file and store in LinkedList stars
        try {
            File file = new File("/Users/katechoi/IdeaProjects/project-5-choiy21/src/stars.csv");
            Scanner scanner = new Scanner(file);
            scanner.nextLine(); // skip header line

            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                int temperature = Integer.parseInt(data[0]);
                double luminosity = Double.parseDouble(data[1]);
                double radius = Double.parseDouble(data[2]);
                double absoluteMagnitude = Double.parseDouble(data[3]);
                int starType = Integer.parseInt(data[4]);
                String starColor = data[5];
                String spectralClass = data[6];

                // create new object and add to LinkedList
                Star star = new Star(temperature, luminosity, radius, absoluteMagnitude, starType, starColor, spectralClass);
                stars.add(star);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // sort linked list and measure time
        long startTime = System.currentTimeMillis();
        sort(stars, stars.size());
        long endTime = System.currentTimeMillis();
        System.out.println("Sorting time: " + (endTime - startTime) + " milliseconds");

        writeToFile(stars, "sortedDataset.txt");

    }

    public static void sort(LinkedList<Star> stars, int n) {
        boolean sorted = false;
        StarComparator comparator = new StarComparator();
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (comparator.compare(stars.get(i), stars.get(i + 1)) > 0) {
                    swap(stars, i, i + 1);
                    sorted = false;
                }
            }
        }
    }

    public static void swap(LinkedList<Star> stars, int i, int j) {
        Star temp = stars.get(i);
        stars.set(i, stars.get(j));
        stars.set(j, temp);
    }

    public static void writeToFile(LinkedList<Star> stars, String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            // write header
            writer.write("Temperature (K),Luminosity(L/Lo),Radius(R/Ro),Absolute magnitude(Mv),Star type,Star color,Spectral Class");
            writer.newLine();
            for (Star star : stars) {
                // write each star's data to the output file
                writer.write(star.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
