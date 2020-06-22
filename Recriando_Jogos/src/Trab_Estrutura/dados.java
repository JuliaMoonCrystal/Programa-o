package Trab_Estrutura;

public class dados {
 private String regiao;
 private Double dados_Regiao;
 private String qualidade;
 
public dados(String regiao, double dados_Regiao,String qualidade) {
	this.dados_Regiao=dados_Regiao;
	this.regiao=regiao;
	this.qualidade=qualidade;
}

public String getRegiao() {
	return regiao;
}
public void setRegiao(String regiao) {
	this.regiao = regiao;
}
public Double getDados_Regiao() {
	return dados_Regiao;
}
public void setDados_Regiao(Double dados_Regiao) {
	this.dados_Regiao = dados_Regiao;
}
public String getQualidade() {
	return qualidade;
}
public void setQualidade(String qualidade) {
	this.qualidade = qualidade;
}
 
 
 
 
 
 
 
 
 
 
}
