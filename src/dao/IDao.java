/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Consultation;
import entities.Rv;
import java.util.List;
/**
 *
 * @author Abdulah ZOUBOYE
 */
public interface IDao<T> {

public int insert(T ogj);
public int update(T ogj);
public int delete(int id);
public int cancel(int id);

public List<T> findAll();
public List<T> findAllById(int id);
public List<T> findAllValide();
public T findById(int id);
public List<T> findRvById(int userId);
    
public int updateRvSec(Rv rv);
public int updateRvMed(Consultation consultation);

}
