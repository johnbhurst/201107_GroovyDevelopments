import java.util.Date;

public class QueensJava {

  static class Board {
    int size;
    private int[] pos;
    private boolean[] col;
    private boolean[] diag1;
    private boolean[] diag2;

    public Board(int size) {
      this.size = size;
      this.pos = new int[size];
      for (int i = 0; i < size; i++) {
        pos[i] = -1;
      }
      this.col = new boolean[size];
      this.diag1 = new boolean[2 * size + 1];
      this.diag2 = new boolean[2 * size + 1];
    }

    void place(int row, int col) {
      pos[row] = col;
      this.col[col] = true;
      diag1[col - row + size] = true;
      diag2[col + row] = true;
    }

    int unplace(int row) {
      int col = pos[row];
      pos[row] = -1;
      this.col[col] = false;
      diag1[col - row + size] = false;
      diag2[col + row] = false;
      return col;
    }

    boolean isOk(int row, int col) {
      return !(this.col[col] || diag1[col - row + size] || diag2[col + row]);
    }

    boolean solve() {
      int row = 0;
      int col = 0;
      while (row >= 0 && row < size) {
        while (col < size && !isOk(row, col)) {
          col++;
        }
        if (col < size) {
          place(row, col);
          row++;
          col = 0;
        }
        else {
          row--;
          if (row >= 0) {
            col = unplace(row) + 1;
          }
        }
      }
      return row == size;
    }

    int getCol(int row) {
      return pos[row];
    }
  }

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("I need a number.");
      System.exit(-1);
    }
    int size = Integer.parseInt(args[0]);
    Board b = new Board(size);
    long start = new Date().getTime();
    if (b.solve()) {
      long elapsed = new Date().getTime() - start;
      for (int i = 0; i < size; i++) {
        int col = b.getCol(i);
        for (int j = 0; j < col; j++) {
          System.out.print(" ");
        }
        System.out.println("*");
      }
      System.out.println("" + elapsed + " milliseconds.");
    }
  }

}

