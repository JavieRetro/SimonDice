package SimonDice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.management.Query;

import Files.CustomReadFile;
import Files.CustomWriteFile;

public class Record {

	final int MAX_JUGADORES = 10;
	private int contador ;
	private Jugador[] jugadores;
	private int maxim = 0;
	
	public Record(){
		this.maxim = 0;
		this.contador = 0;
		this.jugadores = new Jugador[MAX_JUGADORES];
	}
	/**
	 * añadirJugador: Recibimos por parámetro un Jugador lo añadimos al array jugadores
	 * si obtenemos mas de 10 jugadores el siguiente lo actualizo con el jugador que menos puntos tenga el array
	 * @param _jugador recibir objeto tipo Jugador
	 */
	public void anadirJugador(Jugador _jugador) {
		if (this.contador < this.MAX_JUGADORES) {
			this.jugadores[contador] = _jugador;
			this.contador++;
		} else {
			this.jugadores[MAX_JUGADORES-1] = _jugador;
			
			}
		}

	
	/**
	 * maximo: metodo que nos indica cuantos jugadores
	 *  tenemos hasta el momento en array
	 */


	/**
	 * ordenarRanking: ordenar de mayor a menor los jugadores por puntuación.
	 */
	
	public void ordenarRanking() {
	
		
		for(int i = 0; i <= this.contador - 1; i++ ) {
			for(int j = 0; j < this.contador - i - 1; j++){
				if(this.jugadores[j].getPuntuacion() < this.jugadores[j + 1].getPuntuacion()) {
					Jugador jugador = jugadores[j + 1];
					jugadores[j + 1] = jugadores[j];
					jugadores[j] = jugador;
				}
			}
		}
	}
	/** 
	 * Mostrar los 10 mejores jugadores
	 */
	public void showRanking () {
		for(int i = 0; i < this.contador; i++ ) {
			System.out.println(i + 1 + "." + this.jugadores[i].getNombre() + " " + this.jugadores[i].getPuntuacion());
		}
		
	}
	/**
	 * buscarJugador: Recibir String, buscamos en el array el jugador
	 * con el mismo nombre y devolver el objto jugador, si no lo encontramos, devolver null.
	 * @param _nombre Recibe String
	 * @return Devolver jugador o null
	 */
	
	public Jugador buscarJugador(String _nombre) {
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
			}else 
				i++;
				
			}
			
		}
	/**
	 * escribirRanking: Recorrer array jugadores, llamamos 
	 * al método writefile y escribimos en el fichero la puntuación 
	 * y el nombre de jugadores
	 */
	
	public void escribirRanking() {
		try {
			CustomWriteFile wr = new CustomWriteFile("./src/data/top.txt");
			String nombre = " ";
			for(int i = 0; i < this.contador; i++) {
				nombre += this.jugadores[i].getPuntuacion() + " " + this.jugadores[i].getNombre() + "\n";
				
				
			}
			wr.writeFile(nombre);
			wr.closeWriteFile();
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	/**
	 * cargarRanking: lee el fichero con el método leerJugadores de CustomReadFile
	 * @throws IOException
	 */
	
	public void cargarRanking() throws IOException {
		
			CustomReadFile red = new CustomReadFile("./src/data/top.txt");
			ArrayList<Jugador> a = red.leerJugadores();
			
			int i = 0;
	        int size = a.size();
	        while (i < size && i < this.MAX_JUGADORES) {
	            Jugador j = a.get(i);
	            anadirJugador(j);
	            i++;
	        }
	        red.closeReadFile();
	
	   }
	}
