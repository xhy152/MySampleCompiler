package com.compiler;

import java.util.ArrayList;

public class SignTable {
  private int pramOffset;// 填表的时候方便记录参数或局部变量的位置（EBP + XXXX），+为参数，-为局部变量
  private int localOffset;
  private SignTable parentTable;
  private ArrayList<Sign> table;
  // private StringBuffer Sentence;
  private ArrayList<String> Sentences;
  private int maxParaSize;// 当前块内最大的参数列表尺寸
  public int innerVarCtn;// 记录中间变量的数量，规约出一个句子就可以清零
  private int maxInnerVarCtn;//

  public SignTable()
  {
    super();
    this.pramOffset = 8;
    this.localOffset = -4;
    this.setParentTable(null);
    this.table = new ArrayList<>();
    // this.Sentence = new StringBuffer();
    this.Sentences = new ArrayList<>();
    this.innerVarCtn = 0;
  }

  public void updateMaxParaSize(int curParasize) {
    if (curParasize > this.maxParaSize)
      this.maxParaSize = curParasize;
  }

  public void updateMaxInnerVarCtn(int curInnerVarCtn) {
    if (curInnerVarCtn > this.maxInnerVarCtn)
      this.maxInnerVarCtn = curInnerVarCtn;
  }

  public int getReserveSize() {
    return -localOffset + maxInnerVarCtn + maxParaSize;
  }

  public void clearInnerVarCtn() {
    this.localOffset += innerVarCtn * 4;
    while (innerVarCtn > 0) {
      removeByName("__inner" + (innerVarCtn - 1));
      innerVarCtn--;
    }
    this.innerVarCtn = 0;
  }

  public void addInnerVarCtn() {
    this.innerVarCtn++;
  }

  public int getInnerVarCtn() {
    return this.innerVarCtn;
  }

  private void removeByName(String Name) {
    Sign sign2 = null;
    for (Sign sign : table) {
      if (sign.id.equals(Name)) {
        sign2 = sign;
        break;
      }
    }
    table.remove(sign2);
  }

  /*
   * 返回字符串的3部分依次为： 是否为局部变量(及参数); 变量类型;偏移
   * 
   * 不直接返回一个Sign的原因：Sign内部没有标记自身是全局的 还是局部的
   */
  public String getOffsetOfID(String idName) {
    String retString;
    SignTable curTable = this;
    while (curTable != null) {
      for (Sign sign : curTable.table) {
        if (sign.id.equals(idName)) {
          retString = (curTable.getParentTable() == null) ? "0" : "1";
          retString += ":" + sign.type;
          retString += ":" + sign.offset;
          return retString;
        }
      }
      curTable = curTable.getParentTable();
    }
    return "-1:-1:-1";
  }

  public Sign getSignByIdName(String idName) {
    String retString;
    SignTable curTable = this;
    while (curTable != null) {
      for (Sign sign : curTable.table) {
        if (sign.id.equals(idName)) {
          return sign;
        }
      }
      curTable = curTable.getParentTable();
    }
    return null;
  }

  public boolean isFuncRepeate(String funcName) {
    for (Sign sign : this.table) {
      if (sign.id.equals(funcName)) {
        return true;
      }
    }
    return false;
  }

  public boolean add(Sign sign) {
    return table.add(sign);
  }

  /**
   * @return parentTable
   */
  public SignTable getParentTable() {
    return parentTable;
  }

  /**
   * @param parentTable
   *          要设置的 parentTable
   */
  public void setParentTable(SignTable parentTable) {
    this.parentTable = parentTable;
  }

  /**
   * @return pramOffset
   */
  public int getPramOffset() {
    return pramOffset;
  }

  /**
   * @param pramOffset
   *          要设置的 pramOffset
   */
  public void addPramOffset(int pramOffset) {
    this.pramOffset += pramOffset;
  }

  /**
   * @return localOffset
   */
  public int getLocalOffset() {
    return localOffset;
  }

  /**
   * @param localOffset
   *          要设置的 localOffset
   */
  public void addLocalOffset(int localOffset) {
    this.localOffset -= localOffset;
  }

  /**
   * @return sentence
   */
  public String getSentence() {
    StringBuffer retBuffer = new StringBuffer();
    for (String str : this.Sentences) {
      retBuffer.append(str);
    }
    return retBuffer.toString();
  }

  /**
   * @param sentence
   *          要设置的 sentence
   */
  public void addSentence(String sentence) {
    // Sentence.append(sentence);
    Sentences.add(sentence);
  }

  public int getIndexOfLastSen() {
    return this.Sentences.size();
  }

  public void backpatch(ArrayList<Integer> lst, String Label, int Lpos) {
    for (int i : lst) {
      String beforeInsert = this.Sentences.get(i);
      if (beforeInsert.indexOf("@null产生的空行") < 0) {
        this.Sentences.set(i, beforeInsert + Label + "\n");
      }
    }
    if (!lst.isEmpty()) {
      this.Sentences.set(Lpos, Label + ": " + this.Sentences.get(Lpos));
    }
  }

}
