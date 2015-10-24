/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.business.impl;

import java.util.Date;
import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.generico.ResolutorReferencia;
import py.com.ideaspymes.facilerp.pesistencia.stock.ComprobanteStock;
import py.com.ideaspymes.facilerp.pesistencia.stock.Deposito;
import py.com.ideaspymes.facilerp.pesistencia.stock.DetComprobanteStock;
import py.com.ideaspymes.facilerp.pesistencia.stock.Ingrediente;
import py.com.ideaspymes.facilerp.pesistencia.stock.MovimientoStockCompra;
import py.com.ideaspymes.facilerp.pesistencia.stock.MovimientoStockVenta;
import py.com.ideaspymes.facilerp.pesistencia.stock.Producto;
import py.com.ideaspymes.facilerp.pesistencia.stock.enums.TipoProducto;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IComprobanteStockDAO;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IMovimientoStockDAO;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ComprobanteStockDAO implements IComprobanteStockDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;
    @EJB
    private IMovimientoStockDAO movimientoStockDAO;
    @EJB
    private ResolutorReferencia resolutorRef;

    @Override
    public ComprobanteStock create(ComprobanteStock entity, String usuario) {
        ComprobanteStock c = abmService.create(entity, usuario);

        switch (c.getTipo()) {
            case VENTA:
                creaMovientosStockVenta(c.getDetalles());
                break;
            case COMPRA:
                creaMovientosStockCompra(c.getDetalles());
                break;
            case TRANSFERENCIA_INTERNA:
                creaMovientosStockTransferInterna(c.getDetalles());
                break;
            case TRANSFERENCIA_EXTERNA:
                creaMovientosStockTransferExtena(c.getDetalles());
                break;
        }

        return c;
    }

    @Override
    public ComprobanteStock edit(ComprobanteStock entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(ComprobanteStock entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public ComprobanteStock find(Object id) {
        return abmService.find(id, ComprobanteStock.class);
    }

    @Override
    public List<ComprobanteStock> findAll() {
        return abmService.getEM().createQuery("select obj from ComprobanteStock obj").getResultList();
    }

    @Override
    public List<ComprobanteStock> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    private void creaMovientosStockVenta(List<DetComprobanteStock> detalles) {

        for (DetComprobanteStock d : detalles) {

            Deposito dp = resolutorRef.getDeposito(d.getComprobanteStock().getRefOrigen());

            MovimientoStockVenta m = new MovimientoStockVenta();
            m.setComprobanteStock(d.getComprobanteStock());
            System.out.println("Referencia en CreaMovimientoStockVenta: " + d.getComprobanteStock().getRefOrigen());

            if (dp != null) {
                m.setDeposito(dp);
            }
            m.setFecha(new Date());
            m.setProducto(d.getProducto());
            m.setUnidadMedida(d.getUnidadMedida());
            m.setCantidad(d.getCantidad());

            movimientoStockDAO.creaMovimientoStock(m);

        }
    }

    private void creaMovientosStockCompra(List<DetComprobanteStock> detalles) {
        for (DetComprobanteStock d : detalles) {
            MovimientoStockCompra m = new MovimientoStockCompra();
            m.setComprobanteStock(d.getComprobanteStock());

            Deposito dp = resolutorRef.getDeposito(d.getComprobanteStock().getRefDestino());

            if (dp != null) {
                m.setDeposito(dp);
            }
            m.setFecha(new Date());
            m.setProducto(d.getProducto());
            m.setUnidadMedida(d.getUnidadMedida());
            m.setCantidad(d.getCantidad());
            movimientoStockDAO.creaMovimientoStock(m);
        }
    }

    private void creaMovientosStockTransferInterna(List<DetComprobanteStock> detalles) {

    }

    private void creaMovientosStockTransferExtena(List<DetComprobanteStock> detalles) {

    }

}
