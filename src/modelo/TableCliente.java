/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import clientecrudrest.ClienteCrudRest;
/**
 *
 * @author Rodrigo
 */
public class TableCliente {
    public ObjectTableModel objectTable () {
        // objeto resolver adiciona a class cliente
        AnnotationResolver resolver = new AnnotationResolver(Cliente.class);
        //Ns usamos o resolver como parametro do ObjectTableModel 
        // juntamente com os campos de título da minha tabela
        ObjectTableModel tableModel = new ObjectTableModel(resolver,"id,nome,email");
        // aqui nos usamos a lista para ser os dados da tabela
        tableModel.setData(ClienteCrudRest.getListaDeCliente());
       
        JTable table  = new JTable(tableModel);
        JFrame frame = new JFrame("Lista de Clientes");
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(table);
        pane.setPreferredSize(new Dimension(400,200));
        frame.add(pane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        return tableModel;
    }
    
}
