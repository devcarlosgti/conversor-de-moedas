package calculos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.Set;


public class ConversorMoedas {

    private static final Set<String> moedasUsadas = new HashSet<>();

    public static void converter(String de, String para, double valor) throws Exception {

        moedasUsadas.add(de);
        moedasUsadas.add(para);

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + "2c6c9b7436273b3b08b12a70/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject taxas = json.getAsJsonObject("conversion_rates");

        double taxa = taxas.get(para).getAsDouble();
        double convertido = valor * taxa;

        System.out.printf("%.2f %s = %.2f %s%n", valor, de, convertido, para);
    }

    public static void listarCotacoesUsadas() throws Exception {

        String[] usadas = {"USD", "BRL", "EUR"};


        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + "2c6c9b7436273b3b08b12a70/latest/USD" );

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject taxas = json.getAsJsonObject("conversion_rates");

        System.out.println("\n=== COTAÇÕES USADAS (BASE " + endereco + ") ===\n");

        for (String moeda : usadas) {
            if (taxas.has(moeda)) {
                double valor = taxas.get(moeda).getAsDouble();
                System.out.printf("\"%s\": %s,\n", moeda, valor);
            }
        }
    }
    public static void gerarArquivoCotacoesUsadas() throws Exception {

        // defina aqui as moedas usadas no seu conversor:
        String[] usadas = {"USD", "BRL", "EUR"};

        //String base = "USD"; // moeda base usada no projeto

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + "2c6c9b7436273b3b08b12a70/latest/USD" );

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject taxas = json.getAsJsonObject("conversion_rates");

        // objeto JSON final apenas com as moedas usadas
        JsonObject cotacoesFiltradas = new JsonObject();

        for (String moeda : usadas) {
            if (taxas.has(moeda)) {
                cotacoesFiltradas.addProperty(moeda, taxas.get(moeda).getAsDouble());
            }
        }

        // converte para string JSON formatada
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonFinal = gson.toJson(cotacoesFiltradas);

        // salva no arquivo
        FileWriter writer = new FileWriter("cotacoes.json");
        writer.write(jsonFinal);
        writer.close();

        System.out.println("\nArquivo 'cotacoes.json' criado com sucesso!");
    }
}