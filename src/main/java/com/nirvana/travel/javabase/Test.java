package com.nirvana.travel.javabase;

/**
 * @author arainliu
 * @date 2021/2/18
 */
public class Test {

  public static void main(String[] args) {
//    Integer i1 = Integer.valueOf(40);
//    Integer i2 = new Integer(40);
//    System.out.println(i1==i2);

    String str1 = "he";
    String str2 = "llo";
    String str3 = "world";
    String str4 = str1 + str2 + str3;

  }
//
//
//  private static void loadInitialDrivers() {
//    String drivers;
//    try { // 步骤2先读取
//      drivers = AccessController.doPrivileged(new PrivilegedAction<String>() {
//        public String run() {
//          return System.getProperty("jdbc.drivers");
//        }
//      });
//    } catch (Exception ex) {
//      drivers = null;
//    }
//
//    // 步骤1，通过 Service Provider 获取
//    AccessController.doPrivileged(new PrivilegedAction<Void>() {
//      public Void run() {
//        ServiceLoader<Driver> loadedDrivers = ServiceLoader.load(Driver.class);
//        Iterator<Driver> driversIterator = loadedDrivers.iterator();
//        try {
//          while (driversIterator.hasNext()) {
//            driversIterator.next();
//          }
//        } catch (Throwable t) {
//          // Do nothing
//        }
//        return null;
//      }
//    });
//
//    if (drivers == null || drivers.equals("")) {
//      return;
//    }
//
//    // 步骤1失败后进行使用步骤2之前读取的内容
//    String[] driversList = drivers.split(":");
//    println("number of Drivers:" + driversList.length);
//    for (String aDriver : driversList) {
//      try {
//        println("DriverManager.Initialize: loading " + aDriver);
//        // 直接获取系统类加载器，不适用于多ClassLoader的java web环境
//        Class.forName(aDriver, true, ClassLoader.getSystemClassLoader());
//      } catch (Exception ex) {
//        println("DriverManager.Initialize: load failed: " + ex);
//      }
//    }
//  }
}
