package com.company.hibernate.db.entities;

import com.company.hibernate.db.dao.DAO;

import java.util.List;

/**
 * Created by anjalhussan on 10/25/16.
 */
public class DataSet {

    private List<BaseEntity> fields;

    public DataSet(final List<BaseEntity> fields){
        this.fields = fields;
    }

    public DataSet updateFieldsWith(final DAO dao){
        for (BaseEntity entity:fields){
            entity.setDAO(dao);
        }
        return this;
    }

    public List<BaseEntity> getFields(){return fields;}
}
