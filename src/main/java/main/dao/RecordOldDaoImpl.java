package main.dao;

import main.entity.RecordOld;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RecordOldDaoImpl extends RecordOldDao {



	@Override
	public List<RecordOld> getAll() {
		String query = "SELECT * FROM dati_fiscali df inner join anagrafica a on df.id = a.fk_dati_fiscali" +
				" left join sinistri on a.id = sinistri.fk_anagrafica";
		List<RecordOld> recordOlds = new ArrayList<>();

		try (Connection connection = getConnection();
				Statement statement =  connection.createStatement();
			)
		{
 			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				RecordOld recordOld = new RecordOld();
				recordOld.setCodiceFiscale(resultSet.getString("dati_fiscali.codice_fiscale"));
				recordOld.setNome (resultSet.getString("anagrafica.nome") );
				recordOld.setCognome (resultSet.getString("anagrafica.cognome"));
				recordOld.setTipoSinistro (resultSet.getString("anagrafica.cognome"));
				if (recordOld.getFk_anagrafica() == null)
				recordOld.setLuogoSinistro (resultSet.getString("sinistri.tipo"));
				recordOld.setCognome (resultSet.getString("sinistri.luogo"));
				recordOlds.add(recordOld);
			}
			return recordOlds;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();
 	}

	@Override
	public void insert(RecordOld recordOld) {
		String query = "insert into uffici ( NOME,PIANO ) VALUES (?,?)";

		try (Connection connection = getConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(query);
 ) {
			//PREPAREDSTATEMENT
			 preparedStatement.setString(1, recordOld.getNome());
			 preparedStatement.setInt (2, recordOld.getPiano());

			  if(!preparedStatement.execute()) {
				 System.out.println("ufficio inserito");
			  }

		}catch (Exception e) {
			e.printStackTrace();

	 	}
	}

	@Override
	public void update(RecordOld recordOld) {

		String queryUpdate  = "update   uffici set   NOME =? ,PIANO =? where id =?";
		try (Connection connection = getConnection();
 				PreparedStatement statementUpdate =  connection.prepareStatement(queryUpdate);
			)
		{

				statementUpdate.setString(1, recordOld.getNome());
				statementUpdate.setInt (2, recordOld.getPiano());
				statementUpdate.setInt (3, recordOld.getId() );
					if (!statementUpdate.execute()) {
						System.out.println("ufficio modificato");
				}



		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
	String query = "DELETE FROM uffici  WHERE  id =?";
	try (Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		)
	{
		preparedStatement.setInt(1, id);
		if(preparedStatement.executeUpdate() >0) {
			System.out.println("ufficio eliminato");
		}



	} catch (SQLException e) {
		e.printStackTrace();
	}

 	}

}
