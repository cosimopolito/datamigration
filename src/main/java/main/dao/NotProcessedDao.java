package main.dao;

import main.entity.RecordCsv;

public  abstract  class NotProcessedDao extends  Dao {
    public abstract void insert(RecordCsv recordCsv) ;

}
