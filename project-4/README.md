# Main Topics
- Read from a text file of a dataset
- Class and objects, arrays, file input/output, input validation with Exceptions, and output with classes.
- Sort ArrayLists
- Program development and management with IntelliJ and Git

# Task
In this lab, you will have to find your own data set from an online repository such as https://www.kaggle.com/ or http://archive.ics.uci.edu/ml/index.php. The data set you choose has only three requirements: 1) it must be in a text file in CSV format, 2) it must have between 100 and 100,000 entries, and 3) it must be meaningful in some way to you. You will create a class for the data in your dataset. You will read from the dataset and fill an ArrayList with objects of your custom class then you will develop a sorting algorithm to sort those objects in an output text file.

1. Download your own dataset.

2. Create a well written class to store each record from your dataset. The members of this class must include all attributes in your dataset. This class must contain the following methods beside the default, parametrized, and copy constructors:

    @Override\
    String toString();

The method toString() returns a String version of the information stored in the class.

3. Create one arrayList to store the objects of your class.

4. Read each row in your dataset and store it in an object of your customized class type and then add it to the arrayList.

5. Implement comparator interface in another customized class to compare 2 objects based on a numerical attribute.

6. Using your developed comparator class, create a method called Sort as follows:
- The parameters to this method includes the arrayList of your dataset and the size n.
- The sorting algorithm you will implement works by repeatedly stepping through the list, comparing adjacent elements and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted.

7. Write a Swap method and use it in your sort method.

8. Print out the content of the arrayList after sorting into a text file called "sortedDataset.txt" using toString method.

9. Measure the time (use System.currentTimeMillis()) that it takes to run Sort for different values of N (try large numbers), the number of entries in your list being sorted.

10. Using a graphing software, plot the execution time vs. N.
