/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.client.parsers;

import udes.ds.agent.AbstractEquation;
import udes.ds.agent.BasicEquation;
import udes.ds.agent.SummativeEquation;

/**
 *
 * @author Michaël
 */
public class SummativeParser extends MultiTermParser {

    @Override
    public AbstractEquation ParseEquation(String entry) {
        BasicEquation[] terms = SplitTerms(entry);
        SummativeEquation result = new SummativeEquation(terms[0], terms[1]);

        for (int i = 2; i < terms.length; ++i) {
            result = new SummativeEquation(result, terms[i]);
        }

        return result;
    }

}
