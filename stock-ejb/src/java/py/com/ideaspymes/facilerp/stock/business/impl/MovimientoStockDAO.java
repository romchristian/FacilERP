/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.business.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.pesistencia.stock.Deposito;
import py.com.ideaspymes.facilerp.pesistencia.stock.Existencia;
import py.com.ideaspymes.facilerp.pesistencia.stock.MovimientoStock;
import py.com.ideaspymes.facilerp.pesistencia.stock.Producto;
import py.com.ideaspymes.facilerp.pesistencia.stock.UnidadMedida;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IMovimientoStockDAO;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class MovimientoStockDAO implements IMovimientoStockDAO {

    @EJB
    private ABMService abms;

    @Override
    public void creaMovimientoStock(MovimientoStock m) {
        abms.getEM().merge(m);
        Producto p = m.getProducto();
        System.out.println("Invoque creaMovimiento");
        afectaStockExistencia(m.getDeposito(), p, m.cantidadAAfectar(), m.getUnidadMedida());
    }

    private void afectaStockExistencia(Deposito d, Producto p, Double cantidadAAfectar, UnidadMedida um) {
        System.out.println("Invoque afectaExistencia :  Deposito: " + d +" Producto : " + p + " UnidadMedida: " + um + " Cantidad : " + cantidadAAfectar);
        if (p != null && d != null && cantidadAAfectar != null && um != null ) {
            Existencia e = null;
            System.out.println("Estoy dentro");
            try {
                e = (Existencia) abms.getEM().createQuery("Select e from Existencia e WHERE e.deposito= :deposito and e.producto= :producto and e.unidadMedida= :unidadmedida")
                        .setParameter("producto", p)
                        .setParameter("deposito", d)
                        .setParameter("unidadmedida", um)
                        .getSingleResult();

            } catch (Exception ex) {
                System.out.println("No se encontro existencia: " + ex.getMessage());
            }

            if (e == null) {
                e = new Existencia();
                e.setDeposito(d);
                e.setProducto(p);
                e.setCantidad(cantidadAAfectar);
                e.setUnidadMedida(um);
                System.out.println("No Existe e : " + e.getCantidad());
            } else {

                Double existenciaActual = e.getCantidad() == null ? 0d : e.getCantidad();
                e.setCantidad(existenciaActual + cantidadAAfectar);
                System.out.println("Existe e : " + e.getCantidad());
            }

            abms.getEM().merge(e);
            System.out.println("Hizo el merge: " + e.getCantidad());

            afectaStock(p, um);

        }
    }

    private void afectaStock(Producto p, UnidadMedida um) {
        if (p != null && um != null) {
            Double cantidadAcumulada = 0d;
            try {
                cantidadAcumulada = (Double) abms.getEM()
                        .createQuery("Select sum(e.cantidad) from Existencia e where e.producto= :producto and e.unidadMedida= :unidadmedida")
                        .setParameter("producto", p)
                        .setParameter("unidadmedida", um)
                        .getSingleResult();

                p.setStock(cantidadAcumulada);
                abms.getEM().merge(p);
            } catch (Exception e) {
            }

        }
    }
}
