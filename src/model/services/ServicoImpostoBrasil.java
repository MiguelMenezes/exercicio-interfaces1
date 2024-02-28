package model.services;

public class ServicoImpostoBrasil {
	
	
	
	public ServicoImpostoBrasil() {
		
	}
	
	
	
	public double imposto (double valor) {
		if(valor <= 100) {
			return valor * 0.2;
		}else {
			return valor * 0.15;
		}
	}

}
