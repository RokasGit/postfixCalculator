package Tests;

import VisitorImpl.Operation;
import VisitorImpl.Operator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    private Operator operator;
    @BeforeEach
    void createOperator(){
        operator = new Operator(Operation.DIVISION);
    }

    @Test
    void getOperation() {
        Assertions.assertEquals(Operation.DIVISION,operator.getOperation());
    }
}