package com.game.base.uncategorized;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Isak
 */
public class GOEnemyBall extends GameObject
{
    public static final int SIZE = 16;
    
    private static float ballSpeedX;
    private static float ballSpeedY;
    private static float ballDirection;

    public GOEnemyBall(GOBall ball, float x, float y)
    {
        this.x = ball.getX() + x;
        this.y = ball.getY() + y;
        sx = SIZE;
        sy = SIZE;
    }
    
    @Override
    public void update()
    {
        x += ballSpeedX;
        y += ballSpeedY;
    }
    
    public void setBallSpeed(GOBall ball, GOBall ball2)
    {
            
            ballSpeedX = ballDirection*((ball.getX()-x)/20)/*+((ball2.getX()-x)/20)*/;
            ballSpeedY = ballDirection*((ball.getY()-y)/20)/*+((ball2.getY()-y)/20)*/;

        
        if(ballSpeedX > 4f)
            ballSpeedX = 4f;
        if(ballSpeedX < -4f)
            ballSpeedX = -4f;
        if(ballSpeedY > 4f)
            ballSpeedY = 4f;
        if(ballSpeedY < -4f)
            ballSpeedY = -4f;
    }
    
    public void setBallDirection(float i)
    {
        ballDirection = i;
    }
    

}
