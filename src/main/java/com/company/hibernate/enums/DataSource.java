package com.company.hibernate.enums;

/**
 * Created by anjalhussan on 10/25/16.
 */
public enum DataSource {
    AUTOMATION_SOURCE("mysql-data-source.xml");

    private String source;
    DataSource(final String source){
        this.source=source;
    }

    public String getSource(){
        return source;
    }
}
