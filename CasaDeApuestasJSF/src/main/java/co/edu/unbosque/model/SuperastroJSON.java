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

public class SuperastroJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:8088/";
	
	public static ArrayList<Superastro> getJSON() throws IOException, ParseException{
		url = new URL(sitio+"superastro/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<Superastro> lista = new ArrayList<Superastro>();
		lista = parsingSuperastro(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Superastro> parsingSuperastro(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Superastro> lista = new ArrayList<Superastro>();
        JSONArray loteria = (JSONArray) jsonParser.parse(json);
        Iterator i = loteria.iterator();
        while (i.hasNext()) {
           JSONObject innerObj = (JSONObject) i.next();
           Superastro superastro = new Superastro();
           superastro.setCodigo(Integer.parseInt(innerObj.get("codigo").toString()));
           superastro.setNumerou1(Integer.parseInt(innerObj.get("numero1").toString()));
           superastro.setNumerou2(Integer.parseInt(innerObj.get("numero2").toString()));
           superastro.setNumerou3(Integer.parseInt(innerObj.get("numero3").toString()));
           superastro.setNumerou4(Integer.parseInt(innerObj.get("numero4").toString()));
           superastro.setSignou(innerObj.get("signou").toString());
           superastro.setdApuesta(innerObj.get("dApuesta").toString());
           superastro.setApuesta(Integer.parseInt(innerObj.get("apuesta").toString()));
            
           lista.add(superastro);
        }
        return lista;
	}
	
	public static int postJSON(Superastro superastro) throws IOException {
		url = new URL(sitio+"superastro/guardar");

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
				+ "\"codigo\":\""+ superastro.getCodigo()
				+"\",\"numerou1\": \""+superastro.getNumerou1()
				+"\",\"numerou2\": \""+superastro.getNumerou2()
				+"\",\"numerou3\": \""+superastro.getNumerou3()
				+"\",\"numerou4\": \""+superastro.getNumerou4()
				+"\",\"signou\": \""+superastro.getSignou()
				+"\",\"apuesta\": \""+superastro.getApuesta()
				+"\",\"dApuesta\": \""+superastro.getdApuesta()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
}

