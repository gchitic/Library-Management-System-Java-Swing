CREATE DATABASE biblioteca;

--crearea tabelelor
CREATE TABLE IF NOT EXISTS public.carte
(
    id_carte integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    denumire text COLLATE pg_catalog."default",
    autor text COLLATE pg_catalog."default",
    editura text COLLATE pg_catalog."default",
    domeniul text COLLATE pg_catalog."default",
    an_aparitie integer,
    CONSTRAINT carte_pkey PRIMARY KEY (id_carte)
)
CREATE TABLE IF NOT EXISTS public.cititor
(
    id_cititor integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nume text COLLATE pg_catalog."default",
    prenume text COLLATE pg_catalog."default",
    nr_tel text COLLATE pg_catalog."default",
    adresa text COLLATE pg_catalog."default",
    CONSTRAINT cititor_pkey PRIMARY KEY (id_cititor)
)

CREATE TABLE IF NOT EXISTS public.inchiriere
(
    id_inchiriere integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    carte_id integer,
    cititor_id integer,
    data_inchiriere date,
    data_estim_return date,
    CONSTRAINT id_inchiriere PRIMARY KEY (id_inchiriere),
    CONSTRAINT carte_id FOREIGN KEY (carte_id)
        REFERENCES public.carte (id_carte) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT cititor_id FOREIGN KEY (cititor_id)
        REFERENCES public.cititor (id_cititor) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
CREATE TABLE IF NOT EXISTS public.returnare
(
    id_returnare integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    inchiriere_id integer,
    data_return date,
    CONSTRAINT returnare_pkey PRIMARY KEY (id_returnare),
    CONSTRAINT inchiriere_id FOREIGN KEY (inchiriere_id)
        REFERENCES public.inchiriere (id_inchiriere) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--Inserari
INSERT INTO carte(denumire, autor, editura, domeniul, an_aparitie) VALUES(?, ?, ?, ?, ?);
INSERT INTO cititor(nume, prenume, nr_tel, adresa) VALUES(?, ?, ?, ?);
INSERT INTO inchiriere(carte_id, cititor_id, data_inchiriere, data_estim_return) VALUES(?, ?, ?, ?);
INSERT INTO returnare(inchiriere_id, data_return) VALUES(?, ?);


--Update
UPDATE carte 
SET denumire = ?, autor = ?, editura = ?, domeniul = ?, an_aparitie = ? 
WHERE id_carte = ?;

UPDATE cititor 
SET nume = ?, prenume = ?, nr_tel = ?, adresa = ? 
WHERE id_cititor = ?;

--Delete
DELETE FROM carte WHERE id_carte = ?;
DELETE FROM cititor WHERE id_cititor = ?;


--Select
SELECT * FROM carte;
SELECT * FROM cititor;

SELECT i.id_inchiriere, i.carte_id, c.denumire||' de '||c.autor as Carte, i.cititor_id, 
		ci.nume||' '||ci.prenume as Cititor, ci.nr_tel, ci.adresa, i.data_inchiriere, 
		i.data_estim_return
FROM public.inchiriere as i inner join public.carte as c on i.carte_id = c.id_carte
                inner join public.cititor as ci on i.cititor_id = ci.id_cititor;


SELECT r.id_returnare, i.id_inchiriere, i.carte_id, c.denumire||' de '||c.autor as Carte,
i.cititor_id, ci.nume||' '||ci.prenume as Cititor, ci.nr_tel, ci.adresa, 
i.data_inchiriere, i.data_estim_return, r.data_return  
FROM returnare r inner join inchiriere i on r.inchiriere_id=i.id_inchiriere 
				inner join carte c on i.carte_id=c.id_carte
				inner join cititor ci on i.cititor_id=id_cititor;





