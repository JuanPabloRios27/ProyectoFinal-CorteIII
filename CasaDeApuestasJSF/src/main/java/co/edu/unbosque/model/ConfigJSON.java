package co.edu.unbosque.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConfigJSON {
	private static URL url;
	private static String sitio = "http://localhost:8088/";
	
	public static ArrayList<Config> getJSON() throws IOException, ParseException{
		url = new URL(sitio+"configuracion/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<Config> lista = new ArrayList<Config>();
		lista = parsingConfig(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Config> parsingConfig(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Config> lista = new ArrayList<Config>();
        JSONArray loteria = (JSONArray) jsonParser.parse(json);
        Iterator i = loteria.iterator();
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            
            Config configuracion = new Config();
            configuracion.setNombre(innerObj.get("nombre").toString());
            configuracion.setPresupuesto(Integer.parseInt(innerObj.get("presupuesto").toString()));
            configuracion.setSedes(Integer.parseInt(innerObj.get("sedes").toString()));
            
            lista.add(configuracion);
        }
        return lista;
	}
	
	public static int postJSON(Config config) throws IOException {
		url = new URL(sitio+"configuracion/guardar");

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
				+"\",\"nombre\": \""+config.getNombre()
				+"\",\"sedes\": \""+config.getSedes()
				+"\",\"presupuesto\": \""+config.getPresupuesto()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
}
