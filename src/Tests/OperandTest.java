package Tests;

import VisitorImpl.Operand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperandTest {
    private Operand operand;
    @BeforeEach
    void setOperand(){
        operand = new Operand(0);
    }
    @Test
    void getValue() {
        Assertions.assertEquals(0,operand.getValue());
    }
}