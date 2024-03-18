package Files;


import java.io.IOException;
import java.io.FileWriter;

public class CustomWriteFile extends FileWriter implements ICostumWriteFile {
	private FileWriter wr;
	/**
	 * Constructora que recibe string
	 * @param texto
	 * @throws IOException
	 */
	
	public CustomWriteFile (String texto) throws IOException{
		super(texto);
		this.wr = new FileWriter(" ");
		
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
			this.wr.write(texto);
		}catch (IOException e) {
		System.out.println("Error al fichar el texto");
	}
  }
}
	


