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
          me += "_  ";
        }
        else if (board[r][c] < 10) {
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
    if (startRow < 0 || startCol < 0 || startRow >= board.length || startCol >= board[startRow].length) {
      throw new IllegalArgumentException("out of bounds");
    }
    return solveH(startRow,startCol,1);
  }
  
  private boolean solveH(int row, int col, int move) {
    if (move > board.length * board[0].length) {
      return true;
    }
    for (int x = 0; x < board.length * board[0].length; x++) {
      if (placeKnight(row,col,move)){
        if (solveH(row+1,col+2,move+1)){
          return true;
        }
        else if (solveH(row+1,col-2,move+1)){
          return true;
        }
        else if (solveH(row-1,col+2,move+1)){
          return true;
        }
        else if (solveH(row-1,col-2,move+1)){
          return true;
        }
        else if (solveH(row+2,col+1,move+1)){
          return true;
        }
        else if (solveH(row+2,col-1,move+1)){
          return true;
        }
        else if (solveH(row-2,col+1,move+1)){
          return true;
        }
        else if (solveH(row-2,col-1,move+1)){
          return true;
        }
      }
      removeKnight(row,col);
    }
    return false;
  }

  public int countSolutions(int startRow, int startCol) {
    if (checkBoard()){
      throw new IllegalStateException("non-zero found");
    }
    if (startRow < 0 || startCol < 0 || startRow >= board.length || startCol >= board[startRow].length) {
      throw new IllegalArgumentException("out of bounds");
    }
    return countBulls(startRow,startCol,1);
  }


  private int countBulls(int row, int col, int move) {
    if (move > board.length * board[0].length) {
      return 1;
    }
    int tots = 0;
    if (placeKnight(row,col,move)){
      tots += countBulls(row+1,col+2,move+1);
      tots += countBulls(row+1,col-2,move+1);
      tots += countBulls(row-1,col+2,move+1);
      tots += countBulls(row-1,col-2,move+1);
      tots += countBulls(row-2,col+1,move+1);
      tots += countBulls(row-2,col-1,move+1);
      tots += countBulls(row+2,col+1,move+1);
      tots += countBulls(row+2,col-1,move+1);
      removeKnight(row,col);
    }
    return tots;
  }

  private boolean placeKnight(int r, int c, int move) {
    if (r >= board.length || c >= board.length || r < 0 || c < 0) {
      return false;
    }
    if (board[r][c] != 0) {
      return false;
    }
    board[r][c] = move;
    return true;
  }

  private boolean removeKnight(int r, int c) {
    if (r > board.length || c > board.length || r < 0 || c < 0) {
      return false;
    }
    if (board[r][c] == 0) {
      return false;
    }
    board[r][c] = 0;
    return true;
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
