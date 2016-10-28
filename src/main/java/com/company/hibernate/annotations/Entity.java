package com.company.hibernate.annotations;


import com.company.hibernate.enums.Schema;

import java.lang.annotation.*;

/**
 * Created by anjalhussan on 10/25/16.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Repeatable(Entities.class)
public @interface Entity {

    Class entity();
    Schema schema();

    int invocationCount() default 0;

    long[] ids() default {};


}
