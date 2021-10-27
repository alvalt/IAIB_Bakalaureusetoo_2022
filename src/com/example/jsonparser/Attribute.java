package com.example.jsonparser;

public class Attribute {

    private String name;
    private String type;
    private int length;
    private boolean notNull;
    private boolean pKey;
    private boolean fKey;
    private String initialValue;

    public Attribute() {

    }
    public Attribute(String name, String type, int length, boolean notNull,
                     boolean pKey, boolean fKey, String initialValue) {
        this.name = name;
        this.type = type;
        this.length = length;
        this.notNull = notNull;
        this.pKey = pKey;
        this.fKey = fKey;
        this.initialValue = initialValue;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    public boolean ispKey() {
        return pKey;
    }

    public void setpKey(boolean pKey) {
        this.pKey = pKey;
    }

    public boolean isfKey() {
        return fKey;
    }

    public void setfKey(boolean fKey) {
        this.fKey = fKey;
    }

    public String getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(String initialValue) {
        this.initialValue = initialValue;
    }



}
