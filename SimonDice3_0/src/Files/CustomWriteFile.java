package Files;


import java.io.IOException;
import java.io.FileWriter;

public class CustomWriteFile implements ICostumWriteFile {
	private String wr;
	
	@Override
	public void closeWriteFile() {
		// TODO Auto-generated method stub
		try {
			if(wr != null) {
				this.wr.close();
			}
		}catch(IOException e) {
			System.out.println("No se cierra el scanner de escritura");
			
		}
	}

	@Override
	public void write(String w) {
		// TODO Auto-generated method stub
		try {
		if(w != null) {
			this.wr.write(w);
		 }
		}catch (IOException e) {
		System.out.println("Error al fichar el texto");
	}
  }
}
	


