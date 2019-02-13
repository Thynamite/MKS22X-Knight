public class KnightBoard{

  private int[][] board;

  public KnightBoard(int startingRows,int startingCols) {
    if (startingRows <= 0 || startingCols <= 0) {
      throw new IllegalArgumentException("0 or negative value for dimension");
    }
    int[][] initial = new int[startingRows][startingCols];
    for (int r = 0; r < initial.length; r++) {
      for (int c = 0; c < initial[r].length; c++) {
        initial[r][c] = 0;
      }
    }
  board = initial;
  }

  public String toString() {
    String me = "";
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        if (board[r][c] >= 10) {
          me += " " + board[r][c] + " ";
        }
        else {
          me += board[r][c] + " ";
        }
      }
      me += "\n";
    }
    return me;
  }

}
