package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Número do Quarto: ");
		int quarto = sc.nextInt();
		System.out.print("Data de checkin (dd/mm/aaaa): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de checkout (dd/mm/aaaa): ");
		Date checkOut = sdf.parse(sc.next());
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na Reserva: a data de chekout deve ser superior a de chekin!");
		} else {
			Reserva reserva = new Reserva(quarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println("Atualização da reserva: ");
			System.out.print("Data de checkin (dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de checkout (dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());

			Date agora = new Date();
			if (checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro na Reserva: as datas de atualização devem ser maiores que a atual!");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na Reserva: a data de chekout deve ser superior a de chekin!");
			} else {
				reserva.atualizar(checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
			}
		}

		System.out.println();

		sc.close();

	}

}
