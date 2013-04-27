/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.base.uncategorized;

import org.lwjgl.opengl.Display;

/**
 *
 * @author Isak
 */

public class GOProjectile extends GameObject 
{
    public static final int SIZE = 2;
    
    private static final float SPEEDX = 4f;
    private static final float SPEEDY = 4f;
    
    private static boolean used = false;
    
    public GOProjectile()
    {
        sx = SIZE;
        sy = SIZE;
    }

    @Override
    public void update()
    {
        y += 4f;
    }
    
    public void shoot(GOBall ball)
    {
        if(used != true)
        {
            x = ball.x;
            y = ball.y;
            used = true;
        }
    }
    
    public void outOfArea()
    {
        if(y >= Display.getHeight())
            used = false;
    }
}
