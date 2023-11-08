package zad1;

import java.math.BigDecimal;

public class OperationAdd implements Arthmetic {

    @Override
    public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
        return number1.add(number2);
    }
}
