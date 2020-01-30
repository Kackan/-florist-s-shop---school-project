package com.mysolution1;

public class Kwiat {
	private String nazwa;
	private int liczba_platkow;
	private float price;
	
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public int getLiczba_platkow() {
		return liczba_platkow;
	}
	public void setLiczba_platkow(int liczba_platkow) {
		this.liczba_platkow = liczba_platkow;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	public Kwiat()
	{
		
	}
	public Kwiat(String nazwa, int liczba_platkow, float price) {
		super();
		this.nazwa = nazwa;
		this.liczba_platkow = liczba_platkow;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return nazwa + ", liczba_platkow =" + liczba_platkow + ", cena = " + price;
	}

	
}