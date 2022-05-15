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
public class setStepperProperties extends javax.swing.JDialog {

    stepperMotor l,oldstep;
    PanelFrontEndView pf; 
    int []a,b,c,d;
    public setStepperProperties(java.awt.Frame parent, boolean modal,stepperMotor l,PanelFrontEndView pf,int [] a,int [] b,int [] c,int [] d) {
        super(parent, modal);
        initComponents();
        this.l=l;
        this.pf=pf;
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        availablePort(a, b, c, d); 
        oldstep=new stepperMotor();
        oldstep.setpins(l.getpins());
        oldstep.setPort(l.getPort());
        
        
    }

    private setStepperProperties(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void availablePort(int [] a,int [] b,int [] c,int [] d){
        try {
            Boolean pa=true,pb=true,pc=true,pd=true;
            int ca=0,cb=0,cc=0,cd=0;
            for (int i = 0; i < 7; i++) {
                if(a[i]==(-1) && pa){
                    ca++;
                    if(ca==4){
                        port_combo.addItem("A");
                        pa=false;}
                }
                if(b[i]==(-1) && pb){
                    cb++;
                    if(cb==4){
                        port_combo.addItem("B");
                        pb=false;}
                }
                if(c[i]==(-1) && pc){
                    cc++;
                    if(cc==4){
                        port_combo.addItem("C");
                        pc=false;}
                }
                if(d[i]==(-1) && pd){
                    cd++;
                    if(cd==4){
                        port_combo.addItem("D");
                        pd=false;}
                }
            }
        } catch (Exception e) { JOptionPane.showMessageDialog(rootPane,"available excep : "+e);       
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        stepper_set_btn = new javax.swing.JButton();
        port_combo = new javax.swing.JComboBox();
        D0 = new javax.swing.JComboBox();
        D3 = new javax.swing.JComboBox();
        D1_label = new javax.swing.JLabel();
        D2 = new javax.swing.JComboBox();
        D2_label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        D0_label = new javax.swing.JLabel();
        D3_label = new javax.swing.JLabel();
        D1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Port");

        stepper_set_btn.setText("Set");
        stepper_set_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stepper_set_btnActionPerformed(evt);
            }
        });

        port_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                port_comboItemStateChanged(evt);
            }
        });
        port_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                port_comboActionPerformed(evt);
            }
        });

        D0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D0ActionPerformed(evt);
            }
        });

        D3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D3ActionPerformed(evt);
            }
        });

        D1_label.setText("D1");

        D2_label.setText("D2");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Set Stepper Properties");

        D0_label.setText("D0");

        D3_label.setText("D3");

        D1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(port_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(D0_label)
                                .addComponent(D2_label))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(D0, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(D3_label)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(D1_label)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stepper_set_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(port_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(D2_label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(D0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(D0_label))
                            .addComponent(D1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(D1_label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(D3_label, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stepper_set_btn)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addContainerGap(32, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stepper_set_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stepper_set_btnActionPerformed
        // TODO add your handling code here:
        char port=((port_combo.getSelectedItem().toString()).toCharArray())[0];
        int [] p=new int[4];
        p[0]=Integer.parseInt(D0.getSelectedItem().toString());
        p[1]=Integer.parseInt(D1.getSelectedItem().toString());
        p[2]=Integer.parseInt(D2.getSelectedItem().toString());
        p[3]=Integer.parseInt(D3.getSelectedItem().toString());
        if(!(p[0]==p[1] || p[0]==p[2] ||  p[0]==p[3] ||
           p[1]==p[2] || p[1]==p[3] ||  p[2]==p[3] )){
            l.setPort(port);
            l.setpins(p);
            pf.setcomponent(l,oldstep);
            this.dispose();
        }else{
            jLabel3.setText("Select Distinct Bits");
        }
    }//GEN-LAST:event_stepper_set_btnActionPerformed

    private void port_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_port_comboItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            char port=((port_combo.getSelectedItem().toString()).toCharArray())[0];
            D0.removeAllItems();
            D1.removeAllItems();
            D2.removeAllItems();
            D3.removeAllItems();
            switch(port){
                case 'A':
                for (int i = 0; i <8; i++) {
                    if(a[i]==(-1))
                    {
                        D0.addItem(""+i);
                        D1.addItem(""+i);
                        D2.addItem(""+i);
                        D3.addItem(""+i);
                    }
                }
                break;
                case 'B':
                for (int i = 0; i <8; i++) {
                    if(b[i]==(-1))
                    {
                        D0.addItem(""+i);
                        D1.addItem(""+i);
                        D2.addItem(""+i);
                        D3.addItem(""+i);
                    }
                }
                break;
                case 'C':
                for (int i = 0; i <8; i++) {
                    if(c[i]==(-1))
                    {
                        D0.addItem(""+i);
                        D1.addItem(""+i);
                        D2.addItem(""+i);
                        D3.addItem(""+i);
                    }
                }
                break;
                case 'D':
                for (int i = 0; i <8; i++) {
                    if(d[i]==(-1))
                    {
                        D0.addItem(""+i);
                        D1.addItem(""+i);
                        D2.addItem(""+i);
                        D3.addItem(""+i);
                    }
                }
                break;
            }
        }
    }//GEN-LAST:event_port_comboItemStateChanged

    private void port_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_port_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_port_comboActionPerformed

    private void D0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_D0ActionPerformed

    private void D3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_D3ActionPerformed

    private void D1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_D1ActionPerformed

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
            java.util.logging.Logger.getLogger(setStepperProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(setStepperProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(setStepperProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(setStepperProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setStepperProperties dialog = new setStepperProperties(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox port_combo;
    private javax.swing.JButton stepper_set_btn;
    // End of variables declaration//GEN-END:variables
}
