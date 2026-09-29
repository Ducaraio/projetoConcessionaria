package com.kio.carscars.enums;

public enum TipoMoto {
	SCOOTER(1), ESPORTIVA(2), STREET(3), OFF_ROAD(4), TOURING(5), TRAIL(6);
	
	private int numb;

	private TipoMoto(int numb) {
		this.numb = numb;
	}

	public int getNumb() {
		return numb;
	}
	
	public static TipoMoto valueOf(int numb) {
		for(TipoMoto valor: TipoMoto.values()) {
			if(valor.getNumb() == numb) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Código de tipo de moto inválido");
	}
}
