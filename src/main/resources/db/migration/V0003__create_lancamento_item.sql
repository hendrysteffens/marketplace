create table lancamento_item(
	id serial not null,
	id_lancamento int not null,
	id_item int not null,
	primary key (id),
	foreign key (id_lancamento) references lancamento(id),
	foreign key (id_item) references item(id)
);
