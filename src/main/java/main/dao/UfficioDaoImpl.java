package main.dao;

import main.entity.Ufficio;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UfficioDaoImpl extends UfficioDao{

	@Override
	public Ufficio get(int id) {
		String query = "SELECT * FROM UFFICI WHERE ID =?";
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			)
		{
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			Ufficio ufficio = new Ufficio();
			if(resultSet.next()) {
				ufficio.setId(resultSet.getInt("ID"));
				ufficio.setNome (resultSet.getString("nome") );
				ufficio.setPiano (resultSet.getInt("piano"));
				return ufficio;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Ufficio> getAll() {
		String query = "SELECT * FROM UFFICI ";
		List<Ufficio> uffici = new ArrayList<>();

		try (Connection connection = getConnection();
				Statement statement =  connection.createStatement();
			)
		{
 			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				Ufficio ufficio = new Ufficio();
				ufficio.setId(resultSet.getInt("ID"));
				ufficio.setNome (resultSet.getString("nome") );
				ufficio.setPiano (resultSet.getInt("piano"));
				uffici.add(ufficio);
			}
			return uffici;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();
 	}

	@Override
	public void insert(Ufficio ufficio) {
		String query = "insert into uffici ( NOME,PIANO ) VALUES (?,?)";

		try (Connection connection = getConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(query);
 ) {
			//PREPAREDSTATEMENT
			 preparedStatement.setString(1, ufficio.getNome());
			 preparedStatement.setInt (2,ufficio.getPiano());
			 
			  if(!preparedStatement.execute()) {
				 System.out.println("ufficio inserito");
			  }
			  
		}catch (Exception e) {
			e.printStackTrace();

	 	}
	}

	@Override
	public void update(Ufficio ufficio) {
	 
		String queryUpdate  = "update   uffici set   NOME =? ,PIANO =? where id =?";
		try (Connection connection = getConnection();
 				PreparedStatement statementUpdate =  connection.prepareStatement(queryUpdate);
			)
		{
 		  
				statementUpdate.setString(1, ufficio.getNome()); 
				statementUpdate.setInt (2, ufficio.getPiano()); 
				statementUpdate.setInt (3, ufficio.getId() ); 
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
