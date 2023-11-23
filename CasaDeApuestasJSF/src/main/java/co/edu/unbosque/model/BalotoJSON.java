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

public class BalotoJSON {
	
	
	private static URL url;
	private static String sitio = "http://localhost:8088/";
	
	public static ArrayList<BalotoBean> getJSON() throws IOException, ParseException{
		url = new URL(sitio+"baloto/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<BalotoBean> lista = new ArrayList<BalotoBean>();
		lista = parsingBaloto(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<BalotoBean> parsingBaloto(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        ArrayList<BalotoBean> lista = new ArrayList<BalotoBean>();
        JSONArray baloto = (JSONArray) jsonParser.parse(json);
        Iterator i = baloto.iterator();
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            BalotoBean balotos = new BalotoBean();
            balotos.setCodigo(Integer.parseInt(innerObj.get("codigo").toString()));
            balotos.setNum1(Integer.parseInt(innerObj.get("num1").toString()));
            balotos.setNum2(Integer.parseInt(innerObj.get("num2").toString()));
            balotos.setNum3(Integer.parseInt(innerObj.get("num3").toString()));
            balotos.setNum4(Integer.parseInt(innerObj.get("num4").toString()));
            balotos.setNum5(Integer.parseInt(innerObj.get("num5").toString()));
            balotos.setNum6(Integer.parseInt(innerObj.get("num6").toString()));
            balotos.setdApuesta(innerObj.get("dApuesta").toString());
            balotos.setApuesta(Integer.parseInt(innerObj.get("apuesta").toString()));
            
            lista.add(balotos);
        }
        return lista;
	}
	
	public static int postJSON(BalotoBean baloto) throws IOException {
		
		
		url = new URL(sitio+"baloto/guardar");

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
				+ "\"codigo\":\""+ baloto.getCodigo()
				+"\",\"num1\": \""+baloto.getNum1()
				+"\",\"num2\": \""+baloto.getNum2()
				+"\",\"num3\": \""+baloto.getNum3()
				+"\",\"num4\": \""+baloto.getNum4()
				+"\",\"num5\": \""+baloto.getNum5()
				+"\",\"num6\": \""+baloto.getNum6()
				+"\",\"dApuesta\":\""+baloto.getdApuesta()
				+"\",\"apuesta\": \""+baloto.getApuesta()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		
	}
	
}

