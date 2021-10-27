package com.example.jsonparser;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ParseJson json = new ParseJson();
        List<Table> tables = json.getTablesFromJson();
        for (Table table : tables) {
            System.out.println(table.getTableName());
            for (Connector connector : table.getConnectors()) {
                System.out.println(connector.getSource());
                System.out.println(connector.getEnd());
                System.out.println(connector.getSourceCardinality());
                System.out.println(connector.getEndCardinality());
            }
        }
    }
}
