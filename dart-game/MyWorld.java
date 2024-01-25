import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int verbleibendeVersuche = 6;

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
        //füge Dartboard der Welt hinzu
        Dartboard dartboard = new Dartboard();
        addObject(dartboard, 615, 191);
        
        //füge 6 Versuche der Welt hinzu
        for(int i = 0; i < verbleibendeVersuche; i++) {
            Versuch versuch = new Versuch();
            addObject(versuch, 1020 + i * 10, 475);
        }
        
        //füge Zielvisier initial im Mittelpunkt des Dartboards hinzu
        Zielvisier zielvisier = new Zielvisier();
        addObject(zielvisier,617,186);
    }
    
    //Methode entferntVersuch() entfernt ein Versuchpfeil-Objekt aus der Liste
    public void entferneVersuch() {
        if(verbleibendeVersuche > 0) 
        {
            verbleibendeVersuche--;
            //erzeuge Liste mit Versuchspfeilen
            List<Versuch> versucheListe = getObjects(Versuch.class);
            //solange nicht Liste mit Versuchspfeilen leer ist, entfern ein Versuchspfeil-Objekt aus der Liste
            if(!versucheListe.isEmpty()) {
                removeObject(versucheListe.get(0));
            }
            //wenn Liste leer, dann Spielreset
            if(verbleibendeVersuche == 0) {
                Greenfoot.delay(50);
                spielReset();
            }
        }
    }
    
    private void spielReset() 
    {
        //alle Objekte auf Welt entfernen
        entferneAlleObjekte();
        //Welt neu bauen
        prepare();
    }
    
    //Methode entferneAlleObjekte() entfernt alle Objekte auf Welt
    private void entferneAlleObjekte() 
    {
        removeObjects(getObjects(null));
    }
}