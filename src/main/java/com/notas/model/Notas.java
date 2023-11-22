package com.notas.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="notas")
public class Notas implements Serializable{
	
	private static final long serialVersionUID = -475240504046427588L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@JsonProperty("nota1")
	private double nota1;
	
	@JsonProperty("nota2")
	private double nota2;
	
	@JsonProperty("nota3")
	private double nota3;
	
	@JsonProperty("notaFinal")
	private double notaFinal;
	
	@JsonProperty("idAlumno")
	//@Column(nullable=false)
	private long idAlumno;
	
	@JsonProperty("nombreAlumno")
	//@Column(nullable=false)
	private String nombreAlumno;
	
	@JsonProperty("idMateria")
	//@Column(nullable=false)
	private long idMateria;
	
	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	
	public double getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}

	public long getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(long idMateria) {
		this.idMateria = idMateria;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getNota3() {
		return nota3;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}

	public long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
	}
}
