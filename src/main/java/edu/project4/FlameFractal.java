package edu.project4;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class FlameFractal {
    private final int width;
    private final int height;
    private final int iterations;
    private final int numVariations;
    private final double[][] transformations;
    private final int[] hitCounts;

    FlameFractal(int width, int height, int iterations, int numVariations, double[][] transformations) {
        this.width = width;
        this.height = height;
        this.iterations = iterations;
        this.numVariations = numVariations;
        this.transformations = transformations;
        this.hitCounts = new int[width * height];
    }

    void generateFractal() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new FractalTask(0, width * height));
    }

    private class FractalTask extends RecursiveAction {
        private static final int THRESHOLD = 10000;
        private final int start;
        private final int end;

        FractalTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= THRESHOLD) {
                processPixels(start, end);
            } else {
                int middle = start + (end - start) / 2;
                invokeAll(new FractalTask(start, middle), new FractalTask(middle, end));
            }
        }

        private void processPixels(int start, int end) {
            Random random = new Random();
            for (int i = start; i < end; i++) {
                int x = i % width;
                int y = i / width;

                double px = x / (double) width;
                double py = y / (double) height;

                for (int j = 0; j < iterations; j++) {
                    int variation = random.nextInt(numVariations);
                    double[] transformation = transformations[variation];

                    double xNew = transformation[0] * px + transformation[1] * py + transformation[4];
                    double yNew = transformation[2] * px + transformation[3] * py + transformation[5];

                    px = xNew;
                    py = yNew;

                    int pixelX = (int) (width * px);
                    int pixelY = (int) (height * py);

                    if (pixelX >= 0 && pixelX < width && pixelY >= 0 && pixelY < height) {
                        hitCounts[pixelY * width + pixelX]++;
                    }
                }
            }
        }
    }

    void saveImage(String fileName) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int maxHits = findMaxHits();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int count = hitCounts[y * width + x];
                int brightness = (int) (255.0 * count / maxHits);
                Color color = new Color(brightness, brightness, brightness);
                image.setRGB(x, y, color.getRGB());
            }
        }

        try {
            ImageIO.write(image, "png", new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int findMaxHits() {
        int maxHits = 0;
        for (int count : hitCounts) {
            if (count > maxHits) {
                maxHits = count;
            }
        }
        return maxHits;
    }
}
