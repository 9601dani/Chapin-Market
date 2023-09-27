/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.danimo.chapin.market.view;

import com.danimo.chapin.market.daoImpl.BodegaDaoImpl;
import com.danimo.chapin.market.daoImpl.EmpleadoDaoImpl;
import com.danimo.chapin.market.daoImpl.ProductoDaoImpl;
import com.danimo.chapin.market.model.Bodega;
import com.danimo.chapin.market.model.Empleado;
import com.danimo.chapin.market.model.Producto;
import org.postgresql.gss.GSSOutputStream;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import static com.danimo.chapin.market.enums.Sucursal.getIdSucursal;

/**
 *
 * @author danimo
 */
public class IngresarABodegaView extends javax.swing.JInternalFrame {

    private int id_empleado;
    /**
     * Creates new form IngresarABodegaView
     */
    public IngresarABodegaView(int id) throws PropertyVetoException {
        initComponents();
        this.setMaximum(true);
        this.setResizable(true);
        this.obtenerNombreProductos();
        this.id_empleado= id;
    }

    public void obtenerNombreProductos(){
        // TODO obtener el nombre de los productos y mostrarlos en un combobox
        ArrayList<String> nombres = new ArrayList<>();
        ProductoDaoImpl productoDaoImpl = new ProductoDaoImpl();
        nombres = productoDaoImpl.obtenerNombres();
        //TODO mostrar los nombres en el combobox
        for (String nombre: nombres) {
            jComboBox1.addItem(nombre);
        }
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Ingresar Productos a Bodega");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 39, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Producto:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 370, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("Cantidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 130, 30));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 370, 30));

        jButton1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton1.setText("Guardar en bodega");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, 320, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO vere si existe el producto en bodega de sucursal para actualizarlo, y si no hago un nuevo registro en mi entidad bodega:
        String name_product = jComboBox1.getSelectedItem().toString();
        int cantidad=0;
        cantidad = Integer.parseInt(jTextField1.getText());
        if(cantidad <= 0){
            JOptionPane.showMessageDialog(null,"La cantidad debe ser mayor a 0, campo vacio");
        }else{

            //consulto mi empleado, para saber en que sucursal estoy
            Empleado empleado = new EmpleadoDaoImpl().obtenerPorId(this.id_empleado);
            BodegaDaoImpl bodegaDaoImpl = new BodegaDaoImpl();
            Producto producto = new BodegaDaoImpl().obtenerProductoAdmin(name_product);
            Bodega producto_in_bodega= bodegaDaoImpl.obtenerProducto( getIdSucursal(empleado.getSucursal_id()),producto.getCodigo_producto());
            System.out.println("id_sucursal: "+getIdSucursal(empleado.getSucursal_id())+" name_product: "+name_product);
            System.out.println("producto_in_bodega: "+producto_in_bodega);
            if (producto_in_bodega != null){
                //actualizo la cantidad
                producto_in_bodega.setCantidad(producto_in_bodega.getCantidad()+cantidad);
                bodegaDaoImpl.actualizar(producto_in_bodega);
                JOptionPane.showMessageDialog(null,"Se actualizo la cantidad del producto en bodega");
            }else{
                //creo un nuevo registro, y primero voy a buscar el producto en la bd
                System.out.println("entre aqui en el else");
                System.out.println("producto "+ producto);
                Bodega bodega = new Bodega(getIdSucursal(empleado.getSucursal_id()),producto.getCodigo_producto(),cantidad);
                bodegaDaoImpl.insertar(bodega);
                JOptionPane.showMessageDialog(null,"Se agrego el producto a bodega");
            }
            this.jTextField1.setText("");
        }


        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
