/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.danimo.chapin.market.view;

import com.danimo.chapin.market.daoImpl.ClienteDaoImpl;
import com.danimo.chapin.market.model.Cliente;

import javax.swing.*;
import java.beans.PropertyVetoException;

/**
 *
 * @author danimo
 */
public class UpdateClienteView extends javax.swing.JInternalFrame {
    private Cliente cliente;
    /**
     * Creates new form UpdateClienteView
     */
    public UpdateClienteView(Cliente cliente) throws PropertyVetoException {
        initComponents();
        this.setMaximum(true);
        this.setResizable(true);
        this.cliente= cliente;
        this.seterDatos();
    }
    
    public void seterDatos(){
        this.txt1.setText(cliente.getNit());
        this.txt2.setText(cliente.getNombre());
        this.txt3.setText(cliente.getDireccion());
        this.txt4.setText(String.valueOf(cliente.getNo_puntos()));
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        txt2 = new javax.swing.JTextField();
        txt3 = new javax.swing.JTextField();
        txt4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        button_actualizar = new javax.swing.JButton();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Puntos:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Nit:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("Direccion:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, -1, -1));

        txt1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt1.setEnabled(false);
        getContentPane().add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, 230, 30));

        txt2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 300, 230, 30));

        txt3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 380, 230, 30));

        txt4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt4.setEnabled(false);
        getContentPane().add(txt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 450, 230, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel5.setText("ACTUALIZAR DATOS CLIENTE");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        button_actualizar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        button_actualizar.setText("ACTUALIZAR");
        button_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(button_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 550, 190, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_actualizarActionPerformed
        // TODO obtengo los datos para crear mi objeto cliente:
        String nit = this.txt1.getText();
        String nombre = this.txt2.getText();
        String direccion = this.txt3.getText();
        int puntos = Integer.parseInt(this.txt4.getText());
        // TODO creo mi objeto cliente:
        Cliente cliente = new Cliente(nit, nombre, direccion, puntos);
        // TODO actualizo mi cliente:
        new ClienteDaoImpl().actualizar(cliente);
        JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente");
        this.dispose();

    }//GEN-LAST:event_button_actualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_actualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    // End of variables declaration//GEN-END:variables
}
