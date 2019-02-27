/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author rim
 */
public interface Iserv<S> {
    void insertPST(S t);
    void delete(S t);
    void update(S t);
    List<S> getAll();
    S getById(S t);
    
            
    
}


