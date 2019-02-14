public class Driver {
  public static void main(String[] args) {
    KnightBoard help = new KnightBoard(5,5);
    help.solve(0,0);
    System.out.println(help);
  }
}
