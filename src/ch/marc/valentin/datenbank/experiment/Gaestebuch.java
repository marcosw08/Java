package ch.marc.valentin.datenbank.experiment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Gaestebuch {

	public static void main(String[] args) throws IOException, SQLException {
		Connection db=DriverManager.getConnection("jdbc:h2:./daten/gaestebuch", "sa", "sa");
		String auswahl;
		do {
			System.out.println("Hallo, was wollen Sie tun?");
			System.out.println("A - Einträge anzeigen");
			System.out.println("B - Eintrag hinzufügen");
			System.out.println("C - Eintrag löschen");
			System.out.println("D - Beenden");
			auswahl =liesVonDerKonsole("Buchstabe eintippen: ");
			if(auswahl.equals("A")) {
				System.out.println("Einträge anzeigen");
				eintraegeAnzeigen(db);
				
			}
			if(auswahl.equals("B")) {
				System.out.println("Eintrag hinzufügen");
				String name=liesVonDerKonsole("Name eingeben: ");
				String text=liesVonDerKonsole("Text eingeben: ");
				eintragHinzufuegen(name, text);
			}
			if(auswahl.equals("C")) {
				System.out.println("Eintrag löschen");
				
			}
		} while(!auswahl.equals("D"));
		db.close();
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
	private static void eintragHinzufuegen(String name, String text) {
		System.out.println("Ihr Name ist: "+name);
		System.out.println("Ihr Text ist: "+text);
		
	}
	private static void eintraegeAnzeigen (Connection db) throws SQLException {
		Statement s = db.createStatement();
		ResultSet r = s.executeQuery("select * from gaestebuch");
		while (!r.isLast()) {
			System.out.println(r.getString("NAME"));
			r.next();
		}
		s.close();
	}
}

