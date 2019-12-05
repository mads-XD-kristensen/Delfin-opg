create database Delfin;
use Delfin;

CREATE TABLE Medlem (
  ID int NOT NULL AUTO_INCREMENT,
  stamOpl varchar(150) NOT NULL,
  Alder int(120) NOT NULL,
  passivAktiv boolean NOT NULL,
  BetalStatus boolean not null default false,
  træner varchar(69),
  PRIMARY KEY (ID));

  create table SvømResultat(
 Medlem_ID int not null,
 Stævne varchar(50) not null,
 Placering varchar(50) not null,
 Tid varchar(50) not null, 
 Svømmedisciplin varchar(50) not null,
 svømID int auto_increment,
 primary key (svømID));
 
 
insert into medlem ( stamopl, alder, passivAktiv, BetalStatus, træner) values ( "Mads Kristensen", "1997", true, true, null);
insert into medlem ( stamopl, alder, passivAktiv, BetalStatus, træner) values ( "Jonas Mik", "1996", false, true, null);
insert into medlem ( stamopl, alder, passivAktiv, BetalStatus, træner) values ( "Mads Overgaard ", "1997", true, false, "Jens");
insert into medlem ( stamopl, alder, passivAktiv, BetalStatus, træner) values ( "Albert Sylvester", "2006", true, true, "Jens");
insert into medlem ( stamopl, alder, passivAktiv, BetalStatus, træner) values ( "Daniel Bisgaard", "2005", false, false, "Jens");
insert into medlem ( stamopl, alder, passivAktiv, BetalStatus, træner) values ( "Bent Bentsen", "1963", false, false, null);
insert into medlem ( stamopl, alder, passivAktiv, BetalStatus, træner) values ( "Simone Simonsen", "1976", false, true, null);
insert into medlem ( stamopl, alder, passivAktiv, BetalStatus, træner) values ( "Søren Sørensen", "2010", true, false, "Jens");
insert into medlem ( stamopl, alder, passivAktiv, BetalStatus, træner) values ( "Mads Madsen", "2008", true, true, "Jens");
insert into medlem ( stamopl, alder, passivAktiv, BetalStatus, træner) values ( "Lars Larsen", "2002", false, true, null);

insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values ( 1, "OL", "Første", "14.34", "Crawl"); 
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values ( 2, "Tredje OL qualifier", "Tredje", "30.4", "Crawl"); 
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values ( 3, "Stævnet", "Anden", "14.35", "Crawl"); 
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values ( 4, "Ølby ølsvømmestævne", "Ottende", "1.32", "Crawl"); 
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values ( 5, "Vandløse svømmestævne", "Første", "45.43", "Crawl"); 
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values (6, "OL", "Femte", "14.76", "Crawl");
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values (7, "VM", "Tredje", "60.32", "Rygcrawl");
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values (8, "DM", "Fjerde", "23.32", "Rygcrawl");
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values (9, "Radio 100 fm", "Første", "32.34", "Rygcrawl");
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values (10, "Hurtigstævnet", "Anden", "0.67", "Rygcrawl");
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values (3, ":)", "Sjete", "04.23", "Rygcrawl");
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values (2, "Mars stævnet", "Syvende", "87.34", "Butterfly");
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values (4, "Mads' Stævne", "Anden", "90.32", "Butterfly");
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values (5, "Det første stævne", "Første", "123.45", "Butterfly");
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values (8, "IDK stævnet", "Sidste", "123.34", "Butterfly");
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values (9, "Intet stævnet", "Tredje", "12.345", "Brystsvømning");
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values (7, "Natte stævnet", "Femte", "12.34", "Brystsvømning");
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values (5, "Stævne stævnet", "Sjete", "11.45", "Brystsvømning");
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values (6, "?", "Første", "11.44", "Brystsvømning");
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values (10, "OL", "Tredje", "22.67", "Brystsvømning");
insert into svømresultat (medlem_id, stævne, placering, tid, svømmedisciplin) values (1, "SM", "Ottende", "97.45", "Brystsvømning");
