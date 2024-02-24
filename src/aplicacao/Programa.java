package aplicacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do aluguel: ");
		System.out.print("Modelo do carro: ");
		String modelo = sc.nextLine();
		
		System.out.print("Retirada (dd/mm/aaaa hh:mm): ");
		LocalDateTime inicio = LocalDateTime.parse(sc.nextLine(), formatadorHora);
		System.out.print("Retorno (dd/mm/aaaa hh:mm): ");
		LocalDateTime fim = LocalDateTime.parse(sc.nextLine(), formatadorHora);
		
		sc.close();
	}

}
