package com.example.sentenceGenerator;

import com.example.jsonparser.Attribute;
import com.example.jsonparser.Connector;

public class SentenceStructure {



    public SentenceStructure() {


    }

    public String addTableName(String name) {
       String tableName = "Andmebaasis on tabel ";
       tableName = tableName + name;

       return tableName;
    }


    public String addAttributeInfo(Attribute attribute, String name) {

        String attributeInfo = "Tabelis " + name;
        if (attribute.ispKey()) {
            attributeInfo +=  " on primaarvõti ";
        }
        else if(attribute.isfKey()) {
            attributeInfo += " on välisvõti";
        }
        else {
            attributeInfo +=  " on veerg ";
        }
        attributeInfo += attribute.getName()
        + ", mis on tüüpi " + attribute.getType() + " suurusega " + attribute.getLength() +
        ", algväärtusega " + attribute.getInitialValue();
        if (attribute.isNotNull()) {

            attributeInfo += ", piiranguga NOT NULL";
        }
        return attributeInfo;

    }

    public String addConnectorInfo(Connector connector) {

        String connectorInfo = "Iga rida tabelis " + connector.getSource() + " on seotud täpselt ühe reaga tabelis "
                + connector.getEnd() + ", kus nende vahel on " +
                connector.getSourceCardinality() + " " + connector.getEndCardinality() + " suhe.";

        return connectorInfo;

    }
}
