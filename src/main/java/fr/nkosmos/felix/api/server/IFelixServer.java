package fr.nkosmos.felix.api.server;

import fr.nkosmos.felix.api.server.database.IDatabaseManager;

/**
 * Base interface for a Felix API server
 * 
 * @author xTrM_
 */
public interface IFelixServer {

    /**
     * Start the server
     */
    void load();
    
    /**
     * @return the {@link IDatabaseManager DatabaseManager} instance
     */
    IDatabaseManager getDatabase();

}
