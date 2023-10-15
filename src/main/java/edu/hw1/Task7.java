package edu.hw1;

public class Task7 {
    private static int calculateBinaryRadix(int n) {
        int i;
        for (i = 0; n != 0; i++) {
            n >>= 1;
        }
        return i;
    }

    public static int rotateLeft(int n, int shift) {
        if (shift < 0) {
            return rotateRight(n, -shift);
        }
        int bitCount = calculateBinaryRadix(n);
        if (bitCount == 0) {
            return 0;
        }
        shift %= bitCount;
        int shiftMask = ((1 << shift) - 1) << (bitCount - shift);
        int numberMask = (1 << bitCount) - 1;
        int res = (n << shift) | ((n & shiftMask) >> (bitCount - shift));
        return res & numberMask;
    }

    public static int rotateRight(int n, int shift) {
        if (shift < 0) {
            return rotateLeft(n, -shift);
        }
        int bitCount = calculateBinaryRadix(n);
        if (bitCount == 0) {
            return 0;
        }
        shift %= bitCount;
        int shiftMask = (1 << shift) - 1;
        return (n >> shift) | ((n & shiftMask) << (bitCount - shift));
    }
}
