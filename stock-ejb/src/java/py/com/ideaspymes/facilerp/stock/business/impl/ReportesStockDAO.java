/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.business.impl;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IReportesStockDAO;
import py.com.ideaspymes.facilerp.stock.business.pojos.Rendimiento;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ReportesStockDAO implements IReportesStockDAO {

    @EJB
    private ABMService abms;

    @Override
    public List<Rendimiento> getRendimientos() {
        List<Object[]> lista = abms.getEM()
                .createNativeQuery(ConsultasStock.getRendimiento())
                .getResultList();

        List<Rendimiento> R = new ArrayList<>();
        
        for (Object[] obj : lista) {
            R.add(new Rendimiento((String) obj[0], (Double) obj[1]));
        }
        return R;
    }
}
