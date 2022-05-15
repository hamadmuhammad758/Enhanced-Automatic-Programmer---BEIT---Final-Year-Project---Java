/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ardublock.core.MessageFetcher;
import com.ardublock.ui.MessageDialog;
import com.ardublock.ui.OpenblocksFrame;
import com.ardublock.Context;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
/**
 *
 * @author 
 */
public class Main_Menu extends javax.swing.JFrame implements MouseListener{

    /**
     * Creates new form Main_Menu
     */
    JButton b1;
    JLabel l1;
    String deviceToCreate;
    static String code_view="";
   static Main_Menu thiss;
    private boolean readyToCreateNewDevice;
    ArrayList<String> devices_list=new ArrayList<>();
    DefaultListModel list_model=new DefaultListModel();
    private OpenblocksFrame openblocksFrame;
    public Main_Menu() {
        initComponents();
        pfev.addMouseListener(this);
        fd.addMouseListener(this);
        deviceToCreate="";
        thiss=this;
        create_btn.setIcon(new ImageIcon(this.getClass().getResource("/com/ardublock/icons/new.png")));
        save_btn.setIcon(new ImageIcon(this.getClass().getResource("/com/ardublock/icons/save.png")));
        open_btn.setIcon(new ImageIcon(this.getClass().getResource("/com/ardublock/icons/open.png")));
        generate_btn.setIcon(new ImageIcon(this.getClass().getResource("/com/ardublock/icons/generate.png")));
   }
	
