package ch.marc.valentin.datenbank.experiment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hallo {

	public static void main(String[] args) throws IOException {
		String name = liesVonDerKonsole("Wie heisst du? ");
		System.out.println("Hallo, " + name.toUpperCase() + ", du Held!");
	}
	
	private static String liesVonDerKonsole(String meldung) throws IOException {
		// Geht leider nur im Terminal, nicht in Eclipse:
		//
		// String name = System.console().readLine(meldung);
		// 
		// System.in und System.out geht immer:
		System.out.print(meldung);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		return bufferedReader.readLine();
	}
}
