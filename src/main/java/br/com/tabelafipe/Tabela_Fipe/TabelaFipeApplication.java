package br.com.tabelafipe.Tabela_Fipe;

import br.com.tabelafipe.Tabela_Fipe.principal.MenuPrincipal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TabelaFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TabelaFipeApplication.class, args);
	}

    MenuPrincipal menuPrincipal = new MenuPrincipal();

    @Override
    public void run(String... args) throws Exception {
        menuPrincipal.exibeMenu();
    }

}
