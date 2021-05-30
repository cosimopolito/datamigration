package main.dao;

import main.entity.RecordCsv;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class NewAssicuratoDaoImpl extends   NewAssicuratoDao {

    @Override
    public void insert(RecordCsv recordCsv) {
        String query = "insert into assicurato ( nome,cognome,cod_fiscale,numero_sinistri ) VALUES (?,?,?,?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            //PREPAREDSTATEMENT
            preparedStatement.setString(1, recordCsv.getNome());
            preparedStatement.setString (2, recordCsv.getCognome());
            preparedStatement.setString (3, recordCsv.getCodiceFiscale());
            preparedStatement.setInt (4, recordCsv.getNumeroSinistri());

            if(!preparedStatement.execute()) {
                System.out.println("assicurato inserito");
            }

        }catch (Exception e) {
            e.printStackTrace();

        }
    }

}
