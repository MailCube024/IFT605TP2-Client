/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.client.parsers;

import ift605tp2.client.equations.SinusEquation;
import udes.ds.agent.AbstractEquation;

/**
 *
 * @author Utilisateur
 */
public class SinusParser implements IEquationParser{
    
    private static final EquationParser parser = new EquationParser();
    
    @Override
    public AbstractEquation ParseEquation(String entry) {
        int indexOpen = entry.indexOf("(");
        int indexClose = entry.indexOf(")");
        AbstractEquation inside = parser.ParseEquation(entry.substring(indexOpen+1,indexClose).trim());
        
        return new SinusEquation(inside);
    }
    
}
