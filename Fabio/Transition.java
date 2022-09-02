import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Transition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transition extends SharedMembers
{
    private static final GreenfootImage transition = new GreenfootImage(1000, 700);
    private static final int fadeUpperLimit = 255;
    private static final int fadeLowerLimit = 25;
    
    public Transition(String selection)
    {
        if (selection == "black")
        {
            this.xSpeed = 5;
            transition.setColor(Color.BLACK);
        }
        else if (selection == "white")
        {
            this.xSpeed = 3;
            transition.setColor(Color.WHITE);
        }
        transition.fill();
        setImage(transition);
        transition.setTransparency(fadeUpperLimit);
    }
    
    /**
     * Act - do whatever the Transition wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        fadeOut();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    private void fadeOut()
    {
        // put your code here
        transition.setTransparency(transition.getTransparency() - this.xSpeed);
        if (transition.getTransparency() <= fadeLowerLimit)
        {
            getWorld().removeObject(this);
        }
    }

}
