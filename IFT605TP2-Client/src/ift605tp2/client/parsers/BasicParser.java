/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.client.parsers;

import udes.ds.agent.AbstractEquation;
import udes.ds.agent.Equation;

/**
 *
 * @author Michaël
 */
public class BasicParser extends SingleTermParser {

    @Override
    public AbstractEquation ParseEquation(String entry) {
        return ExtractTerm(entry);
    }

}
