/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yeiim
 */
public class TMProducto extends AbstractTableModel {

    private final String[] columnas = {"Codigo", "Nombre", "Precio", "Inventario"};
    private List<Producto> producto = new ArrayList<>();

    public TMProducto(List<Producto> product) {
        this.producto = product;
    }
    
    @Override
    public int getRowCount() {
        return this.producto.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Object resp;
        
        switch(columna){
            case 0:
                resp = this.producto.get(fila).getCodigo();
                break;
            case 1:
                resp = this.producto.get(fila).getNombre();
                break;
            case 2:
                resp = this.producto.get(fila).getPrecio();
                break;
            default:
                resp = this.producto.get(fila).getInventario();
        }     
        return resp;
    }
    
    @Override
    public String getColumnName(int column){
        return this.columnas[column];
    }
    
    public void actualizarTabla(){
        fireTableDataChanged();
    }
    
    public Producto detalle(int fila){
        return this.producto.get(fila);
    }
    
}
