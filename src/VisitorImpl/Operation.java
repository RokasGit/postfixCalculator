package VisitorImpl;

public enum Operation {
    MULTIPLICATION("*"),
    ADDITION("+"),
    DIVISION("/"),
    SUBTRACTION("-");
    private String operationValue;

    Operation(String operationValue) {
        this.operationValue = operationValue;
    }

    public static Operation getOperation(String operationValue) {
        switch (operationValue) {
            case "*" -> {
                return MULTIPLICATION;
            }
            case "+" -> {
                return ADDITION;
            }
            case "/" -> {
                return DIVISION;
            }
            case "-" -> {
                return SUBTRACTION;
            }
            default -> throw new IllegalStateException("It is not an operation");
        }
    }
}
