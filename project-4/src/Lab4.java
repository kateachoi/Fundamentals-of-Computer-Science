import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {


        // create one ArrayList to store objects of Star class
        ArrayList<Star> stars = new ArrayList<>();

        // read data from file and add to stars ArrayList
        try {
            File file = new File("/Users/katechoi/IdeaProjects/project-4-choiy21/src/stars.csv");
            Scanner scanner = new Scanner(file);
            scanner.nextLine(); // skip header line

            // read each row in the dataset and store it in an object of Star class type
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                int temperature = Integer.parseInt(data[0]);
                double luminosity = Double.parseDouble(data[1]);
                double radius = Double.parseDouble(data[2]);
                double absoluteMagnitude = Double.parseDouble(data[3]);
                int starType = Integer.parseInt(data[4]);
                String starColor = data[5];
                String spectralClass = data[6];

                // add the new object to the ArrayList
                Star star = new Star(temperature, luminosity, radius, absoluteMagnitude, starType, starColor, spectralClass);
                stars.add(star);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // sort stars
        long startTime = System.currentTimeMillis();
        sort(stars, stars.size());
        long endTime = System.currentTimeMillis();
        System.out.println("Sorting time: " + (endTime - startTime) + " milliseconds");

        // write sorted data to a new file
        writeToFile(stars, "sorted_stars.txt");

    }

    // use developed comparator class to create a method called sort with parameters ArrayList<> of dataset and the size n
    public static void sort(ArrayList<Star> stars, int n) {
        // when there are no swaps required, the sort algorithm determines that an array is completely sorted and the algorithm ends
        boolean sorted = false;
        StarComparator comparator = new StarComparator();

        // sorting algorithm

        // while array of size n is not sorted
        while (!sorted) {
            sorted = true;
            // for each adjacent pair of elements in the ArrayList
            for (int i = 0; i < n - 1; i++) {
                // if the adjacent pair is out of order
                if (i < n - 1 && comparator.compare(stars.get(i), stars.get(i + 1)) > 0) {
                    // swap the adjacent pair (swap stars[i] and stars[i+1])
                    swap(stars, i);
                    sorted = false;;
                }
            }
            n--; // the largest element is already sorted
        }
    }

    public static void swap(ArrayList<Star> stars, int i) {
        Star temp = stars.get(i);
        stars.set(i, stars.get(i + 1));
        stars.set(i + 1, temp);
    }

    // print out the contents of the ArrayList after sorting into a text file using the toString method of class Star
    public static void writeToFile(ArrayList<Star> stars, String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            // write header
            writer.write("Temperature (K),Luminosity(L/Lo),Radius(R/Ro),Absolute magnitude(Mv),Star type,Star color,Spectral Class");
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

