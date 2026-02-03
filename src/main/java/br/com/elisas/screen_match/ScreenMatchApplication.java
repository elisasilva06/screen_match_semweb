package br.com.elisas.screen_match;

import br.com.elisas.screen_match.model.DadosSerie;
import br.com.elisas.screen_match.service.ConsumoAPI;
import br.com.elisas.screen_match.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoAPI();
        var json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=487226a7");
        System.out.println(json);
        //json = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
        //System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
