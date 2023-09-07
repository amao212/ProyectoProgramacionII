.database
.table


CREATE TABLE CLIENTE
(
	Cliente_Id_Cliente					INTEGER 		PRIMARY KEY AUTOINCREMENT,
	Cliente_Nombre						VARCHAR(30)		NOT NULL,
	Cliente_Apellido					VARCHAR(30)		NOT NULL,
	Cliente_Cedula						VARCHAR(50)		NOT NULL,
	Cliente_Direccion					VARCHAR(50)			NULL,
	Cliente_Correo						VARCHAR(30)		NOT NULL,
	Cliente_Estado						VARCHAR(20)		DEFAULT ('A'),
	Cliente_NumeroCreditos				INTEGER 		NOT NULL,
	Cliente_FechaIngreso				DATETIME		NOT NULL,
	Cliente_FechaMod					DATETIME		NOT NULL
);

INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Javier","Bolívar",10088347535,"Quito","javiar@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Nelson","Bolívar",10088347535,"Quito","nelson@gmail.con","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Paola","Lozano",10088347535,"Quito","paola@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Angel","Granadas",10088347535,"Quito","angel@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Omar","Garzón",10088347535,"Quito","omar@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Ovidiio","Ríos",10088347535,"Quito","ovidiio@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Mauricio","Gonzalez",10088347535,"Quito","mauricio@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Jimmy","Arias",10088347535,"Quito","jimmy@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Jose","Barrera",10088347535,"Quito","jose@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Luis","Montoya",10088347535,"Quito","luis@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Lina","Bolaños",10088347535,"Quito","lina@gmail.com","A",56,DATE(),DATE());

CREATE TABLE USUARIO
(
	Usuario_Id					INTEGER		PRIMARY KEY AUTOINCREMENT,
	Usuario_Credencial 			VARCHAR(30)	NOT NULL,
	Usuario_PASSWORD			VARCHAR(30)	NOT NULL,
	Usuario_Nombre				VARCHAR(30)	NOT NULL,
	Usuario_Apellido			VARCHAR(30)	NOT NULL,
	Usuario_Cedula				VARCHAR(20)	NOT NULL,
	Usuario_Estado				VARCHAR(10)	DEFAULT ('A'),
	Usuario_FechaIngreso		DATETIME	NOT NULL,
	Usuario_FechaModificacion	DATETIME	NOT NULL
);


INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("Empleado","clave1234","Diana","Ramirez","1000934234","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("Administrador","948343434","Olga","Ruiz","419342342","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("Administrador","usuaraio3","Ruben","Hernandez","10034234","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("Empleado","cla445454","Carlos","Rodríguez","10056545234","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("Empleado","323423444","Sonia","Castaño","10243434234","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("Empleado","gato12344","Fernanda","Cortéz","1005434234","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("Empleado","perro5425","Angelica","Figuras","10054535234","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("Empleado","lobo32424","Sofía","Casas","1053434234","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("Empleado","fasldfja4","Cristina","Ortiz","10534234234","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("Empleado","1234343ga","Jhonathan","Romero","1005543234","A",DATE(),DATE());


CREATE TABLE INVENTARIO
(
	Inventario_Id					INTEGER		PRIMARY KEY AUTOINCREMENT,
	Inventario_Codigo_Producto		Integer		NOT NULL,
	Inventario_Nombre_Producto		VARCHAR(10)	NOT NULL,
	Inventario_Costo_Producto		MONEY		NOT NULL,
	Inventario_Cantidad				INTEGER		NOT NULL,
	Inventario_Estado				VARCHAR(10)	DEFAULT ('A'),
	Inventario_PVP_Producto			MONEY		NOT NULL,
	Inventario_FechaIngreso			DATETIME	NOT NULL,
	Inventario_FechaModificacion	DATETIME	NOT NULL
);



INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (32408654342,"Leche","1,45",100,"A","1,80",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (324245442,"Mantequilla","3,45",100,"A","4,00",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (32678673342,"Queso","3,45",100,"A","4,00",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (3249789342,"Pasta","3,45",100,"A","4,00",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (32245342,"Arroz","35,45",100,"A","40,00",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (32523423342,"Café","5,45",100,"A","6,45",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (32678543342,"Azúcar","2,45",100,"A","3,54",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (324646342,"Sal","1,45",100,"A","2,00",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (322423342,"Pollo","0,45",100,"A","1,00",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (32523423342,"Galletas","6,45",100,"A","7,00",DATE(),DATE());


CREATE TABLE FACTURA
(
	Id_Factura					INTEGER		PRIMARY KEY AUTOINCREMENT,
	Usuario_Id					INTEGER		NOT NULL,
	Cliente_Id_Cliente			INTEGER		NOT NULL,
	Inventario_Id				INTEGER		NOT NULL,
	Estado_Factura				VARCHAR(10) DEFAULT ('A'),
	Total_Factura				MONEY		NOT NULL,
	FechaIngreso_Factura		DATETIME	NOT NULL,
	FechaModificacion_Factura	DATETIME	NOT NULL,
	FOREIGN KEY (Usuario_Id)  			REFERENCES 	USUARIO(Usuario_Id),
	FOREIGN KEY (Cliente_Id_Cliente)  	REFERENCES 	CLIENTE(Cliente_Id_Cliente),
	FOREIGN KEY (Inventario_Id) 		REFERENCES 	INVENTARIO(Inventario_Id)

);
INSERT INTO FACTURA(Usuario_Id, Cliente_Id_Cliente, Inventario_Id,Estado_Factura,Total_Factura, FechaIngreso_Factura,FechaModificacion_Factura) VALUES (1,1,5,"A","40,00",DATE(),DATE());
INSERT INTO FACTURA(Usuario_Id, Cliente_Id_Cliente, Inventario_Id,Estado_Factura,Total_Factura, FechaIngreso_Factura,FechaModificacion_Factura) VALUES (1,2,4,"A","4,00",DATE(),DATE());
INSERT INTO FACTURA(Usuario_Id, Cliente_Id_Cliente, Inventario_Id,Estado_Factura,Total_Factura, FechaIngreso_Factura,FechaModificacion_Factura) VALUES (5,3,6,"A","6,45",DATE(),DATE());
INSERT INTO FACTURA(Usuario_Id, Cliente_Id_Cliente, Inventario_Id,Estado_Factura,Total_Factura, FechaIngreso_Factura,FechaModificacion_Factura) VALUES (4,4,8,"A","2,00",DATE(),DATE());
INSERT INTO FACTURA(Usuario_Id, Cliente_Id_Cliente, Inventario_Id,Estado_Factura,Total_Factura, FechaIngreso_Factura,FechaModificacion_Factura) VALUES (6,5,9,"A","1,00",DATE(),DATE());
INSERT INTO FACTURA(Usuario_Id, Cliente_Id_Cliente, Inventario_Id,Estado_Factura,Total_Factura, FechaIngreso_Factura,FechaModificacion_Factura) VALUES (6,6,6,"A","6,45",DATE(),DATE());
INSERT INTO FACTURA(Usuario_Id, Cliente_Id_Cliente, Inventario_Id,Estado_Factura,Total_Factura, FechaIngreso_Factura,FechaModificacion_Factura) VALUES (8,7,2,"A","4,00",DATE(),DATE());
INSERT INTO FACTURA(Usuario_Id, Cliente_Id_Cliente, Inventario_Id,Estado_Factura,Total_Factura, FechaIngreso_Factura,FechaModificacion_Factura) VALUES (9,8,1,"A","1,80",DATE(),DATE());
INSERT INTO FACTURA(Usuario_Id, Cliente_Id_Cliente, Inventario_Id,Estado_Factura,Total_Factura, FechaIngreso_Factura,FechaModificacion_Factura) VALUES (9,9,2,"A","4,00",DATE(),DATE());
INSERT INTO FACTURA(Usuario_Id, Cliente_Id_Cliente, Inventario_Id,Estado_Factura,Total_Factura, FechaIngreso_Factura,FechaModificacion_Factura) VALUES (10,10,3,"A","4,00",DATE(),DATE());




SELECT Id_Factura, b.Usuario_Credencial, c.Cliente_Nombre, d. Inventario_Nombre_Producto,Estado_Factura,Total_Factura, FechaIngreso_Factura,FechaModificacion_Factura
FROM FACTURA a
JOIN USUARIO b  ON a.Usuario_Id = b.Usuario_Id
JOIN CLIENTE c 	ON a.Cliente_Id_Cliente = c.Cliente_Id_Cliente
JOIN INVENTARIO d 	ON a.Inventario_Id = d.Inventario_Id
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("admin",1,"adm","ad","a","adminn","A",DATE(),DATE());


