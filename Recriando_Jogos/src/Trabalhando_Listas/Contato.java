package Trabalhando_Listas;

public class Contato {
  String nome;
  int telefone;
  String email;
  
public Contato(String nome,int telefone,String email) {
	this.nome=nome;
	this.telefone=telefone;
	this.email=email;
}
  
public int getTelefone() {
	return telefone;
}
public void  getTelegone(int telefone) {
	this.telefone=telefone;
}
  
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String setEmail() {
	return email;
}
public void getEmail(String email) {
	this.email=email;
}
  
}
