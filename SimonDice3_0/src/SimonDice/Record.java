package SimonDice;

import java.util.Iterator;
import javax.management.Query;

public class Record {

	final private int MAX_JUGADORES = 10;
	private int contador = 0;
	private Jugador[] jugadores = new Jugador[MAX_JUGADORES];
	private int maxim = 0;
	
	public Record(){
		this.maxim = 0;
		this.contador = 0;
		this.jugadores = new Jugador[MAX_JUGADORES];
	}
	/**
	 * añadirJugador: Recibimos por parámetro un Jugador lo añadimos al array jugadores
	 * si obtenemos mas de 10 jugadores el siguiente lo actualizo con el jugador que menos puntos tenga el array
	 * @param _jugador recibir objeto del tipo Jugador
	 */
	public void añadirJugador(Jugador _jugador) {
		int minimo = 0;
		for (int i = 0; i < contador; i++) {
			if (jugadores[i].getPuntuacion() < jugadores[minimo].getPuntuacion()) {
				minimo = i;
			}
		}
		if (this.contador < this.MAX_JUGADORES) {
			this.jugadores[contador] = _jugador;
			this.contador++;
		} else {
			if (_jugador.getPuntuacion() > jugadores[minimo].getPuntuacion()) {
				jugadores[minimo] = _jugador;
			}
		}

	}
	/**
	 * maximo: metodo que nos indica cuantos jugadores
	 *  tenemos hasta el momento en array
	 */

	public void maximo() {
		if (contador < MAX_JUGADORES) {
			maxim = contador;
		} else {
			maxim = MAX_JUGADORES;
		}
	}
	/**
	 * ordenarRanking: ordenar de mayor a menor los jugadores por puntuación.
	 */
	
	public void ordenarRanking() {
		maximo();
		
		for(int i = 0; i <= this.maxim - 1; i++ ) {
			for(int j = 0; j <= this.maxim - 1; j++){
				if(jugadores[j].getPuntuacion() < jugadores[j + 1].getPuntuacion()) {
					Jugador temp = jugadores[j + 1];
					jugadores[j + 1] = jugadores[j];
					jugadores[j] = temp;
				}
			}
		}
	}
	/** 
	 * Mostrar los 10 mejores jugadores
	 */
	public void showRanking () {
		ordenarRanking();
		for(int i = 0; i < this.maxim; i++ ) {
			System.out.println(i + 1 + "." + jugadores[i].getNombre() + " " + jugadores[i].getPuntuacion());
		}
		
	}
	
	public Jugador buscarJugador(String _nombre) {
		maximo();
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < maxim) {
			if(_nombre.equals (jugadores[i].getNombre()))
				encontrado = true;
			else 
				i++;
		}
		if(encontrado) {
			return jugadores[i];
			
			
		}else {
		
		return null;
		
		}
	}
	/**
	 * showRanking: Método encargado de mostrar al mejor jugador, si hay más
	 * de un jugador con la misma puntuación que el primero tambien se muestre
	 */
	public void showBestPlayer() {
		ordenarRanking();
		int i = 1;
		System.out.println("1." + jugadores[0].getNombre() + " " + jugadores[0].getPuntuacion());
		while(i < this.maxim) {
			if(jugadores[0].getPuntuacion() == jugadores[i].getPuntuacion()) {
				System.out.println(i + 1 +"."+ jugadores[i].getNombre() + " " + jugadores[i].getPuntuacion());
				i++;
			}else i++;
			
				
				
				
			}
			
		}
	
	public void escribirRanking() {
		
	}
	
	public void cargarRanking() {
		
	}
		
		
	}
