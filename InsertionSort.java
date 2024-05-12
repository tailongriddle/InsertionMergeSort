import java.util.Arrays;
import java.util.Random;

/***
 * 
 * Insertion sort class
 * 
 * @author tai
 *
 */
public class InsertionSort {


  /*
   * 
   * Random Array Generator
   * 
   */
  public static int[] randArray(int size) {

    Random rand = new Random(); // create new random

    int[] returnArray = new int[size]; // initialize return array

    for (int i = 0; i < size; i++) { // for each item in array...
      returnArray[i] = rand.nextInt(100); // set to random number
    }

    return returnArray; // return

  }

  /*
   * 
   * Insertion Sort
   * 
   */
  public static int[] Insertion(int[] array) {

    int key = array[0];
    int i = 0;


    for (int j = 1; j < array.length; j++) { // starting at the second index

      key = array[j]; // key is j
      // insert A[j] into the sorted sequence A[1.. j-1]
      i = j - 1; // i is one less than j

      if (i >= 0) {


        while (array[i] > key) {
          array[i + 1] = array[i];

          i = i - 1;

          if (i < 0) {
            break;
          }

        }
        array[i + 1] = key;

      }

    }
    return array;

  }



  /***
   * 
   * Main method to test code
   * 
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("Insertion Sort Test: ");

    int[] newArray = randArray(10);
    System.out.println(Arrays.toString(newArray));
    Insertion(newArray);
    System.out.println(Arrays.toString(newArray));


    System.out.println("Insertion Sort (unsorted): ");

    int numberOfTrials = 1000;
    long startTime = 0;

    for (int n = 1; n <= 1001; n += 100) {

      startTime = System.currentTimeMillis(); // start time

      for (int i = 0; i < numberOfTrials; i++) { // test n size 1000 times
        int[] testArray = randArray(n); // create new random array

        Insertion(testArray);
      }
      long endTime = System.currentTimeMillis(); // end time
      System.out.print(n + "  ");

      System.out.print((((endTime - startTime) / ((double) numberOfTrials))));
      System.out.print(" ");

      System.out.println((((endTime - startTime) / ((double) numberOfTrials))) / (n * n));
    }


    System.out.println("Insertion Sort (sorted): ");

    numberOfTrials = 1000;
    startTime = 0;

    for (int n = 1; n <= 10001; n += 1000) {
      int[] testArray = randArray(n); // create new random array
      Insertion(testArray); // sort array

      startTime = System.currentTimeMillis(); // start time

      for (int i = 0; i < numberOfTrials; i++) { // test n size 1000 times

        Insertion(testArray);
      }
      long endTime = System.currentTimeMillis(); // end time
      System.out.print(n + "  ");

      System.out.print((((endTime - startTime) / ((double) numberOfTrials))));
      System.out.print(" ");

      System.out.println((((endTime - startTime) / ((double) numberOfTrials))) / (n));

    }
  }

}
