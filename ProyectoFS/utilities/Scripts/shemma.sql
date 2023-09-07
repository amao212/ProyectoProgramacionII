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

CREATE TABLE USUARIO
(
	Usuario_Id					INTEGER		PRIMARY KEY AUTOINCREMENT,
	Usuario_Credencial 			VARCHAR(30)	NOT NULL UNIQUE,
	Usuario_PASSWORD			VARCHAR(30)	NOT NULL,
	Usuario_Nombre				VARCHAR(30)	NOT NULL,
	Usuario_Apellido			VARCHAR(30)	NOT NULL,
	Usuario_Cedula				VARCHAR(20)	NOT NULL,
	Usuario_Estado				VARCHAR(10)	DEFAULT ('A'),
	Usuario_FechaIngreso		DATETIME	NOT NULL,
	Usuario_FechaModificacion	DATETIME	NOT NULL
);

INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) 
VALUES ("42398429","adm","ad","49303471","adminn","A",DATE(),DATE());

CREATE TABLE INVENTARIO
(
	Inventario_Id					INTEGER		PRIMARY KEY AUTOINCREMENT,
	Inventario_Codigo_Producto		Integer		NOT NULL,
	Inventario_Nombre_Producto		VARCHAR(10)	NOT NULL,
	Inventario_Costo_Producto		MONEY
	Inventario_Cantidad				INTEGER		NOT NULL,
	Inventario_Estado				VARCHAR(10)	DEFAULT ('A'),
	Inventario_PVP_Producto			MONEY
	Inventario_FechaIngreso			DATETIME	NOT NULL,
	Inventario_FechaModificacion	DATETIME	NOT NULL
);

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
INSERT INTO FACTURA(Usuario_Id, Cliente_Id_Cliente, Inventario_Id,Estado_Factura,Total_Factura, FechaIngreso_Factura,FechaModificacion_Factura)
VALUES (1,2,3,"A","3243",DATE(),DATE());

SELECT Id_Factura, b.Usuario_Id, c.Cliente_Nombre, d. Inventario_Nombre_Producto
FROM FACTURA a
JOIN USUARIO b  ON a.Usuario_Id = b.Usuario_Id
JOIN CLIENTE c 	ON a.Cliente_Id_Cliente = c.Cliente_Id_Cliente
JOIN INVENTARIO d 	ON a.Inventario_Id = d.Inventario_Id
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES ("admin",1,"adm","ad","a","adminn","A",DATE(),DATE());


