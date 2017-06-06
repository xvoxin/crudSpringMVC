package com.example.abd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Klient {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idklient;
	@Size(min = 1, message="Pole nie może być puste")
	@Pattern(regexp = "[A-ZŻŹĆĄŚĘŁÓŃ][a-zżźćńółęąś]*", message = "Imię musi zaczynać się od wielkiej litery")
	private String imie;
	
	@Size(min = 1, message="Pole nie może być puste")
	@Pattern(regexp = "[A-ZŻŹĆĄŚĘŁÓŃ][a-zżźćńółęąś]*", message = "Nazwisko musi zaczynać się od wielkiej litery")
	private String nazwisko;
	
	@Size(min = 1, message="Pole nie może być puste")
	@Pattern(regexp = "[A-ZŻŹĆĄŚĘŁÓŃ][a-zżźćńółęąś]*", message = "Kraj musi zaczynać się od wielkiej litery")
	private String kraj;
	
	@Size(min = 1, message="Pole nie może być puste")
	@Pattern(regexp = "[A-ZŻŹĆĄŚĘŁÓŃ][a-zżźćńółęąś]*", message = "Miasto musi zaczynać się od wielkiej litery")
	private String miasto;
	
	public int getIdklient() {
		return idklient;
	}
	public void setIdklient(int idklient) {
		this.idklient = idklient;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getKraj() {
		return kraj;
	}
	public void setKraj(String kraj) {
		this.kraj = kraj;
	}
	public String getMiasto() {
		return miasto;
	}
	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}
	
	
}
