package SimonDice3_0;

public class Jugador {
	private String nombre;
	private int puntuacion;
	
	public Jugador (String _nombre) {
	this.nombre = _nombre;
	this.puntuacion = 0;
	}
	/**
	 * 
	 * @return vble String
	 */
	public String getNombre() {
		return "Hola " + this.nombre + " pulsa la tecla ENTER para empezar a jugar";	
	}
	/**
	 * metodo que devuelve la vble int puntuacion
	 * @return vble int puntuación
	 */
	
	public int getPuntuacion() {
		
		if (this.puntuacion < 0) {
			return this.puntuacion = 0;
		}else {
		return this.puntuacion;
	}

  }
	/**
	 * Metodo para recibir el valor de la puntuacion
	 * @param x
	 */
	public void setPuntuacion(int x) {
		
		this.puntuacion = x;
	}
}
