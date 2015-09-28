/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.client;

import constants.Constants;
import contracts.IAdminHandler;
import contracts.IDerivationHandler;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import udes.ds.agent.AbstractEquation;
import udes.ds.agent.Equation;

/**
 *
 * @author Michaël
 */
public class ClientManager {

    private boolean m_isConnected;
    private long m_adminKey;
    private IDerivationHandler m_handler = null;
    private IAdminHandler m_adminHandler = null;

    public ClientManager() {
        m_isConnected = false;
        m_adminKey = -1;
    }

    public boolean IsConnected() {
        return m_isConnected;
    }
    
    public boolean IsAdmin() {
        return m_adminKey != -1;
    }

    /**
     * @param hostname
     */
    public void Connect(String hostname) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {

            Registry registry = LocateRegistry.getRegistry(hostname, Constants.RMI_PORT);
            m_handler = (IDerivationHandler) registry.lookup(Constants.DERIVATION_ENGINE_ID);
            m_adminHandler = (IAdminHandler) registry.lookup(Constants.ADMIN_ENGINE_ID);
            m_isConnected = true;
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
            m_isConnected = false;
        }
    }

    public AbstractEquation Derivate(Equation e) {
        try {
            return (AbstractEquation) m_handler.Derivate(e);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public void ConnectAsAdmin(String username, String password) {
        try {
            m_adminKey = m_adminHandler.Connect(username, password);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean StopTask(String name) {
        try {
            return m_adminHandler.StopTask(name, m_adminKey);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    } 
    
    public String[] GetCurrentlyRunningTasks() {
        try {
            return m_adminHandler.GetCurrentlyRunningTask(m_adminKey);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new String[0];
    }
}
