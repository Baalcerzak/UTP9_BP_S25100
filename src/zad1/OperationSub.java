package zad1;

import java.math.BigDecimal;

public class OperationSub implements Arthmetic {


    @Override
    public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
        return number1.subtract(number2);
    }
}
