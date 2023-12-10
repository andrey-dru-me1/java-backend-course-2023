//package edu.project4;
//
//import java.util.List;
//import java.util.concurrent.ThreadLocalRandom;
//
//public class MultithreadedRenderer implements Renderer {
//
//    private Point rotate(Point p, double angle) {
//        return new Point(p.x() * Math.cos(angle) - p.y() * Math.sin(angle),
//                         p.x() * Math.sin(angle) + p.y() * Math.cos(angle));
//    }
//
//    private Pixel map_range(Rect world, Point pwr, FractalImage canvas) {
//        double xMapped = (pwr.x() - world.x()) / world.width() * canvas.width();
//        double yMapped = (pwr.y() - world.y()) / world.height() * canvas.height();
//
//        int xPixel = (int) Math.floor(xMapped);
//        int yPixel = (int) Math.floor(yMapped);
//
//        // Проверка, чтобы не выйти за границы изображения
//        if (canvas.contains(xPixel, yPixel)) {
//            return canvas.pixel(xPixel, yPixel); // Возвращаем соответствующий пиксель на изображении
//        } else {
//            return null; // Точка за пределами изображения
//        }
//    }
//
//    @Override
//    public FractalImage render(FractalImage canvas, Rect world, List<Transformation> variations, int samples,
//                               short iterPerSample, long seed) {
//        for (int num = 0; num < samples; ++num) {
//            Point pw = new Point(ThreadLocalRandom.current().nextDouble(world.width()) + world.x(),
//                                 ThreadLocalRandom.current().nextDouble(world.height()) + world.y());
//
//            for (short step = 0; step < iterPerSample; ++step) {
//                Transformation variation = variations.get(ThreadLocalRandom.current().nextInt(variations.size()));
//
//                pw = variation.apply(pw);
//
//                double theta2 = 0.0;
//                int symmetry = 6;
//                for (int s = 0; s < symmetry; theta2 += Math.PI * 2 / symmetry, ++s) {
//                    var pwr = rotate(pw, theta2);
//                    if (!world.contains(pwr)) {
//                        continue;
//                    }
//
//                    Pixel pixel = map_range(world, pwr, canvas);
//                    if (pixel == null) {
//                        continue;
//                    }
//
//                    // 1. делаем лок на время работы с пикселем
//                    // 2. подмешиваем цвет и увеличиваем hit count
//                    synchronized (pixel) {
//
//                    }
//                }
//            }
//        }
//    }
//
//}
