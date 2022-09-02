import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private static final GreenfootImage button = new GreenfootImage("button.png");
    private String selection;
    
    public Button(String selection)
    {
        setImage(button);
        this.selection = selection;
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if (selection == "restart")
        {
            restartGame();
        }
        else if (selection == "start")
        {
            showInstructions();
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    private void restartGame()
    {
        // put your code here
        if (Greenfoot.mouseClicked(this) == true || "escape".equals(Greenfoot.getKey()))
        {
            Game level = (Game)getWorld();
            level.gameOverSound.stop();
            Greenfoot.setWorld(new Game());
        }
    }

    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    private void showInstructions()
    {
        // put your code here
        if (Greenfoot.mouseClicked(this) == true || "space".equals(Greenfoot.getKey()))
        {
            Game level = (Game)getWorld();
            level.showInstructionsScreen = true;
        }
    }

}
