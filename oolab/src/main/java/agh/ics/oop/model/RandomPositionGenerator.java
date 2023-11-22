package agh.ics.oop.model;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Random;

public class RandomPositionGenerator implements Iterable<Vector2d>{
    private long seed = 12345L;
    private Random rand = new Random(seed);
    private int grassCount;
    private int maxWidth;
    private int maxHeight;
    private int[] xTab;
    private int[] yTab;
    public RandomPositionGenerator(int maxWidth, int maxHeight, int grassCount) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.grassCount = grassCount;
        xTab = new int[maxWidth];
        yTab = new int[maxHeight];
        for (int i = 0; i < maxWidth; i++) { //maxWidth równa się maxHeight w naszym zadaniu
            xTab[i] = i;
            yTab[i] = i;
        }

    }

    @NotNull
    @Override
    public Iterator<Vector2d> iterator() {
        return new CustomIterator();
    }


    public class CustomIterator implements Iterator<Vector2d>{
        private int xRand;
        private int yRand;
        private int xVal;
        private int yVal;

        @Override
        public boolean hasNext() {
            return grassCount>0;
        }

        @Override
        public Vector2d next() {
            xRand = rand.nextInt(maxWidth);
            yRand = rand.nextInt(maxHeight);
            xVal = xTab[xRand];
            yVal = yTab[yRand];
            grassCount--;
            maxHeight--;
            maxWidth--;
            xTab[xRand] = xTab[maxWidth];
            xTab[maxWidth] = xVal;
            yTab[yRand] = yTab[maxHeight];
            yTab[maxHeight] = yVal;
            return new Vector2d(xVal,yVal);
        }
    }

}