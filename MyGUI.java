import ecs100.*;
import java.awt.Color;
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

    /**
     * Constructor for objects of class MyGUI
     */
    public MyGUI()
    {
        // initialise instance variables
        speed = 0;
        
        //setup buttons
        UI.addButton("Quit", UI::quit);
        
        //setup slider
        UI.addSlider("Speed", 0, 100, 20, this::setSpeed);
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
}
