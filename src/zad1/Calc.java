/**
 *
 *  @author Balcerzak Piotr S25100
 *
 */

package zad1;


import java.math.BigDecimal;
import java.util.HashMap;

public class Calc {
    HashMap<String,Arthmetic> hMap = new HashMap<String, Arthmetic>();
    public String doCalc(String arg) {

        String[] tab=arg.split(" ");
        try {
            String operand = tab[1];

            BigDecimal number1 = new BigDecimal(tab[0]);
            BigDecimal number2 = new BigDecimal(tab[2]);


            addOperationToMap();

            Arthmetic arthmetic = hMap.get(operand);
            BigDecimal answer = arthmetic.calculate(number1, number2);

            String stringAnswer = answer.toString();
            return stringAnswer;
        }catch(Exception ex){
            String exMessage="Arguments are incorrect";
            return exMessage;
        }


    }
    private void addOperationToMap(){
        hMap.put("*", new OperationMultiply());
        hMap.put("/", new OperationDivision());
        hMap.put("+", new OperationAdd());
        hMap.put("-", new OperationSub());
    }
}  
