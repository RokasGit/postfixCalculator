package Tests;

import VisitorImpl.Operation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {
    @Test
    void getOperation() {
        // this is a static method
        Assertions.assertEquals(Operation.MULTIPLICATION,Operation.getOperation("*"));
        Assertions.assertEquals(Operation.ADDITION,Operation.getOperation("+"));
        Assertions.assertEquals(Operation.DIVISION,Operation.getOperation("/"));
        Assertions.assertEquals(Operation.SUBTRACTION,Operation.getOperation("-"));
        Assertions.assertThrows(IllegalStateException.class,() ->{
            Assertions.assertEquals(Operation.DIVISION,Operation.getOperation("ANY RANDOM VALUE"));
        });
        Assertions.assertThrows(IllegalStateException.class,() ->{
            Assertions.assertEquals(Operation.DIVISION,Operation.getOperation(""));
        });
        Assertions.assertThrows(NullPointerException.class,() ->{
            Assertions.assertEquals(Operation.DIVISION,Operation.getOperation(null));
        });
        Assertions.assertThrows(IllegalStateException.class,() ->{
            Assertions.assertEquals(Operation.DIVISION,Operation.getOperation("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                    "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                    "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
        });
    }
}