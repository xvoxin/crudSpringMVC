package com.example.abd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class Album {
	@Id
   	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idalbum;
	
	@Size(min = 1, message="Pole nie może być puste")
	@Pattern(regexp = "[A-ZŻŹĆĄŚĘŁÓŃ][a-zżźćńółęąś]*", message = "Nazwa musi zaczynać się od wielkiej litery")
	private String nazwa;
	
	@Range(min = 1, message = "Pole nie może być puste")
	private int dlugosc;
	
	@ManyToOne
	@JoinColumn(name="artysta")
	@NotNull
	//@NotEmpty
	//@Range(min = 1, message = "Pole nie może być puste")
	private Artysta artysta;
	
	@ManyToOne
	@JoinColumn(name="wydawca")
	@NotNull(message = "chuj")
	//@NotEmpty
	//@Range(min = 1, message = "Pole nie może być puste")
	private Wydawca wydawca;
	
	public int getIdalbum() {
		return idalbum;
	}
	public void setIdalbum(int idalbum) {
		this.idalbum = idalbum;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public int getDlugosc() {
		return dlugosc;
	}
	public void setDlugosc(int dlugosc) {
		this.dlugosc = dlugosc;
	}
	public Artysta getArtysta() {
		return artysta;
	}
	public void setArtysta(Artysta artysta) {
		this.artysta = artysta;
	}
	public Wydawca getWydawca() {
		return wydawca;
	}
	public void setWydawca(Wydawca wydawca) {
		this.wydawca = wydawca;
	}

	
}
