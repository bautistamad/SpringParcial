package ar.edu.ubp.das.rest.beans;

public class Sugerencia {
	private String codTipoServicio;
	private int numeroTema;
	private String sugerencia;
	private String email;
	private String tema;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public int getNumeroTema() {
		return numeroTema;
	}
	public void setNumeroTema(int numeroTema) {
		this.numeroTema = numeroTema;
	}
	public String getCodTipoServicio() {
		return codTipoServicio;
	}
	public void setCodTipoServicio(String codTipoServicio) {
		this.codTipoServicio = codTipoServicio;
	}
	public String getSugerencia() {
		return sugerencia;
	}
	public void setSugerencia(String sugerencia) {
		this.sugerencia = sugerencia;
	}
}
