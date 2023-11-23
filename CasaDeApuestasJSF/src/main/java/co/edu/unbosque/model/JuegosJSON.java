package co.edu.unbosque.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JuegosJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:8088/";
	
	public static ArrayList<Juegos> getJSON() throws IOException, ParseException{
		url = new URL(sitio+"apostadores/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<Juegos> lista = new ArrayList<Juegos>();
		lista = parsingJuegos(json);
		http.disconnect();
		return lista;
	}
	
	
	public static ArrayList<Juegos> parsingJuegos(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Juegos> lista = new ArrayList<Juegos>();
        JSONArray juego = (JSONArray) jsonParser.parse(json);
        Iterator i = juego.iterator();
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            Juegos juegos = new Juegos();
            juegos.setTipo(innerObj.get("tipo").toString());
            juegos.setNombre(innerObj.get("nombre").toString());
            lista.add(juegos);
        }
        return lista;
	}
	
	public static int postJSON(Juegos juego) throws IOException {
		url = new URL(sitio+"juegos/guardar");

		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		try {
			http.setRequestMethod("POST");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		String data = "{"
				+"\",\"juego\": \""+juego.getNombre()
				+"\",\"tipo\":\""+juego.getTipo()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
}

