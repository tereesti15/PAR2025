import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class UnHttpClient {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Uso: java -jar unHttpClient.jar -u <URL> -m <METHOD> [-p <params>]");
            return;
        }

        String url = "";
        String method = "GET";
        String params = "";

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-u":
                    url = args[i + 1];
                    i++;
                    break;
                case "-m":
                    method = args[i + 1].toUpperCase();
                    i++;
                    break;
                case "-p":
                    params = args[i + 1];
                    i++;
                    break;
            }
        }
		System.out.println("Pedido Http: ");
		System.out.println("URL: " + url);
		System.out.println("METODO: " + method);
		System.out.println("PARAMETROS: " + params);
        sendHttpRequest(url, method, params);
    }

    private static void sendHttpRequest(String urlString, String method, String params) {
        try {
            if (!params.isEmpty() && method.equals("GET")) {
                urlString += "?" + params;
            }
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setRequestProperty("User-Agent", "UnHttpClient/1.0");

            if (!params.isEmpty() && (method.equals("POST") || method.equals("PUT"))) {
                connection.setDoOutput(true);
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = params.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
            }

            System.out.println("\nHTTP Request:");
            System.out.println(method + " " + urlString + " HTTP/1.1");

            int responseCode = connection.getResponseCode();
            System.out.println("\nHTTP Response:");
            System.out.println("HTTP/1.1 " + responseCode + " " + connection.getResponseMessage());

            connection.getHeaderFields().forEach((key, value) ->
                    System.out.println("Header: " + key + " Value: " + value));

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line).append("\n");
                }
                System.out.println(response);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
