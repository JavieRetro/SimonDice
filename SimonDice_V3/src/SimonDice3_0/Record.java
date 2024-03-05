package SimonDice3_0;

import java.util.Iterator;

public class Record {

	final private int MAX_JUGADORES = 10;
	private int contador = 0;
	private Jugador[] jugadores = new Jugador[MAX_JUGADORES];
	private int max = 0;
	
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
			max = contador;
		} else {
			max = MAX_JUGADORES;
		}
	}
}
