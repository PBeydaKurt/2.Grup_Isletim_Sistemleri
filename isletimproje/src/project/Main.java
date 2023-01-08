package project;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		File file = new File("giris.txt");

		ProcessBuilder p = new ProcessBuilder(file);

		p.start();

	}

}
