package com.kio.carscars.enums;

public enum TipoCarro {
	HATCH(1), CAMINHONETE(2), ESPORTIVO(3), SEDAN(4);
	
	private Integer numb;
	
	private TipoCarro(Integer numb) {
		this.numb = numb;
	}

	public Integer getNumb() {
		return numb;
	}
	
	public static TipoCarro valueOf(int numb){
		for(TipoCarro valor: TipoCarro.values()) {
			if(valor.getNumb() == numb) {
				return valor;
			}
		}
			throw new IllegalArgumentException("Código de tipo de carro inválido.");
	}
	
	
}
