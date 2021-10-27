package com.example.jsonparser;


import java.util.List;

public class Table {

    private String tableName;
    private List<Attribute> attributes;
    private List<Connector> connectors;


    public Table() {

    }

    public Table(String tableName, List<Attribute> attributes, List<Connector> connectors) {
        this.tableName = tableName;
        this.attributes = attributes;
        this.connectors = connectors;
    }


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Connector> getConnectors() {
        return connectors;
    }

    public void setConnectors(List<Connector> connectors) {
        this.connectors = connectors;
    }
}
