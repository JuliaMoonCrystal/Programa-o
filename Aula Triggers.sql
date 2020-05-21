CREATE DATABASE aulatriggers01
go
USE aulatriggers01
 
CREATE TABLE servico(
id INT NOT NULL,
nome VARCHAR(100),
preco DECIMAL(7,2)
PRIMARY KEY(ID))
 
CREATE TABLE depto(
codigo INT not null,
nome VARCHAR(100),
total_salarios DECIMAL(7,2)
PRIMARY KEY(codigo))
 
CREATE TABLE funcionario(
id INT NOT NULL,
nome VARCHAR(100),
salario DECIMAL(7,2),
depto INT NOT NULL
PRIMARY KEY(id)
FOREIGN KEY (depto) REFERENCES depto(codigo))
 
INSERT INTO servico VALUES
(1, 'Orçamento', 20.00),
(2, 'Manutenção preventiva', 85.00)
 
INSERT INTO depto (codigo, nome) VALUES
(1,'RH'),
(2,'DTI')
 
INSERT INTO funcionario VALUES
(1, 'Fulano', 1537.89,2)
INSERT INTO funcionario VALUES
(2, 'Cicrano', 2894.44, 1)
INSERT INTO funcionario VALUES
(3, 'Beltrano', 984.69, 1)
INSERT INTO funcionario VALUES
(4, 'Tirano', 2487.18, 2)


SELECT*FROM servico
SELECT*FROM depto
SELECT*FROM funcionario

CREATE TRIGGER t_viewdepto ON depto 
FOR INSERT ,UPDATE,DELETE
AS
  BEGIN
    SELECT *FROM inserted
	SELECT*FROM deleted
END

INSERT INTO depto VALUES
(3,'Almoxerifado',NULL)

update depto
SET nome='AML.'
WHERE codigo=3

DELETE depto
WHERE codigo=3

CREATE TRIGGER t_protegeservico ON servico
FOR DELETE
AS
   BEGIN
     ROLLBACK TRANSACTION --desfaz ultima trasaçaõ--
	 RAISERROR('NÃO É PERMITIDO APAGAR DADOS DESSE SERVIÇO',16,1)
   END

   DELETE servico
   where id=1

   CREATE TRIGGER t_protegevalorservico ON servico
   FOR UPDATE
   AS
     BEGIN
	    DECLARE @preconovo AS DECIMAL(7,2),
		@precovelho DECIMAL(7,2),
		@idservico int,
		@nomesevico VARCHAR(100)

   SELECT @idservico=id,@nomesevico=nome,@preconovo=preco
   FROM inserted

   SELECT @precovelho=preco
   FROM deleted

   IF(@precovelho>@preconovo)
   BEGIN
    ROLLBACK TRANSACTION
	RAISERROR('o novo valor deve ser maior ou aigual ao antigo',16,1)
	END
 END

 UPDATE servico
 SET preco=85.00
 WHERE id=2

 --DISABLE TRIGGER
 --ENABLE TRIGGER

 DISABLE TRIGGER t_protegeservico ON servico
 ENABLE TRIGGER t_protegeservico ON servico

 CREATE TRIGGER t_insereservico ON servico
 INSTEAD OF INSERT
 AS
  BEGIN
  --  ROLLBACK TRANSACTION
	SELECT*FROM servico
  END

  INSERT INTO servico VALUES
  (10,'XXX',50)

  DROP TRIGGER t_insereservico


  ---exercicio de aula-----
  CREATE PROCEDURE sp_departamento(@codigo INT,@total DECIMAL(7,2))
  AS
   DECLARE @novo DECIMAL(7,2)
    IF((SELECT depto.total_salarios FROM depto WHERE depto.codigo =@codigo) IS NULL)
	 BEGIN
	   UPDATE depto SET depto.total_salarios=@total FROM depto Where depto.codigo =@codigo
     END
	 ELSE
	 BEGIN
	   UPDATE depto SET depto.total_salarios=(depto.total_salarios+@total) FROM depto WHERE depto.codigo=@codigo 
     END

----------------------------------------------------------------------
  CREATE TRIGGER t_inserir ON funcionario
  FOR INSERT
AS
  BEGIN
     DECLARE 
	     @salario DECIMAL(7,2),
		 @cod INT		 
		 SELECT @cod = depto , @salario = salario from inserted

	EXEC sp_departamento @cod, @salario
END	

-----------------------------------------------------------------------
 CREATE TRIGGER t_deletar On funcionario
 FOR DELETE
 AS
  BEGIN
    DECLARE
	   @salario DECIMAL(7,2),
		 @cod INT		 
		 SELECT @cod = depto , @salario =(salario*-1) from inserted  
 	EXEC sp_departamento @cod, @salario
END	 

 ---------------------------------------------------------------------
 CREATE TRIGGER t_atualizar ON funcionario
 FOR UPDATE
 AS
  BEGIN
    DECLARE
	        @VNovo DECIMAL(7,2),
			@VVelho DECIMAL(7,2),
			@valor DECIMAL(7,2),
			@dNovo INT,
			@dVelho INT

	SELECT @VNovo = salario , @dNovo = depto FROM inserted
	SELECT @VVelho = salario , @dVelho = depto FROM deleted

	IF(@dNovo = @dVelho)
	BEGIN
		SET @valor = @VNovo-@VVelho
		EXEC sp_departamento @dNovo,@valor
	END
	ELSE
	BEGIN
		SET @VVelho = @VVelho*-1
		EXEC sp_departamento @dNovo,@VNovo
		EXEC sp_departamento @VVelho,@VVelho
	END
END

 DROP TRIGGER t_atualizafuncionario
 DROP TABLE funcionario
 DROP TABLE depto
 DROP procedure sp_departamento


 DELETE funcionario
 WHERE id=1

 UPDATE funcionario
 SET salario =salario+500
 WHERE id=2

  INSERT INTO funcionario VALUES
  (5,'Maria',2000.00,1),
  (6,'João',1500.00,1)

   INSERT INTO funcionario VALUES
  (7,'Luis',4500.00,2),
  (8,'Gustavo',20000.00,2)


  SELECT*FROM depto
  SELECT*FROM funcionario

