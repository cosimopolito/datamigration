package main.dao;

import main.entity.RecordOld;

public  abstract  class NotProcessedDao extends  Dao {
    public abstract void insert(RecordOld recordOld) ;

}
