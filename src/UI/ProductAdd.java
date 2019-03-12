
package UI;

import Model.Product;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;


public class ProductAdd extends Form implements CommandListener{

    private TextField id,qty,name;
    private ChoiceGroup type,rate,ship;
    private TextField price;
    
    private Command save , view;
    
    
    public ProductAdd(String title) {
        super(title);
        init();
    }
    
    private void init(){
        
        id = new TextField("PID", null, 15, TextField.NUMERIC);
        name = new TextField("Name", null, 15, TextField.ANY);
        qty = new TextField("Qty", null, 15, TextField.NUMERIC);
        type = new ChoiceGroup("Type", ChoiceGroup.POPUP);
        type.append("Best", null);
        type.append("Medium", null);
        type.append("Normal", null);
        
        String [] rates = {"5","4","3"};
        rate = new ChoiceGroup("Rate", ChoiceGroup.EXCLUSIVE,rates , null);
        
        String [] shipments = {"free","postal"};
        ship =  new ChoiceGroup("Ship", ChoiceGroup.MULTIPLE, shipments,null);
        
        price = new TextField("Price", null,15, TextField.NUMERIC);
        
        save = new Command("Save",Command.OK, 1);
        view = new Command("View",Command.OK, 0);
        
        addCommand(save);
        addCommand(view);
        setCommandListener(this);
        
        append(id);
        append(name);
        append(qty);
        append(type);
        append(rate);
        append(ship);
        append(price);
    
           
        
    }

    public void commandAction(Command c, Displayable d) {
    
        if (c==save) {
            
            Product p = new Product();
            p.setId(id.getString());
            p.setName(name.getString());
            p.setQty(Integer.parseInt(qty.getString()));
            p.setRate(rate.getString(rate.getSelectedIndex()));
            p.setType(type.getString(type.getSelectedIndex()));
            p.setPrice(Double.parseDouble(price.getString()));
            
            String ships = "";
    
            for (int i = 0; i < ship.size(); i++) {
                if (ship.isSelected(i)) {   
                    ships+=ship.getString(i)+" , ";
                }
            }
        
            p.setShipping(ships);
            
            Product.setProduct_list(p);
            
            Alert alert = new Alert("SAVED!");
            Midlet.Midlet.display.setCurrent(alert);
            
            clearFileds();
            
            System.out.println(p.getId()+" product added!");
            
            
        }else if (c==view) {
            
            Midlet.Midlet.display.setCurrent(new ProductView("PRODUCT VIEW"));
        }
    }
    
    private void clearFileds(){
    
        id.setString(null);
        name.setString(null);
        qty.setString(null);
        price.setString(null);
        type.setSelectedIndex(0, true);
        rate.setSelectedIndex(0, true);
        ship.setSelectedIndex(0, true);
    }

}
