public class Driver {
  public static void main(String[] args) {
    KnightBoard help = new KnightBoard(8,8);
    help.solve(0,0);
    System.out.println(help);
  }
}
