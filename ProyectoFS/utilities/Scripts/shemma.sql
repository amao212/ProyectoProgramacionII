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
INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_Estado, Usuario_FechaIngreso, Usuario_FechaModificacion) 
VALUES ("admin","admin","admin","admin","admin","A",DATE(),DATE());

CREATE TABLE INVENTARIO
(
	Inventario_Id					INTEGER		PRIMARY KEY AUTOINCREMENT,
	Inventario_Codigo_Producto		Integer		NOT NULL,
	Inventario_Nombre_Producto		VARCHAR(10)	NOT NULL,
	Inventario_Costo_Producto		MONEY,
	Inventario_Cantidad			    INTEGER		NOT NULL,
	Inventario_Estado				VARCHAR(10)	DEFAULT ('A'),
	Inventario_PVP_Producto		    MONEY,
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

INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion)
VALUES 
       (101, 'Teléfono Móvil XS', 300.00, 10, 400.00, '2023-09-05 10:00:00', '2023-09-05 10:00:00'),
       (102, 'Portátil Ultra Slim', 700.00, 5, 900.00, '2023-09-05 11:00:00', '2023-09-05 11:00:00'),
       (103, 'Audífonos Inalámbricos', 50.00, 25, 80.00, '2023-09-05 12:00:00', '2023-09-05 12:00:00'),
       (104, 'Reloj Inteligente Pro', 150.00, 20, 210.00, '2023-09-06 09:00:00', '2023-09-06 09:30:00'),
       (105, 'Teclado Mecánico RGB', 40.00, 15, 65.00, '2023-09-06 10:15:00', '2023-09-06 10:45:00'),
       (106, 'Tablet Gráfica Deluxe', 120.00, 10, 160.00, '2023-09-06 11:00:00', '2023-09-06 11:30:00'),
       (107, 'Cámara DSLR 20MP', 500.00, 8, 650.00, '2023-09-06 12:00:00', '2023-09-06 12:30:00'),
       (108, 'Ratón Ergonómico', 25.00, 30, 35.00, '2023-09-06 14:00:00', '2023-09-06 14:30:00'),
       (109, 'Micrófono USB Studio', 80.00, 12, 110.00, '2023-09-06 15:00:00', '2023-09-06 15:30:00'),
       (110, 'Monitor 27" 4K', 250.00, 6, 320.00, '2023-09-06 16:00:00', '2023-09-06 16:30:00');


