package com.sonam.chophel.helper;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * Created by USER on 10/14/2019.
 */
public class MySQLCustomDialect extends MySQL5Dialect {
    public MySQLCustomDialect() {
        super();
        registerHibernateType(-9, "string");
    }
}

