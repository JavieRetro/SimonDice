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
	    private Scanner sc;
	    
public CustomReadFile(String texto) throws FileNotFoundException {
		super(texto);
		// TODO Auto-generated constructor stub
		this.red = new FileReader(" ")  ;
		this.sc = new Scanner(this);
	}
		
	@Override
	public ArrayList<String> leerJugadores() {
		// TODO Auto-generated method stub
			ArrayList<String> jugadores = new ArrayList<String>();
			while (sc.hasNextLine()) {
				String texto = sc.nextLine();
				String[] info = texto.split(" ", 2);
				jugadores.add(info[0] + " - " + info[1]);
				}
				closeReadFile();
				return jugadores;
			}
		
		

	@Override
	public void closeReadFile() {
		// TODO Auto-generated method stub
		try {
		if(red != null) {
			red.close();
		}
	}catch(IOException e) {
		System.out.println("No se cierra el scanner de lectura");
		
	}
}
	
}
