public class optimizes{
  private int row;
  private int col;
  private int moves;

  public optimizes(int r, int c, int m) {
    row = r;
    col = c;
    moves = m;
  }

  public optimizes sort(optimizes a, optimizes b) {
    if (a.getMoves() > b.getMoves()) {
      return a;
    }
    else {
      return b;
    }
  }

  public int getMoves(){
    return moves;
  }

  public void setMoves(int m) {
    moves = m;
  }

  public void bubbleSort() {                                     //BubbleSort (should be swapping mutliple times when it compares across the board the entire array length)
  optimizes[] data = this;
  optimizes indexnum = data[0];
  for (int through = 0; through < data.length; through++) {
    for (int check = 0; check < data.length - through -1; check++) {
      if (data[check].getMoves() >= data[check+1].getMoves()) {
        indexnum = data[check];
        data[check].setMoves(data[check +1].getMoves());
        data[check+1] = indexnum;
      }
      //System.out.println(toString(data));                                          //Testing
    }
    //System.out.println(toString(data));                                                 //Testing
  }
}
}
