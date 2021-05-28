package main.dao;

import main.entity.RecordOld;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class NewAssicuratoDaoImpl extends   NewAssicuratoDao {

    @Override
    public void insert(RecordOld recordOld) {
        String query = "insert into assicurati ( nome,cognome,codice_fiscale,num_sinistri ) VALUES (?,?,?,?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            //PREPAREDSTATEMENT
            preparedStatement.setString(1, recordOld.getNome());
            preparedStatement.setString (2, recordOld.getCognome());
            preparedStatement.setString (3, recordOld.getCodiceFiscale());
            preparedStatement.setInt (4, recordOld.getNumeroSinistri());

            if(!preparedStatement.execute()) {
                System.out.println("assicurato inserito");
            }

        }catch (Exception e) {
            e.printStackTrace();

        }
    }

}
