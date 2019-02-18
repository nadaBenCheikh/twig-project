/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author esprit
 */
public interface Iservices<T> {
    void isert(T t);
    void delete(T t);
    void update(T t);
    List<T> displayAllProjects(int x);
    T getById(T t);
}
