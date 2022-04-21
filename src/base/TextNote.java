package base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.FileWriter;



public class TextNote extends Note {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String context;

	public TextNote(String title) {
		super(title);
	}

	public TextNote(String title, String content) {
		// TO DO
		super(title);
		this.context = content;
	}

	public String getContext() {
		return this.context;
	}
	
	public void setContext(String content) {
		this.context = content;
	}

	/**
	 * load a TextNote from File f
	 * 
	 * the tile of the TextNote is the name of the file the content of the TextNote
	 * is the content of the file
	 * 
	 * @param File f
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public TextNote(File f) throws FileNotFoundException, IOException {
		super(f.getName());
		this.context = getTextFromFile(f.getAbsolutePath());
		System.out.println("haha");
	}

	/**
	 * get the content of a file
	 * 
	 * @param absolutePath of the file
	 * @return the content of the file
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private String getTextFromFile(String absolutePath) throws FileNotFoundException, IOException {
		String result = "";
		// TODO

		try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(absolutePath)))) {
			System.out.println("haha");
			while ((result += br.readLine()) != null) {

			    System.out.println(result);
			}

		} catch (IOException e) {

			e.printStackTrace();

		}
        

		return result;
	}

	/**
	 * export text note to file
	 * 
	 * 
	 * @param pathFolder path of the folder where to export the note the file has to
	 *                   be named as the title of the note with extension ".txt"
	 * 
	 *                   if the tile contains white spaces " " they has to be
	 *                   replaced with underscores "_"
	 * @throws IOException 
	 * 
	 * 
	 */
	public void exportTextToFile(String pathFolder) throws IOException {
		// TODO
		if (pathFolder == "") {
			pathFolder = ".";
		}
		File file = new File(pathFolder + File.separator + this.getTitle().replaceAll(" ", "_") + ".txt");
		// TODO
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			bw.write(this.getContext());
	        //System.out.println("File written Successfully");
		}catch (IOException ioe) {
			   ioe.printStackTrace();
		}
	}

}
