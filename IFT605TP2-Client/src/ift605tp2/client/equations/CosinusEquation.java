/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.client.equations;

import udes.ds.agent.AbstractEquation;

/**
 *
 * @author Bruno-Pier
 */
public class CosinusEquation extends AbstractEquation{

    private static final long serialVersionUID = 1L;
    private AbstractEquation _inside;
    
    public CosinusEquation(AbstractEquation inside){
        super();
        _inside = inside;
    }
    
    public AbstractEquation getInside() {
        return _inside;
    }
    
    public double getFunctionValue(double x) {
        return Math.cos(_inside.getFunctionValue(x));
    }    
    
    public String getUserReadableString() {
        return new String("cos(" + _inside.getUserReadableString() + ")");
    }

    public AbstractEquation derivate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
