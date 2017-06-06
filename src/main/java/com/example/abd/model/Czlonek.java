package com.example.abd.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.abd.validation.DateValidation;

@Entity
public class Czlonek {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idczlonek;
	
	@Size(min = 1, message="Pole nie może być puste")
	@Pattern(regexp = "[A-ZŻŹĆĄŚĘŁÓŃ][a-zżźćńółęąś]*", message = "Nazwisko musi zaczynać się od wielkiej litery")
	private String imie;
	
	@Size(min = 1, message="Pole nie może być puste")
	@Pattern(regexp = "[A-ZŻŹĆĄŚĘŁÓŃ][a-zżźćńółęąś]*", message = "Nazwisko musi zaczynać się od wielkiej litery")
	private String nazwisko;
	
	@NotNull
	@DateValidation
	private String dataur;
	
	@Size(min = 1, message="Pole nie może być puste")
	@Pattern(regexp = "[A-ZŻŹĆĄŚĘŁÓŃ][a-zżźćńółęąś]*", message = "Kraj musi zaczynać się od wielkiej litery")
	private String kraj;
	
	@OneToMany(targetEntity = Artystaczlonek.class, mappedBy = "czlonek", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Collection<Artystaczlonek> artystaczlonek = new ArrayList<Artystaczlonek>();
	
	public int getIdczlonek() {
		return idczlonek;
	}
	public void setIdczlonek(int idczlonek) {
		this.idczlonek = idczlonek;
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
	public String getDataur() {
		return dataur;
	}
	public void setDataur(String data) {
		this.dataur = data;
	}
	public String getKraj() {
		return kraj;
	}
	public void setKraj(String kraj) {
		this.kraj = kraj;
	}
	public Collection<Artystaczlonek> getArtystaczlonek() {
		return artystaczlonek;
	}
	public void setArtystaczlonek(Collection<Artystaczlonek> artystaczlonek) {
		this.artystaczlonek = artystaczlonek;
	}
	
	
}
