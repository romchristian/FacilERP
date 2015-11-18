insert into rol (nombre, estado, version) values ('admin','ACTIVO',1);
insert into persona(dtype,estado,nrodocumento,usuario,clave,nombre) values('Usuario','ACTIVO','','admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Administrador');
insert into persona(dtype,nombres) values('Proveedor','Molinos Harineros');
insert into persona_rol values(1,1);

insert into impuesto(nombre,valor,version) values('IVA 10%',10,1);
insert into unidadMedida(nombre, estado, version) values ('Kg','ACTIVO',1);
insert into deposito(nombre,version) values ('Deposito 1',1);
insert into deposito(nombre,version) values ('Deposito 2',1);

insert into producto(codigo,nombre,tipoproducto,impuesto_id,unidadmedidabase_id,costo,precioventa,inventariable,tienevencimiento,estado,version)
values ('001','Azucar','MATERIA_PRIMA',1,1,10000,15000,true,true,'ACTIVO',1);
insert into producto(codigo,nombre,tipoproducto,impuesto_id,unidadmedidabase_id,costo,precioventa,inventariable,tienevencimiento,estado,version)
values ('002','Habano 1','PRODUCTO_ALMACENABLE',1,1,10000,15000,true,true,'ACTIVO',1);
insert into producto(codigo,nombre,tipoproducto,impuesto_id,unidadmedidabase_id,costo,precioventa,inventariable,tienevencimiento,estado,version)
values ('003','Habano 2','PRODUCTO_ALMACENABLE',1,1,10000,15000,true,true,'ACTIVO',1);
insert into producto(codigo,nombre,tipoproducto,impuesto_id,unidadmedidabase_id,costo,precioventa,inventariable,tienevencimiento,estado,version)
values ('004','Habano 3','PRODUCTO_ALMACENABLE',1,1,10000,15000,true,true,'ACTIVO',1);
insert into producto(codigo,nombre,tipoproducto,impuesto_id,unidadmedidabase_id,costo,precioventa,inventariable,tienevencimiento,estado,version)
values ('005','Chocolate 1','PRODUCTO_ALMACENABLE',1,1,10000,15000,true,true,'ACTIVO',1);
insert into producto(codigo,nombre,tipoproducto,impuesto_id,unidadmedidabase_id,costo,precioventa,inventariable,tienevencimiento,estado,version)
values ('006','Cafe expresso','ELABORACION_EN_CANTINA',1,1,10000,15000,true,true,'ACTIVO',1);
insert into producto(codigo,nombre,tipoproducto,impuesto_id,unidadmedidabase_id,costo,precioventa,inventariable,tienevencimiento,estado,version)
values ('007','Capuccino','ELABORACION_EN_CANTINA',1,1,10000,15000,true,true,'ACTIVO',1);
insert into producto(codigo,nombre,tipoproducto,impuesto_id,unidadmedidabase_id,costo,precioventa,inventariable,tienevencimiento,estado,version)
values ('008','Ron','ELABORACION_EN_CANTINA',1,1,10000,15000,true,true,'ACTIVO',1);
insert into producto(codigo,nombre,tipoproducto,impuesto_id,unidadmedidabase_id,costo,precioventa,inventariable,tienevencimiento,estado,version)
values ('009','Trago 1','ELABORACION_EN_CANTINA',1,1,10000,15000,true,true,'ACTIVO',1);
insert into producto(codigo,nombre,tipoproducto,impuesto_id,unidadmedidabase_id,costo,precioventa,inventariable,tienevencimiento,estado,version)
values ('010','Trago 2','ELABORACION_EN_CANTINA',1,1,10000,15000,true,true,'ACTIVO',1);
insert into producto(codigo,nombre,tipoproducto,impuesto_id,unidadmedidabase_id,costo,precioventa,inventariable,tienevencimiento,estado,version)
values ('011','Trago 3','ELABORACION_EN_CANTINA',1,1,10000,15000,true,true,'ACTIVO',1);
insert into producto(codigo,nombre,tipoproducto,impuesto_id,unidadmedidabase_id,costo,precioventa,inventariable,tienevencimiento,estado,version)
values ('012','Trago 4','ELABORACION_EN_CANTINA',1,1,10000,15000,true,true,'ACTIVO',1);
insert into producto(codigo,nombre,tipoproducto,impuesto_id,unidadmedidabase_id,costo,precioventa,inventariable,tienevencimiento,estado,version)
values ('013','Trago 5','ELABORACION_EN_CANTINA',1,1,10000,15000,true,true,'ACTIVO',1);




CREATE OR REPLACE VIEW groups AS select cast(lower(r.nombre) as character varying(255)) AS groupid, p.usuario AS userid from persona_rol pr join rol r on r.id = pr.roles_id join persona p on p.id = pr.usuarios_id;
ALTER TABLE groups OWNER TO postgres;
CREATE OR REPLACE VIEW users AS SELECT usuario AS userid, clave AS password FROM persona where dtype = 'Usuario';
ALTER TABLE users OWNER TO postgres;

insert into configuracion(modulo,nombreclave,nombre,opciones,valor, version) values ('stock','MULTIPLE_DEPOSITO','Multiple depósitos','INHABILITADO,HABILITADO','INHABILITADO',1);

insert into salon (descripcion,version) values('interior',1);
insert into mesa(descripcion,capacidad,estado,numero,version,salon_id) values ('Mesa',2,'SIN_ASIGNAR',1,1,1);
insert into mesa(descripcion,capacidad,estado,numero,version,salon_id) values ('Mesa',4,'SIN_ASIGNAR',2,1,1);
insert into mesa(descripcion,capacidad,estado,numero,version,salon_id) values ('Mesa',4,'SIN_ASIGNAR',3,1,1);
insert into mesa(descripcion,capacidad,estado,numero,version,salon_id) values ('Mesa',2,'SIN_ASIGNAR',4,1,1);
insert into mesa(descripcion,capacidad,estado,numero,version,salon_id) values ('Mesa',6,'SIN_ASIGNAR',5,1,1);
insert into mesa(descripcion,capacidad,estado,numero,version,salon_id) values ('Mesa',4,'SIN_ASIGNAR',6,1,1);
insert into mesa(descripcion,capacidad,estado,numero,version,salon_id) values ('Mesa',2,'SIN_ASIGNAR',7,1,1);
insert into mesa(descripcion,capacidad,estado,numero,version,salon_id) values ('Mesa',6,'SIN_ASIGNAR',8,1,1);
insert into mesa(descripcion,capacidad,estado,numero,version,salon_id) values ('Mesa',2,'SIN_ASIGNAR',9,1,1);