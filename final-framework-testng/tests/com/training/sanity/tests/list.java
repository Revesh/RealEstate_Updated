package com.training.sanity.tests;

import java.util.ArrayList;
import java.util.List;

public class list {

	public static void main(String args[]) 
    { 
  
        // create a ArrayList String type 
       List<String> gfg = new ArrayList<String>(); 
  
        // Initialize an ArrayList with add() 
        gfg.add("Geeks"); 
        gfg.add("for"); 
        gfg.add("Geeks"); 
  
        // print ArrayList 
        System.out.println("ArrayList : " + gfg); 
        
        List<String> abc= new ArrayList<String>(); 
        
        // Initialize an ArrayList with add() 
        abc.add("asd"); 
        abc.add("fgfh"); 
        abc.add("Guio"); 
        
       // List<String> newList = ListUtils.union(list1, list2);
        
        List<String> newList = new ArrayList<String>(gfg);
        newList.addAll(abc);
        
        
        System.out.println(newList);
        
    } 
}
