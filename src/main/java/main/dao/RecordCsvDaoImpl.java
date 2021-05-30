package main.dao;

import main.entity.RecordCsv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecordCsvDaoImpl extends RecordCsvDao {

    @Override
    public List<RecordCsv> getAll() {
        List<RecordCsv> recordCsvs = null;
        try (Reader reader = Files.newBufferedReader(Paths.get("C://assicurati.csv"))) {

            recordCsvs = new ArrayList<>();
            // read csv file
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
            for (CSVRecord record : records) {
                RecordCsv recordCsv = new RecordCsv();
                recordCsv.setId(Integer.parseInt(record.get(0).trim()));
                recordCsv.setNome(record.get(1).trim());
                recordCsv.setCognome(record.get(2).trim());
                recordCsv.setDataNascita(new SimpleDateFormat("dd/mm/yyyy").parse(record.get(3).trim()));
                recordCsv.setCodiceFiscale(record.get(4).trim());
                recordCsv.setNumeroSinistri(Integer.parseInt(record.get(5).trim()));

                recordCsvs.add(recordCsv);

            }
            return recordCsvs;

        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return Collections.emptyList();
    }
}
