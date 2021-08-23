//package me.sjl.mapstract;
//
//import me.sjl.mapstract.convert.Convert;
//import me.sjl.mapstract.entity.MapDemo;
//import me.sjl.mapstract.entity.MapTargetDemo;
//
//public class Main {
//
//    public static void main(String[] args) {
//        MapDemo.Data data = new MapDemo.Data();
//        data.setDataName("张三");
//        data.setDataNo("111");
//
//        MapDemo mapDemo = new MapDemo();
//        mapDemo.setStr("张三他爸爸");
//        mapDemo.setData(data);
//
//        Convert instance = Convert.INSTANCE;
//        MapTargetDemo convert = instance.convert(mapDemo);
//        System.out.println(convert);
//
//        MapTargetDemo.Data targetData = instance.convertToData(data);
//        System.out.println("targetData:" + targetData);
//
//    }
//
//}
