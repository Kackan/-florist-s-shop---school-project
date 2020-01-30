package com.mysolution1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Kwiaciarnia {
	private List<Kwiat> kwiaty = new ArrayList<>();
	private List<Kwiat> kupione = new ArrayList<>();
	private Scanner in = new Scanner(System.in);
	float suma = 0f;
	private int n = 0;

	public void initList() {//wype�nienie listy kwiat�w w kwiaciarni.
		
		kwiaty.add(new Kwiat("R�a", 6, 4.50f));
		kwiaty.add(new Kwiat("Tulipan", 5, 4.50f));
		kwiaty.add(new Kwiat("Narcyz", 4, 3.50f));
		kwiaty.add(new Kwiat("Fio�ek", 12, 2.20f));
		kwiaty.add(new Kwiat("Kwiat Lotosu", 6, 10.50f));
		kwiaty.add(new Kwiat("Stokrotka", 20, 1.50f));
		kwiaty.add(new Kwiat("Magnolia", 7, 4.0f));
		kwiaty.add(new Kwiat("Piwonia", 5, 3.75f));
		kwiaty.add(new Kwiat("Krokus", 4, 3.80f));
		kwiaty.add(new Kwiat("Forsycja", 8, 5.00f));
	}

	public void buyingKwiaty() {//metoda umo�liwiaj�ca wyb�r kwiata
		System.out.println("Witamy w naszej kwiaciarni");

		while (true) {
			System.out.println("Wpisz nr kwiata, kt�ry chcesz doda� do koszyka");
			for (int i = 0; i < kwiaty.size(); i++) {
				System.out.println("Nr:" + (i + 1) + " nazwa: " + kwiaty.get(i).getNazwa() + ", "
						+ kwiaty.get(i).getPrice() + " z�");
			}
			System.out.println("Wpisz 0 by zako�czy� zakupy i przej�� do koszyka");

			n = in.nextInt();

			switch (n) {
			case 1:
				addKwiat(0);
				break;

			case 2:
				addKwiat(1);
				break;

			case 3:
				addKwiat(2);
				break;

			case 4:
				addKwiat(3);
				break;

			case 5:
				addKwiat(4);
				break;

			case 6:
				addKwiat(5);

				break;

			case 7:
				addKwiat(6);
				break;

			case 8:
				addKwiat(7);
				break;

			case 9:
				addKwiat(8);
				break;
			case 10:
				addKwiat(9);
				break;

			case 0:
				generallyBoughtFlowers();
				toPay();
				System.out.println("Statystyki:");
				averagePrice();
				averagePriceofBoughtFlowers();
				medianOfFlowersInFlorist();
				medianOfBoughtFlowers();
				return;
			}
		}
	}

	public void addKwiat(int i) {//metoda dodaj�ca kwiaty do koszyka w odpowiedniej ilo�ci
		int c;
		System.out.println("Ile sztuk kwiat�w chcesz zam�wi�?");
		c = in.nextInt();

		for (int j = 0; j < c; j++) {
			kupione.add(kwiaty.get(i));
		}

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void toPay() {//metoda m�wi�ca ile nale�y zap�aci�
		kupione.forEach(k -> suma = suma + k.getPrice());
		System.out.println("Do zap�aty: " + suma);
	}

	public void averagePrice() {//�rednia cena kwiat�w w kwiaciarni
		float suma = 0;
		int avg = kwiaty.size();

		for (int i = 0; i < kwiaty.size(); i++) {
			suma = suma + kwiaty.get(i).getPrice();
		}

		System.out.println("�rednia cena wszystkich kwiat�w w kwiaciarni jest r�wna: " + (suma / avg));
	}

	public void averagePriceofBoughtFlowers() {//metoda liczy �redni� cen� kupionych kwiat�w
		float suma = 0;
		int avg = kupione.size();

		for (int i = 0; i < kupione.size(); i++) {
			suma = suma + kupione.get(i).getPrice();
		}

		System.out.println("�rednio za jednego kwiata zap�acisz: " + (suma / avg));

	}

	public void medianOfFlowersInFlorist() {//metoda liczy median� wszystkich kwiat�w w kwiaciarni
		Comparator<Kwiat> compar = (o1, o2) -> {
			return o1.getPrice() < o2.getPrice() ? -1 : o1.getPrice() > o2.getPrice() ? 1 : 0;
		};

		kwiaty.sort(compar);

		float median = 0;
		if (kwiaty.size() % 2 == 0) {
			median = kwiaty.get((kwiaty.size() / 2) - 1).getPrice() + kwiaty.get(kwiaty.size() / 2).getPrice();
			System.out.println("Mediana kwiat�w w kwiaciarni jest r�wna: ");
			System.out.println(median / 2);
		} else {
			median = kwiaty.get((kwiaty.size() / 2)).getPrice();
			System.out.println("Mediana kwiat�w w kwiaciarni jest r�wna: ");
			System.out.println(median);
		}

	}

	public void medianOfBoughtFlowers() {//metoda liczy mediane kupionych kwiat�w

		Comparator<Kwiat> compar = (o1, o2) -> {
			return o1.getPrice() < o2.getPrice() ? -1 : o1.getPrice() > o2.getPrice() ? 1 : 0;
		};

		kupione.sort(compar);

		float median = 0;
		if (kupione.size() % 2 == 0) {
			median = kupione.get((kupione.size() / 2) - 1).getPrice() + kupione.get(kupione.size() / 2).getPrice();
			System.out.println("Mediana zakupionych kwiat�w jest r�wna: ");
			System.out.println(median / 2);
		} else {
			median = kupione.get((kupione.size() / 2)).getPrice();
			System.out.println("Mediana zakupionych kwiat�w jest r�wna: ");
			System.out.println(median);
		}

	}

	public void generallyBoughtFlowers() {//metoda pokazuj�ca ilo�� kwiat�w w koszyku + statystyk�, kt�ry kwiat
		//jest najcz�ciej kupowany na podstawie zakupu tego u�ytkownika.
		
		Map<Kwiat, Integer> map = new HashMap<>();

		for (int i = 0; i < kupione.size(); i++) {	
		
			Integer j=map.get(kupione.get(i));
			map.put(kupione.get(i),(j==null)? 1: j+1);
			
		}
		
		
		System.out.println("W swoim koszyku masz: ");
		map.forEach((k,v)->System.out.println(k+" w ilo�ci: "+v));

		
			List<Integer>list=new ArrayList<>(map.values());
			int maxx=0;
			for(int i=0; i<list.size(); i++)
			{
				maxx=list.get(i);
				for(int j=0; j<list.size(); j++)
				{
					if(maxx<list.get(j))
					{
						maxx=list.get(j);
					}
				}
			}
		
		System.out.println("Kwiat najcz�ciej kupowany to: "+getKey(map, maxx));

	}
	
	public Kwiat getKey(Map<Kwiat,Integer>map, Integer value)
	{
		Kwiat flower=null;
		
		for(Map.Entry<Kwiat,Integer>entry:map.entrySet())
		{		
			if(value.equals(entry.getValue()))
			{
				flower=entry.getKey();
			}
		}
		return flower;
	}
}