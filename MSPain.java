import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;
/**
 * mking some sliders and responding to mouse events
 *
 * @author (Rayha)
 * @version (a version number or a date)
 */
public class MSPain
{
    // instance variables - replace the example below with your own
    private double lineWidth;
    
    // shape
    private String shape;
    
    //fields to remember pressed position
    private double startX, startY;
    
    //remenber the colour
    private Color currentColor = Color.black;
    

    /**
     * Constructor for objects of class MSPain
     */
    public MSPain()
    {
        // initialise instance variables
        lineWidth = 25;
        shape = "line";
        
        //shapes
        UI.addButton("rectangle", this::rectangle);
        UI.addButton("circle", this::circle);
        UI.addButton("fill recantgle", this::fillRectangle);
        UI.addButton("fill circle", this::fillCircle);
        UI.addButton("line", this::line);
        
        UI.addButton("Clear",UI::clearGraphics);
        
        //setup buttons
        UI.addButton("Quit", UI::quit);
        
        //rando colours
        UI.addButton("ColoUr", this::chooseColour);
        UI.addButton("Rando ColoUr", this::changeColour);
        
        //setup slider
        UI.addSlider("Line Width", 0, 50, 25, this::setWidth);
        
        //setup mouse listener
        UI.setLineWidth(10);
        UI.setMouseListener(this::doMouse);
    }

    /**
     * callback meathod for speed slider
     */
    public void setWidth(double thick) {
        
        //set the speed to new speed
        this.lineWidth = thick;
    
    }
    
    /**
     * callback meathod to mouse listener
     * only make one callback to the mouse lisenter
     */
    public void doMouse(String action, double x, double y) {
        if (action.equals("pressed"))   {
            this.startX = x;
            this.startY = y;
        } else if (action.equals("released")) {
            UI.setLineWidth(lineWidth);
            if (shape.equals("line")){
                UI.drawLine(this.startX, this.startY, x, y);
            } else if (x > this.startX && y >this.startY) {
                double width = x - this.startX;
                double height = y - this.startY; 
                if (shape.equals("rectangle")) {
                    UI.drawRect(this.startX, this.startY, width, height);
                } else if (shape.equals("circle")) {
                    UI.drawOval(this.startX, this.startY, width, height);
                } else if ((shape.equals("fill rectangle"))) {
                    UI.fillRect(this.startX, this.startY, width, height);
                } else if (shape.equals("fill circle")) {
                    UI.fillOval(this.startX, this.startY, width, height);
                }
            } else if (x < this.startX && y > this.startY) {
                double width = this.startX - x;
                double height = y - this.startY; 
                if (shape.equals("rectangle")) {
                    UI.drawRect(x, this.startY, width, height);
                } else if (shape.equals("circle")) {
                    UI.drawOval(x, this.startY, width, height);
                } else if ((shape.equals("fill rectangle"))) {
                    UI.fillRect(x, this.startY, width, height);
                } else if (shape.equals("fill circle")) {
                    UI.fillOval(x, this.startY, width, height);
                }
            } else if (x > this.startX && y < this.startY) {
                double width = x - this.startX;
                double height = this.startY - y;
                if (shape.equals("rectangle")) {
                    UI.drawRect(this.startX, y, width, height);
                } else if (shape.equals("circle")) {
                    UI.drawOval(this.startX, y, width, height);
                } else if ((shape.equals("fill rectangle"))) {
                    UI.fillRect(this.startX, y, width, height);
                } else if (shape.equals("fill circle")) {
                    UI.fillOval(this.startX, y, width, height);
                }
            } else if ((x < this.startX && y < this.startY)){
                double width = this.startX - x;
                double height = this.startY - y;
                if (shape.equals("rectangle")) {
                    UI.drawRect(x, y, width, height);
                } else if (shape.equals("circle")) {
                    UI.drawOval(x, y, width, height);
                } else if ((shape.equals("fill rectangle"))) {
                    UI.fillRect(x, y, width, height);
                } else if (shape.equals("fill circle")) {
                    UI.fillOval(x, y, width, height);
                }
            }
        }
}
    
    public void rectangle() {
        shape = "rectangle";
    }
    public void circle() {
        shape = "circle";
    }
    public void fillRectangle() {
        shape = "fill rectangle";
    }
    public void fillCircle() {
        shape = "fill circle";
    }
    public void line() {
        shape = "line";
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