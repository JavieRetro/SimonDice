package Files;

import java.util.ArrayList;

import SimonDice.Jugador;

public interface ICostumReadFile {
	ArrayList<String> leerJugadores();
	void closeReadFile();
}