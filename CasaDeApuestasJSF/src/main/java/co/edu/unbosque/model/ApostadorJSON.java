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

public class ApostadorJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:8088/";
	
	public static ArrayList<Apostador> getJSON() throws IOException, ParseException{
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
		ArrayList<Apostador> lista = new ArrayList<Apostador>();
		lista = parsingUsuarios(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Apostador> parsingUsuarios(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Apostador> lista = new ArrayList<Apostador>();
        JSONArray usuarios = (JSONArray) jsonParser.parse(json);
        Iterator i = usuarios.iterator();
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            Apostador apostador = new Apostador();
            apostador.setCedula(Integer.parseInt(innerObj.get("cedula").toString())); 
            apostador.setCelular(Integer.parseInt(innerObj.get("celular").toString()));
            apostador.setDireccion(innerObj.get("direccion").toString());
            apostador.setNombre(innerObj.get("nombre").toString());
            apostador.setSede(innerObj.get("sede" ).toString());
            lista.add(apostador);
        }
        return lista;
	}
	public static int postJSON(Apostador ab) throws IOException {
		url = new URL(sitio+"apostadores/guardar");
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
				+ "\"nombre\":\""+ ab.getNombre()
				+ "\",\"cedula\": \""+ab.getCedula()
				+ "\",\"celular\": \""+ ab.getCelular()
				+ "\",\"direccion\": \""+ab.getDireccion()
				+ "\",\"sede\":\""+ ab.getSede()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	public static void eliminar(int cedula) throws IOException, ParseException{
		url = new URL(sitio+"apostadores/eliminar/"+cedula);
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
	public static void editar() throws IOException, ParseException{
		url = new URL(sitio+"apostadores/editar/");
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

