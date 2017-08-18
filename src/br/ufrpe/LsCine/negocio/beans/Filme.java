package br.ufrpe.LsCine.negocio.beans;

import java.io.Serializable;

public class Filme implements Serializable{

	private String nome;
	private int duracao; 
	private String classificacao; 
	
	public Filme(String nome, int duracao, String classificacao){
		this.nome = nome;
		this.duracao = duracao;
		this.classificacao = classificacao;	
	}
	
	public Filme(){
		
	}
	
	public String toString() {
		return "Filme [Nome: " + nome + ", duracao: " + duracao + ", classificacao " + classificacao + "]";
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public String getClassificacao() {
		/*if(classificacao==1){
			return "Livre";
		}
		if(classificacao==2){
			return "+10";
		}
		if(classificacao==3){
			return "+12";
		}
		if(classificacao==4){
			return "+14";
		}
		if(classificacao==5){
			return "+16";
		}
		if(classificacao==6){
			return "+18";
		}
		return"nao encontrada";*/
		return classificacao;
	}
	
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

}
