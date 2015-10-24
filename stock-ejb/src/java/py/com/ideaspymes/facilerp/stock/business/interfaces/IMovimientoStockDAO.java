/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.business.interfaces;

import javax.ejb.Local;
import py.com.ideaspymes.facilerp.pesistencia.stock.MovimientoStock;

/**
 *
 * @author Acer
 */


@Local
public interface IMovimientoStockDAO {
    public void creaMovimientoStock(MovimientoStock m);
}
