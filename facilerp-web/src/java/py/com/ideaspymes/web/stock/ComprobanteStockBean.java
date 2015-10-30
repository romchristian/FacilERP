/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.stock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;
import py.com.ideaspymes.facilerp.contabilidad.business.interfaces.IFacturaProveedorDAO;

import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Empresa;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.DetFacturaProveedor;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.FacturaProveedor;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.Proveedor;
import py.com.ideaspymes.facilerp.pesistencia.stock.Ingrediente;

import py.com.ideaspymes.web.generico.BeanGenerico;
import py.com.ideaspymes.facilerp.pesistencia.stock.ComprobanteStock;
import py.com.ideaspymes.facilerp.pesistencia.stock.DetComprobanteStock;
import py.com.ideaspymes.facilerp.pesistencia.stock.Producto;
import py.com.ideaspymes.facilerp.pesistencia.stock.enums.TipoComprobanteStock;
import py.com.ideaspymes.facilerp.pesistencia.stock.enums.TipoProducto;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IComprobanteStockDAO;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IProductoDAO;
import py.com.ideaspymes.web.generico.Credencial;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class ComprobanteStockBean extends BeanGenerico<ComprobanteStock> implements Serializable {

    @Inject
    private Credencial credencial;
    @EJB
    private IComprobanteStockDAO ejb;
    @EJB
    private IFacturaProveedorDAO ejbFactura;
    @EJB
    private IProductoDAO productoDAO;

    @Override
    public AbstractDAO<ComprobanteStock> getEjb() {
        return ejb;
    }

    @Override
    public ComprobanteStock getNuevo() {
        return new ComprobanteStock();
    }

    public void generarComprobante() {
        generarComprobanteCompra();
        generarComprobanteVenta();
        generarFactura();
    }

    public void generarComprobanteCompra() {
        ComprobanteStock c = new ComprobanteStock();

        c.setTipo(TipoComprobanteStock.COMPRA);
        c.setFecha(new Date());
        c.setRefDocumento("FacturaCompra:1");
        c.setRefOrigen("Proveedor:1");
        c.setRefDestino("py.com.ideaspymes.facilerp.pesistencia.stock.Deposito:1");
        c.setUsuario(credencial.getUsuario());
        c.setDetalles(new ArrayList<DetComprobanteStock>());

        //Detalles
        List<Producto> productos = productoDAO.findAll();
        for (Producto p : productos) {
            if (p.getTipoProducto() == TipoProducto.MATERIA_PRIMA) {
                DetComprobanteStock d = new DetComprobanteStock();
                d.setComprobanteStock(c);
                d.setProducto(p);
                d.setUnidadMedida(p.getUnidadMedidaBase());
                d.setCantidad(10d);
                d.setValor(p.getCosto());
                c.getDetalles().add(d);
            }
        }

        ejb.create(c, credencial.getUsuario().getUsuario());
    }

    public void generarFactura() {

        FacturaProveedor fp = new FacturaProveedor();
        fp.setNumero("123456");
        fp.setTotal(1000000.0d);

        //Detalles
        List<Producto> productos = productoDAO.findAll();
        ArrayList lista = new ArrayList();
        fp.setDetalles(lista);
        for (Producto p : productos) {
            if (p.getTipoProducto() == TipoProducto.MATERIA_PRIMA) {
                DetFacturaProveedor dfp = new DetFacturaProveedor();
                dfp.setFacturaProveedor(fp);
                dfp.setProducto(p);
                dfp.setUnidadMedida(p.getUnidadMedidaBase());
                dfp.setCantidad(10d);
                dfp.setPrecioUnitario(25000.0d);
                dfp.setTotal(250000.0d);
                fp.getDetalles().add(dfp);
            }
        }
        
        ejbFactura.create(fp, credencial.getUsuario().getUsuario());

    }

    public void generarComprobanteVenta() {
        ComprobanteStock c = new ComprobanteStock();

        c.setTipo(TipoComprobanteStock.VENTA);
        c.setFecha(new Date());
        c.setRefDocumento("FacturaVenta:1");
        c.setRefOrigen("py.com.ideaspymes.facilerp.pesistencia.stock.Deposito:1");
        c.setRefDestino("Cliente:10");
        c.setUsuario(credencial.getUsuario());
        c.setDetalles(new ArrayList<DetComprobanteStock>());

        //Detalles
        List<Producto> productos = productoDAO.findAll();
        for (Producto p : productos) {
            if (p.getTipoProducto() == TipoProducto.ELABORACION_EN_CANTINA) {
                for (Ingrediente i : p.getIngredientes()) {
                    DetComprobanteStock d = new DetComprobanteStock();
                    d.setComprobanteStock(c);
                    d.setProducto(i.getProducto());
                    d.setUnidadMedida(i.getProducto().getUnidadMedidaBase());
                    d.setCantidad(3d * i.getCantidad());
                    d.setValor(i.getCosto() * 3d);
                    c.getDetalles().add(d);
                }

            }
        }
        ejb.create(c, credencial.getUsuario().getUsuario());
    }

}
