/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userinterface;

import com.effect.Animation;
import com.effect.CacheDataLoader;
import com.effect.FrameImage;
import com.gameobject.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class GamePanel extends JPanel implements Runnable, KeyListener{
    
    private Thread thread;
    private boolean isRunning;
    private InputManagement input;
    private BufferedImage bufImage;
    private Graphics2D bufG2D;
    
    Player p = new Player(300,300,80,80);
    public GamePanel(){
        input = new InputManagement(this);
        bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage(bufImage, 0, 0, this);
    }
    public void UpdateGame(){
        p.update();
    }
    public void RenderGame(){
        if(bufImage == null){
            bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        }
        else{
            bufG2D = (Graphics2D) bufImage.getGraphics();
        }
        if(bufG2D!=null){
            bufG2D.setColor(Color.white);
            bufG2D.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
            // vẽ object ở đây
            p.draw(bufG2D);
        }
    }
    public void startGame(){
        if(thread == null){
            isRunning = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    @Override
    public void run(){
        long FPS = 80;
        long period = 1000*1000000/FPS;
        long beginTime;
        long sleepTime;
        beginTime = System.nanoTime();
        while(isRunning){
            
            UpdateGame();
            RenderGame();
            repaint();
            long deltaTime = System.nanoTime() - beginTime; 
            sleepTime = period - deltaTime;
            try {
                if(sleepTime > 0)
                    Thread.sleep(sleepTime/1000000);
                else   
                    Thread.sleep(period/2000000);
            } catch (InterruptedException ex) {}
            
            beginTime = System.nanoTime();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        input.processKeyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        input.processKeyReleased(e.getKeyCode());
    }
}
