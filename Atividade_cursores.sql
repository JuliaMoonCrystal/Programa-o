CREATE DATABASE Atividade_cursores
GO
USE Atividade_cursores

--Exercicio tirado de situação real.
/* A empresa tinha duas tabelas: Envio e Endereço, como listada abaixo.
No atributo NR_LINHA_ARQUIV, há um número que referencia a 
linha de incidência do endereço na tabela endereço.
Por exemplo: 

ENVIO:
|CPF		    |NR_LINHA_ARQUIV	|...
|11111111111	|1			        |
|11111111111	|2			        |

ENDEREÇO:
|CPF		|CEP		|PORTA	|ENDEREÇO	|COMPLEMENTO		|BAIRRO			|CIDADE			|UF	|
|11111111111|11111111	|10	    |Rua A		|			        |Pq A			|São Paulo		|SP	|
|11111111111|22222222	|125    |Rua B	    |		            |Pq B			|São Paulo		|SP	|

Portanto, o NR_LINHA_ARQUIV (1) referencia o registro do endereço da Rua A e o NR_LINHA_ARQUIV (2) 
referencia o endereço da Rua B.

Como se trata de uma estrutura completamente mal feita, o DBA solicitou
que se colcasse as colunas NM_ENDERECO, NR_ENDERECO, NM_COMPLEMENTO, NM_BAIRRO, NR_CEP,
NM_CIDADE, NM_UF varchar(2) e movesse os dados da tabela endereço para a tabela envio.

Fazer uma PROCEDURE, com cursor, que resolva esse problema
*/

create table envio (
CPF varchar(20),
NR_LINHA_ARQUIV	int,
CD_FILIAL int,
DT_ENVIO datetime,
NR_DDD int,
NR_TELEFONE	varchar(10),
NR_RAMAL varchar(10),
DT_PROCESSAMENT	datetime,
NM_ENDERECO varchar(200),
NR_ENDERECO int,
NM_COMPLEMENTO	varchar(50),
NM_BAIRRO varchar(100),
NR_CEP varchar(10),
NM_CIDADE varchar(100),
NM_UF varchar(2),
)

create table endereço(
CPF varchar(20),
CEP	varchar(10),
PORTA	int,
ENDEREÇO	varchar(200),
COMPLEMENTO	varchar(100),
BAIRRO	varchar(100),
CIDADE	varchar(100),
UF Varchar(2)
)

/*
Por se tratar de dados confidenciais, a procedure abaixo foi feita para se criar
dados ficticios nas tabelas
*/

create procedure sp_insereenvio
as
declare @cpf as int
declare @cont1 as int
declare @cont2 as int
declare @conttotal as int
set @cpf = 11111
set @cont1 = 1
set @cont2 = 1
set @conttotal = 1
	while @cont1 <= @cont2 and @cont2 < = 100
			begin
				insert into envio (CPF, NR_LINHA_ARQUIV, DT_ENVIO)
				values (cast(@cpf as varchar(20)), @cont1,GETDATE())
				insert into endereço (CPF,PORTA,ENDEREÇO)
				values (@cpf,@conttotal,CAST(@cont2 as varchar(3))+'Rua '+CAST(@conttotal as varchar(5)))
				set @cont1 = @cont1 + 1
				set @conttotal = @conttotal + 1
				if @cont1 > = @cont2
					begin
						set @cont1 = 1
						set @cont2 = @cont2 + 1
						set @cpf = @cpf + 1
					end
	end

exec sp_insereenvio

select * from envio order by CPF,NR_LINHA_ARQUIV asc
select * from endereço order by CPF asc

CREATE PROCEDURE sp_transfere_Dados
 AS
BEGIN

	DECLARE @END_CPF VARCHAR(20),
			@ENV_CPF VARCHAR(20),
			@NR_LINHA_ARQUIV INT,
			@CD_FILIAL INT,
			@DT_ENVIO DATETIME,
			@NR_DDD INT,
			@NR_TELEFONE VARCHAR(10),
			@NR_RAMAL VARCHAR(10),
			@DT_PROCESSAMENT VARCHAR(20),
			@NM_ENDERECO varchar(200),
			@NR_ENDERECO int,
			@NM_COMPLEMENTO	varchar(50),
			@NM_BAIRRO varchar(100),
			@NR_CEP varchar(10),
			@NM_CIDADE varchar(100),
			@NM_UF varchar(2)

	DECLARE cursor_enviar CURSOR FOR
    SELECT CPF,NR_LINHA_ARQUIV,CD_FILIAL,DT_ENVIO,NR_DDD,NR_TELEFONE,@NR_RAMAL,@DT_PROCESSAMENT FROM envio
	OPEN cursor_enviar
	DECLARE cursor_endereco CURSOR FOR
		SELECT CPF,CEP,ENDEREÇO,PORTA, COMPLEMENTO,BAIRRO,CIDADE,UF FROM endereço
	OPEN cursor_endereco
	 FETCH NEXT FROM cursor_enviar INTO
	 @ENV_CPF,@NR_LINHA_ARQUIV,@CD_FILIAL,@DT_ENVIO,@NR_DDD,@NR_TELEFONE,@NR_RAMAL,@DT_PROCESSAMENT


	 FETCH NEXT FROM cursor_endereco INTO

	 @END_CPF,@NR_CEP,@NM_ENDERECO,@NR_ENDERECO, @NM_COMPLEMENTO,@NM_BAIRRO,@NM_CIDADE,@NM_UF

	 WHILE @@FETCH_STATUS = 0
	 BEGIN
		UPDATE envio SET NR_CEP = @NR_CEP,NM_ENDERECO = @NM_ENDERECO, NR_ENDERECO = @NR_ENDERECO, NM_COMPLEMENTO = @NM_COMPLEMENTO, NM_BAIRRO = @NM_BAIRRO, NM_CIDADE = @NM_CIDADE, NM_UF = @NM_UF WHERE CPF = @END_CPF AND CPF = @ENV_CPF AND NR_LINHA_ARQUIV = @NR_LINHA_ARQUIV

		 FETCH NEXT FROM cursor_enviar INTO

		 @ENV_CPF,@NR_LINHA_ARQUIV,@CD_FILIAL,@DT_ENVIO,@NR_DDD,@NR_TELEFONE,@NR_RAMAL,@DT_PROCESSAMENT

		 FETCH NEXT FROM cursor_endereco INTO
		 @END_CPF,@NR_CEP,@NM_ENDERECO,@NR_ENDERECO, @NM_COMPLEMENTO,@NM_BAIRRO,@NM_CIDADE,@NM_UF
	
	END
	CLOSE cursor_enviar
    DEALLOCATE cursor_enviar

	CLOSE cursor_endereco
    DEALLOCATE cursor_endereco
END