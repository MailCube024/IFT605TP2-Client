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
public class SubtractiveEquation extends AbstractEquation {
    
    private static final long serialVersionUID = 1L;
    private AbstractEquation _first;
    private AbstractEquation _second;
    
    public SubtractiveEquation(AbstractEquation first, AbstractEquation second) {
        super();
        _first = first;
        _second = second;
    }
    
    public AbstractEquation getFirst() {
        return _first;
    }
    
    public AbstractEquation getSecond() {
        return _second;
    }

    public double getFunctionValue(double x) {
        return (_first.getFunctionValue(x) - _second.getFunctionValue(x));
    }
    
    public String getUserReadableString() {
        return new String(_first.getUserReadableString() + " - " + _second.getUserReadableString());
    }

    public AbstractEquation derivate() {
        return new SubtractiveEquation(this.getFirst().derivate(), this.getSecond().derivate());
    }
}
