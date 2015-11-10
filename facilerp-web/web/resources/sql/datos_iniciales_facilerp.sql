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


CREATE OR REPLACE VIEW groups AS select cast(lower(r.nombre) as character varying(255)) AS groupid, p.usuario AS userid from persona_rol pr join rol r on r.id = pr.roles_id join persona p on p.id = pr.usuarios_id;
ALTER TABLE groups OWNER TO postgres;
CREATE OR REPLACE VIEW users AS SELECT usuario AS userid, clave AS password FROM persona where dtype = 'Usuario';
ALTER TABLE users OWNER TO postgres;

insert into configuracion(modulo,nombreclave,nombre,opciones,valor, version) values ('stock','MULTIPLE_DEPOSITO','Multiple depósitos','INHABILITADO,HABILITADO','INHABILITADO',1);