package datatypes;

public class DtHora {
	private int horas;
	private int minutos;
	private int segundos;

	public DtHora() {
		super();
	}

	public DtHora(int horas, int minutos, int segundos) {
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
	}

	public int getHoras() {
		return horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

}