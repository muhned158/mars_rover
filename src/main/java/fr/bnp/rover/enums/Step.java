package fr.bnp.rover.enums;

public enum Step {
    /**
     * L : left
     * R: Right
     * M: Move
     */
    LEFT('L'), RIGHT('R'), MOVE('M');

    private char value;
    private Step(char value){
        this.value= value;
    }
    public char getValue(){
        return this.value;
    }
}
