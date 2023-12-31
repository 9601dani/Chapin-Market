/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.danimo.chapin.market.view;

import com.danimo.chapin.market.daoImpl.ProductoDaoImpl;
import com.danimo.chapin.market.model.Producto;

import javax.swing.*;
import java.beans.PropertyVetoException;

/**
 *
 * @author danimo
 */
public class NewProductView extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewProductView
     */
    public NewProductView() throws PropertyVetoException {
        initComponents();
        this.setMaximum(true);
        this.setResizable(true);
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
        descr_producto_txt = new javax.swing.JTextField();
        name_producto_txt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        price_producto_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        marca_producto_txt = new javax.swing.JTextField();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Ingreso de Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Marca");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));
        getContentPane().add(descr_producto_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 290, 30));
        getContentPane().add(name_producto_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 290, 30));

        jButton1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 200, 60));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("Precio");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, -1, -1));
        getContentPane().add(price_producto_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 290, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel5.setText("Descripcion");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, -1, -1));
        getContentPane().add(marca_producto_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 290, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO verificare que no hayan campos vacios y mandare a llamar al metodo insertar de ProductoDaoImpl:
        String nombre = "@";
        Double precio = -1.0;
        String descripcion= "@";
        String marca="@";
        nombre = name_producto_txt.getText();
        precio = Double.parseDouble(price_producto_txt.getText());
        descripcion =  descr_producto_txt.getText();
        marca = marca_producto_txt.getText();

        if (descr_producto_txt.getText().isEmpty() || name_producto_txt.getText().isEmpty() || nombre.equals("@") || precio.equals(-1.0) || descripcion.equals("@") || marca.equals("@")) {
            JOptionPane.showMessageDialog(null, "No se puede guardar existen datos vacios");
        } else {
            //limpiare los campos:
            descr_producto_txt.setText("");
            name_producto_txt.setText("");
            price_producto_txt.setText("");
            marca_producto_txt.setText("");
            ProductoDaoImpl productoDaoImpl = new ProductoDaoImpl();
            productoDaoImpl.insertar(new Producto(nombre, precio, descripcion, marca));
        }


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField descr_producto_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField marca_producto_txt;
    private javax.swing.JTextField name_producto_txt;
    private javax.swing.JTextField price_producto_txt;
    // End of variables declaration//GEN-END:variables
}
