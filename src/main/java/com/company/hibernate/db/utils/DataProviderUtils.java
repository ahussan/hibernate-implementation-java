package com.company.hibernate.db.utils;

import com.company.hibernate.annotations.Entity;
import com.company.hibernate.db.dao.DAO;
import com.company.hibernate.db.dao.GenericDAO;
import com.company.hibernate.db.entities.BaseEntity;
import com.company.hibernate.db.entities.DataSet;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Created by anjalhussan on 10/25/16.
 */
public class DataProviderUtils {


    public static final String GENERIC_DP = "genericDP";

    private DataProviderUtils() {
    }

    @SuppressWarnings("unchecked")
    @DataProvider(name = GENERIC_DP)
    public static Iterator<Object[]> provideDBData(final Method testMethod) {
        if (testMethod == null) {
            throw new IllegalArgumentException("Test method cannot be null!");
        }

        final List<DataSet> dataSets = new ArrayList<>();
        final List<Object[]> outputData = new ArrayList<>();

        int outputDataSize = Integer.MAX_VALUE;

        for (Entity entity : testMethod.getAnnotationsByType(Entity.class)) {
            final DAO entityDAO = new GenericDAO<>(entity.entity(), entity.schema());
            final List<BaseEntity> retrievedFields = new ArrayList<>();

            int minInvocationCount = entity.ids().length;

            if (minInvocationCount > 0) {
                for (long id : entity.ids()) {
                    retrievedFields.add(entityDAO.findById(id));
                }
            } else {
                retrievedFields.addAll(entityDAO.findall());
                minInvocationCount = retrievedFields.size();
            }

            dataSets.add(new DataSet(retrievedFields).updateFieldsWith(entityDAO));

            final int currentDataSize = outputDataSize;
            outputDataSize = Optional.of(IntStream.of(entity.invocationCount(), minInvocationCount)
                    .filter(value -> value > 0)
                    .min()
                    .getAsInt())
                    .filter(value -> value < currentDataSize)
                    .orElse(currentDataSize);
        }

        if (outputDataSize < Integer.MAX_VALUE) {
            for (int i = 0; i < outputDataSize; i++) {
                final Object[] dataSet = new Object[dataSets.size()];

                for (int j = 0; j < dataSets.size(); j++) {
                    dataSet[j] = dataSets.get(j).getFields().get(i);
                }

                outputData.add(dataSet);
            }
        }
        return outputData.iterator();
    }

}
