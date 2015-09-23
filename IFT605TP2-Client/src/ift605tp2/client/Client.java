/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.client;

import constants.Constants;
import contracts.IDerivationCommand;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import udes.ds.agent.Constant;
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
        String host = "localhost";
        try {
            Registry registry = LocateRegistry.getRegistry(host, Constants.RMI_PORT);
            IDerivationCommand stub = (IDerivationCommand) registry.lookup(Constants.DERIVATION_ENGINE_ID);
            //IDerivationCommand stub = (IDerivationCommand) Naming.lookup("rmi://localhost:" + Constants.RMI_PORT + "/" + Constants.DERIVATION_ENGINE_ID);
            Equation response = stub.Derivate(new Constant(7));
            response.printUserReadable();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }    
    }
}
