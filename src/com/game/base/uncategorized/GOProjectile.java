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
    
    private static final float SPEEDX = 15f;
    private static final float SPEEDY = 15f;
    
    private static boolean used = false;
    private static float userDirecX;
    private static float userDirecY;
    
    public GOProjectile()
    {
        sx = SIZE;
        sy = SIZE;
    }

    @Override
    public void update()
    {
        y += SPEEDY * userDirecY;
        x += SPEEDX * userDirecX;
    }
    
    public void shoot(GOBall ball)
    {
        if(used != true)
        {
            x = ball.x + ball.SIZE/2;
            y = ball.y;
            used = true;
        }
    }
    
    public void projectileDirec(float direcX, float direcY)
    {
        userDirecX = direcX;
        userDirecY = direcY;
    }
    
    public void outOfArea()
    {
        if((y >= Display.getHeight()) || (y <= 0) || (x >= Display.getWidth()) || (x <= 0))
            used = false;
    }
    
    public boolean getIsUsed()
    {
        return used;
    }
}
