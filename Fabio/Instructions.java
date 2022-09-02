import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Insructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends Actor
{
    private static final GreenfootImage getReadyText = new GreenfootImage("instructions_ready.png");
    private static final GreenfootImage tap = new GreenfootImage("instructions_tap.png");
    
    public Instructions(String selection)
    {
        if(selection == "getReady")
        {
            setImage(getReadyText);
        }
        else if (selection == "tap")
        {
            setImage(tap);
        }
    }
    
    /**
     * Act - do whatever the Insructions wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        playGameNow();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    private void playGameNow()
    {
        // put your code here
        if (Greenfoot.mouseClicked(this) == true || "space".equals (Greenfoot.getKey()))
        {
            Game level = (Game)getWorld();
            level.playGame = true;
        }
    }

}
