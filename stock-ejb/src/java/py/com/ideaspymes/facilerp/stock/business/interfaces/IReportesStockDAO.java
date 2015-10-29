/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.business.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.ideaspymes.facilerp.stock.business.pojos.Rendimiento;

/**
 *
 * @author Acer
 */
@Local
public interface IReportesStockDAO {
    List<Rendimiento> getRendimientos();
}
