create table lancamento (
	id serial not null,
	dt_inicial timestamp,
    dt_final timestamp,
    vl_total numeric (8,2),
    observacao varchar(1000),
	primary key (id)
);

