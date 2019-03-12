package Midlet;

import UI.ProductAdd;
import UI.ProductView;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

public class Midlet extends MIDlet {

    public static Display display;
    public static ProductAdd productAdd;
    public static ProductView productView;

    private void init() {
        display = Display.getDisplay(this);
        productAdd = new ProductAdd("PRODUCT ADD");

    }

    public void startApp() {
        init();
        display.setCurrent(productAdd);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
