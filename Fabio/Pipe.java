import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pipe extends SharedMembers
{
    private static final GreenfootImage Bottom = new GreenfootImage("bottom_pipe.png");
    private static final GreenfootImage Top = new GreenfootImage("top_pipe.png");
    
    public Pipe(String selection)
    {
        this.xSpeed = 4;
        if (selection == "top")
        {
            setImage(Top);
        }
        else if (selection == "bottom")
        {
            setImage(Bottom);
        }
    }
    
    /**
     * Act - do whatever the Pipe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        this.moveLeft();
        removePipe();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    private void removePipe()
    {
        // put your code here
        if (getX() < - getImage().getWidth())
        {
            getWorld().removeObject(this);
        }
    }

}
