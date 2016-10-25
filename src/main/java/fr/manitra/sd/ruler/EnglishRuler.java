package fr.manitra.sd.ruler;

/**
 * Created by manitra on 26/10/2016.
 */
public class EnglishRuler {

    public static void main(String[] args) {
        drawRuler(2, 4);
    }

    public static void drawRuler(int nInches, int majorInches) {
        drawLine(majorInches, 0);
        for (int j = 1; j <= nInches; j++) {
            drawInterval(majorInches - 1);
            drawLine(majorInches, j);
        }
    }

    private static void drawInterval(int centralLength) {
        if (centralLength >= 1) {
            drawInterval(centralLength - 1);
            drawLine(centralLength);
            drawInterval(centralLength - 1);
        }
    }

    /**
     * Draw a line with the given tick length with label
     * @param tickLength
     * @param tickLabel if tickLabel > 0 then draw it
     */
    private static void drawLine(int tickLength, int tickLabel) {
        for (int j = 0; j < tickLength; j++) {
            System.out.print("-");
        }
        if (tickLabel > 0) {
            System.out.print(" " + tickLabel);
        }
        System.out.print("\n");
    }

    /**
     * Draw a line with the given tick length (but no label)
     * @param tickLength
     */
    private static void drawLine(int tickLength) {
        drawLine(tickLength, -1);
    }
}
