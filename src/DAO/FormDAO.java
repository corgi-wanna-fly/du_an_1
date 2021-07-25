/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;

/**
 *
 * @author xuant
 */
public class FormDAO {
    public static void centerJIF(JDesktopPane jDesktopPane, JComponent jComponent) {
        Dimension desktopSize = jDesktopPane.getSize();
        Dimension jInternalFrameSize = jComponent.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jComponent.setLocation(width, height);
        jComponent.setVisible(true);
    }
}
