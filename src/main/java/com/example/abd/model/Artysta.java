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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.abd.validation.DateValidation;

@Entity
public class Artysta {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idartysta;
	
	@Size(min = 1, message="Pole nie może być puste")
	@Pattern(regexp = "[A-ZŻŹĆĄŚĘŁÓŃ][a-zżźćńółęąś]*", message = "Nazwa musi zaczynać się od wielkiej litery")
	private String nazwa;
	
	@DateValidation
	private String datazal;
	
	@Size(min = 1, message="Pole nie może być puste")
	@Pattern(regexp = "[A-ZŻŹĆĄŚĘŁÓŃ][a-zżźćńółęąś]*", message = "Nazwa musi zaczynać się od wielkiej litery")
	private String gatunek;
	
	@Size(min = 1, message="Pole nie może być puste")
	@Pattern(regexp = "[A-ZŻŹĆĄŚĘŁÓŃ][a-zżźćńółęąś]*", message = "Nazwa musi zaczynać się od wielkiej litery")
	private String kraj;
	
	@OneToMany(targetEntity = Album.class, mappedBy = "artysta", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Collection<Album> album = new ArrayList<Album>();
	
	@OneToMany(targetEntity = Artystaczlonek.class, mappedBy = "artystacz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Artystaczlonek> artystaczlonek = new ArrayList<Artystaczlonek>();
	
	public int getIdartysta() {
		return idartysta;
	}
	public void setIdartysta(int idartysta) {
		this.idartysta = idartysta;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getDatazal() {
		return datazal;
	}
	public void setDatazal(String datazal) {
		this.datazal = datazal;
	}
	public String getGatunek() {
		return gatunek;
	}
	public void setGatunek(String gatunek) {
		this.gatunek = gatunek;
	}
	public String getKraj() {
		return kraj;
	}
	public void setKraj(String kraj) {
		this.kraj = kraj;
	}
	public Collection<Album> getAlbum() {
		return album;
	}
	public void setAlbum(Collection<Album> album) {
		this.album = album;
	}
	public Collection<Artystaczlonek> getArtystaczlonek() {
		return artystaczlonek;
	}
	public void setArtystaczlonek(Collection<Artystaczlonek> artystaczlonek) {
		this.artystaczlonek = artystaczlonek;
	}
	
}
