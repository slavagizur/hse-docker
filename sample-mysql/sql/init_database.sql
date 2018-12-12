create table sample_data
(
	id int auto_increment,
	text_field varchar(200) null,
	constraint sample_data_pk
		primary key (id)
);

insert into sample_data
 (text_field) values ('Значение первое');

insert into sample_data
 (text_field) values ('Значение второе');

commit;