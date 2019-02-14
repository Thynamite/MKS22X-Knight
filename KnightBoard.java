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
        if (board[r][c] == 0) {
          me += "_ ";
        }
        else if (board[r][c] >= 10) {
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

  public boolean solve(int startRow, int startCol) {
    if (checkBoard()){
      throw new IllegalStateException("non-zero found");
    }
    if (startRow <= 0 || startCol <= 0 || startRow >= board.length || startCol >= board[startRow].length) {
      throw new IllegalArgumentException("out of bounds");
    }
    return solveH(startRow,startCol,1);
  }

  private boolean solveH(int row, int col, int move) {
    if (move >= board.length * board[row].length) {
      return true;
    }
    int rows = board.length;
    int cols = board[row].length;
    for (int r = 0; r < board.length; r++) { //this is bad
      if (placeKnight(r,col,move)){
        if (solveH(row+1,col+2,move+1)){
          return true;
        }
        if (solveH(row+1,col-2,move+1)){
          return true;
        }
        if (solveH(row-1,col+2,move+1)){
          return true;
        }
        if (solveH(row-1,col-2,move+1)){
          return true;
        }
        if (solveH(row+2,col+1,move+1)){
          return true;
        }
        if (solveH(row+2,col-1,move+1)){
          return true;
        }
        if (solveH(row-2,col+1,move+1)){
          return true;
        }
        if (solveH(row-2,col-1,move+1)){
          return true;
        }
        removeKnight(r,col);
      }
    }
    return false;
  }
  private boolean placeKnight(int r, int c, int move) {
    if (r > board.length || c > board.length || r < -1 || c < -1) {
      return false;
    }
    if (board[r][c] != 0) {
      return false;
    }
    board[r][c] = move;
    return true;
  }

  private boolean removeKnight(int r, int c) {
    if (r > board.length || c > board.length || r < -1 || c < -1) {
      return false;
    }
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

  private boolean checkBoard(){
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board.length; c++) {
        if (board[r][c] != 0) {
          return true;
        }
      }
    }
    return false;
  }
}
