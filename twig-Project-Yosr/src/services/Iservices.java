/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Tasks;
import java.util.List;

/**
 *
 * @author esprit
 */
public interface Iservices<T> {
    void isert(T t);
    void delete(int x);
    void update(T t);
    List<T> displayAll();
    T getById(T t);
  
    
}
