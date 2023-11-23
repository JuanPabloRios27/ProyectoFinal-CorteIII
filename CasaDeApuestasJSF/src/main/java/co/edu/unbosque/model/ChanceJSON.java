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

public class ChanceJSON {
	
	static LocalDate fecha = LocalDate.now();
	DayOfWeek test = fecha.getDayOfWeek();
	static String diaHoy = fecha.format(DateTimeFormatter.ofPattern("EEEE"));
	static String textoNormalizado = Normalizer.normalize(diaHoy, Normalizer.Form.NFD);
    static Pattern patron = Pattern.compile("[^\\p{ASCII}]");
    static String today = patron.matcher(textoNormalizado).replaceAll("");
	
	private static URL url;
	private static String sitio = "http://localhost:8088/";
	
	public static ArrayList<Chance> getJSON() throws IOException, ParseException{
		url = new URL(sitio+"chance/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<Chance> lista = new ArrayList<Chance>();
		lista = parsingChances(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Chance> parsingChances(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Chance> lista = new ArrayList<Chance>();
        JSONArray usuarios = (JSONArray) jsonParser.parse(json);
        Iterator i = usuarios.iterator();
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            Chance chance = new Chance();
            chance.setCodigo(Integer.parseInt(innerObj.get("codigo").toString()));
            chance.setNum1(Integer.parseInt(innerObj.get("num1").toString()));
            chance.setNum2(Integer.parseInt(innerObj.get("num2").toString()));
            chance.setNum3(Integer.parseInt(innerObj.get("num3").toString()));
            chance.setNum4(Integer.parseInt(innerObj.get("num4").toString()));
            chance.setApuesta(Integer.parseInt(innerObj.get("apuesta").toString()));
            chance.setdApuesta(innerObj.get("dApuesta").toString());
            lista.add(chance);
        }
        return lista;
	}
	
	public static int postJSON(Chance chance) throws IOException {
		url = new URL(sitio+"chance/guardar");

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
				+ "\"codigo\":\""+ chance.getCodigo()
				+"\",\"apuesta\": \""+chance.getApuesta()
				+"\",\"dApuesta\": \""+today
				+"\",\"num1\": \""+chance.getNum1()
				+"\",\"num2\": \""+chance.getNum2()
				+"\",\"num3\": \""+chance.getNum3()
				+"\",\"num4\": \""+chance.getNum4()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
}

