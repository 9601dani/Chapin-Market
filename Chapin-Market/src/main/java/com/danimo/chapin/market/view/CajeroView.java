/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.danimo.chapin.market.view;

import com.danimo.chapin.market.daoImpl.EmpleadoDaoImpl;
import com.danimo.chapin.market.daoImpl.EstanteriaDaoImpl;
import com.danimo.chapin.market.daoImpl.ProductoDaoImpl;
import com.danimo.chapin.market.model.Empleado;
import com.danimo.chapin.market.model.Estanteria;
import com.danimo.chapin.market.model.Producto;

import javax.swing.table.DefaultTableModel;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import static com.danimo.chapin.market.enums.Sucursal.getIdSucursal;

/**
 *
 * @author danimo
 */
public class CajeroView extends javax.swing.JInternalFrame {
    private int id_empleado;
    /**
     * Creates new form VendedorView
     */
    public CajeroView(int id) throws PropertyVetoException {
        initComponents();
        this.setMaximum(true);
        this.setResizable(true);
        this.id_empleado= id;
        mostrarProductoEstanteriaSucursal();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new javax.swing.JLabel();
        name_vendedor_txt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        label1.setText("Bienvenido Cajero: ");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 38, -1, -1));

        name_vendedor_txt.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(name_vendedor_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 340, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Productos en estanteria:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 1420, 510));

        jMenu1.setText("Ingreso");

        jMenuItem2.setText("Ingresar Venta");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cerrar");

        jMenuItem1.setText("Cerrar Sesion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Main.MainP.removeAll();
        Main.MainP.repaint();
        Login login = null;
        try {
            login = new Login();
            login.setVisible(true);
            Main.MainP.add(login);
            Main.MainP.moveToFront(login);

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO aqui enviare a la ventana de venta:
        VentaView ventaView = null;
        try {
            ventaView = new VentaView(this.id_empleado);
            ventaView.setVisible(true);
            Main.MainP.add(ventaView);
            Main.MainP.moveToFront(ventaView);

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void mostrarProductoEstanteriaSucursal(){
        // TODO mostrar los productos en la estanteria de la sucursal del cajero
        try{
            ArrayList<Estanteria> productos_estanteria = new EstanteriaDaoImpl().obtenerProductosEstanterias(getIdSucursal(new EmpleadoDaoImpl().obtenerPorId(this.id_empleado).getSucursal_id()));
            ProductoDaoImpl productoDao = new ProductoDaoImpl();
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Precio");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Marca");
            modelo.addColumn("Cantidad");
            modelo.addColumn("No Pasillo");
            for(Estanteria producto: productos_estanteria){
                Producto pro_actu = productoDao.obtenerPorId(producto.getProducto());
                modelo.addRow(new Object[]{
                   pro_actu.getCodigo_producto(),
                   pro_actu.getNombre(),
                   pro_actu.getPrecio(),
                   pro_actu.getDescripcion(),
                   pro_actu.getMarca(),
                   producto.getCantidad(),
                   producto.getNo_pasillo()
                });
            }
            this.jTable1.setModel(modelo);
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label1;
    public static javax.swing.JLabel name_vendedor_txt;
    // End of variables declaration//GEN-END:variables
}
