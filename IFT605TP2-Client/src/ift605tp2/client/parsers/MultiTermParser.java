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
public abstract class MultiTermParser extends SingleTermParser {

    protected BasicEquation[] SplitTerms(String entry) {
        String[] terms = entry.split("\\r?\\n");
        BasicEquation[] equations = new BasicEquation[terms.length];
        
        for (int i = 0; i < terms.length; ++i) {
            equations[i] = ExtractTerm(terms[i]);
        }
        return equations;
    }
}
