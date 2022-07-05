public class Utils {

  static void printDashOfLength(int len) {
    while (len > 0) {
      System.out.print("-");
      len--;
    }
    System.out.println();
  }

  static void coverStringWithDash(String s) {
    printDashOfLength(s.length());
    System.out.println(s);
    printDashOfLength(s.length());
  }
}
