/**
 *
 *  @author Balcerzak Piotr S25100
 *
 */

package zad2;


import java.beans.PropertyVetoException;

public class Main {
  public static void main(String[] args) {

    Purchase purch = new Purchase("komputer", "nie ma promocji", 3000.00);
    System.out.println(purch);

    // --- tu należy dodać odpowiedni kod
    purch.addPropertyChangeListener();
    purch.addVetoableChangeListener();
    // ----------------------------------

    try {
      purch.setData("w promocji");
      purch.setPrice(2000.00);
      System.out.println(purch);

      purch.setPrice(500.00);

    } catch (PropertyVetoException exc) {
      System.out.println(exc.getMessage());
    }
    System.out.println(purch);
  }
}
