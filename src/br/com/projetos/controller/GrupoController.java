package br.com.projetos.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.projetos.dao.GrupoDAO;
import br.com.projetos.models.Grupo;



@ManagedBean(name="controleGrupo")	
@SessionScoped
public class GrupoController implements Serializable{
	
	private GrupoDAO dao;
	private Grupo objeto;
	
	
	public GrupoController(){
		dao = new GrupoDAO();
	}
	
	
	public String listar(){
		return "/privado/grupo/listar?faces-redirect=true";
	}
	
	public String novo(){
		objeto = new Grupo();
		return "form";
	}
	
	public String cancelar(){
		return "listar";
	}
	
	public String gravar(){
		if (dao.gravar(objeto)){
			return "listar";
		}else{
			return "form";
		}
	}
	
	public String alterar(Grupo obj){
		objeto = obj;
		return "form";
	}
	
	public String excluir(Grupo obj){
		dao.excluir(obj);
		return "listar";
	}
	
	public GrupoDAO getDao() {
		return dao;
	}
	public void setDao(GrupoDAO dao) {
		this.dao = dao;
	}
	public Grupo getObjeto() {
		return objeto;
	}
	public void setObjeto(Grupo objeto) {
		this.objeto = objeto;
	}
	
	

}
