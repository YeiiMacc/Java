/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author yeiim
 */
public class BaseDatosProductos {

    private HashMap<Integer, Producto> listaProductos = new HashMap<>();

    public BaseDatosProductos() {
        this.listaProductos.put(1, new Producto(1, "Manzanas", 8000, 65));
        this.listaProductos.put(2, new Producto(2, "Limones", 2300, 15));
        this.listaProductos.put(3, new Producto(3, "Granadilla", 2500, 38));
        this.listaProductos.put(4, new Producto(4, "Arandanos", 9300, 55));
        this.listaProductos.put(5, new Producto(5, "Tomates", 2100, 42));
        this.listaProductos.put(6, new Producto(6, "Fresas", 4100, 3));
        this.listaProductos.put(7, new Producto(7, "Helado", 4500, 41));
        this.listaProductos.put(8, new Producto(8, "Galletas", 500, 8));
        this.listaProductos.put(9, new Producto(9, "Chocolates", 3500, 806));
        this.listaProductos.put(10, new Producto(10, "Jamon", 15000, 10));
    }

    public List<Producto> getListaProductos() {
        return new ArrayList<>(this.listaProductos.values());
    }

    public void setListaProductos(HashMap<Integer, Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public boolean verificarExistencia(Producto producto) {
        return this.listaProductos.containsKey(producto.getCodigo());
    }

    public boolean verificarExistencia(String nombre) {
        for (Producto p : this.listaProductos.values()) {
            if (nombre.toLowerCase().equals(p.getNombre().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public int ultimoCodigo() {
        int codigo = 0;
        for (Producto p : this.listaProductos.values()) {
            codigo = p.getCodigo();                    
        }
        return codigo;
    }

    public void agregar(Producto producto) {
        this.listaProductos.put(producto.getCodigo(), producto);
    }

    public void actualizar(Producto producto) {
        this.listaProductos.replace(producto.getCodigo(), producto);
    }

    public void borrar(Producto producto) {
        this.listaProductos.remove(producto.getCodigo());
    }
    
    public String generarInformeUI() {
        List<Producto> listaMayores = extraerMayores();
        return listaMayores.get(0).getNombre()+ ", " + listaMayores.get(1).getNombre() + ", " + listaMayores.get(2).getNombre();
    }

    private List<Producto> extraerMayores() {
        List<Producto> lista = new ArrayList<>(this.listaProductos.values());
        List<Producto> listaMayores = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Producto c = new Producto();
            for (Producto cTem : lista) {
                if (cTem.getPrecio() > c.getPrecio()) {
                    c = cTem;
                }
            }
            listaMayores.add(c);
            lista.remove(c);
        }
        return listaMayores;
    }
}
