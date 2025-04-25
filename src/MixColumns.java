public class MixColumns {

  public static byte[][] execute(byte[][] state) {
    byte[][] result = new byte[4][4];

    for(int col = 0; col < 4; col++) {
      result[0][col] = (byte) (gmul(0x02, state[0][col]) ^ gmul(0x03, state[1][col]) ^ state[2][col] ^ state[3][col]);
      result[1][col] = (byte) (state[0][col] ^ gmul(0x02, state[1][col]) ^ gmul(0x03, state[2][col]) ^ state[3][col]);
      result[2][col] = (byte) (state[0][col] ^ state[1][col] ^ gmul(0x02, state[2][col]) ^ gmul(0x03, state[3][col]));
      result[3][col] = (byte) (gmul(0x03, state[0][col]) ^ state[1][col] ^ state[2][col] ^ gmul(0x02, state[3][col]));
    }

    return result;
  }

  public static byte gmul(int multiplicand, int multiplier) {
    int product = 0;
    int mostSignificantBit;

    for(int bitPosition = 0; bitPosition < 8; bitPosition++) {
      if((multiplier & 1) != 0) {
        product ^= multiplicand;
      }

      mostSignificantBit = multiplicand & 0x80;

      multiplicand <<= 1;

      if(mostSignificantBit != 0) {
        multiplicand ^= 0x1B;
      }

      multiplier >>= 1;
    }

    return (byte) (product & 0xFF);
  }

}
