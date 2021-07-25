/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author xuant
 */
public class IconListener extends MouseAdapter{
    String emoji;

    public IconListener(String emoji) {
        this.emoji = emoji;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        super.mouseClicked(me); //To change body of generated methods, choose Tools | Templates.
    }
    
}
