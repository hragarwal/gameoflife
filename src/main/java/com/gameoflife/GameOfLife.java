package com.gameoflife;

import com.gameoflife.rules.Rule;

import java.util.List;

public class GameOfLife {

    private List<Rule> rules;

    public GameOfLife(List<Rule> rules) {
        this.rules = rules;
    }

    public Matrix nextGeneration(Matrix matrix) {
        Matrix updatedMatrix = matrix;
        for (Rule rule: rules){
            updatedMatrix = rule.apply(updatedMatrix);
        }
        return updatedMatrix;
    }
}
