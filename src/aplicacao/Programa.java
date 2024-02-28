package aplicacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.AluguelCarro;
import model.entidades.Veiculo;
import model.services.ServicoAluguelCarro;
import model.services.ServicoImpostoBrasil;

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

		AluguelCarro aluguelCarro = new AluguelCarro(inicio, fim, new Veiculo(modelo));

		System.out.print("Preço por hora R$: ");
		double precoHora = sc.nextDouble();
		System.out.print("Preço por dia R$: ");
		double precoDia = sc.nextDouble();

		ServicoAluguelCarro servicoAluguelCarro = new ServicoAluguelCarro(precoDia, precoHora,
				new ServicoImpostoBrasil());
		
		servicoAluguelCarro.processarFatura(aluguelCarro);
		
		System.out.println("");
		System.out.println("FATURA: ");
		System.out.println("Pagamento básico : R$"+ aluguelCarro.getFatura().getPagamentoBasico());
		System.out.println("Imposto: R$" + aluguelCarro.getFatura().getImposto());
		System.out.println("Pagamento total: R$" + aluguelCarro.getFatura().getPagamentoTotal());
		

		sc.close();
	}

}
