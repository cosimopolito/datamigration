
package main;

import main.dao.*;
import main.entity.RecordOld;

import java.sql.*;
import java.util.List;


public class Connessione {
	
	public static void eseguiQuery(String ufficio, Integer piano) {

	}
	public static void main(String[] args) {
		RecordOldDao recordDao = new  RecordOldDaoImpl();
		NotProcessedDao notProcessedDao = new NotProcessedDaoImpl();
		NewAssicuratoDao newAssicuratoDao = new NewAssicuratoDaoImpl();

		List<RecordOld> recordOlds = recordDao.getAll();
		for (RecordOld item:recordOlds ) {
			if (item.getCodiceFiscale().length() != 16){
				notProcessedDao.insert(item);
			}
			else {
				newAssicuratoDao.insert(item);
			}
		}
	}
	
}
