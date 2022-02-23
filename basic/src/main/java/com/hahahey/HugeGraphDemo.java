package com.hahahey;

import com.baidu.hugegraph.driver.GraphManager;
import com.baidu.hugegraph.driver.GremlinManager;
import com.baidu.hugegraph.driver.HugeClient;
import com.baidu.hugegraph.driver.SchemaManager;
import com.baidu.hugegraph.structure.graph.Edge;
import com.baidu.hugegraph.structure.graph.Path;
import com.baidu.hugegraph.structure.graph.Vertex;
import com.baidu.hugegraph.structure.gremlin.Result;
import com.baidu.hugegraph.structure.gremlin.ResultSet;
import com.baidu.hugegraph.structure.schema.PropertyKey;

import java.util.*;


public class HugeGraphDemo {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        return this.equals(obj);
    }

    public static void main(String[] args) {

        HugeGraphOperation hugeGraphOperation = new HugeGraphOperation();

        //HugeGraph-Client 是操作 graph 的总入口,与server建立连接后才能获取到schema，graph，gremlin的操作入口对象
        HugeClient hugeClient = hugeGraphOperation.getHugeClient();


        //元数据 用于管理hugeGraph中的四种元数据，分别是 PropertyKey(属性类型)，VertexLabel(顶点类型)，EdgeLabel(边类型) 和 IndexLabel(索引类型)
        SchemaManager schema = hugeClient.schema();

        GraphManager graph = hugeClient.graph();

        PropertyKey propertyKey = schema.getPropertyKey("");


        GremlinManager gremlin = hugeClient.gremlin();



        List<Vertex> vertices = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        List<com.baidu.hugegraph.structure.graph.Path> paths = new ArrayList<>();
        int times = 1;

        String code =  "g.V('2:aaa').repeat(both()).times(2).path()";
        //ResultSet resultSet = gremlin.gremlin("g.V('1:marko').out()").execute();
        //ResultSet resultSet = gremlin.gremlin("g.V().hasId('1:marko').repeat(both()).times(5).dedup().path()").execute();
        ResultSet resultSet = gremlin.gremlin(code).execute();



        Iterator<Result> results = resultSet.iterator();
        while (results.hasNext()) {
            Result or = results.next();

            Path path = or.getPath();
            System.out.println("from path : " + path.objects().size());

            List<Object> objects = path.objects();
            objects.forEach(System.out::println);

            System.out.println("******************");
            Object object = or.getObject();
            if (object instanceof Vertex) {
                vertices.add((Vertex) object);
            } else if (object instanceof Edge) {
                edges.add((Edge) object);
            } else if (object instanceof com.baidu.hugegraph.structure.graph.Path) {
                paths.add((com.baidu.hugegraph.structure.graph.Path) object);
            }
        }


        Iterator<Path> iterator = paths.iterator();
        while(iterator.hasNext()){
            Path next = iterator.next();
            List<Object> objects = next.objects();
            Iterator<Object> iterator1 = objects.iterator();
            while (iterator1.hasNext()){
                Object next1 = iterator1.next();
                if(next1 instanceof Vertex){
                    vertices.add((Vertex) next1);
                    Vertex  v = (Vertex) next1;
                    System.out.println(v.id());
                }else if(next1 instanceof Edge){
                    edges.add((Edge) next1);
                    Edge  v = (Edge) next1;
                    System.out.println(v.id());
                }else if(next1 instanceof com.baidu.hugegraph.structure.graph.Path){
                    System.out.println("path 中的path:" + next1);
                }
            }
        }



//        if(paths.isEmpty()){
//            vertices = null;
//        }else {
//            Set<Object> vertexIds = new HashSet<>(); q
//            paths.forEach(path -> path.objects().forEach(obj -> {
//        if(obj instanceof Vertex){
//            Vertex vertex = (Vertex) obj;
//            vertexIds.add(vertex.id());
//        }else if(obj instanceof Edge){
//            Edge edge = (Edge) obj;
//            vertexIds.add(edge.sourceId());
//            vertexIds.add(edge.targetId());
//        }
//            }));
//
//            vertices = hugeGraphOperation.getVertices(hugeClient,new ArrayList<>(vertexIds));
//        }
//
//
//        edges = hugeGraphOperation.getEdgeFromVertex(hugeClient,vertices);






        vertices.forEach(System.out::println);
        System.out.println("-------------");
        edges.forEach(System.out::println);
        System.out.println("-------------");
        paths.forEach(System.out::println);


        hugeGraphOperation.close();
    }




}
