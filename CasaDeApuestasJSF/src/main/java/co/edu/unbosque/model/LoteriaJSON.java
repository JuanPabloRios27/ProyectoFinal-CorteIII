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

public class LoteriaJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:8088/";
	
	public static ArrayList<Loteria> getJSON() throws IOException, ParseException{
		url = new URL(sitio+"loteria/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<Loteria> lista = new ArrayList<Loteria>();
		lista = parsingLoteria(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Loteria> parsingLoteria(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Loteria> lista = new ArrayList<Loteria>();
        JSONArray loteria = (JSONArray) jsonParser.parse(json);
        Iterator i = loteria.iterator();
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            Loteria loterias = new Loteria();
            loterias.setCodigo(Integer.parseInt(innerObj.get("codigo").toString()));
            loterias.setNumero1(Integer.parseInt(innerObj.get("numero1").toString()));
            loterias.setNumero2(Integer.parseInt(innerObj.get("numero2").toString()));
            loterias.setNumero3(Integer.parseInt(innerObj.get("numero3").toString()));
            loterias.setNumero4(Integer.parseInt(innerObj.get("numero4").toString()));
            loterias.setSerie(Integer.parseInt(innerObj.get("serie").toString()));
            loterias.setdApuesta(innerObj.get("dApuesta").toString());
            loterias.setApuesta(Integer.parseInt(innerObj.get("apuesta").toString()));
           
            
            lista.add(loterias);
        }
        return lista;
	}
	
	public static int postJSON(Loteria loteria) throws IOException {
		url = new URL(sitio+"loteria/guardar");

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
				+ "\"codigo\":\""+ loteria.getCodigo()
				+"\",\"apuesta\": \""+loteria.getApuesta()
				+"\",\"dApuesta\": \""+loteria.getdApuesta()
				+"\",\"numero1\": \""+loteria.getNumero1()
				+"\",\"numero2\": \""+loteria.getNumero2()
				+"\",\"numero3\": \""+loteria.getNumero3()
				+"\",\"numero4\": \""+loteria.getNumero4()
				+"\",\"serie\": \""+loteria.getSerie()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
}

