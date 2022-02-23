package com.hahahey.HiveOperation;//package com.hahahey.HiveOperation;
//
//import org.apache.hive.service.rpc.thrift.*;
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.apache.thrift.transport.TSocket;
//import org.apache.thrift.transport.TTransport;
//
//
//public class HiveOperation {
//    public static void main(String[] args) throws Exception {
//        TTransport tTransport = new TSocket("192.168.241.101", 10000);
//        TBinaryProtocol protocol = new TBinaryProtocol(tTransport);
//        TCLIService.Client client = new TCLIService.Client(protocol);
//
//        tTransport.open();
//        System.out.println("transport is open " + tTransport.isOpen());
//
//
//        TOpenSessionReq openSessionReq = new TOpenSessionReq(TProtocolVersion.HIVE_CLI_SERVICE_PROTOCOL_V5);
//
//        TOpenSessionResp openResp = client.OpenSession(openSessionReq);
//        TSessionHandle sessHandle = openResp.getSessionHandle();
//
//
//        System.out.println("tOpenSessionResp  " + openResp.getStatus());
//
//
//
//
//
//    }
//}
