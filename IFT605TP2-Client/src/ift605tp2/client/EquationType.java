/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.client;

/**
 *
 * @author Michaël
 */
public enum EquationType {
    Constant("Constant"),
    Basic("Basic"),
    Multiplicative("Multiplicative"),
    Summative("Summative");
    
    private final String name;

    private EquationType(String stringVal) {
        name=stringVal;
    }
    @Override
    public String toString(){
        return name;
    }

    public static String getEnumByString(String code){
        for(EquationType e : EquationType.values()){
            if(code == null ? e.name == null : code.equals(e.name)) return e.name();
        }
        return null;
    }
}
