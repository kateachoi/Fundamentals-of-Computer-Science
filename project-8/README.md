# Main Topics
- Read from a text file of a simple dataset
- Develop three sorting algorithms, bubble sort, quick sort and odd-even transposition sort for an array of objects
- Analyze the performance of the sorting algorithms in terms of the number of swaps and time
- Compare the performances of a serial vs. parallel sorting algorithm

# Task
In this project, you will have to find your own data set from an online repository such as https://www.kaggle.com/. The data set you choose has only three requirements: 1) it must be in a text file in CSV format, 2) it must have between 100 and 100,000 entries, and 3) it must be meaningful in some way to you. You will create a class for the data in your dataset. You will read from the dataset and fill an ArrayList with the dataset objects then you will develop 3 sorting algorithms for this ArrayList.

**Requirement 1 has been developed in previous projects.**

**Requirement 2**: I have provided you with some meaningful starter code. Your tasks regarding the quick sort are to:/
  1. Write a partition method using the specified signature.
  2. Write a recursive quickSort method using the specified signature.

**Requirement 3**: Implement the bubble and odd-even transposition sort algorithms for the same ArrayList.

**Requirement 4**: After making sure your algorithms are working properly, run bubbleSort and transpositionSort on different data points of size 1k, 10K, 20K,30K,....100K and collect the number of swaps for the data points in an external text file. In the case of the transpositionSort algorithm, all swaps that could occur in independently must be counted only once. Use the text file to plot the graphs for both algorithms such that one axis represents the data size and the other axis represents the number of swaps. If your command line argument was for bubble sort, you will output the number of swaps and execution time; if it was for transposition sort, you will only output the number of swaps.; if it was for quick sort, you will only output the execution time.

**Requirement 5**: After making sure your algorithms are working properly, run quickSort and transpositionSort on different data points of size 1k, 10K, 20K,30K,....100K and collect the execution time for the data points in an external text file. Use the text file to plot the graphs for both algorithms such that one axis represents the data size and the other axis represents the execution time.
