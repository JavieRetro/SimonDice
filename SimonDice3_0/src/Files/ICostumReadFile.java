package Files;

import java.util.ArrayList;

import SimonDice.Jugador;

public interface ICostumReadFile {
	ArrayList<Jugador> leerJugadores();
	void closeReadFile();
}