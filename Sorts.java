import java.util.Arrays;

/**
 * All Sort Algos
 */
public class Sorts {

  static void swap(int i, int j, int[] arr) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  static void swap(int i, int j, String[] arr) {
    String temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  //bubbleSort for array for integers
  //push largest to the last index in every interation
  //loop till the index after which array is already sorted
  static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      boolean isSorted = true;
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(j, j + 1, arr);
          isSorted = false;
        }
      }

      if (isSorted) return;
    }
  }

  //bubbleSort for array of Strings
  static void bubbleSort(String[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      boolean isSorted = true;
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j].compareTo(arr[j + 1]) > 0) {
          swap(j, j + 1, arr);
          isSorted = false;
        }
      }

      if (isSorted) return;
    }
  }

  static void bubbleSortRecursive(int[] arr, int endPos) {
    if (endPos == 1) return;

    boolean isAlreadySorted = true;
    for (int i = 0; i < endPos - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        swap(i, i + 1, arr);
        isAlreadySorted = false;
      }
    }
    if (isAlreadySorted) return;
    bubbleSortRecursive(arr, endPos - 1);
  }

  static void selectionSort(int[] arr, boolean isStable) {
    for (int i = 0; i < arr.length; i++) {
      int min_index = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[min_index]) {
          min_index = j;
        }
      }

      if (i != min_index) {
        //unstable
        if (!isStable) swap(i, min_index, arr); else {
          //stable
          int key = arr[min_index];
          while (min_index > i) {
            arr[min_index] = arr[min_index - 1];
            min_index--;
          }
          arr[i] = key;
        }
      }
    }
  }

  static void selectionSortRecursive(int[] arr, int startPos) {
    if (startPos == arr.length - 1) return;
    int min_i = startPos;
    for (int i = startPos + 1; i < arr.length; i++) {
      if (arr[min_i] > arr[i]) {
        min_i = i;
      }
    }
    if (min_i != startPos) swap(min_i, startPos, arr);
    selectionSortRecursive(arr, startPos + 1);
  }

  static int findPosBinary(int[] arr, int key, int start, int end) {
    while (start <= end) {
      int mid = (int) Math.floor((start + end) / 2);
      System.out.println(start + " " + mid + " " + end + " " + key);
      if (arr[mid] == key) {
        return mid + 1;
      } else if (arr[mid] < key) {
        start = mid + 1;
      } else if (arr[mid] > key) {
        end = mid - 1;
      }
    }
    return start;
  }

  static void insertionSort(int[] arr, boolean isToDoBinarySearch) {
    for (int i = 1; i < arr.length; i++) {
      int key = arr[i];
      int j = i;
      if (isToDoBinarySearch) {
        int pos = findPosBinary(arr, key, 0, i - 1);
        while (j > pos) {
          arr[j] = arr[j - 1];
          j--;
        }
      } else {
        while (j > 0 && key < arr[j - 1]) {
          arr[j] = arr[j - 1];
          j--;
        }
      }

      arr[j] = key;
    }
  }

  static void insertionSortRecursive(int[] arr, int endPos) {
    //if array reached end
    if (endPos == arr.length) return;
    //key element for comparision and preserve it when it's position get overwritten when swapping
    int key = arr[endPos];
    //i for iterating over the sorted subarray
    int i = endPos;
    //finding current position for the key element in the sorted array and shifting other elements
    while (i > 0 && key < arr[i - 1]) {
      arr[i] = arr[i - 1];
      i--;
    }
    //assign value of key to the current position
    arr[i] = key;
    // System.out.println(Arrays.toString(arr));
    //repeat for other elements
    insertionSortRecursive(arr, endPos + 1);
  }

  static void merge(int[] arr, int start, int end, int mid) {
    int n1 = mid - start + 1;
    int n2 = end - mid;
    int[] first = new int[n1];
    int[] second = new int[n2];

    for (int i = 0; i < n1; i++) {
      first[i] = arr[start + i];
    }

    for (int i = 0; i < n2; i++) {
      second[i] = arr[i + mid + 1];
    }

    System.out.println(Arrays.toString(first) + " " + Arrays.toString(second));

    int i = 0, j = 0, k = start;
    while (i < n1 && j < n2) {
      if (first[i] <= second[j]) {
        arr[k] = first[i];
        i++;
      } else {
        arr[k] = second[j];
        j++;
      }
      k++;
    }
    while (i < n1) {
      arr[k] = first[i];
      k++;
      i++;
    }

    while (j < n2) {
      arr[k] = second[j];
      k++;
      j++;
    }
  }

  static void mergeSort(int[] arr, int start, int end) {
    if (start >= end) return;

    int mid = (int) Math.floor((start + end) / 2);

    mergeSort(arr, start, mid);
    mergeSort(arr, mid + 1, end);
    //start0 end1 mid0

    merge(arr, start, end, mid);
  }
}
