package com.company.hibernate.Model.company;

import com.company.hibernate.db.entities.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by anjalhussan on 10/25/16.
 */
@DynamicUpdate
@Entity
@Table(name = "LOGIN")
public class LogIn extends BaseEntity{


    private static final long serialVersionUID = 2402742607791521669L;

    @Column(name = "ENVIRONMENT")
    private String environment;

    @Column(name = "EMPLOYERUSERNAME")
    private String EmpoyerUserName;

    @Column(name = "THIRDPARTYUSERNAME")
    private String ThirdpartyUserName;

    @Column(name = "PASSWORD")
    private String password;

    public String getEmpoyerUserName() {
        return EmpoyerUserName;
    }

    public void setEmpoyerUserName(String employerUserName) {
        this.EmpoyerUserName = employerUserName;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getThirdPartyUserName() {
        return ThirdpartyUserName;
    }

    public void setThirdpartyUserName(String thirdpartyUserName) {
        this.ThirdpartyUserName = thirdpartyUserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("companyCode", EmpoyerUserName)
                .append("userName", ThirdpartyUserName)
                .append("password", password)
                .toString();
    }
}


