package fr.bnp.rover.models;

import fr.bnp.rover.enums.Direction;

public class Rover {

    /**
     *  (x) coordinate of the rover
     */
    private int x;

    /**
     * (y) coordinate of the rover
     */
    private int y;

    /**
     * Direction of the rover
     */
    Direction direction;


    public Rover(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    /**
     * @return x the abscissa of the rover
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the abscissa of the rover
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * @return y the ordinate  of the rover
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the ordinate  of the rover
     */
    public void setY(int y) {
        this.y = y;
    }

    public  void incrementY(){
        y++;
    }

    public void decrementY(){
        y--;
    }

    public void incrementX(){
        x++;
    }

    public void decrementX(){
        x--;
    }
    public Direction getDirection() {
        return direction;
    }
    public String getPosition() {
        return x + " " + y + " " + direction.getValue();
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }
}
