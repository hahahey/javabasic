package com.hahahey.leetcode;


import java.sql.*;

public class JdbcOperation {
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://192.168.233.101:3306/dev?useSSL=false";
    public static String username = "root";
    public static String passwd = "root";

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        //PreparedStatement pre = null;
        //ResultSet rs = null;


        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL, username, passwd);


        Statement statement = conn.createStatement();


        //boolean execute = statement.execute("create table person(name varchar(10),age int)");
        //boolean execute = statement.execute("drop table person;");

        //boolean execute = statement.execute("insert into person values('aaa',11);", 0);
        //boolean execute1 = statement.execute("update person set age = 100 where name = 'aaa';");

        String sql = "select * from person;";
        String[] split = sql.split(";");
        int length = split.length;

        for (int i = 0; i < length; i++) {
            boolean execute = statement.execute(split[i]);
            if (execute) {
                ResultSet resultSet = statement.getResultSet();
                if(resultSet.next()){
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    System.out.println("columnCount " + columnCount);
                    for (int i1 = 1; i1 <= columnCount; i1++) {
//                        System.out.println("metaData.getColumnName(i1) " + metaData.getColumnName(i1));
//                         System.out.println(metaData.getColumnType(i1));
//                       System.out.println(metaData.getColumnLabel(i1));
//                        System.out.println(metaData.getColumnTypeName(i1));
//                       System.out.println(metaData.getCatalogName(i1));
//                        System.out.println(metaData.getColumnClassName(i1));
//                        System.out.println(metaData.getColumnDisplaySize(i1));
//                        System.out.println(metaData.getPrecision(i1));
//                        System.out.println(metaData.getScale(i1));
//                        System.out.println(metaData.getSchemaName(i1));
                        System.out.println(metaData.getTableName(i1));
                        System.out.println();

                    }

                }

            }

        }



        //System.out.println("execute  " + execute);


    }
}
