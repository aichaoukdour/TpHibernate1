/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.services;

import java.util.List;

/**
 *
 * @author hp
 */
interface IDao<T> {
    boolean create(T o);
    List<T> findAll();
     T getById(int n);
    
}    