package br.com.alura.screenmatch.exercicios;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exercicios {
    public void ex01() {
        List<String> input = Arrays.asList("10", "abc", "20", "30x");
        List<Integer> inputInteger = input.stream().map(s -> {
                    try {
                        return Optional.of(Integer.parseInt(s));
                    } catch (NumberFormatException e) {
                        return Optional.<Integer>empty();
                    }
                }).filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        System.out.println(inputInteger);
    }

    public void ex02() {
        System.out.println(processaNumero(Optional.of(5)));
        System.out.println(processaNumero(Optional.of(-3)));
        System.out.println(processaNumero(Optional.empty()));
    }

    public static Optional<Integer> processaNumero(Optional<Integer> numero) {
        return numero.filter(n -> n > 0).map(n -> n*n);
    }

    public void ex03() {
        System.out.println(obterPrimeiroEUltimoNome("  João Carlos Silva   ")); // Saída: "João Silva"
        System.out.println(obterPrimeiroEUltimoNome("Maria   "));
    }

    public static String obterPrimeiroEUltimoNome(String nomeCompleto) {
        String[] nome = nomeCompleto.trim().split(" ");

        if (nome.length == 1) {
            return nome[0];
        }

        return nome[0] + " " + nome[nome.length-1];
    }

    public void ex04() {
        System.out.println(ehPalindromo("socorram me subi no onibus em marrocos")); // Saída: true
        System.out.println(ehPalindromo("Java"));
    }

    public static boolean ehPalindromo(String palavra) {
        String semEspacos = palavra.replace(" ", "").toLowerCase();
        return semEspacos.contentEquals(new StringBuilder(semEspacos).reverse());
    }

    public void ex05() {
        List<String> emails = Arrays.asList("TESTE@EXEMPLO.COM", "exemplo@Java.com ", "Usuario@teste.Com");
        System.out.println(converterEmails(emails));
    }

    public List<String> converterEmails(List<String> emails) {
        return emails.stream().map(s -> s.trim().toLowerCase()).toList();
    }
}
