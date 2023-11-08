package zad1;

import java.math.BigDecimal;
import java.math.MathContext;

public class OperationDivision implements Arthmetic {

    @Override
    public BigDecimal calculate(BigDecimal number1, BigDecimal number2){

        return number1.divide(number2,MathContext.DECIMAL32);
    }
}
