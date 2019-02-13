public class KnightBoard{

  private int[][] board;

  public KnightBoard(int startingRows,int startingCols) {
    int[][] initial = new int[startingRows][startingCols];
    for (int r = 0; r < initial.length; r++) {
      for (int c = 0; c < initial[r].length; c++) {
        initial[r][c] = 0;
      }
    }
  board = initial;
  }


}
