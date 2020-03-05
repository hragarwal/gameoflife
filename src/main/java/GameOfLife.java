import java.util.List;

class GameOfLife {

    private List<Rule> rules;

    GameOfLife(List<Rule> rules) {
        this.rules = rules;
    }

    Matrix nextGeneration(Matrix matrix) {
        Matrix updatedMatrix = matrix;
        for (Rule rule: rules){
            updatedMatrix = rule.apply(updatedMatrix);
        }
        return updatedMatrix;
    }
}
