package edu.hw1;

public class Task8 {

    private static final int FIELD_SIZE = 8;

    private final byte[][] field;

    private Task8(byte[][] field) {
        this.field = field;
    }

    public static boolean knightBoardCapture(byte[][] field) {
        return !new Task8(field).checkHits();
    }

    private boolean liesInConstraints(int x, int y) {
        return x >= 0 && x < FIELD_SIZE && y >= 0 && y < FIELD_SIZE;
    }

    @SuppressWarnings("magicnumber")
    private boolean doesHitSomeone(int x, int y) {
        for (int i = -2; i <= 2; i++) {
            if (i == 0) {
                continue;
            }
            for (int j : new int[] {2 / i, -2 / i}) {
                if (liesInConstraints(x + i, y + j) && field[x + i][y + j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks all the knights either if any hit another or not.
     *
     * @return `true` if some knight hits another knight and `false` otherwise
     */
    private boolean checkHits() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (field[i][j] == 1 && doesHitSomeone(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
