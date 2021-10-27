package com.example.sentenceGenerator;
import com.example.jsonparser.Attribute;
import com.example.jsonparser.Connector;
import com.example.jsonparser.Table;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Generator {

    private List<Table> tables;
    private SentenceStructure sentenceStructure;
    private BufferedWriter outputFile;

    public Generator(List<Table> tables) {

        this.tables = tables;
        this.sentenceStructure = new SentenceStructure();
        try {
          this.outputFile  = new BufferedWriter(new FileWriter("C:\\Users\\alvar\\IntelliJ Projects\\" +
                  "src\\com\\example\\sentenceGenerator\\output.txt",  true));
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
    }

    }

    private String addTableName(Table table) {

        return table.getTableName();
    }
    private List<Connector> addTableConnectors(Table table) {

        return table.getConnectors();
    }

    private List<Attribute> addTableAttributes(Table table) {

        return table.getAttributes();

    }

    public void generateSentences() {

            try {
                for (Table table : this.tables) {
                    this.outputFile.write(this.sentenceStructure.addTableName(table.getTableName()));
                    this.outputFile.newLine();
                    generateAttributeSentences(table.getAttributes(), table.getTableName());
                    generateConnectorSentences(table.getConnectors());
                    System.out.println("Successfully wrote to the file.");
                }
            this.outputFile.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }


    private void generateAttributeSentences(List<Attribute> attributes, String name) {
        for (Attribute attribute : attributes) {
            try {

                this.outputFile.write(this.sentenceStructure.addAttributeInfo(attribute, name));
                this.outputFile.newLine();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }

    private void generateConnectorSentences(List<Connector> connectors) {
        for (Connector connector : connectors) {
            try {

                this.outputFile.write(this.sentenceStructure.addConnectorInfo(connector));
                this.outputFile.newLine();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }




}
