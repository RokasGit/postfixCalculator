package Tests;

import LinkedStackImpl.Node;
import VisitorImpl.Operand;
import VisitorImpl.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    private Node<Token> tokenNode;
    @BeforeEach
    void createNewNode(){
        tokenNode = new Node<>(new Operand(6));
    }
    @Test
    void setData() {
        tokenNode.setData(new Operand(5));
        Assertions.assertEquals(5,((Operand)tokenNode.getData()).getValue());
    }

    @Test
    void getData() {
        Assertions.assertEquals(6,((Operand)tokenNode.getData()).getValue());
    }

    @Test
    void setNext() {
        tokenNode.setNext(new Node<>(new Operand(8)));
        Assertions.assertEquals(8,((Operand)tokenNode.getNext().getData()).getValue());
    }

    @Test
    void getNext() {
        assertNull(tokenNode.getNext());
    }
}