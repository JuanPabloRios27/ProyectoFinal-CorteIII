package co.edu.unbosque.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BetplayJSON {
	
	static LocalDate fecha = LocalDate.now();
	DayOfWeek test = fecha.getDayOfWeek();
	static String diaHoy = fecha.format(DateTimeFormatter.ofPattern("EEEE"));
	static String textoNormalizado = Normalizer.normalize(diaHoy, Normalizer.Form.NFD);
    static Pattern patron = Pattern.compile("[^\\p{ASCII}]");
    static String today = patron.matcher(textoNormalizado).replaceAll("");
	
	private static URL url;
	private static String sitio = "http://localhost:8088/";
	
	public static ArrayList<Betplay> getJSON() throws IOException, ParseException{
		url = new URL(sitio+"betplay/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<Betplay> lista = new ArrayList<Betplay>();
		lista = parsingBetplays(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Betplay> parsingBetplays(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Betplay> lista = new ArrayList<Betplay>();
        JSONArray usuarios = (JSONArray) jsonParser.parse(json);
        Iterator i = usuarios.iterator();
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            Betplay bet = new Betplay();
            bet.setCodigo(Integer.parseInt(innerObj.get("codigo").toString()));
            bet.setResultado(Integer.parseInt(innerObj.get("codigo").toString()));
            bet.setPartido(innerObj.get("partido").toString());
            bet.setdApuesta(innerObj.get("dApuesta").toString());
            bet.setApuesta(Integer.parseInt(innerObj.get("apuesta").toString()));
            lista.add(bet);
        }
        return lista;
	}
	
	public static int postJSON(Betplay bet) throws IOException {
		url = new URL(sitio+"betplay/guardar");

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
				+ "\"codigo\":\""+ bet.getCodigo()
				+"\",\"apuesta\": \""+bet.getApuesta()
				+"\",\"dApuesta\": \""+today
				+"\",\"partido\": \""+bet.getPartido()
				+"\",\"resultado\": \""+bet.getResultado()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
}

