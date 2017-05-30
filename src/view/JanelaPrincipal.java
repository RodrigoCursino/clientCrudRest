/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import clientecrudrest.ClienteCrudRest;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import modelo.Cliente;
import modelo.TableCliente;

/**
 *
 * @author Rodrigo
 */
public class JanelaPrincipal extends JFrame {

    private JPanel painelCadastro;
    private JPanel painelListagem;
    private JPanel painelNome;
    private JPanel painelEmail;
    private JTextField nomeCliente;
    private JTextField emailCliente;
    private JLabel nome;
    private JLabel email;
    private JButton cadastrar;
    private JTable table;
    private  JScrollPane pane;
    private Cliente cliente;
    private TableCliente tableModel;

    public JanelaPrincipal() {
        setTitle("CrudRest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        // Centralizar JFrame
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (tela.width - getWidth()) / 2;
        int y = (int) (tela.height - getHeight()) / 2;
        setLocation(x, y);

        // Label e Jtext nome
        nome = new JLabel();
        nome.setText("Nome: ");
        nomeCliente = new JTextField();
        nomeCliente.setPreferredSize(new Dimension(300, 30));

        // painel nome
        painelNome = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelNome.add(nome);
        painelNome.add(nomeCliente);

        // label email e nome
        email = new JLabel();
        email.setText("email: ");
        emailCliente = new JTextField();
        emailCliente.setPreferredSize(new Dimension(300, 30));

        painelEmail = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelEmail.add(email);
        painelEmail.add(emailCliente);

        // Botão
        cadastrar = new JButton();
        cadastrar.setText("Cadastrar");

        // ação do botão
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliente = new Cliente();
                
                cliente.setNome(nomeCliente.getText());
                cliente.setEmail(emailCliente.getText());
                
                ClienteCrudRest.postCliente(cliente);
                
                nomeCliente.setText("");
                emailCliente.setText("");
            }
        });

        // painel cadastro
        painelCadastro = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        //painelCadastro.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        painelCadastro.add(painelNome);
        painelCadastro.add(painelEmail);
        painelCadastro.add(cadastrar);
        
        tableModel = new TableCliente();
        table = new JTable();
        table  = new JTable(tableModel.objectTable());
        pane = new JScrollPane();
        pane.setViewportView(table);
    
        // painel listagem
        painelListagem = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelListagem.add(table);
        painelListagem.add(pane);
        

        // adicionando painel listagem e cadastro
        add(painelCadastro, BorderLayout.NORTH);
        add(painelListagem, BorderLayout.CENTER);
    }

}
