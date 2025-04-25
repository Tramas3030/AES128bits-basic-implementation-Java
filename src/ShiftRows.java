public class ShiftRows {

  public static byte[][] execute(byte[][] state) {
    byte[][] result = new byte[4][4];

    for (int row = 0; row < 4; row++) {
      for (int col = 0; col < 4; col++) {
        result[row][col] = state[row][(col + row) % 4];
      }
    }

    return result;
  }

}
