package fr.bnp.rover.models;

/**
 *
 */
public class Plateau {
    /**
     *  (x) coordinate of the plateau
     */
    private int x;

    /**
     * (y) coordinate of the plateau
     */
    private int y;

    public Plateau(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return x the abscissa of the plateau
     */
    public int getX() {
        return x;
    }

    /**
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return y the ordinate  of the plateau
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the ordinate  of the plateau
     */
    public void setY(int y) {
        this.y = y;
    }

}
