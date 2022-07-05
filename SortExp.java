import java.util.Arrays;

public class SortExp {

  public static void main(String[] args) {
    // int[] a = new int[] { 2, 5, 3, 1, 7, 4 };
    String[] a = new String[] {
      "GeeksforGeeks",
      "Quiz",
      "Practice",
      "Gblogs",
      "Coding",
    };
    Sorts.bubbleSort(a);
    // Sorts.bubbleSortRecursive(a, a.length);
    // Sorts.selectionSort(a, false);
    // Sorts.selectionSort(a, true);
    // Sorts.selectionSortRecursive(a, 0);
    // Sorts.insertionSort(a, false);
    // Sorts.insertionSort(a, true);
    // Sorts.insertionSortRecursive(a, 1);
    // Sorts.mergeSort(a, 0, a.length - 1);
    System.out.println(Arrays.toString(a));
    // LinkedList list = new LinkedList();
    // list.add(2);
    // list.add(5);
    // list.add(3);
    // list.add(1);
    // list.add(7);
    // list.add(4);
    // list.print();
    // list.inertionSortLinkedlist();
    // list.print();
  }
}
