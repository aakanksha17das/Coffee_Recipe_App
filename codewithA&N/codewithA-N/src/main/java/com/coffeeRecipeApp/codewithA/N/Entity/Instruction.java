package com.coffeeRecipeApp.codewithA.N.Entity;

public class Instruction {
    int instructionId;
    String instructionText;

    public Instruction() {
    }

    public Instruction(int instructionId, String instructionText) {
        this.instructionId = instructionId;
        this.instructionText = instructionText;
    }

    public int getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(int instructionId) {
        this.instructionId = instructionId;
    }

    public String getInstructionText() {
        return instructionText;
    }

    public void setInstructionText(String instructionText) {
        this.instructionText = instructionText;
    }
}
