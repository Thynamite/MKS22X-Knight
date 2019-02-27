public class optimize{
  private int[][] possibles;

  public optimize(int rows, int cols) {
    possibles = new int[rows][cols];
    for (int r = 0; r < possibles.length; r++) {
      for (int c = 0; c < possibles[r].length; c++) {
        possibles[r][c] = possibleMoves(r,c);
      }
    }
  }

  public int[] sortList(int row, int col){
    int[] g = {1,2,1,-2,-1,2,-1,-2,2,1,2,-1,-2,1,-2,-1};
    optimizes[] o = new optimizes[8];
    for (int x = 0; x < g.length; x+=2) {
      o[x/2] = new optimizes(g[x],g[x+1],50);
    }
    int[] n = new int[8];
    int[] r = new int[24];

    for (int x = 0; x < g.length; x+=2 ) {
      if ((row + g[x] > -1 && row + g[x] < possibles.length) && (col + g[x+1] > -1 && col + g[x+1] < possibles[0].length)) {
        o[x/2].setMoves(possibles[row][col]);
      }
    }
    bubbleSort(o);
  }

  public void update(int row, int col){
    possibles[row][col] = 50;
    int[] g = {1,2,1,-2,-1,2,-1,-2,2,1,2,-1,-2,1,-2,-1};
    for (int x = 0; x < g.length; x+=2 ) {
      if ((row + g[x] > -1 && row + g[x] < possibles.length) && (col + g[x+1] > -1 && col + g[x+1] < possibles[0].length)) {
        possibles[row+g[x]][col+g[x+1]]--;
      }
    }
  }

  private int possibleMoves(int row, int col) {
    int totalMoves = 0;
    int[] g = {1,2,1,-2,-1,2,-1,-2,2,1,2,-1,-2,1,-2,-1};
    for (int x = 0; x < g.length; x+=2 ) {
      if ((row + g[x] > -1 && row + g[x] < possibles.length) && (col + g[x+1] > -1 && col + g[x+1] < possibles[0].length)) {
        totalMoves++;
      }
    }
    return totalMoves;
  }

  public String toString(){
    String me = "";
    for (int r = 0; r < possibles.length; r++) {
      for (int c = 0; c < possibles[r].length; c++) {
        me += possibles[r][c];
        if (c == possibles.length-1) {
          me+= '\n';
        }
      }
    }
    return me;
  }
}
