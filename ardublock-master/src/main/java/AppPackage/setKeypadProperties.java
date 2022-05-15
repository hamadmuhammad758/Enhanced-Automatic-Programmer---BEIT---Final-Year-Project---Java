/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AppPackage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class setKeypadProperties extends javax.swing.JDialog {

    PanelFrontEndView pf;
    Keypad k,oldkey;
    int []a,b,c,d;
    
    public setKeypadProperties(java.awt.Frame parent, boolean modal,Keypad k,PanelFrontEndView pf,int [] a,int [] b,int [] c,int [] d) {
        super(parent, modal);
        initComponents();
    
        this.pf = pf;
        this.k = k;
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        oldkey=new Keypad();
        oldkey.setPort(k.getPort());

        availablePort(a, b, c, d);
    }

    private setKeypadProperties(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void availablePort(int [] a,int [] b,int [] c,int [] d){
        try {
            Boolean pa=true,pb=true,pc=true,pd=true;
            int ca=0,cb=0,cc=0,cd=0;
            for (int i = 0; i < 7; i++) {
                if(a[i]==(-1) && pa){
                    ca++;
                    if(ca==7){
                        port_combo.addItem("A");
                        pa=false;}
                }
                if(b[i]==(-1) && pb){
                    cb++;
                    if(cb==7){
                        port_combo.addItem("B");
                        pb=false;}
                }
                if(c[i]==(-1) && pc){
                    cc++;
                    if(cc==7){
                        port_combo.addItem("C");
                        pc=false;}
                }
                if(d[i]==(-1) && pd){
                    cd++;
                    if(cd==7){
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

        jLabel1 = new javax.swing.JLabel();
        port_combo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        keypad_save_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Set Keypad Properties");

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

        jLabel2.setText("Port");

        keypad_save_btn.setText("Set");
        keypad_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keypad_save_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(keypad_save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(port_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(port_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(keypad_save_btn)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void port_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_port_comboItemStateChanged

    }//GEN-LAST:event_port_comboItemStateChanged

    private void port_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_port_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_port_comboActionPerformed

    private void keypad_save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keypad_save_btnActionPerformed
        k.setPort(((port_combo.getSelectedItem().toString()).toCharArray())[0]);
        pf.setcomponent(k,oldkey);
        this.dispose();
    }//GEN-LAST:event_keypad_save_btnActionPerformed

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
            java.util.logging.Logger.getLogger(setKeypadProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(setKeypadProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(setKeypadProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(setKeypadProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setKeypadProperties dialog = new setKeypadProperties(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton keypad_save_btn;
    private javax.swing.JComboBox port_combo;
    // End of variables declaration//GEN-END:variables
}
