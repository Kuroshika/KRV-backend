package com.kuka.krv.dao.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactorySingleton {
    volatile static private SqlSessionFactory factory;

    private SqlSessionFactorySingleton() {};

    public static SqlSessionFactory getFactory() {
        if (factory == null) {
            synchronized (SqlSessionFactorySingleton.class) {
                if (factory == null) {
                    try {
                        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
                        factory = new SqlSessionFactoryBuilder().build(is);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return factory;
    }


}
