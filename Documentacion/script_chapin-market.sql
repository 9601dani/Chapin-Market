/*Create Database*/
CREATE DATABASE chapinmarket;

\c chapinmarket

/*Create Schema*/
CREATE SCHEMA rycp;
CREATE SCHEMA ryce;
CREATE SCHEMA rycc;

/*Create User*/
CREATE USER chapinmarket WITH PASSWORD 'chapinmarket';
GRANT ALL PRIVILEGES ON DATABASE chapinmarket TO chapinmarket;
ALTER USER chapinmarket WITH SUPERUSER;


/*Create Tables*/
CREATE TABLE ryce.sucursal(
    codigo_sucursal SERIAL,
    nombre varchar(50) NOT NULL,
    /*total_obtenido float NOT NULL*/
    PRIMARY KEY (codigo_sucursal)
);

CREATE TABLE ryce.rol(
    codigo_rol SERIAL,
    nombre varchar(50) NOT NULL,
    PRIMARY KEY (codigo_rol)
);

CREATE TABLE ryce.empleado(
    codigo_empleado SERIAL,
    nombre varchar(50) NOT NULL,
    apellido varchar(50) NOT NULL,
    username varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    no_caja int NOT NULL,
    codigo_sucursal int NOT NULL,
    codigo_rol INT NOT NULL,
    PRIMARY KEY (codigo_empleado), /*Aqui podria ser que el username tambien debe ser unico*/
    FOREIGN KEY (codigo_sucursal) REFERENCES ryce.sucursal(codigo_sucursal),
    FOREIGN KEY (codigo_rol) REFERENCES ryce.rol(codigo_rol)
);

CREATE TABLE rycc.categoriatarjeta(
    codigo_categoria SERIAL,
    nombre varchar(50) NOT NULL,
    PRIMARY KEY (codigo_categoria)
);

CREATE TABLE rycc.cliente(
    nit_cliente VARCHAR(50) NOT NULL,
    nombre varchar(250) NOT NULL,
    direccion varchar(50) NOT NULL,
    no_puntos int NOT NULL,
    PRIMARY KEY (nit_cliente)
);

CREATE TABLE rycc.tarjetapuntos(
    nit_cliente VARCHAR(50) NOT NULL,
    codigo_categoria int NOT NULL,
    total_gastado float NOT NULL,
    PRIMARY KEY (nit_cliente),
    FOREIGN KEY (nit_cliente) REFERENCES rycc.cliente(nit_cliente),
    FOREIGN KEY (codigo_categoria) REFERENCES rycc.categoriatarjeta(codigo_categoria)
);

CREATE TABLE rycp.producto(
    codigo_producto SERIAL,
    nombre varchar(50) NOT NULL,
    precio float NOT NULL,
    descripcion varchar(150) NOT NULL,
    marca varchar(50) NOT NULL,
    PRIMARY KEY (codigo_producto)
);

CREATE TABLE rycp.bodega(
    sucursal int NOT NULL,
    producto int NOT NULL,
    cantidad int NOT NULL,
    PRIMARY KEY (sucursal, producto),
    FOREIGN KEY (sucursal) REFERENCES ryce.sucursal(codigo_sucursal),
    FOREIGN KEY (producto) REFERENCES rycp.producto(codigo_producto)
);

CREATE TABLE rycp.estanteria(
    sucursal int NOT NULL,
    producto int NOT NULL,
    cantidad int NOT NULL,
    no_pasillo int NOT NULL,
    PRIMARY KEY (sucursal, producto),
    FOREIGN KEY (sucursal) REFERENCES ryce.sucursal(codigo_sucursal),
    FOREIGN KEY (producto) REFERENCES rycp.producto(codigo_producto)
);

CREATE TABLE rycp.venta(
    codigo_venta SERIAL,
    fecha date NOT NULL,
    subtotal float NOT NULL,
    descuento float NOT NULL,
    total float NOT NULL,
    nit_cliente VARCHAR(50) NOT NULL,
    codigo_empleado int NOT NULL,
    PRIMARY KEY (codigo_venta),
    FOREIGN KEY (nit_cliente) REFERENCES rycc.cliente(nit_cliente),
    FOREIGN KEY (codigo_empleado) REFERENCES ryce.empleado(codigo_empleado)
);

CREATE TABLE rycp.detalleventa(
    codigo_detalle_venta SERIAL,
    codigo_venta int NOT NULL,
    producto int NOT NULL,
    cantidad int NOT NULL,
    PRIMARY KEY (codigo_detalle_venta),
    FOREIGN KEY (codigo_venta) REFERENCES rycp.venta(codigo_venta),
    FOREIGN KEY (producto) REFERENCES rycp.producto(codigo_producto)
);


/*Comandos para ver tablas en las schemas
    * \dt ryce.*
    * \dt rycc.*
    * \dt rycp.*

    Comandos para ver tablas en la base de datos
    * \dt

    Comandos para ver schemas en la base de datos
    * \dn
    
    Comandos para Iniciar la bd
    * sudo su - postgres
    * psql

    Creacion de usuario para toda la bd chapinmarket
    * CREATE USER chapinmarket WITH PASSWORD 'chapinmarket';
    * GRANT ALL PRIVILEGES ON DATABASE chapinmarket TO chapinmarket;
    * ALTER USER chapinmarket WITH SUPERUSER;
      
*/



