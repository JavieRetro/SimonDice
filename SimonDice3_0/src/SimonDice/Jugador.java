package SimonDice;
/*
 * clase Jugador
 */

public class Jugador {
	private String nombre;
	private int puntuacion;
	/**
	 * 
	 * @param _nombre vble String
	 */
	
	public Jugador (String _nombre) {
	this.nombre = _nombre;
	this.puntuacion = 0;
	}
	/**
	 * 
	 * @return vble String
	 */
	public String getNombre() {
		return this.nombre;	
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
