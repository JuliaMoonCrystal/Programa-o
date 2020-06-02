CREATE DATABASE exercicio_lab
GO
USE exercicio_lab

CREATE TABLE Times(
codigo INT Primary Key NOT NULL,
time   VARCHAR(100) NOT NULL,
sigla  VARCHAR(100) NOT NULL
)

CREATE TABLE jogos(
timeA INT NOT NULL,
timeB INT NOT NULL,
GolsA INT ,
GolsB INT ,
Data_Hora DATETIME NOT NULL,
PRIMARY KEY (timeA,timeB,Data_Hora),
FOREIGN KEY (timeA) REFERENCES Times(codigo),
FOREIGN KEY (timeB) REFERENCES Times(codigo)
)
CREATE TABLE campeonato(
time_nome  INT NOT NULL,
jogos INT ,
vitorias INT ,
empates INT,
derrotas INT,
gols_pro INT,
gols_contra INT,
PRIMARY KEY(time_nome),
FOREIGN KEY (time_nome) REFERENCES Times(codigo)
)
---1------------------------------------------------------------
CREATE TRIGGER t_insere_campeonato ON times
FOR INSERT
AS
 BEGIN
   DECLARE 
     @novo_time INT
	 SELECT @novo_time=codigo From inserted
	 INSERT INTO campeonato Values(@novo_time,0,0,0,0,0,0)
END

Drop trigger t_insere_campeonato

INSERT INTO Times VAlues
(1,'Barcelona','BAR')
INSERT INTO Times VAlues
(2,'Celta de Vigo','CEL')
INSERT INTO Times VAlues
(3,'Málaga','MAL')
INSERT INTO Times VAlues
(4,'Real Madri','RMA')

---2-----------------------------------------------------------
CREATE TRIGGER t_atualiza_jogos ON jogos
For UPDATE
AS
BEGIN 
  DECLARE
    @timeA INT,
	@timeB INT,
	@GolsA int,
	@GolsB INT

	SELECT @timeA=timeA,@timeB=timeB,@GolsA=GolsA,@GolsB=GolsB FROM inserted

	IF(@GolsA > @GolsB)
	BEGIN
	  UPDATE campeonato SET jogos=(campeonato.jogos+1), gols_pro=(campeonato.gols_pro+@GolsA),gols_contra=(campeonato.gols_contra+@GolsB),
	  vitorias=(campeonato.vitorias+1) WHERE time_nome=@timeA 

	  UPDATE campeonato SET jogos=(campeonato.jogos+1), gols_pro=(campeonato.gols_pro+@GolsB),gols_contra=(campeonato.gols_contra+@GolsA),
	  derrotas=(campeonato.derrotas+1) WHERE time_nome=@timeB
	END
	ELSE IF(@GolsB >@GolsA)
	BEGIN
	UPDATE campeonato SET jogos=campeonato.jogos+1, gols_pro=(campeonato.gols_pro+@GolsB),gols_contra=(campeonato.gols_contra+@GolsA),
	vitorias=(campeonato.vitorias+1) WHERE time_nome=@timeB

	UPDATE campeonato SET jogos=campeonato.jogos+1, gols_pro=(campeonato.gols_pro+@GolsA),gols_contra=(campeonato.gols_contra+@GolsB),
	derrotas=(campeonato.derrotas+1) WHERE time_nome=@timeA
	END
	ELSE 
	BEGIN
    UPDATE campeonato Set jogos=campeonato.jogos+1, gols_pro=(campeonato.gols_pro+@GolsA),gols_contra=(campeonato.gols_contra+@GolsB),
	empates=(campeonato.empates+1) WHERE time_nome=@timeA
	UPDATE campeonato SET jogos=campeonato.jogos+1, gols_pro=(campeonato.gols_pro+@GolsB),gols_contra=(campeonato.gols_contra+@GolsA),
	empates=(campeonato.empates+1) WHERE time_nome=@timeB
	END 
 END	

INSERT INTO jogos(timeA,timeB,Data_Hora) VALUES
(1,2,'22/04/2013 15:00'),
(1,3,'29/04/2013 15:00'),
(1,4,'06/05/2013 15:00'),
(2,1,'25/04/2013 15:00'),
(2,3,'02/04/2013 15:00'),
(2,4,'09/05/2013 15:00'),
(3,1,'12/05/2013 15:00'),
(3,2,'15/05/2013 15:00'),
(3,4,'18/05/2013 15:00'),
(4,1,'23/05/2013 15:00'),
(4,2,'27/05/2013 15:00'),
(4,3,'31/05/2013 15:00')

UPDATE jogos
SET GolsA=3,GolsB=1
WHERE timeA=4 AND timeB=3

SELECT*FROM campeonato	
SELECT*FROM jogos

Create Function fn_campeonato()
RETURNS @tabela_campeonato TABLE(
sigla_time VARCHAR(100),
jogos INT,
vitorias INT,
empates INT,
derrotas INT,
gols_pro INT,
gols_contra INT,
pontos Int
)
AS
 BEGIN
  INSERT @tabela_campeonato (sigla_time,jogos,vitorias,empates,derrotas,gols_pro,gols_contra)SELECT sigla,campeonato.jogos, vitorias,empates,derrotas,gols_pro,gols_contra from campeonato,Times where campeonato.time_nome=Times.codigo
  update @tabela_campeonato set pontos  = (vitorias *3)+ empates
	RETURN
END

drop function fn_campeonato
SELECT*FROM dbo.fn_campeonato()