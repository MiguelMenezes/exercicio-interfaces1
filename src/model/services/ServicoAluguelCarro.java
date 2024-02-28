package model.services;

import java.time.Duration;

import model.entidades.AluguelCarro;
import model.entidades.Fatura;

public class ServicoAluguelCarro {

	private Double precoDia;
	private Double precoHora;

	private ServicoImpostoBrasil impostoBrasil;

	public ServicoAluguelCarro(Double precoDia, Double precoHora, ServicoImpostoBrasil impostoBrasil) {
		this.precoDia = precoDia;
		this.precoHora = precoHora;
		this.impostoBrasil = impostoBrasil;
	}

	public void processarFatura(AluguelCarro aluguelCarro) {

		// pega a diferença em minutos:
		double minutos = Duration.between(aluguelCarro.getInicio(), aluguelCarro.getFim()).toMinutes();
		double horas = minutos / 60;

		double pagamentoBasico;
		if (horas <= 12) {

			pagamentoBasico = precoHora * Math.ceil(horas);

		} else {

			pagamentoBasico = precoDia = Math.ceil(horas / 24);

		}

		double imposto = impostoBrasil.imposto(pagamentoBasico);
		aluguelCarro.setFatura(new Fatura(pagamentoBasico, imposto));

	}

}
