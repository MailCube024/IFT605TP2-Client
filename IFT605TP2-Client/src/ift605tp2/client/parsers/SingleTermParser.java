/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.client.parsers;

import udes.ds.agent.BasicEquation;

/**
 *
 * @author Michaël
 */
public abstract class SingleTermParser implements IEquationParser {

    protected BasicEquation ExtractTerm(String term) {
        String[] parameters = term.split("\\s+");

        double coefficient = Double.parseDouble(parameters[0]);
        int exponent = Integer.parseInt(parameters[1]);
        return new BasicEquation(coefficient, exponent);
    }
}
