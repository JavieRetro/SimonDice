package Files;


import java.io.IOException;
import java.io.FileWriter;

public class CustomWriteFile implements ICostumWriteFile {
	private FileWriter wr;
	
	public CustomWriteFile (String texto) throws IOException{
		super();
		this.wr = new FileWriter("C:\\Users\\javie\\OneDrive\\Escritorio\\SimonDiceVer3\\SimonDice3_0\\src\\data\\jugadores.txt");
		
	}
	
	@Override
	public void closeWriteFile() {
		// TODO Auto-generated method stub
		try {
			this.wr.close();
		} catch (IOException e) {
			System.out.println("Error al leer el fichero");
		}
	}

	@Override
	public void writeFile(String texto) {
		// TODO Auto-generated method stub
		try {
		if(wr != null) {
			this.wr.write(texto);
		 }
		}catch (IOException e) {
		System.out.println("Error al fichar el texto");
	}
  }
}
	


