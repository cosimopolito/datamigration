package main.dao;

import main.entity.RecordOld;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RecordOldDaoImpl extends RecordOldDao {



	@Override
	public List<RecordOld> getAll() {
		String query = "SELECT  d.id, d.codice_fiscale, a.nome, a.cognome, a.data_nascita, count(s.id) as numero_sinistri FROM dati_fiscali df inner join anagrafica a on df.id = a.fk_dati_fiscali" +
				" left join sinistri s on a.id = s.fk_anagrafica group by s.id";
		List<RecordOld> recordOlds = new ArrayList<>();

		try (Connection connection = getConnection();
				Statement statement =  connection.createStatement();
			)
		{
 			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				RecordOld recordOld = new RecordOld();
				recordOld.setId(resultSet.getInt("dati_fiscali.id"));
				recordOld.setCodiceFiscale(resultSet.getString("dati_fiscali.codice_fiscale"));
				recordOld.setNome (resultSet.getString("anagrafica.nome") );
				recordOld.setCognome (resultSet.getString("anagrafica.cognome"));
				recordOld.setNumeroSinistri(resultSet.getInt("numero_sinistri"));

				recordOlds.add(recordOld);

				}

			return recordOlds;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();
 	}


}
