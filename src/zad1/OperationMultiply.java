package zad1;


import java.math.BigDecimal;

public class OperationMultiply implements Arthmetic {

    @Override
    public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
        return number1.multiply(number2);
    }
}