    public void startOpenblocksFrame() throws SAXException, IOException, ParserConfigurationException
	{
		Context context = new Context(false);
		
		openblocksFrame = new OpenblocksFrame(context);
		//openblocksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		openblocksFrame.setVisible(true);
		
		MessageFetcher mf = new MessageFetcher();
		mf.startFetchMessage(new MessageDialog(openblocksFrame), context);
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        create_btn = new javax.swing.JButton();
        save_btn = new javax.swing.JButton();
        open_btn = new javax.swing.JButton();
        generate_btn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Main_comp_list = new javax.swing.JList();
        item_pic_main_menu = new javax.swing.JLabel();
        code_tab = new javax.swing.JTabbedPane();
        jPanel3 = new JPanel();
        jPanel4 = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        code_txt_area = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Enhance Automatic Programmer :Home Page");
        setBackground(new java.awt.Color(0, 0, 0));
        setName("main_screen"); // NOI18N

        jToolBar1.setRollover(true);

        create_btn.setText("Create");
        create_btn.setToolTipText("Create Project");
        create_btn.setFocusable(false);
        create_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        create_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        create_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_btnActionPerformed(evt);
            }
        });
        jToolBar1.add(create_btn);

        save_btn.setText("Save");
        save_btn.setToolTipText("Save");
        save_btn.setFocusable(false);
        save_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(save_btn);

        open_btn.setText("Open");
        open_btn.setToolTipText("Open Project");
        open_btn.setFocusable(false);
        open_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        open_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(open_btn);

        generate_btn.setText("Generate Code");
        generate_btn.setToolTipText("Generate Code");
        generate_btn.setFocusable(false);
        generate_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        generate_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        generate_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generate_btnMouseClicked(evt);
            }
        });
        jToolBar1.add(generate_btn);

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setText("Pick Component");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        Main_comp_list.setBackground(new java.awt.Color(0, 0, 0));
        Main_comp_list.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Main_comp_list.setForeground(new java.awt.Color(255, 255, 255));
        Main_comp_list.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "-----", "LED", "LCD 8 bit", "Stepper", "Keypad" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        Main_comp_list.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                Main_comp_listValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(Main_comp_list);

        item_pic_main_menu.setBackground(new java.awt.Color(204, 204, 204));
        item_pic_main_menu.setForeground(new java.awt.Color(204, 204, 204));
        item_pic_main_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        item_pic_main_menu.setBorder(new javax.swing.border.MatteBorder(null));
        item_pic_main_menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        item_pic_main_menu.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(item_pic_main_menu, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(item_pic_main_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        code_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                code_tabMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel3.add(pfev);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );

        code_tab.addTab("Design", new javax.swing.ImageIcon("F:\\Degree Project\\Java Lib\\AkhreeOqaat\\ardublock-master\\src\\main\\resources\\com\\ardublock\\icons\\aboutus.png"), jPanel3); // NOI18N

        jToolBar3.setRollover(true);

        jButton2.setText("MakeFlow");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton2);

        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButton3);

        jButton4.setText("Save");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButton4);

        code_txt_area.setEditable(false);
        code_txt_area.setColumns(20);
        code_txt_area.setRows(5);
        jScrollPane2.setViewportView(code_txt_area);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        );

        code_tab.addTab("Code", new javax.swing.ImageIcon("F:\\Degree Project\\Java Lib\\AkhreeOqaat\\ardublock-master\\src\\main\\resources\\com\\ardublock\\icons\\generate.png"), jPanel4); // NOI18N

        jMenu1.setText("File");
        jMenu1.setName("File_menu"); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Create Project");
        jMenuItem1.setName("file"); // NOI18N
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Save Project");
        jMenu1.add(jMenuItem3);

        jMenuItem5.setText("Open Project");
        jMenu1.add(jMenuItem5);

        jMenuItem4.setText("Generate Code");
        jMenu1.add(jMenuItem4);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Exit");
        jMenuItem2.setToolTipText("exit");
        jMenuItem2.setName("menu"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("System");

        jMenuItem9.setText("System Settings");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);
        jMenu3.add(jSeparator2);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Help");

        jMenuItem7.setText("Help");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Online Support");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);
        jMenu2.add(jSeparator1);

        jMenuItem6.setText("AboutUs");
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(code_tab)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(code_tab)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void create_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_create_btnActionPerformed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        new pickComponents(this, true).show();
    }//GEN-LAST:event_jButton7MouseClicked

    private void Main_comp_listValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_Main_comp_listValueChanged
       // jList1.setSelectedIndex(0);
        readyToCreateNewDevice=true;
      
        switch(""+Main_comp_list.getSelectedValue()){
            case "": 
                break;
            case "LED":
                showimage("led");
                deviceToCreate="led";
                break;
            case "LCD 8 bit":
               showimage("lcd8bit");
                deviceToCreate="lcd";
                break;
            case "Stepper":
                showimage("stepper");
                deviceToCreate="Stepper";
                break;
            case "Keypad":
                showimage("keypad");
                deviceToCreate="Keypad";
                break;         
            case "Temperature Sensor":
                showimage("tsensor");
                deviceToCreate="Temperature Sensor";
                break;
            case "Seven Segment":
               showimage("seven");
                deviceToCreate="Seven Segment";
                break;
                
        }
    }//GEN-LAST:event_Main_comp_listValueChanged
    
    void showimage(String image)
    {
        if(image=="led")
        {
         item_pic_main_menu.setIcon( new ImageIcon(this.getClass().getResource("/com/ardublock/icons/led.png")));   
        }
        else if(image=="lcd8bit")
        {  
         item_pic_main_menu.setIcon( new ImageIcon(this.getClass().getResource("/com/ardublock/icons/lcd16x22.png")));   
        }
        else if(image=="seven")
        {
         item_pic_main_menu.setIcon( new ImageIcon(this.getClass().getResource("/com/ardublock/icons/sevensegment.png")));  
        }
        else if(image=="stepper")
        {  
         item_pic_main_menu.setIcon( new ImageIcon(this.getClass().getResource("/com/ardublock/icons/stepperMottor.png")));   
        }
        else if(image=="keypad")
        {  
         item_pic_main_menu.setIcon( new ImageIcon(this.getClass().getResource("/com/ardublock/icons/keypad2.png")));   
        }
        else if(image=="tsensor")
        {
         item_pic_main_menu.setIcon( new ImageIcon(this.getClass().getResource("/com/ardublock/icons/tempSensor.png")));   
        }
    }
    public  void setlist(ArrayList<String> data)
    {
        
        for(int a=0;a<data.size();a++)
        {
            devices_list.add(data.get(a));
        }
            list_model.clear();
        
         for(int a=0;a<devices_list.size();a++)
            list_model.addElement(devices_list.get(a));
         
         Main_comp_list.setModel(list_model);
    }
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void generate_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generate_btnMouseClicked
        // TODO add your handling code here:
            pfev.generatecode();
    }//GEN-LAST:event_generate_btnMouseClicked

    private void code_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_code_tabMouseClicked
        // TODO add your handling code here:
        if(pfev.code_4_main!="")
        {
            code_txt_area.setText(pfev.code_4_main);
        }else
        {
            code_txt_area.setText("generate code first");
        }

    }//GEN-LAST:event_code_tabMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Context context = new Context(false);
	openblocksFrame = new OpenblocksFrame(context);
        MessageFetcher mf = new MessageFetcher();
        mf.startFetchMessage(new MessageDialog(openblocksFrame), context);
        openblocksFrame.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    public void setcode(String code)
    {
         code_view=code;
        //code_txt_area.setText("muakjsds");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try 
                {
                    Thread.sleep(1000);
                }catch(Exception e)
                {
                }
                Main_Menu m=new Main_Menu();
                
                System.out.println("hmadhmadhmadhmadhmadhmadhmadhmadhmadhmad");
                m.setVisible(true);
                m.setExtendedState(MAXIMIZED_BOTH);
                
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JList Main_comp_list;
    private javax.swing.JTabbedPane code_tab;
    public javax.swing.JTextArea code_txt_area;
    private javax.swing.JButton create_btn;
    private javax.swing.JButton generate_btn;
    private javax.swing.JLabel item_pic_main_menu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    PanelFrontEndView pfev=new PanelFrontEndView();
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JButton open_btn;
    private javax.swing.JButton save_btn;
    // End of variables declaration//GEN-END:variables
    FlowDiagram fd=new FlowDiagram();
    
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
    public void mouseEntered(MouseEvent e){
    //  JOptionPane.showMessageDialog(rootPane,"Entered From menu");
      if(readyToCreateNewDevice){
          System.out.print(deviceToCreate);
          pfev.setDrawingItem(deviceToCreate);
          Main_comp_list.setSelectedIndex(0);
          readyToCreateNewDevice=false;
      }
    }
    @Override
    public void mouseExited(MouseEvent e) {
     }
}
