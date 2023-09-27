package DTO;

public enum UrgenciaEnum {
	
	NADA(1),POUCA(2),MEDIA(3),MUITA(4),EXTREMA(5);
	
	private final int valorUrgencia;
	
	UrgenciaEnum(int valor){
		valorUrgencia = valor;
	}
	
	public int getUrgencia() {
		return valorUrgencia;
	}

}
