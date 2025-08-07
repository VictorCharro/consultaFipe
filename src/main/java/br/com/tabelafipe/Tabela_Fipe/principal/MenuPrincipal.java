package br.com.tabelafipe.Tabela_Fipe.principal;

import br.com.tabelafipe.Tabela_Fipe.model.Dados;
import br.com.tabelafipe.Tabela_Fipe.model.DadosAnos;
import br.com.tabelafipe.Tabela_Fipe.model.DadosModelos;
import br.com.tabelafipe.Tabela_Fipe.model.DadosResultado;
import br.com.tabelafipe.Tabela_Fipe.service.ConsumoAPI;
import br.com.tabelafipe.Tabela_Fipe.service.ConverteDados;

import java.util.Comparator;
import java.util.Scanner;

public class MenuPrincipal {

    Scanner sc = new Scanner(System.in);
    ConsumoAPI consumoAPI = new ConsumoAPI();
    ConverteDados converteDados = new ConverteDados();
    private static final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu(){

        System.out.print("Digite se quer ver Carros, Motos ou Caminhoes: ");
        String opcao = sc.nextLine();
        var jsonMarcas = consumoAPI.obterDados(BASE_URL + opcao + "/marcas");

        var marcas = converteDados.obterLista(jsonMarcas, Dados.class);
        marcas.stream()
                        .sorted(Comparator.comparing(Dados::codigo))
                        .forEach(System.out::println);

        System.out.print("\nDigite o código da marca desejada: ");
        String opcao2 = sc.nextLine();

        var jsonModelos = consumoAPI.obterDados(BASE_URL + opcao + "/marcas/" + opcao2 + "/modelos");

        var modelos = converteDados.obterDados(jsonModelos, DadosModelos.class);
        modelos.modelos()
                .stream().sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.print("\nDigite o codigo do seu modelo: ");
        String opcao3 = sc.nextLine();

        var jsonAno = consumoAPI.obterDados(BASE_URL + opcao + "/marcas/" + opcao2 + "/modelos/" + opcao3 + "/anos");

        var anos = converteDados.obterLista(jsonAno, DadosAnos.class);
        anos.stream()
                .sorted(Comparator.comparing(DadosAnos::codigo))
                .forEach(System.out::println);

        System.out.print("\nDigite o código do ano do seu modelo: ");
        String opcao4 = sc.nextLine();

        var jsonResultado = consumoAPI.obterDados(BASE_URL + opcao + "/marcas/" + opcao2 + "/modelos/" + opcao3 + "/anos/" + opcao4);

        var resultado = converteDados.obterDados(jsonResultado, DadosResultado.class);
        System.out.println("\nDados da tabela FIPE para seu carro");
        System.out.println("Valor: " + resultado.valor());
        System.out.println("Marca: " + resultado.marca());
        System.out.println("Modelo: " + resultado.modelo());
        System.out.println("Ano: " + resultado.ano());
        System.out.println("Combustível: " + resultado.combustivel());
    }
}
