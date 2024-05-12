import java.util.Random;



public class MergeSort {
  public static int[] randArray(int size) {

    Random rand = new Random();

    int[] returnArray = new int[size];

    for (int i = 0; i < size; i++) {
      returnArray[i] = rand.nextInt(100);
    }

    return returnArray;


  }


/***
 * 
 * 
 * Merge sort helper method
 * 
 * 
 * @param originalArray
 * @param lowestIndex
 * @param half
 * @param highestIndex
 */
  public static void Merge(int[] originalArray, int lowestIndex, int half, int highestIndex) {
    int i;
    int j;
    int n1 = half - lowestIndex + 1; // create length of left array
    int n2 = highestIndex - half; // create length of right array

    int[] arrayLeft = new int[n1]; // create left array
    int[] arrayRight = new int[n2]; // create right array
    for (i = 0; i < n1; i++) {
      arrayLeft[i] = originalArray[lowestIndex + i]; // fill left array
    }
 //   System.out.print("Left array: ");

  //  System.out.println(Arrays.toString(arrayLeft));


    for (j = 0; j < n2; j++) {
      arrayRight[j] = originalArray[half + j + 1]; // fill right array
    }


   // System.out.print("Right array: ");

  //  System.out.println(Arrays.toString(arrayRight));


    i = 0;
    j = 0;

    for (int k = lowestIndex; k < highestIndex; k++) {
      if (arrayLeft[i] <= arrayRight[j]) {
        originalArray[k] = arrayLeft[i];
     //   System.out.println("Modified Original Array: " + Arrays.toString(originalArray));
        i++;

        if (i == arrayLeft.length) {

          for (int g = k + 1; 0 < arrayRight.length - j; g++) {

              originalArray[g] = arrayRight[j];
            //  System.out.println("/Modified Original Array: " + Arrays.toString(originalArray));
              j++;
          }

          break;
        }

      } else {
        originalArray[k] = arrayRight[j];
       // System.out.println("Modified Original Array: " + Arrays.toString(originalArray));

        j++;

        if (j == arrayRight.length) {
          
          for (int g = k + 1; 0 < arrayLeft.length - i; g++) {
              originalArray[g] = arrayLeft[i];
            //  System.out.println("/Modified Original Array: " + Arrays.toString(originalArray));
              i++;
          }

          break;
        }
      }
    }

  }

/***
 * 
 * 
 * Merge sort method
 * 
 * @param originalArray
 * @param lowestIndex
 * @param highestIndex
 * @return
 */
  public static int[] mSort(int[] originalArray, int lowestIndex, int highestIndex) {
    int half;


    half = (lowestIndex + highestIndex) / 2;



    if (lowestIndex < highestIndex) {

      mSort(originalArray, lowestIndex, half);
      mSort(originalArray, half + 1, highestIndex);

      Merge(originalArray, lowestIndex, half, highestIndex);





    }



    return originalArray;



  }

  /***
   * 
   * Main Method
   * 
   * @param args
   */
  public static void main(String[] args) {
 

    System.out.println("Merge Sort (unsorted): ");

    int numberOfTrials = 1000;
    long startTime = 0;

    for (int n = 1000; n <= 10000; n += 1000) {

      startTime = System.currentTimeMillis(); // start time

      for (int i = 0; i < numberOfTrials; i++) { // test n size 1000 times
        int[] testArray = randArray(n); // create new random array

        mSort(testArray, 0, n - 1);
      }
      long endTime = System.currentTimeMillis(); // end time
      System.out.print(n + "  ");

      System.out.print((((endTime - startTime) / ((double) numberOfTrials))));
      
      System.out.print(" ");

      System.out.println((((endTime - startTime) / ((double) numberOfTrials))) / (n*(Math.log(n))));
    }
    
    System.out.println("Merge Sort (sorted): ");



    for (int n = 1000; n <= 10000; n += 1000) {
      int[] testArray = randArray(n); // create new random array

      mSort(testArray, 0, n - 1);

      startTime = System.currentTimeMillis(); // start time

      for (int i = 0; i < numberOfTrials; i++) { // test n size 1000 times
               mSort(testArray, 0, n - 1);
      }
      long endTime = System.currentTimeMillis(); // end time
      System.out.print(n + "  ");

      System.out.print((((endTime - startTime) / ((double) numberOfTrials))));
      
      System.out.print(" ");

      System.out.println((((endTime - startTime) / ((double) numberOfTrials))) / (n*(Math.log(n))));
    }





  }

}
