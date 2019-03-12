package UI;

import Model.Product;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;

public class ProductView extends Form implements CommandListener {

    private Command back;
   

    public ProductView(String title) {
        super(title);
        inti();
    }

    private void inti() {

        System.out.println(Product.getProduct_list().toString());
        for (int i = 0; i < Product.getProduct_list().size(); i++) {

            Product p = (Product) Product.getProduct_list().elementAt(i);
            System.out.println(p.getId() + " " + p.getName() + " is loaded");
            StringItem s = new StringItem("Product NO "+p.getId(), null);
            s.setText("\n Name - "+p.getName() + " \n QTY - " + p.getQty() + "\n Rate - " + p.getRate() + "\n Type - " + p.getType() + "\n Ship - " + p.getShipping().replace(',',' ') + "\n Price - " + p.getPrice());
            append(s);
        }
  
        back = new Command("Back", Command.BACK, 1);
        addCommand(back);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == back) {

            Midlet.Midlet.display.setCurrent(Midlet.Midlet.productAdd);
        }
    }

}
