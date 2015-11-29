insert into rol (nombre, estado, version) values ('Administrador','ACTIVO',1);
insert into permiso (nombre, rol_id, version) values ('admin',1,1);
insert into usuario(estado,usuario,clave,nombres,apellidos,rol_id) values('ACTIVO','admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Juan','Perez',1);


insert into persona(dtype,nombres) values('Proveedor','Molinos Harineros');

insert into impuesto(nombre,valor,version) values('IVA 10%',10,1);
insert into unidadMedida(nombre, estado, version) values ('Kg','ACTIVO',1);
insert into deposito(nombre,version) values ('Deposito 1',1);
insert into deposito(nombre,version) values ('Deposito 2',1);

insert into producto(codigo,nombre,tipoproducto,impuesto_id,unidadmedidabase_id,costo,precioventa,inventariable,tienevencimiento,estado,version)
values ('001','Azucar','MATERIA_PRIMA',1,1,10000,15000,true,true,'ACTIVO',1);


CREATE OR REPLACE VIEW groups AS 
select cast(lower(pr.nombre) as character varying(255)) AS groupid,
 u.usuario AS userid 
from permiso pr join usuario u
on pr.rol_id = u.rol_id;


ALTER TABLE groups OWNER TO postgres;
CREATE OR REPLACE VIEW users AS SELECT usuario AS userid, clave AS password FROM usuario;
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

INSERT INTO moneda(abreviacion, decimales, estado, monedalocal, nombre, version)
    VALUES ('Gs', 0, 'ACTIVO', true, 'Guaraníes', 1);
INSERT INTO puntoventa(nombre, version)
    VALUES ('Main', 1);

 INSERT INTO mediopago(nombre, version)
    VALUES ('Efectivo', 1);
