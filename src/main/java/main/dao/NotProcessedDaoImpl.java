package main.dao;

import main.entity.RecordOld;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class NotProcessedDaoImpl extends  NotProcessedDao{
    @Override
    public void insert(RecordOld recordOld) {
        String query = "insert into not_processed ( cod_fiscale,old_id ) VALUES (?,? )";

        try (Connection connection = getConnectionNew();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {

            preparedStatement.setString (1, recordOld.getCodiceFiscale());
            preparedStatement.setInt (2, recordOld.getId());

            if(!preparedStatement.execute()) {
                System.out.println("assicurato inserito");
            }

        }catch (Exception e) {
            e.printStackTrace();

        }
    }
}
