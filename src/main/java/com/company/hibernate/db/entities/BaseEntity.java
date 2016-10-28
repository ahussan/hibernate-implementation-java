package com.company.hibernate.db.entities;


import com.company.hibernate.db.dao.DAO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by anjalhussan on 10/25/16.
 */

@MappedSuperclass
public abstract class BaseEntity implements Serializable{

    private static final long serialVersionUID=8219313243230767802L;

    @Id
    @GeneratedValue
    private Long id;

    @Transient
    private DAO dao;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setDAO(final DAO dao) {
        this.dao = dao;
    }

    public void save(){dao.save(this);}

}
