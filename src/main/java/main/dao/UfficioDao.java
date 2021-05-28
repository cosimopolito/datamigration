package main.dao;

import main.entity.Ufficio;

import java.util.List;

public abstract class UfficioDao extends Dao {
	 public abstract Ufficio get(int id) ;//tatno mi da per forza un valore non puo esser enull
	 public abstract List<Ufficio> getAll() ;
	 public abstract void insert(Ufficio ufficio) ;
	 public abstract void update(Ufficio ufficio) ;
	 public abstract void delete(int id) ;
}
