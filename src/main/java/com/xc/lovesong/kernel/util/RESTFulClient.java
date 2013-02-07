//package com.jd.bip.domain.common;
//import org.apache.cxf.jaxrs.client.WebClient;
//import org.apache.cxf.transport.http.HTTPConduit;
//
///**
// * Created by IntelliJ IDEA.
// * User: Administrator
// * Date: 2011-6-17
// * Time: 16:47:56
// * To change this template use File | Settings | File Templates.
// */
//public class RESTFulClient {
//    private static WebClient client;
//    private static String serviceUri = "services/";
//    public static String baseUri;
//    private static String contentType = "application/xml";
//    
//    static   {
//        //client = WebClient.create(baseUri);
//    }
//    
//    //public <T> T get(java.lang.Class<T> responseClass) { /* compiled code */ }
//    public static <T, U> U get(String uri, java.lang.Class<U> responseClass){
//        client = WebClient.create(baseUri);
//        client.encoding("utf8");
//         return client.path(getUri(uri)).accept(contentType).get(responseClass);
//    }
//
//    public static <T> T getAll(String uri, java.lang.Class<T> responseClass){
//        client = WebClient.create(baseUri);
//        client.encoding("utf8");
//        return client.path(getUri(uri)).accept(contentType).get(responseClass);
//    }
//
//    public static <T, U> U post(String uri, T inputData, java.lang.Class<U> responseClass){
//        client = WebClient.create(baseUri);
//        
//        HTTPConduit hcd = WebClient.getConfig(client).getHttpConduit();
//        hcd.getClient().setReceiveTimeout(0);
//        hcd.getClient().setConnectionTimeout(0);
//        client.encoding("utf8");
//        System.out.println("baseuri:"+baseUri);
//        System.out.println("service:"+getUri(uri));
//        //System.out.println("data:"+JSONSerializer.toJSON(inputData));
//         return client.path(getUri(uri)).accept(contentType).post(inputData, responseClass);
//    }
//    
//
//    public static <T> void post(String uri, T inputData){
//        client = WebClient.create(baseUri);
//        client.encoding("utf8");
//         client.path(getUri(uri)).accept(contentType).post(inputData);
//    }
//
//    public static void delete(String uri) {
//        client = WebClient.create(baseUri);
//        client.encoding("utf8");
//        client.path(getUri(uri)).accept(contentType).delete();
//     }
//    
//    public static  <T>  void put(String uri, T inputData) {
//        client = WebClient.create(baseUri);
//        client.encoding("utf8");
//        client.path(getUri(uri)).accept(contentType).put(inputData);
//     }
//
//    private static String getUri(String uri) {
//        return serviceUri + uri;
//    }
//}