package com.example.abd.model;

import java.math.BigDecimal;
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
import com.example.abd.validation.*;

@Entity
public class Wydawca {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idwydawca;
	
	@Size(min = 1, message="Pole nie może być puste")
	@Pattern(regexp = "[A-ZŻŹĆĄŚĘŁÓŃ][a-zżźćńółęąś]*", message = "Nazwa musi zaczynać się od wielkiej litery")
	private String nazwa;
	
	@Size(min = 1, message="Pole nie może być puste")
	@Pattern(regexp = "[A-ZŻŹĆĄŚĘŁÓŃ][a-zżźćńółęąś]*", message = "Kraj musi zaczynać się od wielkiej litery")
	private String kraj;
	
	@NotNull
	private BigDecimal kapital;
	
	@DateValidation
	private String datazal;
	
	@OneToMany(targetEntity = Album.class, mappedBy = "wydawca", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Collection<Album> album = new ArrayList<Album>();
	
	public int getIdwydawca() {
		return idwydawca;
	}
	public void setIdwydawca(int idwydawca) {
		this.idwydawca = idwydawca;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getKraj() {
		return kraj;
	}
	public void setKraj(String kraj) {
		this.kraj = kraj;
	}
	public BigDecimal getKapital() {
		return kapital;
	}
	public void setKapital(BigDecimal kapital) {
		this.kapital = kapital;
	}
	public String getDatazal() {
		return datazal;
	}
	public void setDatazal(String datazal) {
		this.datazal = datazal;
	}
	public Collection<Album> getAlbum() {
		return album;
	}
	public void setAlbum(Collection<Album> album) {
		this.album = album;
	}
	
}
