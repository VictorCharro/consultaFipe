package br.com.tabelafipe.Tabela_Fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosResultado(@JsonAlias("TipoVeiculo") String tipo,
                             @JsonAlias("Valor") String valor,
                             @JsonAlias("Marca") String marca,
                             @JsonAlias("Modelo") String modelo,
                             @JsonAlias("AnoModelo") String ano,
                             @JsonAlias("Combustivel") String combustivel,
                             @JsonAlias("CodigoFipe") String codigoFipe,
                             @JsonAlias("MesReferencia") String mes) {
}


