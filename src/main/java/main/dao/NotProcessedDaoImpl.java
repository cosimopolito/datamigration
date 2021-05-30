package main.dao;

import main.entity.RecordCsv;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class NotProcessedDaoImpl extends  NotProcessedDao{
    @Override
    public void insert(RecordCsv recordCsv) {
        String query = "insert into not_processed ( cod_fiscale,old_id ) VALUES (?,? )";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {

            preparedStatement.setString (1, recordCsv.getCodiceFiscale());
            preparedStatement.setInt (2, recordCsv.getId());

            if(!preparedStatement.execute()) {
                System.out.println("assicurato inserito");
            }

        }catch (Exception e) {
            e.printStackTrace();

        }
    }
}
