
package main;

import main.dao.UfficioDao;
import main.dao.UfficioDaoImpl;
import main.entity.Ufficio;

import java.sql.*;
import java.util.List;


public class Connessione {
	
	public static void eseguiQuery(String ufficio, Integer piano) {
		String urlString ="jdbc:mysql://localhost:3306/gestione_punteggi?serverTimezone=UTC&useSSL=false";
		try (Connection connection = DriverManager.getConnection(urlString,"root","");
				Statement statement =  connection.createStatement()) {
			//PREPAREDSTATEMENT
			String query = "insert into uffici ( NOME,PIANO ) VALUES (?,?)";
			 PreparedStatement preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setString(1, ufficio);
			 preparedStatement.setInt (2,piano);
			  preparedStatement.execute();
			  ResultSet resultSet = preparedStatement.executeQuery();//ritorna immediatamente un resultset
			  while(resultSet.next()) {}
		}catch (Exception e) {
			e.printStackTrace();

	 	}
	}
	public static void main(String[] args) {
		//com.myslq.sj.jdbc.Driver
//	String urlString ="jdbc:mysql://localhost:3306/gestione_punteggi?serverTimezone=UTC&useSSL=false";
//	ResultSet resultSet = null;
//	
//	//STATEMENT
//	try (Connection connection = DriverManager.getConnection(urlString,"root","");
//			Statement statement =  connection.createStatement()) {
//			System.out.println("CONNESSO");
//		 
// 		  //statement.execute("insert into uffici ( NOME,PIANO ) VALUES ('aula22','3')");
//			 //  resultSet = statement.executeQuery("select * from dipendenti");//ritorna immediatamente un resultset
//
// 		  
//			if (statement.execute("select * from dipendenti")) {
//			   resultSet=statement.getResultSet();
//			 while(resultSet.next()) {
//			   
//				String nome  = resultSet.getString(4);
//				int punteggio  = resultSet.getInt(5) ;
//				System.out.println(  "nome: "+nome + " punteggio: "+punteggio  );
// 
//			 }
//				
//			}
//			else {
//				System.out.println("non ho risultati");
//			}
// 		
//			
//	}
//	catch(SQLException e){
//		e.printStackTrace();
//	}
//	eseguiQuery("uff", 8);
//	
//	 
//	
		UfficioDao ufficioDao = new UfficioDaoImpl();
		Ufficio ufficio =ufficioDao.get(1);
		List<Ufficio> uffici= ufficioDao.getAll();
		Ufficio ufficio2 = new Ufficio();
		 
		ufficio2.setNome("uffic2222");;
		ufficioDao.delete(2);  
		

	  
	}
	
}
