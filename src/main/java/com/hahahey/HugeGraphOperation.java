package com.hahahey;

import com.baidu.hugegraph.driver.GraphManager;
import com.baidu.hugegraph.driver.HugeClient;
import com.baidu.hugegraph.driver.SchemaManager;
import com.baidu.hugegraph.structure.graph.Edge;
import com.baidu.hugegraph.structure.graph.Vertex;
import com.baidu.hugegraph.structure.gremlin.Result;
import com.baidu.hugegraph.structure.gremlin.ResultSet;
import com.baidu.hugegraph.structure.schema.EdgeLabel;
import com.baidu.hugegraph.structure.schema.IndexLabel;
import com.baidu.hugegraph.structure.schema.PropertyKey;
import com.baidu.hugegraph.structure.schema.VertexLabel;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.*;


public class HugeGraphOperation {

    private HugeClient hugeClient;


    {
        System.out.println("获取到连接Client");
        this.hugeClient = new HugeClient("http://192.168.241.103:8082", "hugegraph");


    }

    public HugeClient getHugeClient() {
        return hugeClient;
    }

    public void setHugeClient(HugeClient hugeClient) {
        this.hugeClient = hugeClient;
    }


    public HugeClient getHugeClient(String url, String graph) throws Exception {
        HugeClient hugeClient;
        try {
            hugeClient = new HugeClient(url, graph);
        } catch (Exception e) {
            throw new Exception("连接hugeGraph服务器异常!!!");
        }
        return hugeClient;
    }


    public List<Vertex> getAllVertex() {
        List<Vertex> vertexList = null;


        return null;
    }


    public void close() {
        this.hugeClient.close();
        System.out.println("hugeClient 断开连接------------------------ ");
    }


    public void deleteVertexData(GraphManager graph) {
        int size = graph.listVertices().size();
        for (Vertex vertex : graph.listVertices()) {
            graph.removeVertex(vertex.id());
        }
        System.out.println("共有 " + size + " 个 vertex 数据删除");
    }

    public void deleteEdgeData(GraphManager graph) {
        int size = graph.listEdges().size();
        for (Edge edge : graph.listEdges()) {
            graph.removeVertex(edge.id());
        }
        System.out.println("共有 " + size + " 个 edge   数据删除");
    }


    public void deleteAllData(GraphManager graph) {
        deleteVertexData(graph);
        deleteEdgeData(graph);
    }


    public void deleteIndexLabel(SchemaManager schema) {
        List<IndexLabel> indexLabels = schema.getIndexLabels();

        for (IndexLabel indexLabel : indexLabels) {
            schema.removeIndexLabel(indexLabel.name());
        }
        System.out.println("共有 " + indexLabels.size() + "  个 IndexLabel 被删除");
    }

    public void deleteVertexLabel(SchemaManager schema) {
        List<VertexLabel> vertexLabels = schema.getVertexLabels();
        for (VertexLabel vertexLabel : vertexLabels) {
            schema.removeVertexLabel(vertexLabel.name());
        }
        System.out.println("共有 " + vertexLabels.size() + "  个 VertexLabel 被删除");
    }

    public void deleteEdgeLabel(SchemaManager schema) {
        List<EdgeLabel> edgeLabels = schema.getEdgeLabels();
        for (EdgeLabel edgeLabel : edgeLabels) {
            schema.removeVertexLabel(edgeLabel.name());
        }
        System.out.println("共有 " + edgeLabels.size() + "  个 EdgeLabel 被删除");
    }

    public void deletePropertyKey(SchemaManager schema) {
        List<PropertyKey> propertyKeys = schema.getPropertyKeys();
        for (PropertyKey propertyKey : propertyKeys) {
            schema.removePropertyKey(propertyKey.name());
        }
        System.out.println("共有 " + propertyKeys.size() + "  个PropertyKey被删除");
    }


    public void deleteAll(SchemaManager schema) {
        deleteIndexLabel(schema);
        deleteVertexLabel(schema);
        deleteEdgeLabel(schema);
        deletePropertyKey(schema);
    }


    public List<Vertex> getVertices(HugeClient client,
                                    List<Object> vertexIds) {
        if (vertexIds == null || vertexIds.size() == 0) {
            return null;
        }
        List<Vertex> vertices = new ArrayList<>();

        List<String> idList = new ArrayList<>();
        for (Object vertexId : vertexIds) {
            idList.add(formatId(vertexId));
        }
        Lists.partition(idList, 250)
                .forEach(group -> {
                    String ids = StringUtils.join(group, ",");
                    String gremlin = String.format("g.V(%s)", ids);
                    ResultSet resultSet =
                            client.gremlin().gremlin(gremlin).execute();
                    Iterator<Result> results = resultSet.iterator();
                    List<Vertex> finalVertices = vertices;
                    results.forEachRemaining(
                            vertex -> finalVertices.add((Vertex) vertex.getObject()));
                });
        return vertices;
    }

    private String formatId(Object id) {
        if (id instanceof String) {
            String transformedId =
                    StringUtils.replace(id.toString(), "\\", "\\\\");
            transformedId = StringUtils.replace(transformedId, "\"", "\\\"");
            transformedId = StringUtils.replace(transformedId, "'", "\\'");
            transformedId = StringUtils.replace(transformedId, "\n", "\\n");
            return String.format("'%s'", transformedId);
        }
        return id.toString();
    }


    public List<Edge> getEdgeFromVertex(HugeClient client,
                                        List<Vertex> vertices) {

        if (vertices == null || vertices.size() == 0) {
            return null;
        }
        List<Edge> edges = new ArrayList<>();

        Set<Object> vertexIds = new HashSet<>();
        vertices.forEach(v -> vertexIds.add(v.id()));

        List<String> idList = new ArrayList<>();
        for (Vertex vertex : vertices) {
            idList.add(formatId(vertex.id()));
        }

        Lists.partition(idList, 250)
                .forEach(group -> {
                    String ids = StringUtils.join(group, ",");
                    /*
                     * De-duplication by edgeId. Reserve the edges only if both
                     * srcVertexId and tgtVertexId is a member of vertices.
                     */
                    String code = String.format("g.V(%s).bothE().dedup()" +
                            ".limit(8000)", ids);

                    ResultSet resultSet =
                            client.gremlin().gremlin(code).execute();

                    Iterator<Result> resultIterator = resultSet.iterator();

                    Map<Object, Integer> edgesNumPerVertex = new HashMap<>();

                    while (resultIterator.hasNext()) {
                        Edge edge = resultIterator.next().getEdge();
                        /*
                         * As the results is queried by 'g.V(id).bothE()', the
                         * source vertex of edge from results is in the set of
                         * vertexIds. Hence, just reserve the edge which that
                         * the target in the set of vertexIds.
                         */
                        Object target = edge.targetId();
                        Object source = edge.sourceId();
                        if (vertexIds.contains(target) &&
                                vertexIds.contains(source)) {
                            Integer count = edgesNumPerVertex.get(source);
                            if (count == null) {
                                count = 0;
                            }
                            edgesNumPerVertex.put(source, count++);
                            if (count > 200) {
                                break;
                            }

                            count = edgesNumPerVertex.get(target);
                            if (count == null) {
                                count = 0;
                            }
                            edgesNumPerVertex.put(target, count++);
                            if (count > 200) {
                                break;
                            }

                            edges.add(edge);

                        }
                    }
                });
        return edges;
    }

}