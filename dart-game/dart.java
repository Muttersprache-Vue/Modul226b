import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dart extends Actor
{
    /**
     * Act - do whatever the dart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int zielX;
    private int zielY;
    private boolean gestartet = false;
    
    public Dart(int zielX, int zielY)
    {
        getImage().scale(getImage().getWidth() / 4 , getImage().getHeight() / 4 );
        this.zielX = zielX;
        this.zielY = zielY;
    }
    
    public void act() 
    {
        // Add your action code here.
        if(!gestartet)
        {
            //bewegeZuZiel()-Methode in act()-Methode aufrufen um flüssige Bewegung des Pfeils zu bewerkstelligen
            bewegeZuZiel();
        }
        
        if (isTouching(Dartboard.class))
        {
            Counter counter = (Counter) getWorld().getObjects(Counter.class).get(0);
            //counter.add(1);
        }
    }
    
    //Methode bewegeZuZiel() schickt den Pfeil in Richtung Mittelpunkt des Zielvisiers
    private void bewegeZuZiel()
    {
        //Pfeil in Richtung von Zielvisier drehen mit Koordinaten des Zielvisiers
        turnTowards(zielX, zielY);
        //Bewege Pfeil 6 Pixel bei jedem Aufruf von act()-Methode
        move(6);
        
        //Eingrenzung für Pfeil, wenn Pfeil sich dem Zielvisier nähert
        if(Math.abs(getX() - zielX) < 9 && Math.abs(getY() - zielY) < 9)
        {
            //setze Koordinaten für Pfeil mit Koordinaten von Zielvisier, welche über Konstruktor hier reinkommen
            //Koordinaten von Zielvisier und Pfeilspitze müssen übereinstimmen, damit Pfeil mit Spitze im Mittelpunkt des Fadenkreuzes auftrifft 
            setLocation(zielX, zielY);
        }
    }
}