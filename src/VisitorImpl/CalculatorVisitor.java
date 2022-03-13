package VisitorImpl;

import LinkedStackImpl.LinkedStack;

import java.util.EmptyStackException;

public class CalculatorVisitor implements Calculator, Visitor {
    private LinkedStack<Token> tokenStack;

    public CalculatorVisitor() {
        tokenStack = new LinkedStack<>();
    }

    private void pushOperand(Operand operand) {
        tokenStack.push(operand);
    }

    private void performOperation(Operator operator) throws IllegalStateException {
        switch (operator.getOperation()) {
            case MULTIPLICATION -> {
                try{
                    Operand multiplication = new Operand(((Operand) tokenStack.pop()).getValue() * ((Operand) tokenStack.pop()).getValue());
                    tokenStack.push(multiplication);
                }catch (EmptyStackException e){
                    throw new IllegalStateException("Missing numbers to multiply");
                }
            }
            case ADDITION -> {
                try{
                    Operand addition = new Operand(((Operand) tokenStack.pop()).getValue() + ((Operand) tokenStack.pop()).getValue());
                    tokenStack.push(addition);
                }catch (EmptyStackException e){
                    throw new IllegalStateException("Missing numbers to add");
                }
            }
            case DIVISION -> {
                try{
                    int divider = ((Operand) tokenStack.pop()).getValue();
                    if (divider == 0) {
                        throw new IllegalStateException("You can't share candies between 0 children");
                    }
                    Operand division = new Operand(((Operand) tokenStack.pop()).getValue() / divider);
                    tokenStack.push(division);
                }catch (EmptyStackException e){
                    throw new IllegalStateException("Missing numbers to divide");
                }
            }
            case SUBTRACTION -> {
                try{
                    Operand subtraction = new Operand(((Operand) tokenStack.pop()).getValue() - ((Operand) tokenStack.pop()).getValue());
                    tokenStack.push(subtraction);
                }catch (EmptyStackException e){
                    throw new IllegalStateException("Missing numbers to subtract");
                }
            }
            default -> {
                throw new IllegalStateException("Missing operators!!");
            }
        }

    }

    @Override
    public int getResult() throws IllegalStateException {
        try{
            int result = ((Operand) tokenStack.pop()).getValue();
            if(!tokenStack.isEmpty()){
                tokenStack = new LinkedStack<>();
                throw new IllegalStateException("The stack was cleared as there were numbers left or no operands.");
            }
            return result;
        }catch (Exception exception){
            throw new IllegalStateException(exception.getMessage());
        }

    }

    @Override
    public void visit(Operand operand) {
        pushOperand(operand);
    }

    @Override
    public void visit(Operator operator) {
       try{
           performOperation(operator);
       }catch (IllegalStateException exception){
           throw new IllegalStateException(exception.getMessage());
       }

    }
}
