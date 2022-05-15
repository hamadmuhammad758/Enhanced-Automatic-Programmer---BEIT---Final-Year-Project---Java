/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AppPackage;

import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author hamad PC
 */
public class setLcdProperties extends javax.swing.JDialog {

    lcd l,oldLcd;
    PanelFrontEndView pf;
    int []a,b,c,d;
    
    public setLcdProperties(java.awt.Frame parent, boolean modal,lcd l,PanelFrontEndView pf,int [] a,int [] b,int [] c,int [] d) {
        super(parent, modal);
        initComponents();
        
        this.l=l;
        this.pf=pf; 
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        mode_combo.addItem("4");
        mode_combo.addItem("8");
        availablePort(a, b, c, d);
       oldLcd=new lcd();
        oldLcd.setControl_port(l.getControl_port());
        oldLcd.setData_port(l.getData_port());
        oldLcd.setE(l.getE());
        oldLcd.setMode(l.getMode());
        oldLcd.setRS(l.getRS());
        oldLcd.setPin(l.getPin());

        
    }

    private setLcdProperties(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      public void availablePort(int [] a,int [] b,int [] c,int [] d){
        try {
            Boolean pa=true,pb=true,pc=true,pd=true;
            int ca=0,cb=0,cc=0,cd=0;
            for (int i = 0; i < 7; i++) {
                if(a[i]==(-1) && pa){
                    ca++;
                    if(ca==2){
                        controlport_combo.addItem("A");
                        pa=false;}
                }
                if(b[i]==(-1) && pb){
                    cb++;
                    if(cb==2){
                        controlport_combo.addItem("B");
                        pb=false;}
                }
                if(c[i]==(-1) && pc){
                    cc++;
                    if(cc==2){
                        controlport_combo.addItem("C");
                        pc=false;}
                }
                if(d[i]==(-1) && pd){
                    cd++;
                    if(cd==2){
                        controlport_combo.addItem("D");
                        pd=false;}
                }
            }
        } catch (Exception e) { JOptionPane.showMessageDialog(rootPane,"available excep : "+e);       
        }
    }
    private void toggleVisible(Boolean v){     
        D0.setVisible(v);
        D0_label.setVisible(v);
        D1.setVisible(v);
        D1_label.setVisible(v);
        D2.setVisible(v);
        D2_label.setVisible(v);
        D3.setVisible(v);
        D3_label.setVisible(v);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        D3 = new javax.swing.JComboBox();
        control_port_label = new javax.swing.JLabel();
        D0_label = new javax.swing.JLabel();
        controlport_combo = new javax.swing.JComboBox();
        D0 = new javax.swing.JComboBox();
        RS_E_label = new javax.swing.JLabel();
        D2 = new javax.swing.JComboBox();
        bit1_combo = new javax.swing.JComboBox();
        D1_label = new javax.swing.JLabel();
        mode_combo = new javax.swing.JComboBox();
        RS_E_label1 = new javax.swing.JLabel();
        mode_hint_label = new javax.swing.JLabel();
        D2_label = new javax.swing.JLabel();
        data_port_label = new javax.swing.JLabel();
        D3_label = new javax.swing.JLabel();
        dataport_combo = new javax.swing.JComboBox();
        bit2_combo = new javax.swing.JComboBox();
        lcd_property_title_label = new javax.swing.JLabel();
        mode_label = new javax.swing.JLabel();
        D1 = new javax.swing.JComboBox();
        Save_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        D3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D3ActionPerformed(evt);
            }
        });

        control_port_label.setText("Control Port:");

        D0_label.setText("D0");

        controlport_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                controlport_comboItemStateChanged(evt);
            }
        });

        RS_E_label.setText("RS-Bit");

        D1_label.setText("D1");

        mode_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mode_comboItemStateChanged(evt);
            }
        });
        mode_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mode_comboActionPerformed(evt);
            }
        });

        RS_E_label1.setText("E-Bit");

        mode_hint_label.setText("* 4bit LCD / 8bit LCD");

        D2_label.setText("D2");

        data_port_label.setText("Data Port:");

        D3_label.setText("D3");

        dataport_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dataport_comboItemStateChanged(evt);
            }
        });

        lcd_property_title_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lcd_property_title_label.setText("Set LCD Properties");

        mode_label.setText("LCD Mode:");

        D1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D1ActionPerformed(evt);
            }
        });

        Save_btn.setText("Save");
        Save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lcd_property_title_label))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(mode_hint_label)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(mode_label)
                                .addGap(18, 18, 18)
                                .addComponent(mode_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(data_port_label)
                                .addGap(18, 18, 18)
                                .addComponent(dataport_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(RS_E_label)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bit1_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(RS_E_label1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bit2_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(control_port_label)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(controlport_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Save_btn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(D0_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(D0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(D1_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(D2_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(D3_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lcd_property_title_label)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(control_port_label)
                    .addComponent(controlport_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RS_E_label)
                    .addComponent(bit1_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bit2_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RS_E_label1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mode_label)
                    .addComponent(mode_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(mode_hint_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(data_port_label)
                    .addComponent(dataport_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(D0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D0_label)
                    .addComponent(D2_label, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D1_label, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D3_label, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Save_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void D3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_D3ActionPerformed

    private void controlport_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_controlport_comboItemStateChanged
        // TODO add your handling code here:

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String port=""+((controlport_combo.getSelectedItem().toString()).toCharArray())[0];
            switch(port){
                case "A":
                bit1_combo.removeAllItems();
                bit2_combo.removeAllItems();
                for (int i = 0; i < 8; i++) {
                    if(a[i]==(-1)){
                        bit1_combo.addItem(""+i);
                        bit2_combo.addItem(""+i);
                    }
                }
                break;
                case "B":
                bit1_combo.removeAllItems();
                bit2_combo.removeAllItems();
                for (int i = 0; i < 8; i++) {
                    if(b[i]==(-1)){
                        bit1_combo.addItem(""+i);
                        bit2_combo.addItem(""+i);
                    }
                }
                break;
                case "C":
                bit1_combo.removeAllItems();
                bit2_combo.removeAllItems();
                for (int i = 0; i < 8; i++) {
                    if(c[i]==(-1)){
                        bit1_combo.addItem(""+i);
                        bit2_combo.addItem(""+i);
                    }
                }
                break;
                case "D":
                bit1_combo.removeAllItems();
                bit2_combo.removeAllItems();
                for (int i = 0; i < 8; i++) {
                    if(d[i]==(-1)){
                        bit1_combo.addItem(""+i);
                        bit2_combo.addItem(""+i);
                    }
                }
                break;
            }
        }
    }//GEN-LAST:event_controlport_comboItemStateChanged

    private void mode_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mode_comboItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            //    JOptionPane.showMessageDialog(rootPane,"state");
            String port=""+((mode_combo.getSelectedItem().toString()).toCharArray())[0];

            if(port.equals("4"))
            toggleVisible(true);
            else if(port.equals("8"))
            toggleVisible(false);

            Boolean pa=true,pb=true,pc=true,pd=true;
            dataport_combo.removeAllItems();
            int ca=0,cb=0,cc=0,cd=0;//counts
            for (int i = 0; i < 8; i++) {
                if(a[i]==(-1) && pa){
                    ca++;
                    if(port.equals("4")){
                        if(ca==4)
                        {
                            pa=false;
                            dataport_combo.addItem("A");
                        }
                    }
                    else if(port.equals("8")){
                        if(ca==8)
                        {
                            pa=false;
                            dataport_combo.addItem("A");
                        }
                    }
                }
                if(b[i]==(-1) && pb){
                    cb++;
                    if(port.equals("4")){
                        if(cb==4)
                        {
                            pb=false;
                            dataport_combo.addItem("B");
                        }
                    }
                    else if(port.equals("8")){
                        if(cb==8)
                        {
                            pb=false;
                            dataport_combo.addItem("B");
                        }
                    }
                } if(c[i]==(-1) && pc){
                    cc++;
                    if(port.equals("4")){
                        if(cc==4)
                        {
                            pc=false;
                            dataport_combo.addItem("C");
                        }
                    }
                    else if(port.equals("8")){
                        if(cc==8)
                        {
                            pc=false;
                            dataport_combo.addItem("C");
                        }
                    }
                } if(d[i]==(-1) && pd){
                    cd++;
                    if(port.equals("4")){
                        if(cd==4)
                        {
                            pd=false;
                            dataport_combo.addItem("D");

                        }
                    }
                    else if(port.equals("8")){
                        if(cd==8)
                        {
                            pd=false;
                            dataport_combo.addItem("D");
                        }
                    }
                }
            }

        }
    }//GEN-LAST:event_mode_comboItemStateChanged

    private void mode_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mode_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mode_comboActionPerformed

    private void dataport_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dataport_comboItemStateChanged
        // TODO add your handling code here:
        //sads
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String port=""+((dataport_combo.getSelectedItem().toString()).toCharArray())[0];
            switch(port){
                case "A":
                D0.removeAllItems();
                D1.removeAllItems();
                D2.removeAllItems();
                D3.removeAllItems();
                for (int j = 0; j < 8; j++) {
                    if(a[j]==(-1)){
                        D0.addItem(""+j);
                        D1.addItem(""+j);
                        D2.addItem(""+j);
                        D3.addItem(""+j);
                    }
                }
                break;
                case "B":
                D0.removeAllItems();
                D1.removeAllItems();
                D2.removeAllItems();
                D3.removeAllItems();
                for (int j = 0; j < 8; j++) {
                    if(b[j]==(-1)){
                        D0.addItem(""+j);
                        D1.addItem(""+j);
                        D2.addItem(""+j);
                        D3.addItem(""+j);
                    }
                }
                break;
                case "C":
                D0.removeAllItems();
                D1.removeAllItems();
                D2.removeAllItems();
                D3.removeAllItems();
                for (int j = 0; j < 8; j++) {
                    if(c[j]==(-1)){
                        D0.addItem(""+j);
                        D1.addItem(""+j);
                        D2.addItem(""+j);
                        D3.addItem(""+j);
                    }
                }
                break;
                case "D":
                D0.removeAllItems();
                D1.removeAllItems();
                D2.removeAllItems();
                D3.removeAllItems();
                for (int j = 0; j < 8; j++) {
                    if(d[j]==(-1)){
                        D0.addItem(""+j);
                        D1.addItem(""+j);
                        D2.addItem(""+j);
                        D3.addItem(""+j);
                    }
                }
                break;
            }
        }
    }//GEN-LAST:event_dataport_comboItemStateChanged

    private void D1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_D1ActionPerformed

    private void Save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_btnActionPerformed
        // TODO add your handling code here:
        int mode=Integer.parseInt(""+mode_combo.getSelectedItem());
        char data='A';
        char control='A';
        int rs=0,e=0;
        if(mode==4)
        {
        }else if(mode==8)
        {
            data=((dataport_combo.getSelectedItem().toString()).toCharArray())[0];
            control=((controlport_combo.getSelectedItem().toString()).toCharArray())[0];
            rs=Integer.parseInt(""+bit1_combo.getSelectedItem());
            e=Integer.parseInt(""+bit2_combo.getSelectedItem());

        }
        if(rs==e){
            jLabel1.setText("Select Diffirent bits for Rs and E ");
        }else if((""+data).equals(""+control)){
            jLabel1.setText("Control and Data port can't be same.");
        }else{
            l.setMode(mode);
            l.setData_port(data);
            l.setControl_port(control);
            l.setRS(rs);
            l.setE(e);
            pf.setcomponent(l,oldLcd);
            this.dispose();
        }

    }//GEN-LAST:event_Save_btnActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(setLcdProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(setLcdProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(setLcdProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(setLcdProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setLcdProperties dialog = new setLcdProperties(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox D0;
    private javax.swing.JLabel D0_label;
    private javax.swing.JComboBox D1;
    private javax.swing.JLabel D1_label;
    private javax.swing.JComboBox D2;
    private javax.swing.JLabel D2_label;
    private javax.swing.JComboBox D3;
    private javax.swing.JLabel D3_label;
    private javax.swing.JLabel RS_E_label;
    private javax.swing.JLabel RS_E_label1;
    private javax.swing.JButton Save_btn;
    private javax.swing.JComboBox bit1_combo;
    private javax.swing.JComboBox bit2_combo;
    private javax.swing.JLabel control_port_label;
    private javax.swing.JComboBox controlport_combo;
    private javax.swing.JLabel data_port_label;
    private javax.swing.JComboBox dataport_combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lcd_property_title_label;
    private javax.swing.JComboBox mode_combo;
    private javax.swing.JLabel mode_hint_label;
    private javax.swing.JLabel mode_label;
    // End of variables declaration//GEN-END:variables
}
