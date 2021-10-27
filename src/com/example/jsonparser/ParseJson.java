package com.example.jsonparser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.util.List;

public class ParseJson {

    private List<Table> tables;
    private File file;
    //private JSONParser parser = new JSONParser();

    public ParseJson() {
        this.file = new File("C:\\Users\\alvar\\IntelliJ Projects\\src\\com\\example\\jsonparser\\file.json");
    }

    public List<Table> getTablesFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            final ObjectNode node = new ObjectMapper().readValue(this.file, ObjectNode.class);

            if (node.has("Tables")) {
                System.out.println("Tables: " + node.get("Tables"));

            }
            JsonNode jsonnode = node.get("Tables");
            this.tables = objectMapper.readValue(String.valueOf(jsonnode), new TypeReference<List<Table>>() {
            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(tables);

        return tables;

    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
