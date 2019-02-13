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

  private boolean placeKnight(int r, int c, int move) {
    if (board[r][c] != 0) {
      return false;
    }
    board[r][c] = move;
    return true;
  }

  private boolean removeKnight(int r, int c) {
    if (board[r][c] == 0) {
      return false;
    }
    board[r][c] = 0;
    return true;
  }
  private void moves(int r, int c, int move) {
    int rows = board.length;
    int cols = board[r].length;

    if (r+1 < rows && c+2 < cols) {
      board[r+1][c+2] = move;
    }
    if (r+1 < rows && c-2 > -1) {
      board[r+1][c-2] = move;
    }
    if (r-1 > -1 && c+2 < cols) {
      board[r-1][c+2] = move;
    }
    if (r-1 > -1 && c-2 > -1) {
      board[r-1][c-2] = move;
    }
    if (r+2 < cols && c+1 < cols) {
      board[r+2][c+1] = move;
    }
    if (r+2 < cols && c-1 > -1) {
      board[r+2][c-1] = move;
    }
    if (r-2 > -1 && c+1 < cols) {
      board[r-2][c+1] = move;
    }
    if (r-2 > -1 && c-1 > -1) {
      board[r-2][c-1] = move;
    }
  }
}
