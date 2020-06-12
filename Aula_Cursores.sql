CREATE DATABASE Aula_Cursores
GO
USE Aula_Cursores

CREATE TABLE curso(
codigo INT NOT NULL,
nome VARCHAR(MAX) NOT NULL,
duracao INT NOT NULL
PRIMARY KEY (codigo)
)

CREATE TABLE disciplinas(
cod INT NOT NULL,
nome VARCHAR(MAX) NOT NULL,
carga_horaria INT NOT NULL
PRIMARY KEY (cod)
)

CREATE TABLE disciplina_curso(
cod_dis  INT NOT NULL,
cod_curso INT NOT NULL
PRIMARY KEY (cod_dis,cod_curso),
FOREIGN KEY (cod_dis) REFERENCES disciplinas(cod),
FOREIGN KEY (cod_curso) REFERENCES curso (codigo)
)

INSERT INTO curso VALUES
(0,'Análise e desenvolvemento de sistemas',2880),
(1,'Logistica',2880),
(2,'Polimeros',2880),
(3,'Comércio Exterior',2600),
(4,'Gestão Empresarial',2600)

INSERT INTO disciplinas VALUES
(1,'Algoritmos',80),
(2,'Administração',80),
(3,'Laboratório de Hardware',40),
(4,'Pesquisa Operacional',80),
(5,'Física I',80),
(6,'Fisico quimica',80),
(7,'Comércio Exterior',80),
(8,'Fundamentos de Marketing',80),
(9,'Informática',40),
(10,'Sistemas de Informação',80)

INSERT INTO disciplina_curso VALUES
(1,0),
(2,0),
(2,1),
(2,3),
(2,4),
(3,0),
(4,1),
(5,2),
(6,2),
(7,1),
(7,3),
(8,1),
(8,4),
(9,1),
(9,3),
(10,0),
(10,4)

SELECT *FROM curso
SELECT *FROM disciplinas
SELECT *FROM disciplina_curso

CREATE FUNCTION fn_TeinoCursor()
RETURNS @tabela_Cursor TABLE(
cod_Disciplina INT,
Nome_disciplina VARCHAR(MAX),
Carga_Horaria_disciplina INT,
nome_curso VARCHAR(MAX)
)
AS
 BEGIN
   DECLARE
     @cod_curso INT,
	 @c_dis INT,
	 @cod_Disciplina INT,
	 @Nome_disciplina VARCHAR(MAX),
	 @Carga_Horaria_disciplina INT,
	 @nome_curso VARCHAR(MAX)

    DECLARE cursor_curso CURSOR FOR
	SELECT cod_curso,cod_dis FROM disciplina_curso

    OPEN cursor_curso

    FETCH NEXT FROM cursor_curso
	INTO  @cod_curso,@c_dis
    WHILE @@FETCH_STATUS = 0
    BEGIN
	  SELECT @cod_Disciplina = di.cod,
	  @Nome_disciplina=di.nome,
	  @Carga_Horaria_disciplina=di.carga_horaria,
	  @nome_curso=cur.nome
	  FROM disciplinas di
	  INNER JOIN disciplina_curso dis
	  ON di.cod=dis.cod_dis
	  INNER JOIN curso cur
	  ON cur.codigo=dis.cod_curso
	  WHERE dis.cod_curso=@cod_curso AND dis.cod_dis=@c_dis

	  INSERT INTO @tabela_Cursor VALUES 
	  (@cod_disciplina,@Nome_disciplina,@Carga_Horaria_disciplina,@nome_curso)
			
    FETCH NEXT FROM cursor_curso INTO @cod_curso,@c_dis
    END
    CLOSE cursor_curso
    DEALLOCATE cursor_curso
    RETURN
END

SELECT*FROM dbo.fn_TeinoCursor()