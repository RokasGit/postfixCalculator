package VisitorImpl;


public class Operator extends Token {
    private Operation operation;

    public Operator(Operation operation) {
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    @Override
    public void accept(CalculatorVisitor calculatorVisitor) {
        calculatorVisitor.visit(this);
    }
}
