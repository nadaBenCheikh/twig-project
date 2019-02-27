/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.Login1.service;

import java.util.List;

/**
 *
 * @author esprit
 */
public interface IService<T> {
    void insert(T t);
    void delete(T t);
    void update(T t);
    List<T> displayAll(); //getAll
    T getById(T t);
}


