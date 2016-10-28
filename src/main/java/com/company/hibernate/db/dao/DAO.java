package com.company.hibernate.db.dao;

import com.company.hibernate.db.entities.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by anjalhussan on 10/25/16.
 */
public interface DAO<T extends BaseEntity, ID extends Serializable> {
    T findById(ID id);

    List<T>findall();

    void save(final T entity);
}
