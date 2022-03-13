package Client;

import LinkedStackImpl.LinkedStack;
import VisitorImpl.CalculatorVisitor;
import VisitorImpl.Token;

import java.util.ArrayList;

public class Client {
    private CalculatorVisitor visitor;
    private LinkedStack<Token> tokenStack;
    public Client(CalculatorVisitor visitor,LinkedStack<Token> tokenStack){
        this.visitor=visitor;
        this.tokenStack=tokenStack;
    }
    public int evaluateExpression(ArrayList<Token> tokenList){
        for(int i=0;i<tokenList.size();i++)
        {
            tokenList.get(i).accept(visitor);
        }
        return visitor.getResult();
    }
}
