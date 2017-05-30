/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clientecrudrest.ClienteCrudRest;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rodrigo
 */
public class ExemploTableYouTube extends AbstractTableModel {
    
    List<Cliente> listDeClientes;
    private String[] colunas = {"nome","email"};

    public ExemploTableYouTube() {
        this.listDeClientes = ClienteCrudRest.getListaDeCliente();
    }
    
    
    
    public void addCliente (Cliente cliente) {
        ClienteCrudRest.postCliente(cliente);
        //listDeClientes.add(cliente);
        // este mettodo atualiza a tabela
        fireTableDataChanged();
    }
    
    public void deleteCliente (int rowIndex) {
        Cliente c = new Cliente();
        c = listDeClientes.get(rowIndex);
        ClienteCrudRest.deleteCliente(c);
        listDeClientes.remove(rowIndex);
        // este mettodo atualiza a tabela
        fireTableDataChanged();
    }
    
    public void updateCliente (Cliente cliente) {
        ClienteCrudRest.putCliente(cliente);
        //listDeClientes.add(linha, cliente);
        // este mettodo atualiza a tabela
        fireTableDataChanged();
    }
    public Cliente getCliente (int rowIndex) {
      return listDeClientes.get(rowIndex); 
    }

    @Override
    // quantas linhas temna tabela
    public int getRowCount() {
       return listDeClientes.size();
    }

    @Override
    // quantas colunas tem na tabela
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    // pegar e inserrir valores da tabela
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
            return this.listDeClientes.get(rowIndex).getNome();
            case 1:
            return this.listDeClientes.get(rowIndex).getEmail();
            default:
            return this.listDeClientes.get(rowIndex);
        }
    }
    
    @Override
    // título da tabela
    public String getColumnName (int columnIndex) {
        return this.colunas[columnIndex];
    }
}
