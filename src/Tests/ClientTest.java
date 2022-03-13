package Tests;

import Client.Client;
import LinkedStackImpl.LinkedStack;
import VisitorImpl.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    private Client client;
    private String readString;
    @BeforeEach
    void createClient(){
        client = new Client(new CalculatorVisitor(),new LinkedStack<Token>());
    }
    private ArrayList<Token> separateExpression(String readString) {
        char[] array = readString.toCharArray();
        ArrayList<Token> tokenList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            String stringLetter = "" + array[i];
            try {
                tokenList.add(new Operand(Integer.parseInt(stringLetter)));
            } catch (Exception e) {
                tokenList.add(new Operator(Operation.getOperation(stringLetter)));
            }
        }
       return tokenList;
    }
    @Test
    void zero() {
        readString = "00*";
        Assertions.assertEquals(0,client.evaluateExpression(separateExpression(readString)));
        readString = "00+";
        Assertions.assertEquals(0,client.evaluateExpression(separateExpression(readString)));
        readString="00-";
        Assertions.assertEquals(0,client.evaluateExpression(separateExpression(readString)));
    }



    @Test
    void One(){
        readString="11*";
        Assertions.assertEquals(1,client.evaluateExpression(separateExpression(readString)));
        readString="11+";
        Assertions.assertEquals(2,client.evaluateExpression(separateExpression(readString)));
        readString="11-";
        Assertions.assertEquals(0,client.evaluateExpression(separateExpression(readString)));
        readString="11/";
        Assertions.assertEquals(1,client.evaluateExpression(separateExpression(readString)));
    }
    @Test
    void Many(){
        readString="29*99++";
        Assertions.assertEquals(36,client.evaluateExpression(separateExpression(readString)));
        readString="27*99+-";
        Assertions.assertEquals(4,client.evaluateExpression(separateExpression(readString)));
        readString="99*99*/";
        Assertions.assertEquals(1,client.evaluateExpression(separateExpression(readString)));

    }
    @Test
    void boundary(){
        // has no boundaries

    }
    @Test
    void Exception(){
        // not postfix
        readString="9*9";
        Assertions.assertThrows(IllegalStateException.class,()->{
            client.evaluateExpression(separateExpression(readString));
        });
        // not postfix
        readString="9-9";
        Assertions.assertThrows(IllegalStateException.class,()->{
            client.evaluateExpression(separateExpression(readString));
        });
        // no operators
        readString="999999";
        Assertions.assertThrows(IllegalStateException.class,()->{
            client.evaluateExpression(separateExpression(readString));
        });
        // starts by operator and too many operators
        readString="*99996*";
        Assertions.assertThrows(IllegalStateException.class,()->{
            client.evaluateExpression(separateExpression(readString));
        });
        // accepts single digits only
        readString="6514194195111*3516513516**";
        Assertions.assertThrows(IllegalStateException.class,()->{
            client.evaluateExpression(separateExpression(readString));
        });
        // no parentheses input is accepted.
        readString="99(55(+";
        Assertions.assertThrows(IllegalStateException.class,()->{
            client.evaluateExpression(separateExpression(readString));
        });
    }
}