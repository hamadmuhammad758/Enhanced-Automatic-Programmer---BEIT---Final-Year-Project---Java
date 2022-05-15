/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AppPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author hamad PC
 */
public class FlowDiagram  extends JPanel implements MouseListener, MouseMotionListener{

    
    public FlowDiagram() {
        
        setBackground(Color.LIGHT_GRAY);
        addMouseListener(this);
        addMouseMotionListener(this);
        setBounds(0,0,1020,831);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
   }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
     protected void paintComponent(Graphics g) {     
        super.paintComponent(g); 
        g.setColor(Color.red);
        g.fillRect(100,200, 100,400);
        g.fillRect(100,500, 1400,100);
     }
}
