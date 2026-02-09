Create database bibliothek_aprentas;
Use bibliothek_aprentas;

Create table person (
    id int primary key auto_increment,
    name varchar(40) not null,
    adresse varchar(60) not null
);
Create table buch (
    id int primary key auto_increment,
    titel varchar(60) not null,
    autor varchar(40) not null,
    isbn varchar(13) not null,
    genre varchar(30) not null,
    anzahl_verfuegbar int not null
);
Create table ausleihe (
    ausleihdatum datetime not null default now(),
    person_id int not null,
    buch_id int not null,
    foreign key (person_id) references person(id),
    foreign key (buch_id) references buch(id),
    primary key (ausleihdatum, person_id, buch_id)
);