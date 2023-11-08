/**
 *
 *  @author Balcerzak Piotr S25100
 *
 */

package zad2;


import java.beans.*;
import java.io.Serializable;

public class Purchase{
    private PropertyChangeSupport chg = new PropertyChangeSupport(this);
    private VetoableChangeSupport veto = new VetoableChangeSupport(this);
    private String prod;
    private String data;
    private double price;
    private final int limit = 1000;

    public Purchase(String prod, String data, double price) {
        this.prod = prod;
        this.data = data;
        this.price = price;
    }

    public synchronized void setData(String data) {
        String dataOld = this.data;
        this.data = data;
        String dataNew = data;

        chg.firePropertyChange("data",dataOld, dataNew);
    }

    public synchronized void setPrice(double price) throws PropertyVetoException {
        double priceOld = this.price;
        double priceNew = price;
        veto.fireVetoableChange("price",priceOld,priceNew);
        this.price = price;
        chg.firePropertyChange("price",priceOld, priceNew);
    }

    public synchronized void addPropertyChangeListener() {
        chg.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String id=evt.getPropertyName();
                String newVal = evt.getNewValue().toString();
                String oldVal= evt.getOldValue().toString();

                String mess="Change value of: "+ id +" from: "+oldVal+" to: "+newVal;
                System.out.println(mess);
            }
        });
    }
    public synchronized void addVetoableChangeListener() {
        veto.addVetoableChangeListener(new VetoableChangeListener() {
            @Override
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                String id=evt.getPropertyName();
                Double oldVal= (Double) evt.getOldValue(),
                        newVal= (Double) evt.getNewValue();

                String mess=id+"Change to: "+ newVal +" not allowed";

                if(newVal<limit)
                    throw new PropertyVetoException(mess, null);
            }
        });
    }

    @Override
    public String toString() {
        return "Purchase [prod=" + prod + ", data=" + data + ", price=" + price +"]";
    }
}
