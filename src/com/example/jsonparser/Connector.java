package com.example.jsonparser;

public class Connector {

    private String source;
    private String end;
    private String sourceCardinality;
    private String endCardinality;


    public Connector() {

    }
    public Connector(String source, String end, String sourceCardinality, String endCardinality) {
        this.source = source;
        this.end = end;
        this.sourceCardinality = sourceCardinality;
        this.endCardinality = endCardinality;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getSourceCardinality() {
        return sourceCardinality;
    }

    public void setSourceCardinality(String sourceCardinality) {
        this.sourceCardinality = sourceCardinality;
    }

    public String getEndCardinality() {
        return endCardinality;
    }

    public void setEndCardinality(String endCardinality) {
        this.endCardinality = endCardinality;
    }
}
