package fr.nkosmos.felix.api.server.database;

import java.sql.Connection;

import fr.nkosmos.felix.api.server.IFelixServer;

public interface IDatabaseManager {

	Connection establishConnection(String protocol, String... info);
	
	void close();
	
	IFelixServer server();
	
}
