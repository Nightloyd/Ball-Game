/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.base.uncategorized;

import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

/**
 *
 * @author Isak
 */
public class Game 
{
    private ArrayList<GameObject> objects;
    private GOBall ball;
    private GOEnemyBall enemyBall1;
    private GOBall ball2;
    private GOProjectile ballProjectile;
    private static float i = 1;

    
    public Game()
    {
        objects = new ArrayList<GameObject>();
        
        ball = new GOBall(Display.getWidth() / 2 - GOBall.SIZE /2, Display.getHeight() /2 - GOBall.SIZE /2);
        ball2 = new GOBall(Display.getWidth() / 2 - GOBall.SIZE /2, Display.getHeight() /2 - GOBall.SIZE /2);
        enemyBall1 = new GOEnemyBall(ball, 0, 0);
        ballProjectile = new GOProjectile();
        
        objects.add(ball);
        objects.add(ball2);
        objects.add(enemyBall1);
        objects.add(ballProjectile);
    }
    
    public void getInput()
    {
        if(Keyboard.isKeyDown(Keyboard.KEY_W))
            ball.moveY(1);
        if(Keyboard.isKeyDown(Keyboard.KEY_S))
            ball.moveY(-1);
        if(Keyboard.isKeyDown(Keyboard.KEY_A))
            ball.moveX(-1);
        if(Keyboard.isKeyDown(Keyboard.KEY_D))
            ball.moveX(1);
        
        if(Keyboard.isKeyDown(Keyboard.KEY_UP))
            ball2.moveY(1);
        if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
            ball2.moveY(-1);
        if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
            ball2.moveX(-1);
        if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
            ball2.moveX(1);
        
        if(Keyboard.isKeyDown(Keyboard.KEY_R))
        {
              i *= -1;
              enemyBall1.setBallDirection(i);
        }
        
        if(Keyboard.isKeyDown(Keyboard.KEY_F))
        {
            ballProjectile.shoot(ball);
        }
    }
    
    public void update()
    {
        for(GameObject go : objects)
        {
            enemyBall1.setBallSpeed(ball, ball2);
            ballProjectile.outOfArea();
            go.update();
        }
    }
    
    public void render()
    {
        for(GameObject go : objects)
            go.render();
    }
}
