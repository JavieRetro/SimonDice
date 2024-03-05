package SimonDice3_0;

import java.util.Iterator;

public class Record {

	final private int MAX_JUGADORES = 10;
	private int contador = 0;
	private Jugador[] jugadores = new Jugador[MAX_JUGADORES];
	private int maxim = 0;
	
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

	public void maximo() {
		if (contador < MAX_JUGADORES) {
			maxim = contador;
		} else {
			maxim = MAX_JUGADORES;
		}
	}
	
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
	public void showRanking () {
		ordenarRanking();
		for(int i = 0; i < this.maxim -1; i++ ) {
			
		}
		
	}
	public void showBestPlayer() {
		
	}
	public void cargarRanking() {
		
	}
	public void escribirRanking () {
		
	}

}
	
