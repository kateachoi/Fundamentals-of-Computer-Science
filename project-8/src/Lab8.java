import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab8 {

    // Method declarations
    public static void quickSort(ArrayList<Star> a, int left, int right){
        if (left < right) {
            int partitionIndex = partition(a, left, right);
            quickSort(a, left, partitionIndex - 1);
            quickSort(a, partitionIndex + 1, right);
        }
    }

    public static int partition (ArrayList<Star> a, int left, int right){
        Star pivot = a.get(right);
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (new StarComparator().compare(a.get(j), pivot) < 0) {
                i++;
                // swap
                Star temp = a.get(i);
                a.set(i, a.get(j));
                a.set(j, temp);
            }
        }

        // swap
        Star temp = a.get(i + 1);
        a.set(i + 1, a.get(right));
        a.set(right, temp);

        return i + 1;
    }

    public static int bubbleSort(ArrayList<Star> a, int size){
        int n = a.size();
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (new StarComparator().compare(a.get(j), a.get(j + 1)) > 0) {
                    // swap
                    Star temp = a.get(j);
                    a.set(j, a.get(j + 1));
                    a.set(j + 1, temp);
                    swaps++;
                }
            }
        }
        return swaps;
    }

    public static int transpositionSort(ArrayList<Star> a, int size){
        int n = a.size();
        int swaps = 0;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            // bubble sort on odd indexed elements
            for (int i = 1; i < n - 1; i += 2) {
                if (new StarComparator().compare(a.get(i), a.get(i + 1)) > 0) {
                    // swap
                    Star temp = a.get(i);
                    a.set(i, a.get(i + 1));
                    a.set(i + 1, temp);
                    swaps++;
                    sorted = false;
                }
            }

            // bubble sort on even indexed elements
            for (int i = 0; i < n - 1; i += 2) {
                if (new StarComparator().compare(a.get(i), a.get(i + 1)) > 0) {
                    // swap
                    Star temp = a.get(i);
                    a.set(i, a.get(i + 1));
                    a.set(i + 1, temp);
                    swaps++;
                    sorted = false;
                }
            }
        }

        return swaps;
    }

    public static void main(String[] args) {

        // read in three command-line arguments
        if (args.length != 3) {
            System.out.println("Error: java Lab8 <stars.csv> <sorting_algorithm> <number_of_lines>");
            return;
        }

        File file = new File(args[0]);
        String sortingAlgorithm = args[1];
        int n = Integer.parseInt(args[2]);
        //System.out.println(dataset);
        // create an arrayList to store the objects of Star class
        ArrayList<Star> origList = new ArrayList<Star>();   // original list

        ArrayList<Star> quickList = new ArrayList<Star>();   // list to be sorted via quick sort
        ArrayList<Star> bubbleList = new ArrayList<Star>();   // list to be sorted via bubble sort
        ArrayList<Star> transpositionList = new ArrayList<Star>();   // list to be sorted via transposition sort

        try {
            // read dataset and fill in original list
            Scanner scanner = new Scanner(file);
            scanner.nextLine(); // skip header

            while ((scanner.hasNextLine()) && n > 0) {
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
                origList.add(star);
                quickList.add(star); // create a copy for quick sort
                bubbleList.add(star); // create a copy for bubble sort
                transpositionList.add(star); // create a copy for transposition sort
                n--;
            }
            scanner.close();
            //br.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // track complexity
        int swaps = 0;
        long startTime = 0, endTime = 0;

        switch (sortingAlgorithm) {
            case "quick":
                startTime = System.currentTimeMillis();
                quickSort(quickList, 0, quickList.size() - 1);
                endTime = System.currentTimeMillis();
                break;
            case "bubble":
                startTime = System.currentTimeMillis();
                swaps = bubbleSort(bubbleList, bubbleList.size());
                endTime = System.currentTimeMillis();
                break;
            case "transposition":
                startTime = System.currentTimeMillis();
                swaps = transpositionSort(transpositionList, transpositionList.size());
                endTime = System.currentTimeMillis();
                break;
            default:
                System.out.println("Invalid sorting algorithm specified.");
                return;
        }

        // output results
        switch (sortingAlgorithm) {
            case "quick":
                System.out.println("Execution time for quick sort: " + (endTime - startTime) + " ms");
                break;
            case "bubble":
                System.out.println("Number of swaps for bubble sort: " + swaps);
                System.out.println("Execution time for bubble sort: " + (endTime - startTime) + " ms");
                break;
            case "transposition":
                System.out.println("Number of swaps for transposition sort: " + swaps);
                System.out.println("Execution time for transposition sort: " + (endTime - startTime) + " ms");
        }

    }

}
