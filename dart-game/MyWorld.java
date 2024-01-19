import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 600, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        dartboard dartboard = new dartboard();
        addObject(dartboard,615,191);       
        Versüche versüche = new Versüche();
        addObject(versüche,1035,475);
        Versüche versüche2 = new Versüche();
        addObject(versüche2,1028,463);
        Versüche versüche3 = new Versüche();
        addObject(versüche3,1038,488);
        Versüche versüche4 = new Versüche();
        addObject(versüche4,1043,499);
        Versüche versüche5 = new Versüche();
        addObject(versüche5,1048,510);
        Versüche versüche6 = new Versüche();
        addObject(versüche6,1043,511);
    }
}
