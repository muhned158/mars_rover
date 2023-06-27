package fr.bnp.rover.enums;

public enum Direction {
    NORTH('N'),
    SOUTH('S'),
    EAST('E'),
    WEST('W');

    private char value ;
    private Direction(char value){
        this.value= value;
    }
    public char getValue(){
        return this.value;
    }

}
