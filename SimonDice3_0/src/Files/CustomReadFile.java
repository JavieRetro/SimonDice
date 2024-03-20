package Files;

import java.io.Reader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.io.FileReader;
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.util.Scanner;
/*Importar clase trabajador del paquete SimonDice*/
import SimonDice.Jugador;


public class CustomReadFile extends FileReader implements ICostumReadFile{
	    
	ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	    private Scanner scanner;
	    
public CustomReadFile(String texto) throws FileNotFoundException {
		super(texto);
		// TODO Auto-generated constructor stub
		
		this.scanner = new Scanner(this);
	}
		
	@Override
	/**
	 * leerJugadores: Se lee los jugadores del fichero y estos se añaden a un arrayList
	 */
	public ArrayList<Jugador> leerJugadores() {
		// TODO Auto-generated method stub
		
			while (this.scanner.hasNextLine()) {
				try {
				int puntuacion = scanner.nextInt();
				String texto = scanner.next();
				Jugador jugador = new Jugador(texto);
				jugador.setPuntuacion(puntuacion);
				jugadores.add(jugador);
				this.scanner.nextLine();
				}catch(NoSuchElementException e) {
					System.out.println(e);
				}
			
			}
				return this.jugadores;
		
		}
		
		

	@Override
	public void closeReadFile() {
		// TODO Auto-generated method stub
		try {
			this.close();
		
	}catch(IOException e) {
		System.out.println("No se cierra el scanner de lectura");
		
	}
}
	
}
