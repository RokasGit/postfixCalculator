package VisitorImpl;

public class Operand extends Token {
    private int value;
    public Operand(int value){
        this.value=value;
    }
    public int getValue(){
        return value;
    }

    @Override
    public void accept(CalculatorVisitor calculatorVisitor) {
        calculatorVisitor.visit(this);
    }
}
