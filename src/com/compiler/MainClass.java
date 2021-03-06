package com.compiler;

import java.io.IOException;

public class MainClass {
  static String sourceFileNameString = null;
  static String productionFileNameString = null;
  static String tokenFileNameString = null;
  static String symbolFileNameString = null;
  static String asmFileNameString = null;
  static String exeFileNameString = null;
  static String batFileNameString = null;
  static String genexeFileNameString = null;

  public static void main(String[] args) throws IOException, InterruptedException {
    // TODO 自动生成的方法存根
    // System.out.println(MainClass.class.getResource("/"));

    sourceFileNameString = MainClass.class.getResource("/").getFile() + "myCpp.c";
    productionFileNameString = MainClass.class.getResource("/").getFile() + "production_427.txt";
    tokenFileNameString = MainClass.class.getResource("/").getFile() + "myCpp_token.txt";
    symbolFileNameString = MainClass.class.getResource("/").getFile() + "myCpp_sym.txt";
    asmFileNameString = MainClass.class.getResource("/").getFile() + "myCpp.s";
    exeFileNameString = MainClass.class.getResource("/").getFile() + "myCpp.exe";
    batFileNameString = MainClass.class.getResource("/").getFile() + "myCpp.bat";
    genexeFileNameString = MainClass.class.getResource("/").getFile() + "genExe.bat";
    LexicalAnalyzer.getToken(sourceFileNameString);
    SyntaxAnalyzer test = new SyntaxAnalyzer();
    test.startAnalyse(tokenFileNameString);

    // HashSet<Item> a1 = new HashSet<>();
    // HashSet<Item> a2 = new HashSet<>();
    // HashSet<Item> a3 = new HashSet<>();
    // Item t1 = new Item(0, 1, "dji1");
    // Item t2 = new Item(0, 1, "dji2");
    // a1.add(t1);
    // a2.add(t2);
    // System.out.println(t1.equals(t2));
    // System.out.println(t1.hashCode());
    // System.out.println(t2.hashCode());
    // System.out.println(a1.equals(a2));
    // System.out.println(a1.hashCode());
    // System.out.println(a2.hashCode());
    // a1.add(t2);
    // a2.add(t1);
    // System.out.println(a1.equals(a2));
    // System.out.println(a1.hashCode());
    // System.out.println(a2.hashCode());
    // a3.add(t2);
    // a3.addAll(a1);
    // System.out.println(a1.equals(a3));
    // String[] s1 = { "s1", "s2" };
    // String[] s2 = { "s1", "s2" };
    // System.out.println(s1.equals(s2));
    // System.out.println(s1.hashCode());
    // System.out.println(s2.hashCode());
    // System.out.println(Arrays.hashCode(s1));
    // System.out.println(Arrays.hashCode(s2));
  }

}
