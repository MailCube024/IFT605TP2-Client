/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.client;

import constants.Constants;
import contracts.IDerivationCommand;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import udes.ds.agent.BasicEquation;
import udes.ds.agent.Equation;

/**
 *
 * @author Michaël
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        
        try{
            Registry registry = LocateRegistry.getRegistry(Constants.RMI_PORT);
            IDerivationCommand r = (IDerivationCommand)registry.lookup(Constants.DERIVATION_ENGINE_ID);
            
            Equation e = r.Derivate(new BasicEquation(2, 4));
            
            e.printUserReadable();
            
        } catch (RemoteException e){
            e.printStackTrace();
        } catch (NotBoundException e){
            e.printStackTrace();
        }
    }
    
}
