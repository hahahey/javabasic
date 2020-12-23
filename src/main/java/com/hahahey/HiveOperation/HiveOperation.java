package com.hahahey.HiveOperation;

import org.apache.hive.service.rpc.thrift.*;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;


public class HiveOperation {
    public static void main(String[] args) throws Exception {
        TTransport tTransport = new TSocket("192.168.241.101", 10000);
        TBinaryProtocol protocol = new TBinaryProtocol(tTransport);
        TCLIService.Client client = new TCLIService.Client(protocol);

        tTransport.open();
        System.out.println("transport is open " + tTransport.isOpen());


        TOpenSessionReq openSessionReq = new TOpenSessionReq(TProtocolVersion.HIVE_CLI_SERVICE_PROTOCOL_V5);

        TOpenSessionResp openResp = client.OpenSession(openSessionReq);
        TSessionHandle sessHandle = openResp.getSessionHandle();


        System.out.println("tOpenSessionResp  " + openResp.getStatus());


//        Class.forName("org.apache.hive.jdbc.HiveDriver");
//        Connection conn  = DriverManager.getConnection("jdbc:hive2://172.16.10.223:10000");
//        PreparedStatement preparedStatement = conn.prepareStatement("select * from default.lzk");
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next() != false) {
//            System.out.println(resultSet.getInt(1));
//        }


    }
}
