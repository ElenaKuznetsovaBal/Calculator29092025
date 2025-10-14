package CalcVar211092025;

import java.util.HashMap;
import java.util.Map;

public class Calculator implements IOperationFactory {
    private final Map<String, IOperation> operations = new HashMap<>();

    public Calculator() {
        // Регистрация всех операций
        registerOperation("+", new Addition());
        registerOperation("-", new Subtraction());
        registerOperation("*", new Multiplication());
        registerOperation("/", new Division());
        registerOperation("//", new Division()); // Используем то же деление (LSP)
        registerOperation("^", new Power());
        registerOperation("%", new Modulus());
    }

    private void registerOperation(String operator, IOperation operation) {
        operations.put(operator, operation);
    }

    @Override
    public IOperation createOperation(String operator) {
        IOperation operation = operations.get(operator);
        if (operation == null) {
            throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);
        }
        return operation;
    }

    // Публичные методы для обратной совместимости
    public int sum(int a, int b) { return createOperation("+").execute(a, b); }
    public int sub(int a, int b) { return createOperation("-").execute(a, b); }
    public int multiply(int a, int b) { return createOperation("*").execute(a, b); }
    public int div(int a, int b) { return createOperation("/").execute(a, b); }
    public int integdiv(int a, int b) { return createOperation("//").execute(a, b); }
    public int power(int a, int b) { return createOperation("^").execute(a, b); }
    public int modulus(int a, int b) { return createOperation("%").execute(a, b); }
}
/*public class Calculator {

    // Публичные методы для обратной совместимости
    public int sum(int a, int b) {
        return createOperation("+", a, b).execute();
    }

    public int sub(int a, int b) {
        return createOperation("-", a, b).execute();
    }

    public int multiply(int a, int b) {
        return createOperation("*", a, b).execute();
    }

    public int div(int a, int b) {
        return createOperation("/", a, b).execute();
    }

    public int integdiv(int a, int b) {
        return createOperation("//", a, b).execute();
    }

    public int power(int a, int b) {
        return createOperation("^", a, b).execute();
    }

    public int modulus(int a, int b) {
        return createOperation("%", a, b).execute();
    }

    // Приватный метод создания операций (инкапсуляция)
    private Operation createOperation(String operator, int a, int b) {
        switch (operator) {
            case "+": return new Addition(a, b);
            case "-": return new Subtraction(a, b);
            case "*": return new Multiplication(a, b);
            case "/": return new Division(a, b);
            case "//": return new IntegerDivision(a, b);
            case "^": return new Power(a, b);
            case "%": return new Modulus(a, b);
            default: throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);
        }
    }
}*/

