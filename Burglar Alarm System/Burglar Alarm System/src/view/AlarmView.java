/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import esper.Config;
import events.PanicEvent;
import events.PowerEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Youssef Negm
 */
public class AlarmView extends javax.swing.JFrame {

    /**
     * Creates new form KettleView
     */
    public AlarmView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        currentMovementRate = new javax.swing.JTextField();
        onBtn = new javax.swing.JButton();
        PanicBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        currentDoorForce = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        currentWindowPressure = new javax.swing.JTextField();
        offBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Movement Detection:");

        currentMovementRate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        currentMovementRate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        currentMovementRate.setEnabled(false);

        onBtn.setText("Activate System");
        onBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBtnActionPerformed(evt);
            }
        });

        PanicBtn.setBackground(new java.awt.Color(255, 0, 51));
        PanicBtn.setForeground(new java.awt.Color(255, 255, 255));
        PanicBtn.setText("Panic Button");
        PanicBtn.setEnabled(false);
        PanicBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanicBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Doors Detection:");

        currentDoorForce.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        currentDoorForce.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        currentDoorForce.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Windows Detection:");

        currentWindowPressure.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        currentWindowPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        currentWindowPressure.setEnabled(false);

        offBtn1.setText("Deactivate System");
        offBtn1.setEnabled(false);
        offBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PanicBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(offBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(onBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(currentDoorForce, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(221, 221, 221)
                                .addComponent(currentWindowPressure, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(currentMovementRate, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentMovementRate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentDoorForce, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentWindowPressure, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(98, 98, 98)
                .addComponent(onBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(offBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanicBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onBtnActionPerformed
        Config.sendEvent(new PowerEvent(true));
    }//GEN-LAST:event_onBtnActionPerformed

    private void PanicBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanicBtnActionPerformed
        Config.sendEvent(new PanicEvent(true));
    }//GEN-LAST:event_PanicBtnActionPerformed

    private void offBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offBtn1ActionPerformed
        // TODO add your handling code here:
        Config.sendEvent(new PowerEvent(false));

    }//GEN-LAST:event_offBtn1ActionPerformed

    public JTextField getCurrentMovementRate() {
        return currentMovementRate;
    }

    public JTextField getCurrentDoorForce() {
        return currentDoorForce;
    }

    public JTextField getCurrentWindowPressure() {
        return currentWindowPressure;
    }

    public JButton getPanic() {
        return PanicBtn;
    }

    public JButton getOnBtn() {
        return onBtn;
    }

    public JButton getOffBtn1() {
        return offBtn1;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PanicBtn;
    private javax.swing.JTextField currentDoorForce;
    private javax.swing.JTextField currentMovementRate;
    private javax.swing.JTextField currentWindowPressure;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton offBtn1;
    private javax.swing.JButton onBtn;
    // End of variables declaration//GEN-END:variables
}
