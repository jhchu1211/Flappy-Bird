import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Medal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Medal extends Actor
{
    private static final GreenfootImage bronze = new GreenfootImage("bronze-medal.png");
    private static final GreenfootImage silver = new GreenfootImage("silver-medal.png");
    private static final GreenfootImage gold = new GreenfootImage("gold-medal.png");
    
    public Medal(String selection)
    {
        if (selection == "bronze")
        {
            setImage(bronze);
        }
        else if (selection == "silver")
        {
            setImage(silver);
        }
        else if (selection == "gold")
        {
            setImage(gold);
        }
    }
}
