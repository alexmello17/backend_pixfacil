package com.pix.api.pixfacil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class IntegracaoPayGoTest {
	
	public static void main(String[] args) throws IOException {
		URL obj = new URL("https://api.gate2all.com.br/v1/transactions");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("content-type", "application/json");
		con.setRequestProperty("authenticationApi", "alex.provider");
		con.setRequestProperty("authenticationKey", "E065537FA4D89942CE26");

		String body = "{"
		        + "\"referenceId\": \"123456789\","
		        + "\"amount\": \"1000\","
		        + "\"description\": \"TV LG 42\","
		        + "\"postBackUrl\": \"http://url-notificacao\","
		        + "\"payment\": {"
		        + "    \"pix\" : {"
		        + "        \"provider\" : \"C6BANK\","
		        + "        \"key\" :  \"5511970800770\" "
		        + "    }"
		        + "}"
		        + "}";

		con.setDoOutput(true);
		DataOutputStream dos = new DataOutputStream(con.getOutputStream());
		dos.writeBytes(body);
		dos.flush();
		dos.close();

		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(con.getInputStream())));
		String response = scanner.nextLine();
		scanner.close();

		System.out.println(response);
	}
}



