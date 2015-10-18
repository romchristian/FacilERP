/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.generico;

import java.util.List;

/**
 *
 * @author christian
 */
public interface AbstractDAO<T> {

    public abstract T create(T entity,String usuario);

    public abstract T edit(T entity,String usuario);

    public abstract void remove(T entity,String usuario);

    public abstract T find(Object id);

    public abstract List<T> findAll();

    public abstract List<T> findAll(String query, QueryParameter params);
}
