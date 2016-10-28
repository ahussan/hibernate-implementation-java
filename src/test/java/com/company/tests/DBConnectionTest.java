package com.company.tests;

import com.company.hibernate.Model.company.LogIn;
import com.company.hibernate.annotations.Entity;
import com.company.hibernate.db.utils.DataProviderUtils;
import org.testng.annotations.Test;

import static com.company.hibernate.db.utils.DataProviderUtils.GENERIC_DP;
import static com.company.hibernate.enums.Schema.AUTOMATION;

/**
 * Created by anjalhussan on 10/25/16.
 */
public class DBConnectionTest {

    @Entity(entity = LogIn.class, schema = AUTOMATION, ids = 1)
    @Test(dataProviderClass = DataProviderUtils.class, dataProvider = GENERIC_DP)
    public void generateForms(final LogIn login) {
        System.out.println(login.getEnvironment());
    }

    }
