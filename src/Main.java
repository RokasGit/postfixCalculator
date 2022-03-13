import Client.Client;
import LinkedStackImpl.LinkedStack;
import VisitorImpl.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CalculatorVisitor calculatorVisitor = new CalculatorVisitor();
        LinkedStack<Token> tokenLinkedStack = new LinkedStack<>();
        Client client = new Client(calculatorVisitor,tokenLinkedStack);
        while (true){
            System.out.println("Enter  mathematical expression(only single digits will be read)");
            String readString = input.nextLine();
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

            try {
                System.out.println("Result: " + client.evaluateExpression(tokenList));

            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }



    }
}
