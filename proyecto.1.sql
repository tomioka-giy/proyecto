use proyecto;

create table ventas(
		codigo_venta int not null primary key,
        cantidad int not null,
        fecha_venta date not null,
        nombre_cliente varchar (100) not null,
        nit_cliente int not null unique        
);