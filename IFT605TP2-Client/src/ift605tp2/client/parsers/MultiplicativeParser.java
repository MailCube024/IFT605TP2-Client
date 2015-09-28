/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.client.parsers;

import udes.ds.agent.AbstractEquation;
import udes.ds.agent.BasicEquation;
import udes.ds.agent.MultiplicativeEquation;

/**
 *
 * @author Michaël
 */
public class MultiplicativeParser extends MultiTermParser{

    @Override
    public AbstractEquation ParseEquation(String entry) {
        BasicEquation[] terms = SplitTerms(entry);
        MultiplicativeEquation result = new MultiplicativeEquation(terms[0], terms[1]);
        
        for(int i = 2; i < terms.length; ++i){
            result = new MultiplicativeEquation(result, terms[i]);
        }
        
        return result;
    }
    
}
