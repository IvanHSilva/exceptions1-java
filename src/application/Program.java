package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Número do Quarto: ");
			int quarto = sc.nextInt();
			System.out.print("Data de checkin (dd/mm/aaaa): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de checkout (dd/mm/aaaa): ");
			Date checkOut = sdf.parse(sc.next());

			Reserva reserva = new Reserva(quarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println("Atualização da reserva: ");
			System.out.print("Data de checkin (dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de checkout (dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());
			
			reserva.atualizar(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		} catch (ParseException e) {
			System.out.println("Data Inválida!");
		} catch (DomainException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro Inesperado!");
		}

		sc.close();

	}

}
