public class Driver {
  public static void main(String[] args) {

    KnightBoard help = new KnightBoard(5,5);
    KnightBoard helps = new KnightBoard(1,1);
    help.solve(0,0);
    System.out.println(helps.countSolutions(0,0));
    System.out.println(help);


  }
}
