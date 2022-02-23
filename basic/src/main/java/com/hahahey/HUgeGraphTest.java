package com.hahahey;

import com.baidu.hugegraph.driver.HugeClient;
import com.baidu.hugegraph.structure.gremlin.Result;
import com.baidu.hugegraph.structure.gremlin.ResultSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HUgeGraphTest {

        public static void main(String[] args) {
            HugeClient hugeClient =  new HugeClient("http://192.168.241.103:8082", "hugegraph");
            ResultSet resultSet = hugeClient.gremlin().gremlin("").execute();
            List<Object> list = new ArrayList<>();


            Iterator<Result> iterator = resultSet.iterator();
            while(iterator.hasNext()){
                list.add(iterator.next().getObject());
            }
            list.stream().forEach(System.out::println);


    }

}
