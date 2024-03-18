package Files;

import java.io.Reader;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.util.Scanner;
/*Importar clase trabajador del paquete SimonDice*/
import SimonDice.Jugador;


public class CustomReadFile extends FileReader implements ICostumReadFile{
	    

		private FileReader red;
	    private Scanner scanner;
	    
public CustomReadFile(String texto) throws FileNotFoundException {
		super(texto);
		// TODO Auto-generated constructor stub
		this.red = new FileReader("SimonDice3_0/src/data/top.txt");
		this.scanner = new Scanner(this);
	}
		
	@Override
	/**
	 * leerJugadores: Se lee los jugadores del fichero y estos se añaden a un arrayList
	 */
	public ArrayList<Jugador> leerJugadores() {
		// TODO Auto-generated method stub
			ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
			while (scanner.hasNextLine()) {
				int puntuacion = scanner.nextInt();
				String texto = scanner.nextLine();
				Jugador jugador = new Jugador(texto);
				jugador.setPuntuacion(puntuacion);
				jugadores.add(jugador);
			
				}
				closeReadFile();
				return jugadores;
			}
		
		

	@Override
	public void closeReadFile() {
		// TODO Auto-generated method stub
		try {
			this.red.close();
		
	}catch(IOException e) {
		System.out.println("No se cierra el scanner de lectura");
		
	}
}
	
}
