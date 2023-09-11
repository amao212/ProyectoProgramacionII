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
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Nelson","Bolívar",1008834753,"Quito","nelson@gmail.con","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Paola","Lozano",100883475,"Quito","paola@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Angel","Granadas",10088347,"Quito","angel@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Omar","Garzón",1008834,"Quito","omar@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Ovidiio","Ríos",100883,"Quito","ovidiio@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Mauricio","Gonzalez",10088,"Quito","mauricio@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Jimmy","Arias",1008,"Quito","jimmy@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Jose","Barrera",100,"Quito","jose@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Luis","Montoya",10,"Quito","luis@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("Lina","Bolaños",1,"Quito","lina@gmail.com","A",56,DATE(),DATE());
INSERT INTO CLIENTE(Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_Estado,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES ("ina","Bolños",1123,"Quito","ina@gmail.com","A",56,DATE(),DATE());

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


INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("diana12","clave1234","Diana","Ramirez","1000934234","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("olga12","948343434","Olga","Ruiz","419342342","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("admin","admin","Ruben","Hernandez","10034234","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("carlos12","cla445454","Carlos","Rodríguez","10056545234","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("sonia12","323423444","Sonia","Castaño","10243434234","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("fernanda12","gato12344","Fernanda","Cortéz","1005434234","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("angelica12","perro5425","Angelica","Figuras","10054535234","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("sofia12","lobo32424","Sofía","Casas","1053434234","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("cristina12","fasldfja4","Cristina","Ortiz","10534234234","A",DATE(),DATE());
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("jhonathan12","1234343ga","Jhonathan","Romero","1005543234","A",DATE(),DATE());


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



INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (1234567890,"Leche","1,45",100,"A","1,80",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (1234568789,"Mantequilla","3,45",100,"A","4,00",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (12345678,"Queso","3,45",100,"A","4,00",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (1234567,"Pasta","3,45",100,"A","4,00",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (123456,"Arroz","35,45",100,"A","40,00",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (12345,"Café","5,45",100,"A","6,45",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (1234,"Azúcar","2,45",100,"A","3,54",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (123,"Sal","1,45",100,"A","2,00",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (12,"Pollo","0,45",100,"A","1,00",DATE(),DATE());
INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_Estado, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (1,"Galletas","6,45",100,"A","7,00",DATE(),DATE());


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
INSERT INTO FACTURA(Usuario_Id, Cliente_Id_Cliente, Inventario_Id,Estado_Factura,Total_Factura, FechaIngreso_Factura,FechaModificacion_Factura) VALUES (11,10,3,"A","4,00",DATE(),DATE());



SELECT Id_Factura, b.Usuario_Credencial, c.Cliente_Nombre, d. Inventario_Nombre_Producto,Estado_Factura,Total_Factura, FechaIngreso_Factura,FechaModificacion_Factura
FROM FACTURA a
JOIN USUARIO b  ON a.Usuario_Id = b.Usuario_Id
JOIN CLIENTE c 	ON a.Cliente_Id_Cliente = c.Cliente_Id_Cliente
JOIN INVENTARIO d 	ON a.Inventario_Id = d.Inventario_Id



