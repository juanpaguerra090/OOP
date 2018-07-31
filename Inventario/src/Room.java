import java.util.Scanner;

import javax.swing.JOptionPane;

public class Room {

	private String name;
	private int guests;
	private int nights;
	private double tariff;
	private int credit;
	private boolean available;

	public Room(){ //Default
		this.name = "John Appleseed";
		this.guests = 1;
		this.nights = 1;
		this.tariff = 180.00;
		this.credit = 0;
		this.available = true;
	}

	public Room(String name, int guests, int nights, double tariff, int credit, boolean availability){ // Personalized
		this.name = name;
		this.guests = guests;
		this.nights = nights;
		this.tariff = tariff;
		this.credit = credit;
		this.available = false;
		
	}

	public static Room Checkin(){
		String name = JOptionPane.showInputDialog("Name: ");
		String guests = JOptionPane.showInputDialog("#Guest: ");
		String nights = JOptionPane.showInputDialog("# Nights: ");
		String tariff = JOptionPane.showInputDialog("Tariff: ");
		String credit = JOptionPane.showInputDialog("Credit: ");

		int intGuests = Integer.parseInt(guests);
		int intNights = Integer.parseInt(nights);
		double douTariff = Double.parseDouble(tariff);
		int intCredit = Integer.parseInt(credit);

		return new Room(name, intGuests, intNights, douTariff, intCredit, true);
	}

	public void  setAvailabilit(){
		
	}
	
	@Override
	public String toString() {

		return ("Name: " + this.name + 
				",# of Guests: " + this.guests + 
				",# of Nights: " + this.nights + 
				",Tariff: $"+ this.tariff +
				",Credit: $" + this.credit);
	}
	public static void main(String[] args) {
		Room x = Checkin();
		System.out.println(x);
	}
}
