package main;

import main.dao.*;
import main.entity.RecordCsv;
import org.apache.commons.csv.CSVRecord;

import java.util.List;

public class ReadFromCSV {
    public static void main(String args[]) throws Exception {
        RecordCsvDao recordCsvDao = new RecordCsvDaoImpl();
        NotProcessedDao notProcessedDao = new NotProcessedDaoImpl();
        NewAssicuratoDao newAssicuratoDao = new NewAssicuratoDaoImpl();
        List<RecordCsv> recordsCsv = recordCsvDao.getAll();

        for (RecordCsv record : recordsCsv) {
            if (record.getCodiceFiscale().length() != 16) {
                notProcessedDao.insert(record);
            } else {
                newAssicuratoDao.insert(record);
            }
        }
    }
}
