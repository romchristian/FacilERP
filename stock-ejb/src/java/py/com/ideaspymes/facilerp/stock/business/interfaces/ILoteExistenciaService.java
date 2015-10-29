/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.business.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.ideaspymes.facilerp.pesistencia.stock.LoteExistencia;
import py.com.ideaspymes.facilerp.pesistencia.stock.Producto;
import py.com.ideaspymes.facilerp.pesistencia.stock.UnidadMedida;

/**
 *
 * @author Acer
 */


@Local
public interface ILoteExistenciaService {
    public void creaLoteExitencia(LoteExistencia l);
    public void afectaLotesExistenciaMasCovenientes(Producto p, UnidadMedida um, Double cantidad);
    public Double afectaCantidadUsadaLoteExitencia(LoteExistencia l, Double cantidad);
    public List<LoteExistencia>  getLotesExitenciaMasAntiguos(Producto p , UnidadMedida um, Double cantidad);
    public List<LoteExistencia>  getLotesExitenciaMasRecientes(Producto p , UnidadMedida um, Double cantidad);
    public List<LoteExistencia>  getLotesExitenciaVencimientosMasProximos(Producto p , UnidadMedida um, Double cantidad);
    public Double getCostoPonderado(Producto p);
    public Double getCostoLifo(Producto p);
    public Double getCostoFifo(Producto p);
}
