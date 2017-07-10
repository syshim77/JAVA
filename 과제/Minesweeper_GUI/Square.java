/********************************
* File: Square.java             *
*********************************
* Author:                       *
* Date:                         *
********************************/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

/**
 * Class Square.
 * Defines a square for a minefield
 */
public class Square extends JToggleButton
{
    boolean mine = false;
    int neighborMines = 0;
    boolean pressed = false;
    int flag = 0;
    int x;
    int y;

    public Square( String text)
    {
        super.setText( text );
    }

    /**
     * Constructor sets the size, insets and notes the location in the minefield
     */
    public Square( int newX, int newY )
    {

        this.setPreferredSize( new Dimension( 20,20 ) );
        this.setMargin( new Insets( 1, 1, 1, 1 ) );
        this.setFocusPainted( false );
        x = newX;
        y = newY;
    }

    /**
     * Returns number of neighbors 
     * @return: number of neighboring fileds that have mines
     */
    public int getNeighors()
    {
        return neighborMines;
    }

    /**
     * Sets number of neighboring fileds with mines
     */
    public void setNeighbors( int newNeighbors )
    {
        neighborMines = newNeighbors;
            
    }

    /**
     * Returns true if there is mine in this square
     */
    public boolean isMine()
    {
        return mine;
    }

    /**
     * Sets a mine in this square
     */
    public void setMine()
    {
        mine = true;
    }

    /**
     * Increase number of neighboring fields with mines
     */
    public void addNeighbors(int number)
    {
        neighborMines += number;
    }

    /**
     * Mark square as clicked
     */
    public void setPressed()
    {
        this.setEnabled( false );
    }

    /**
     * Check if the square was clicked
     */
    public boolean isPressed()
    {
        return pressed;
    }

    /**
     * Handle right click on that square
     */
    public int rightClick()
    {
        if( !pressed )
        {
            switch( flag )
            {
                // flag a square with a 'flag'
                case 0:
                    flag = 1;
                    setIcon(new ImageIcon( "C:\\Users\\syshim\\Desktop\\HW07(3)\\pr\\src\\pr\\flag.jpg" ));
                    return -1;

                // mark a square with a '?'
                case 1:
                    flag = 2;
                    setEnabled( true );
                    setIcon( null );
                    setText( "?" );
                    return 1;

                // clear '?'
                case 2:
                    flag = 0;
                    setText( "" );
                    return 0;

                default:
                    break;
            }
        }
        return 0;
    }

    /**
     * resets a square to its initial state
     */
    public void reset()
    {
        setText( "" );
        flag = 0;
        mine = false;
        neighborMines = 0;
        pressed = false;
        setEnabled( true );
        this.setSelected( false );
        setIcon( null );
    }

    /**
     * Check what flag is set on a square
     */
    public int getFlag()
    {
        return flag;
    }

    /**
     * Get x position of this square
     */
    public int getXpos()
    { 
        return x;
    }

    /**
     * Get y position of this square
     */
    public int getYpos()
    {
        return y;
    }

    /**
     * Handle left click on this square
     */
    public void leftClick()
    {
        // set the color of the number of neighbors accordingly 
        // to a number of neighbors
        switch( neighborMines )
        {
            case 1:
                this.setForeground( Color.BLUE );
                break;
                
            case 2:
                this.setForeground( Color.GREEN );
                break;
                
            case 3:
                this.setForeground( Color.RED );
                break;

            case 4:
                this.setForeground( Color.YELLOW );
                break;
                
            case 5:
                this.setForeground( Color.ORANGE );
                break;

                
            case 6:
                this.setForeground( Color.CYAN );
                break;
                
            case 7:
                this.setForeground( Color.PINK );
                break;
                
            case 8:
                this.setForeground( Color.MAGENTA );
                break;
                
            default:
                break;
        }   

        if( pressed )
        {
            setSelected( true );
            return;
        }

        // if flag is set cannot click that square
        if( flag == 1)
            setSelected( false );
        else
        {
            setSelected( true );
            pressed = true;

            if( neighborMines > 0 )
                setText( "" + neighborMines );
        }
    }
}