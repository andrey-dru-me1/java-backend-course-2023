package edu.project4;


public class Main {
    public static void main(String[] args) {
        // Configuration
        int width = 800;
        int height = 800;
        int iterations = 10000;
        int numVariations = 5;

        // Example transformations (you can define your own)
        double[][] transformations = {
                {0.5, 0, 0, 0.5, 0, 0},
                {0.5, 0, 0, 0.5, 0.5, 0},
                {0.5, 0, 0, 0.5, 0.25, 0.433},
                {0.5, 0, 0, 0.5, 0.75, 0.433},
                {0.5, 0, 0, 0.5, 0.5, 0.866}
        };

        FlameFractal flameFractal = new FlameFractal(width, height, iterations, numVariations, transformations);

        long startTime = System.nanoTime();
        flameFractal.generateFractal();
        long endTime = System.nanoTime();
        System.out.println("Multi-threaded execution time: " + (endTime - startTime) + " ns");

        flameFractal.saveImage("fractal_multithreaded.png");
    }
}

