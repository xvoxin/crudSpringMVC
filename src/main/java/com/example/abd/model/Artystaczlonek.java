package com.example.abd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Artystaczlonek {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idartystaczlonek;
	
	@ManyToOne
	@JoinColumn(name="czlonek")
	@NotNull
	//@Range(min = 1, max = 99999, message = "Pole nie może być puste")
	private Czlonek czlonek;
	
	@ManyToOne
	@JoinColumn(name="artystacz")
	@NotNull
	//@Range(min = 1, max = 99999, message = "Pole nie może być puste")
	private Artysta artystacz;

	public int getIdartystaczlonek() {
		return idartystaczlonek;
	}

	public void setIdartystaczlonek(int idartystaczlonek) {
		this.idartystaczlonek = idartystaczlonek;
	}

	public Czlonek getCzlonek() {
		return czlonek;
	}

	public void setCzlonek(Czlonek czlonek) {
		this.czlonek = czlonek;
	}

	public Artysta getArtystacz() {
		return artystacz;
	}

	public void setArtystacz(Artysta artystacz) {
		this.artystacz = artystacz;
	}


	
}
