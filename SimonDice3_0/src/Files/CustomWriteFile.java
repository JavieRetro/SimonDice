package Files;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

public class CustomWriteFile implements ICostumWriteFile {
	private String w;
	
	public CustomWriteFile(String w) {
		this.w = w;
	}
	
	public void writeToFile (String writing) {
		try (FileWriter writer = new FileWriter(w) {
		writer.write(writing);
		}catch (IOException e) {
			
		}
			
	}
	
	

	@Override
	public void closeWriteFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(String texto) {
		// TODO Auto-generated method stub
		
	}

}
