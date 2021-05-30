package main.dao;

import main.entity.RecordCsv;

import java.util.List;

public abstract class RecordCsvDao extends Dao {
 	 public abstract List<RecordCsv> getAll() ;
}
