package CalcVar211092025;

public interface Operation {
    int calculate(int a, int b);
}

// Базовый класс для операций с общими методами
abstract class BaseOperation implements Operation {
    protected void checkOverflow(long result, String operation) {
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("переполнение при " + operation);
        }
    }
}

// Конкретные реализации операций
class Addition extends BaseOperation {
    @Override
    public int calculate(int a, int b) {
        long result = (long) a + (long) b;
        checkOverflow(result, "сложении");
        return (int) result;
    }
}

class Subtraction extends BaseOperation {
    @Override
    public int calculate(int a, int b) {
        long result = (long) a - (long) b;
        checkOverflow(result, "вычитании");
        return (int) result;
    }
}

class Multiplication extends BaseOperation {
    @Override
    public int calculate(int a, int b) {
        long result = (long) a * (long) b;
        checkOverflow(result, "умножении");
        return (int) result;
    }
}

class Division extends BaseOperation {
    @Override
    public int calculate(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("деление на ноль невозможно");
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new ArithmeticException("переполнение при делении");
        }
        return a / b;
    }
}

class Power extends BaseOperation {
    @Override
    public int calculate(int a, int b) {
        if (b < 0) {
            throw new ArithmeticException("отрицательная степень не поддерживается");
        }
        if (b == 0) return 1;
        if (b > 20) {
            throw new ArithmeticException("степень слишком велика (максимум 20)");
        }

        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
            checkOverflow(result, "возведении в степень");
        }
        return (int) result;
    }
}

class Modulus extends BaseOperation {
    @Override
    public int calculate(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("остаток от деления на ноль невозможен");
        }
        return a % b;
    }
}