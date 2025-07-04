package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\Windows\\Temp\\file.txt";
        Map<String, Integer> votes = new HashMap<String, Integer>();
        String linha;

        Integer valor;
        String chave;

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((linha = br.readLine()) != null){
                chave = linha.split(",")[0].trim();
                valor = Integer.valueOf(linha.split(",")[1].trim());
                if(votes.get(chave) != null) {
                    valor = votes.get(chave) + valor;
                    votes.put(chave, valor);
                } else {
                    votes.put(chave, valor);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.printf("Error reading file");
            throw new RuntimeException(e);
        }


        for (String key : votes.keySet()) {
            System.out.println(key + ": " + votes.get(key));
        }

    }
}