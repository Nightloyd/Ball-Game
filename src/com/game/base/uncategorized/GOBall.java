/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.base.uncategorized;

import static org.lwjgl.opengl.GL11.glClearColor;

/**
 *
 * @author Isak
 */
public class GOBall extends GameObject
{
    public static final int SIZE = 16;
    public static final float SPEEDX = 8f;
    public static final float SPEEDY = 8f;
    
    public GOBall(float x, float y)
    {
        this.x = x;
        this.y = y;
        this.sx = SIZE;
        this.sy = SIZE;
    }
    
    @Override
    public void update()
    {
        
    }
    
    public void moveX(float mag)
    {
        x += SPEEDX * mag;
    }
    
    public void moveY(float mag)
    {
        y += SPEEDY * mag;
    }
}
