package com.example.sentenceGenerator;

import com.example.jsonparser.ParseJson;
import com.example.jsonparser.Table;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ParseJson parser = new ParseJson();
        List<Table> tables = parser.getTablesFromJson();
        Generator generator = new Generator(tables);
        generator.generateSentences();
    }
}
