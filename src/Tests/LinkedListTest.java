package Tests;

import LinkedStackImpl.LinkedList;
import VisitorImpl.Operand;
import VisitorImpl.Operation;
import VisitorImpl.Operator;
import VisitorImpl.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList<Token> tokenLinkedList;
    @BeforeEach
    void clearList(){
        tokenLinkedList=new LinkedList<>();
    }
    @org.junit.jupiter.api.Test
    void isEmpty() {
        Assertions.assertTrue(tokenLinkedList.isEmpty());
        tokenLinkedList.addToFront(new Operand(5));
        Assertions.assertFalse(tokenLinkedList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        Assertions.assertEquals(0,tokenLinkedList.size());

    }

    @org.junit.jupiter.api.Test
    void removeFirstAndAddToFront() {
        // Testing add To Front
        tokenLinkedList.addToFront(new Operand(5));
        Assertions.assertEquals(1,tokenLinkedList.size());
        tokenLinkedList.addToFront(new Operand(6));
        Assertions.assertEquals(2,tokenLinkedList.size());
        tokenLinkedList.addToFront(new Operator(Operation.DIVISION));
        Assertions.assertEquals(3,tokenLinkedList.size());
        tokenLinkedList.addToFront(new Operand(7));
        Assertions.assertEquals(4,tokenLinkedList.size());
        // Testing remove first
        Operand removeOperand = (Operand) tokenLinkedList.removeFirst();
        Assertions.assertEquals(3,tokenLinkedList.size());
        Assertions.assertEquals(7,removeOperand.getValue());
        Operator removeOperator = (Operator) tokenLinkedList.removeFirst();
        Assertions.assertEquals(2,tokenLinkedList.size());
        Assertions.assertEquals(Operation.DIVISION,removeOperator.getOperation());
        removeOperand = (Operand) tokenLinkedList.removeFirst();
        Assertions.assertEquals(1,tokenLinkedList.size());
        Assertions.assertEquals(6,removeOperand.getValue());
        removeOperand = (Operand) tokenLinkedList.removeFirst();
        Assertions.assertEquals(0,tokenLinkedList.size());
        Assertions.assertEquals(5,removeOperand.getValue());
        Assertions.assertThrows(EmptyStackException.class,()->{
            tokenLinkedList.removeFirst();
        });


    }
}