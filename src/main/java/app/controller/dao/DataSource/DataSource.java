package app.controller.dao.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSource {
    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "2910post";
    private static final int CONN_POOL_SIZE = 10;

    private BasicDataSource bds = new BasicDataSource();

    private DataSource() {
        bds.setDriverClassName(DRIVER_CLASS_NAME);
        bds.setUrl(DB_URL);
        bds.setUsername(DB_USER);
        bds.setPassword(DB_PASSWORD);
        bds.setInitialSize(CONN_POOL_SIZE);
    }

    private static class DataSourceHolder {
        private static final DataSource INSTANCE = new DataSource();
    }

    public static DataSource getInstance() {
        return DataSourceHolder.INSTANCE;
    }

    public BasicDataSource getBds() {
        return bds;
    }

    public void setBds(BasicDataSource bds) {
        this.bds = bds;
    }
}