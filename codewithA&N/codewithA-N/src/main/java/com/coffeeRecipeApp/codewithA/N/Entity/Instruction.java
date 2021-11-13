package com.coffeeRecipeApp.codewithA.N.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Instruction {

    @Id
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
