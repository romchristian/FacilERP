/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.generico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class ConfigModulo {

    private List<String> modulos;
    public static final String MODULO_BASE = "base";
    public static final String MODULO_PUNTO_VENTA = "puntoventa";
    public static final String MODULO_STOCK = "stock";
    public static final String MODULO_CONTABILIDAD = "contabilidad";

    private ConfigModulo() {

    }

    public static ConfigModulo getInstance() {
        ConfigModulo R = new ConfigModulo();
        R.modulos = new ArrayList<>();
        R.modulos.add(MODULO_BASE);
        R.modulos.add(MODULO_PUNTO_VENTA);
        R.modulos.add(MODULO_STOCK);
        R.modulos.add(MODULO_CONTABILIDAD);
        return R;
    }

    public List<String> getModulos() {
        return modulos;
    }

}
