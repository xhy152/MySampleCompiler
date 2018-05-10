package com.compiler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class SemanticAnalyzer {
  SignTable globalSignTable;
  SignTable curTable;

  Stack<SignTable> tableSt;
  Stack<String> typeSt;
  Stack<String> valueSt;

  private String[][] productions;

  BufferedReader symbolReader;

  public SemanticAnalyzer(String[][] productions) throws FileNotFoundException
  {
    // TODO 自动生成的构造函数存根
    this.productions = productions;
    globalSignTable = new SignTable();
    curTable = globalSignTable;
    // curTable = globalSignTable;
    tableSt = new Stack<>();
    typeSt = new Stack<>();
    valueSt = new Stack<>();
    symbolReader = new BufferedReader(new FileReader(MainClass.symbolFileNameString));

  }

  public void executeAction(int proID) throws IOException {
    String[] curProduction = productions[proID];
    String curString = curProduction[0] + "->" + curProduction[1];
    for (int i = 2; i < curProduction.length; i++) {
      curString += " " + curProduction[i];
    }
    if (curString.equals("S->Start")) {

    } else if (curString.equals("Start->MainDef")) {

    } else if (curString.equals("Start->FuncList MainDef")) {

    } else if (curString.equals("Start->DeclareS Start")) {

    } else if (curString.equals("MainDef->int main ( M0 ParaList ) { Sen return Expr ; }")) {

    } else if (curString.equals("FuncList->FuncList FuncDef")) {

    } else if (curString.equals("FuncList->FuncDef")) {

    } else if (curString.equals("FuncDef->Type id ( M1 ParaList ) { Sen return Expr ; }")) {

    } else if (curString.equals("ParaList->@null")) {

    } else if (curString.equals("ParaList->Type id")) {

    } else if (curString.equals("ParaList->Type id , ParaList1")) {

    } else if (curString.equals("ParaList1->Type id")) {

    } else if (curString.equals("ParaList1->Type id , ParaList1")) {

    } else if (curString.equals("Sen->DeclareS Sen")) {

    } else if (curString.equals("Sen->AssignS Sen")) {

    } else if (curString.equals("Sen->ifS Sen")) {

    } else if (curString.equals("Sen->whileS Sen")) {

    } else if (curString.equals("Sen->id ( CallParaList ) ; Sen")) {

    } else if (curString.equals("Sen->@null")) {

    } else if (curString.equals("CallParaList->@null")) {

    } else if (curString.equals("CallParaList->Expr")) {

    } else if (curString.equals("CallParaList->Expr , CallParaList1")) {

    } else if (curString.equals("CallParaList1->Expr")) {

    } else if (curString.equals("CallParaList1->Expr , CallParaList1")) {

    } else if (curString.equals("DeclareS->Type IDlist ;")) {

    } else if (curString.equals("IDlist->ID1")) {

    } else if (curString.equals("IDlist->ID2")) {

    } else if (curString.equals("IDlist->ID3")) {

    } else if (curString.equals("IDlist->ID1 , IDlist")) {

    } else if (curString.equals("IDlist->ID2 , IDlist")) {

    } else if (curString.equals("IDlist->ID3 , IDlist")) {

    } else if (curString.equals("ID1->id")) {

    } else if (curString.equals("ID2->id = Expr")) {

    } else if (curString.equals("ID3->id [ intConst ]")) {

    } else if (curString.equals("AssignS->id = Expr ;")) {

    } else if (curString.equals("Expr->Expr + Expr1")) {

    } else if (curString.equals("Expr->Expr - Expr1")) {

    } else if (curString.equals("Expr->Expr1")) {

    } else if (curString.equals("Expr1->Expr1 * Expr2")) {

    } else if (curString.equals("Expr1->Expr1 / Expr2")) {

    } else if (curString.equals("Expr1->Expr2")) {

    } else if (curString.equals("Expr2->( Expr )")) {

    } else if (curString.equals("Expr2->id")) {

    } else if (curString.equals("Expr2->Const")) {

    } else if (curString.equals("Expr2->id [ Expr ]")) {

    } else if (curString.equals("BoolE->BoolE1")) {

    } else if (curString.equals("BoolE->BoolE || BoolE1")) {

    } else if (curString.equals("BoolE1->BoolE2")) {

    } else if (curString.equals("BoolE1->BoolE1 && BoolE2")) {

    } else if (curString.equals("BoolE2->BoolE3")) {

    } else if (curString.equals("BoolE2->! BoolE3")) {

    } else if (curString.equals("BoolE3->( BoolE )")) {

    } else if (curString.equals("BoolE3->Expr Condop Expr")) {

    } else if (curString.equals("ifS->if ( BoolE ) { ifSen }")) {

    } else if (curString.equals("ifS->if ( BoolE ) { ifSen } else { ifSen }")) {

    } else if (curString.equals("ifS->if ( BoolE ) { ifSen } else ifS")) {

    } else if (curString.equals("ifSen->Sen")) {

    } else if (curString.equals("ifSen->Sen return Expr ;")) {

    } else if (curString.equals("whileS->while ( BoolE ) { CirSen }")) {

    } else if (curString.equals("CirSen->DeclareS CirSen")) {

    } else if (curString.equals("CirSen->AssignS CirSen")) {

    } else if (curString.equals("CirSen->CirifS CirSen")) {

    } else if (curString.equals("CirSen->whileS CirSen")) {

    } else if (curString.equals("CirSen->return Expr ;")) {

    } else if (curString.equals("CirSen->break ;")) {

    } else if (curString.equals("CirSen->continue ;")) {

    } else if (curString.equals("CirSen->id ( CallParaList ) ; CirSen")) {

    } else if (curString.equals("CirSen->@null")) {

    } else if (curString.equals("CirifS->if ( BoolE ) { CirSen }")) {

    } else if (curString.equals("CirifS->if ( BoolE ) { CirSen } else { CirSen }")) {

    } else if (curString.equals("CirifS->if ( BoolE ) { CirSen } else CirifS")) {

    } else if (curString.equals("Condop->>")) {

    } else if (curString.equals("Condop->>=")) {

    } else if (curString.equals("Condop-><")) {

    } else if (curString.equals("Condop-><=")) {

    } else if (curString.equals("Condop->=")) {

    } else if (curString.equals("Condop->==")) {

    } else if (curString.equals("Condop->!=")) {

    } else if (curString.equals("Const->intConst")) {

    } else if (curString.equals("Const->stringConst")) {

    } else if (curString.equals("Const->floatConst")) {

    } else if (curString.equals("Const->charConst")) {

    } else if (curString.equals("Type->int")) {
      typeSt.push("int");
    } else if (curString.equals("Type->float")) {
      typeSt.push("float");
    } else if (curString.equals("Type->string")) {
      typeSt.push("string");
    } else if (curString.equals("Type->char")) {

    } else if (curString.equals("M0->@null")) {
      curTable = new SignTable();
      curTable.setParentTable(globalSignTable);
      Sign tmpSign = new Sign("main", "int", -1, -1, curTable);
      globalSignTable.add(tmpSign);
    } else if (curString.equals("M1->@null")) {
      curTable = new SignTable();
      curTable.setParentTable(globalSignTable);
      Sign tmpSign = new Sign(symbolReader.readLine(), typeSt.pop(), -1, -1, curTable);
      globalSignTable.add(tmpSign);
    } else if (curString.equals("M2->@null")) {

    } else if (curString.equals("M3->@null")) {

    } else if (curString.equals("M4->@null")) {

    } else if (curString.equals("M5->@null")) {

    } else if (curString.equals("M6->@null")) {

    } else if (curString.equals("M7->@null")) {

    }
  }
}
