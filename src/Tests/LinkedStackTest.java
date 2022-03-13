package Tests;

import LinkedStackImpl.LinkedList;
import LinkedStackImpl.LinkedStack;
import VisitorImpl.Operand;
import VisitorImpl.Operation;
import VisitorImpl.Operator;
import VisitorImpl.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {
    private LinkedStack<Token> tokenStack;
    @BeforeEach
    void clearList(){
        tokenStack=new LinkedStack<>();
    }
    @Test
    void isEmpty() {
        Assertions.assertTrue(tokenStack.isEmpty());
        tokenStack.push(new Operand(5));
        Assertions.assertFalse(tokenStack.isEmpty());
    }

    @Test
    void pushAndPop() {
        tokenStack.push(new Operand(5));
        Assertions.assertEquals(1,tokenStack.getSize());
        tokenStack.push(new Operand(6));
        Assertions.assertEquals(2,tokenStack.getSize());
        tokenStack.push(new Operator(Operation.DIVISION));
        Assertions.assertEquals(3,tokenStack.getSize());
        tokenStack.push(new Operand(7));
        Assertions.assertEquals(4,tokenStack.getSize());
        // Testing remove first
        Operand removeOperand = (Operand) tokenStack.pop();
        Assertions.assertEquals(3,tokenStack.getSize());
        Assertions.assertEquals(7,removeOperand.getValue());
        Operator removeOperator = (Operator) tokenStack.pop();
        Assertions.assertEquals(2,tokenStack.getSize());
        Assertions.assertEquals(Operation.DIVISION,removeOperator.getOperation());
        removeOperand = (Operand) tokenStack.pop();
        Assertions.assertEquals(1,tokenStack.getSize());
        Assertions.assertEquals(6,removeOperand.getValue());
        removeOperand = (Operand) tokenStack.pop();
        Assertions.assertEquals(0,tokenStack.getSize());
        Assertions.assertEquals(5,removeOperand.getValue());
        Assertions.assertThrows(EmptyStackException.class,()->{
            tokenStack.pop();
        });
    }

    @Test
    void getSize() {
        Assertions.assertEquals(0,tokenStack.getSize());
    }
}