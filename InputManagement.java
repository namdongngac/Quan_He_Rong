/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userinterface;

import com.gameobject.GameObject;
import com.gameobject.Player;
import java.awt.event.KeyEvent;

/**
 *
 * @author admin
 */

// quản lí sự kiện từ keyboard
public class InputManagement {
    
    private GamePanel g;
    
    public InputManagement(GamePanel g){
        this.g = g;
    }
    // quản lí nhấn key
    public void processKeyPressed(int keyCode){
        switch(keyCode){
            case KeyEvent.VK_W:
                g.p.setDirection(GameObject.DIR_UP);
                g.p.setSpeedY(-5);
                break;
            case KeyEvent.VK_A:
                g.p.setDirection(GameObject.DIR_LEFT);
                g.p.setSpeedX(-5);
                break;
            case KeyEvent.VK_S:
                g.p.setDirection(GameObject.DIR_DOWN);
                g.p.setSpeedY(5);
                break;
            case KeyEvent.VK_D:
                g.p.setDirection(GameObject.DIR_RIGHT);
                g.p.setSpeedX(5);
                break;
            case KeyEvent.VK_SPACE:
                break;
            case KeyEvent.VK_UP:
                
                break;    
            case KeyEvent.VK_LEFT:
                
                break;
            case KeyEvent.VK_DOWN:
                
                break;
            case KeyEvent.VK_RIGHT:
                
                break;
            case KeyEvent.VK_ENTER:
                break;
        }
    }
    // quản lí thả key
    public void processKeyReleased(int keyCode){
        switch(keyCode){
            case KeyEvent.VK_W:
                g.p.setSpeedY(0);
                break;
            case KeyEvent.VK_A:
                g.p.setSpeedX(0);
                break;
            case KeyEvent.VK_S:
                g.p.setSpeedY(0);
                break;
            case KeyEvent.VK_D:
                g.p.setSpeedX(0);
                break;
            case KeyEvent.VK_SPACE:
                break;
            case KeyEvent.VK_UP:
                
                break;    
            case KeyEvent.VK_LEFT:
                
                break;
            case KeyEvent.VK_DOWN:
                
                break;
            case KeyEvent.VK_RIGHT:
                
                break;
            case KeyEvent.VK_ENTER:
                break;
        }
    }
}
