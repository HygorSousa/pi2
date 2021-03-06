package com.unitins.projetointegrador2.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;


import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Controller
public class GreetingController {
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {

		String sessionId = "";
		String autenticacaoEncoded = "";
		String respostaBot = "";

		// ###################################################### criar sessao
		try {
			autenticacaoEncoded = Base64.getEncoder().encodeToString(
					("apikey:xnH_yGvMwMxSZIVNkYqoHj1e2uNos5QSJ8YvcjN6Bf_4").getBytes(StandardCharsets.UTF_8));

			String url = "https://api.us-south.assistant.watson.cloud.ibm.com/instances/a9e649e9-e1bc-4ee1-9a3c-f93128901e70/v2/assistants/fcccd629-6733-4725-ba80-79b91765024f/sessions?version=2020-04-01";

			HttpsURLConnection httpClient = (HttpsURLConnection) new URL(url).openConnection();

			// add reuqest header
			httpClient.setRequestMethod("POST");
			httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
			httpClient.setRequestProperty("content-type", "application/json");
			httpClient.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			httpClient.setRequestProperty("Authorization", "Basic " + autenticacaoEncoded);

			String urlParameters = "{\"input\": {\"text\": \"boa noite\"}}";

			// Send post request
			httpClient.setDoOutput(true);
			try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
				wr.writeBytes(urlParameters);
				wr.flush();
			}

			int responseCode = httpClient.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			try (BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()))) {

				String line;
				StringBuilder response = new StringBuilder();

				while ((line = in.readLine()) != null) {
					response.append(line);
				}

				// print result
				System.out.println(response.toString());

				sessionId = response.toString();
				sessionId = sessionId.replace("{\"session_id\":\"", "");
				sessionId = sessionId.replace("\"}", "");
				// System.out.println(sessionId);

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		// ###################################################### enviar pro bot
		try {
			String url = "https://api.us-south.assistant.watson.cloud.ibm.com/instances/a9e649e9-e1bc-4ee1-9a3c-f93128901e70/v2/assistants/fcccd629-6733-4725-ba80-79b91765024f/sessions/"
					+ sessionId + "/message?version=2020-04-01";

			HttpsURLConnection httpClient = (HttpsURLConnection) new URL(url).openConnection();

			// add reuqest header
			httpClient.setRequestMethod("POST");
			httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
			httpClient.setRequestProperty("content-type", "application/json");
			httpClient.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			httpClient.setRequestProperty("Authorization", "Basic " + autenticacaoEncoded);

			String urlParameters = "{\"input\": {\"text\": \"" + message.getName() + "\"}}";

			// Send post request
			httpClient.setDoOutput(true);
			try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
				wr.writeBytes(urlParameters);
				wr.flush();
			}

			int responseCode = httpClient.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			try (BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()))) {

				String line;
				StringBuilder response = new StringBuilder();

				while ((line = in.readLine()) != null) {
					response.append(line);
				}

				// print result
				System.out.println(response.toString());

				String[] retornoArray = response.toString().split("\"text\":\"");
				retornoArray = retornoArray[1].split("\"}],");

				if (response.toString().contains("suggestion")) {
					respostaBot = "Eu não entendi. Por favor, tente reformular a frase.";
				}

				else {
					respostaBot = retornoArray[0].replace("\"}]}}", "");
				}

				System.out.println(retornoArray[0]);

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		// ############################################### retornar output

		Greeting greeting = new Greeting();
		// System.out.println(message.getName());
		// input

		greeting.setContent(HtmlUtils.htmlEscape(respostaBot));
		// System.out.println(greeting.getContent());
		// output

		return greeting;
	}

}