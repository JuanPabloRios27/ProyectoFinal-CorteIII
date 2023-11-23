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

public class SedeJSON {
	private static URL url;
	private static String sitio = "http://localhost:8088/";
	
	public static ArrayList<Sede> getJSON() throws IOException, ParseException{
		url = new URL(sitio+"sede/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<Sede> lista = new ArrayList<Sede>();
		lista = parsingSede(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Sede> parsingSede(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Sede> lista = new ArrayList<Sede>();
        JSONArray loteria = (JSONArray) jsonParser.parse(json);
        Iterator i = loteria.iterator();
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            Sede sede = new Sede();
            sede.setCodigo(Integer.parseInt(innerObj.get("codigo").toString()));
            sede.setNombre(innerObj.get("nombre").toString());
            sede.setAfiliacion(innerObj.get("afiliacion").toString());
            sede.setnTrabajadores(Integer.parseInt(innerObj.get("nTrabajadores").toString()));
            lista.add(sede);
        }
        return lista;
	}
	
	public static int postJSON(Sede sede) throws IOException {
		url = new URL(sitio+"sede/guardar");

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
				+ "\"codigo\":\""+ sede.getCodigo()
				+"\",\"nombre\": \""+sede.getNombre()
				+"\",\"afiliacion\": \""+sede.getAfiliacion()
				+"\",\"nTrabajadores\": \""+sede.getnTrabajadores()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	public static void eliminar(int codigo) throws IOException, ParseException{
		url = new URL(sitio+"sede/eliminar/"+codigo);
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("DELETE");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		http.disconnect();
	}
}
