import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;
/**
 * mking some sliders and responding to mouse events
 *
 * @author (Rayha)
 * @version (a version number or a date)
 */
public class MyGUI
{
    // instance variables - replace the example below with your own
    private double speed;
    
    //fields to remember pressed position
    private double startX, startY;
    
    //remenber the colour
    private Color currentColor = Color.black;
    

    /**
     * Constructor for objects of class MyGUI
     */
    public MyGUI()
    {
        // initialise instance variables
        speed = 0;
        
        //setup buttons
        UI.addButton("Quit", UI::quit);
        
        //rando colours
        UI.addButton("ColoUr", this::chooseColour);
        UI.addButton("Rando ColoUr", this::changeColour);
        
        //setup slider
        UI.addSlider("Speed", 0, 100, 20, this::setSpeed);
        
        //setup mouse listener
        UI.setLineWidth(10);
        UI.setMouseListener(this::doMouse);
    }

    /**
     * callback meathod for speed slider
     */
    public void setSpeed(double km) {
        //check if speed is greate than last speed
        if (speed < km) {
            UI.println("Accelerating");
        } else if (speed > km) {
            UI.println("Deccelerating");
        } else {
            UI.println("Stationary");
        }
        
        //set the speed to new speed
        this.speed = km;
    
    }
    
    /**
     * callback meathod to mouse listener
     * only make one callback to the mouse lisenter
     */
    public void doMouse(String action, double x, double y) {
        double width = 100;
        double height = 100;
        if (action.equals("pressed"))   {
            this.startX = x;
            this.startY = y;
        } else if (action.equals("released")) {
            UI.drawLine(this.startX, this.startY, x, y);
        } else if (action.equals("clicked")) {
            UI.fillOval(x - width/2, y - height/2 , width, height);
        }
    }
    
    /**
     * change to random colour
     */
    
    public void changeColour() {
        ///rgb values
        Color col = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
        UI.setColor(col);
    }
    
    /**
     * allows the user to choose the colour form the swign library
     */
    public void chooseColour() {
        this.currentColor = JColorChooser.showDialog(null, "Choose Color", this.currentColor);
        UI.setColor(this.currentColor);
    }
}
