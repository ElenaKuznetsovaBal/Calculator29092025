package CalcVar211092025;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private final Map<String, Operation> operations = new HashMap<>();

    public Calculator() {
        // Используем классы из Operation.java
        operations.put("+", new Addition());
        operations.put("-", new Subtraction());
        operations.put("*", new Multiplication());
        operations.put("/", new Division());
        operations.put("//", new Division());
        operations.put("^", new Power());
        operations.put("%", new Modulus());
    }

    public int calculate(int a, String operator, int b) {
        Operation operation = operations.get(operator);
        if (operation == null) {
            throw new IllegalArgumentException("неподдерживаемая операция: " + operator);
        }
        return operation.calculate(a, b);
    }
}

