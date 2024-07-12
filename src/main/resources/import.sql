INSERT INTO personas (id, identificacion, nombres, primer_apellido, segundo_apellido, telefono, email) VALUES(1, '1069719478', 'Edilson', 'Martinez', 'Clavijo', '3014679382', 'profesor@bolsadeideas.com');
INSERT INTO personas (id, identificacion, nombres, primer_apellido, segundo_apellido, telefono, email) VALUES(2, '1000002',  'Lissette Andrea', 'Delgadillo', 'Rodriguez', '3014679382', 'lissette@bolsadeideas.com');
INSERT INTO personas (id, identificacion, nombres, primer_apellido, segundo_apellido, telefono, email) VALUES(3, '1234567',  'Santiago Alejandro', 'Martinez', 'Delgadillo', '3014679382', 'santiago@bolsadeideas.com');
INSERT INTO personas (id, identificacion, nombres, primer_apellido, segundo_apellido, telefono, email) VALUES(4, '7654321',  'Danna Valeria', 'Martinez', 'Delgadillo', '3014679382', 'danna@bolsadeideas.com');
INSERT INTO usuarios (id, nombre_usuario, contrasena, persona_id, fecha_creacion) values (1, 'emartinez', 'Edilson123*', 1, '2024-04-02');
INSERT INTO usuarios (id, nombre_usuario, contrasena, persona_id, fecha_creacion) values (2, 'ldelgadillo', 'Liss0325*', 2, '2024-04-02');
/* Populate tabla productos */
INSERT INTO productos (nombre, precio, create_at) VALUES('Cristales o lentes oftálmicas', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Monturas para gafas graduadas', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Gafas de sol - XMB', 1499990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Gafas de protección para graduar', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Gafas de natación', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Lubricante para lentes', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Paño especial de limpieza', 299990, NOW());