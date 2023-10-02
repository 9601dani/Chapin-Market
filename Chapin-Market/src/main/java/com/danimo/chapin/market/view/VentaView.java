/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.danimo.chapin.market.view;

import com.danimo.chapin.market.daoImpl.*;
import com.danimo.chapin.market.enums.CategoriaTarjeta;
import com.danimo.chapin.market.enums.Rol;
import com.danimo.chapin.market.handlers.MLogin;
import com.danimo.chapin.market.model.*;

import java.beans.PropertyVetoException;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static com.danimo.chapin.market.enums.CategoriaTarjeta.datoCategoriaTarjeta;
import static com.danimo.chapin.market.enums.CategoriaTarjeta.getNombreCategoriaTarjeta;
import static com.danimo.chapin.market.enums.Rol.getIdRol;
import static com.danimo.chapin.market.enums.Rol.getRol;
import static com.danimo.chapin.market.enums.Sucursal.*;

/**
 *
 * @author danimo
 */
public class VentaView extends javax.swing.JInternalFrame {

    private int id_empleado;
    private Empleado empleado_general;

    private static JPopupMenu sugerencias_popup;
    private double total_venta = 0;
    private VentaManejador venta_manejador;
    /**
     * Creates new form VentaView
     */
    public VentaView(int id) throws PropertyVetoException {
        initComponents();
        this.setMaximum(true);
        this.setResizable(true);
        this.id_empleado=id;
        this.empleado_general = new EmpleadoDaoImpl().obtenerPorId(this.id_empleado);
        this.txt_name_empleado.setText(this.empleado_general.getNombre() + " " + this.empleado_general.getApellido());
        this.txt_sucursal.setText(getStringSucursal((this.empleado_general.getSucursal_id())));
        txt_cantidad.setModel(new SpinnerNumberModel(0,0, Integer.MAX_VALUE,1));
        this.setearModeloTabla();
        this.llenarComboBoxProductos();
        this.venta_manejador = new VentaManejador();
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
        txt_sucursal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_name_empleado = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        button_agregar_lista = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txt_cantidad = new javax.swing.JSpinner();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        buscar_cliente = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_puntos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        categoria_txt = new javax.swing.JTextField();
        button_update_cliente = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        button_pago = new javax.swing.JButton();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Sucursal:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, -1));

        txt_sucursal.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(txt_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 260, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("Empleado:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        txt_name_empleado.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(txt_name_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 260, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Producto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("Cantidad");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel5.setText("Precio Unitario");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jTextField3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTextField3.setEnabled(false);
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 260, -1));

        button_agregar_lista.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        button_agregar_lista.setText("Agregar");
        button_agregar_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_agregar_listaActionPerformed(evt);
            }
        });
        jPanel1.add(button_agregar_lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 120, 50));

        jButton2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 120, 50));

        txt_cantidad.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel1.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 260, 40));

        jComboBox1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 250, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 500, 440));

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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 870, 270));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setText("Subtotal:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        txt_total.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_total.setEnabled(false);
        jPanel2.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 280, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 430, 430, 170));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 230, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setText("Nombre");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        buscar_cliente.setText("Buscar");
        buscar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_clienteActionPerformed(evt);
            }
        });
        jPanel3.add(buscar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 100, 30));

        jTextField2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextField2.setEnabled(false);
        jPanel3.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 230, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setText("Nit");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel9.setText("Categoria Tarjeta");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        txt_puntos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_puntos.setEnabled(false);
        jPanel3.add(txt_puntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 230, 30));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setText("Puntos");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        categoria_txt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        categoria_txt.setEnabled(false);
        jPanel3.add(categoria_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 250, 30));

        button_update_cliente.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        button_update_cliente.setText("Modificar Cliente");
        button_update_cliente.setEnabled(false);
        button_update_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_update_clienteActionPerformed(evt);
            }
        });
        jPanel3.add(button_update_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 210, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 440, 520, 430));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel7.setText("Datos Cliente");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, -1, -1));

        button_pago.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        button_pago.setText("Proceder al Pago");
        button_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_pagoActionPerformed(evt);
            }
        });
        getContentPane().add(button_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 670, 260, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setearModeloTabla(){
        // TODO setear el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio Unitario");
        jTable1.setModel(modelo);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO solamente limpiare los campos:
        jComboBox1.setSelectedIndex(0);
        jTextField3.setText("");
        txt_cantidad.setValue(0);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume(); // Consume el evento si el carácter no es un número
            }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void button_agregar_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_agregar_listaActionPerformed
        // TODO: aqui agregare los productos en una lista, la cual se mostrara en la tabla
        ArrayList<Producto> productos = new ArrayList<>();
        String nombre_producto = (String) jComboBox1.getSelectedItem();
        int cantidad = (int) txt_cantidad.getValue();
        double precio_unitario = Double.parseDouble(jTextField3.getText());
        Producto producto = new ProductoDaoImpl().obtenerPorNombre(nombre_producto);
        if (producto != null){
            if(cantidad==0){
                JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad mayor a 0");
                return;
            }
            total_venta=total_venta+(double) (cantidad*precio_unitario);
            txt_total.setText(Double.toString(total_venta));
            // TODO si existe el producto lo agrego a la lista
            productos.add(producto);

            //TODO: verifico si el producto ya esta en la lista, para hacer el update
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                int codigo_producto = (int) jTable1.getValueAt(i, 0);
                if(codigo_producto==producto.getCodigo_producto()){
                    int cantidad_actual = (int) jTable1.getValueAt(i, 2);
                    jTable1.setValueAt(cantidad_actual+cantidad, i, 2);
                    //TODO: limpio los campos
                    jComboBox1.setSelectedIndex(0);
                    jTextField3.setText("");
                    txt_cantidad.setValue(0);
                    return;
                }
            }
            // TODO agrego el producto a la tabla
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            Object[] fila = new Object[4];
            fila[0] = producto.getCodigo_producto();
            fila[1] = producto.getNombre();
            fila[2] = cantidad;
            fila[3] = precio_unitario;
            modelo.addRow(fila);
            jTable1.setModel(modelo);
            jComboBox1.setSelectedIndex(0);
            jTextField3.setText("");
            txt_cantidad.setValue(0);


        }else{
            // TODO si no existe el producto lo agrego a la lista
            JOptionPane.showMessageDialog(null, "No existe el producto");
        }

    }//GEN-LAST:event_button_agregar_listaActionPerformed

    private void buscar_clienteActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_buscar_clienteActionPerformed
        // TODO buscare al cliente por su nit, y si existe lo mostrare en los campos de texto, si no existe mostrare un formulario para ingresar sus datos a la bd
        String nit = (jTextField1.getText());
        // TODO buscar al cliente por su nit
        Cliente cliente = new ClienteDaoImpl().obtenerPorNit(nit);
        System.out.println(cliente);
        if (cliente != null){
            //TODO: aqui habilito el boton de modificar cliente
            button_update_cliente.setEnabled(true);
            // TODO si existe lo muestro en los campos de texto
            jTextField2.setText(cliente.getNombre());
            txt_puntos.setText(Integer.toString(cliente.getNo_puntos()));
            Tarjeta tarjeta = new TarjetaDaoImpl().obtenerPorCliente(nit);
            if(tarjeta!=null) {
                categoria_txt.setText(getNombreCategoriaTarjeta(tarjeta.getCodigo_categoria()));
            }else{
                categoria_txt.setText("No tiene tarjeta");
            }
        }else{
            // TODO si no existe muestro un formulario para ingresar sus datos a la bd
            try{
                JOptionPane.showMessageDialog(null, "No existe el cliente, debera ingresar sus datos");
                NewClienteView newClienteView = new NewClienteView();
                newClienteView.setVisible(true);
                Main.MainP.add(newClienteView);
                newClienteView.moveToFront();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        // TODO si existe lo muestro en los campos de texto
        // TODO si no existe muestro un formulario para ingresar sus datos a la bd
    }//GEN-LAST:event_buscar_clienteActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO aqui luego de que el usuario seleccione el producto, lo ire a buscar a la bd para poner el precio unitario:
        String nombre_producto = (String) jComboBox1.getSelectedItem();
        Producto producto = new ProductoDaoImpl().obtenerPorNombre(nombre_producto);
        if (producto != null){
            // TODO si existe el producto lo agrego a la lista
            jTextField3.setText(Double.toString(producto.getPrecio()));
            //TODO: aqui seteo que el maximo numero del spinner sea la cantidad de productos en estanteria, obteniendo el producto de la estanteria
            Estanteria estanteria = new EstanteriaDaoImpl().obtenerProducto(getIdSucursal(empleado_general.getSucursal_id()), producto.getCodigo_producto());
            txt_cantidad.setModel(new SpinnerNumberModel(0,0, estanteria.getCantidad(),1));
        }else{
            // TODO si no existe el producto lo agrego a la lista
            JOptionPane.showMessageDialog(null, "No existe el producto");
        }

        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void button_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_pagoActionPerformed
        // TODO aqui procedere al pago de la venta, y actualizare los puntos del cliente
        // TODO: tengo que verificar que el campo del nit no este vacio
        String nit = (jTextField1.getText());
        Double total = Double.parseDouble(txt_total.getText());
        if (jTextField1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar el nit del cliente");
        }else{
            int puntos_a_utilizar=0;
            if(nit.equals("CF") || Integer.parseInt(txt_puntos.getText()) ==0){
                JOptionPane.showMessageDialog(null,"El cliente no tiene puntos disponibles");
            }else {
                puntos_a_utilizar= Integer.parseInt(JOptionPane.showInputDialog("Ingrese puntos a utilizar"));
            }
            int puntos_cliente = Integer.parseInt(txt_puntos.getText());

            if(puntos_a_utilizar >0){
                //TODO: actualizo los puntos del cliente
                if(puntos_a_utilizar > puntos_cliente){
                    JOptionPane.showMessageDialog(null, "El cliente no tiene suficientes puntos");
                    return;
                }else{
                    System.out.println();
                    puntos_cliente = puntos_cliente - puntos_a_utilizar;
                    new ClienteDaoImpl().actualizarPuntos(nit, puntos_cliente);
                }
            }
            if(this.venta_manejador.verificarPuntos(puntos_cliente, puntos_a_utilizar)){
                //TODO: abstraigo toda la lista de productos a un arraylist
                ArrayList<Producto> productos = new ArrayList<>();
                //lista para guardar la cantidad a vender de cada producto
                ArrayList<Integer> cantidades = new ArrayList<>();
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    int codigo_producto = (int) jTable1.getValueAt(i, 0);
                    Producto producto = new ProductoDaoImpl().obtenerPorId(codigo_producto);
                    productos.add(producto);
                    int cantidad = (int) jTable1.getValueAt(i, 2);
                    cantidades.add(cantidad);
                }
                //TODO: obtenemos el total
                double total_venta = Double.parseDouble(txt_total.getText()) - puntos_a_utilizar;
                if(nit.equals("CF")){
                    new VentaDaoImpl().insertar(new Venta(LocalDate.now() , Double.parseDouble(txt_total.getText()), puntos_a_utilizar, total_venta, nit, this.empleado_general.getId()));
                    Venta venta = new VentaDaoImpl().obtenerUltimaVenta();
                    System.out.println(venta.toString());
                    //TODO: Guardare los productos vendidos y actualizare la cantidad en estanteria

                    for (int i = 0; i < productos.size(); i++) {
                        Producto producto = productos.get(i);
                        int cantidad = cantidades.get(i);
                        new DetalleVentaDaoImpl().insertar(new DetalleVenta(venta.getCodigo_venta(), producto.getCodigo_producto(), cantidad));
                        new EstanteriaDaoImpl().actualizarCantidad(getIdSucursal(this.empleado_general.getSucursal_id()), producto.getCodigo_producto(), cantidad);
                    }
                    JOptionPane.showMessageDialog(null, "Venta realizada con exito");
                    this.dispose();
                }else {
                    Tarjeta tarjeta = new TarjetaDaoImpl().obtenerPorCliente(nit);
                    if (tarjeta == null) {
                        //TODO: registro nueva tarjeta
                        new TarjetaDaoImpl().insertar(new Tarjeta(nit, CategoriaTarjeta.COMUN, Double.parseDouble(txt_total.getText())));
                        JOptionPane.showMessageDialog(null, "Se ha registrado una nueva tarjeta al cliente con nit: "+nit);
                    }else{
                        double nuevo_tt= tarjeta.getTotal_gastado()+total_venta;
                        new TarjetaDaoImpl().actualizar(new Tarjeta(tarjeta.getNit_cliente(), tarjeta.getCodigo_categoria(), nuevo_tt));
                    }
                    //TODO: guardo la venta en la bd
                    new VentaDaoImpl().insertar(new Venta(LocalDate.now() , Double.parseDouble(txt_total.getText()), puntos_a_utilizar, total_venta, nit, this.empleado_general.getId()));
                    //TODO: le sumo los puntos al cliente
                    if (total_venta >= 200){
                        int dato = (int) (total_venta/200);
                        new ClienteDaoImpl().actualizarPuntos(nit, puntos_cliente + (dato * datoCategoriaTarjeta(new TarjetaDaoImpl().obtenerPorCliente(nit).getCodigo_categoria())));
                    }
                    //TODO: verifico si ya tiene una tarjeta asociada
                    //TODO: obtendre la ultima venta
                    Venta venta = new VentaDaoImpl().obtenerUltimaVenta();
                    System.out.println(venta.toString());
                    //TODO: Guardare los productos vendidos y actualizare la cantidad en estanteria

                    for (int i = 0; i < productos.size(); i++) {
                        Producto producto = productos.get(i);
                        int cantidad = cantidades.get(i);
                        new DetalleVentaDaoImpl().insertar(new DetalleVenta(venta.getCodigo_venta(), producto.getCodigo_producto(), cantidad));
                        new EstanteriaDaoImpl().actualizarCantidad(getIdSucursal(this.empleado_general.getSucursal_id()), producto.getCodigo_producto(), cantidad);
                    }
                    //TODO: obtengo el cliente para ver sus puntos
                    //TODO: sumo los puntos del cliente
                    JOptionPane.showMessageDialog(null, "Venta realizada con exito");
                    this.dispose();
                }
            }



        }
    }//GEN-LAST:event_button_pagoActionPerformed

    private void button_update_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_update_clienteActionPerformed
        // TODO add your handling code here:
        String nit = (jTextField1.getText());
        Cliente cliente = new ClienteDaoImpl().obtenerPorNit(nit);
        if (cliente != null){

            //TODO: tiene que ingresar usuario y contraseña del admin
            String usuario = JOptionPane.showInputDialog("Ingrese usuario de un administrador");
            String password = JOptionPane.showInputDialog("Ingrese contraseña del usuario");
            //TODO: verifico que el usuario y contraseña sean de un admin A LA BD
            MLogin mLogin = new MLogin();
            try {
                int cliente1 = mLogin.validarUsuario(usuario, password);
                if(cliente1 == -1){
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    return;
                }else{
                    //TODO: si es admin, procedo a actualizar los datos del cliente
                    if(getIdRol(new EmpleadoDaoImpl().obtenerPorId(cliente1).getRol_id())!=(4)){
                        JOptionPane.showMessageDialog(null, "El usuario ingresado no es un administrador");
                        return;
                    }
                    //TODO: llamo al formulario para actualizar los datos del cliente
                    try{
                        UpdateClienteView updateClienteView = new UpdateClienteView(cliente);
                        updateClienteView.setVisible(true);
                        Main.MainP.add(updateClienteView);
                        updateClienteView.moveToFront();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }


        }
        
    }//GEN-LAST:event_button_update_clienteActionPerformed


    private void llenarComboBoxProductos(){
        // TODO llenar el combobox con los productos de la sucursal del empleado
        ArrayList<Estanteria> productos = new EstanteriaDaoImpl().obtenerProductosEstanterias(getIdSucursal(this.empleado_general.getSucursal_id()));
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (Estanteria producto: productos){
            modelo.addElement(new ProductoDaoImpl().obtenerPorId(producto.getProducto()).getNombre());
        }
        jComboBox1.setModel(modelo);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar_cliente;
    private javax.swing.JButton button_agregar_lista;
    private javax.swing.JButton button_pago;
    private javax.swing.JButton button_update_cliente;
    private javax.swing.JTextField categoria_txt;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JSpinner txt_cantidad;
    private javax.swing.JLabel txt_name_empleado;
    private javax.swing.JTextField txt_puntos;
    private javax.swing.JLabel txt_sucursal;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
