/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientecrudrest;

import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.Cliente;

/**
 *
 * @author gilson
 */
public class ClienteCrudRest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getUmCliente();
        getListaDeCliente();
//        postCliente();
//        putCliente();
//        deleteCliente();
    }
    
    public static void getUmCliente(){
        System.out.println("Um Cliente");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8084/CrudRest");
        Cliente cliente = target.path("/cliente/13").request().get(Cliente.class);
        System.out.println("Cliente: "+cliente.getId()+" - "
                                      +cliente.getNome()+" - "
                                      +cliente.getEmail());
    }
    
    public static List<Cliente> getListaDeCliente(){
        List<Cliente> list = new LinkedList<>();
        System.out.println("Lista de Clientes");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8084/CrudRest");
        Response response = target.path("/cliente").request().get(Response.class);
        return list = response.readEntity(new GenericType<List<Cliente>>(){});
      
    }
    
    public static void postCliente(Cliente cliente){
        System.out.println("Post");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8084/CrudRest");
        //Cliente cliente1 = new Cliente(1, "X","x");
        Entity<Cliente> entity = Entity.entity(cliente, MediaType.APPLICATION_JSON);
        Response response = target.path("/cliente").request().post(entity);
        System.out.println(response.readEntity(String.class));    
    }
    
    public static void putCliente(Cliente cliente){
        System.out.println("Put");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8084/CrudRest");
        //Cliente cliente1 = new Cliente(13, "A","aaa");
        Entity<Cliente> entity = Entity.entity(cliente, MediaType.APPLICATION_JSON);
        Response response = target.path("/cliente").request().put(entity);
        System.out.println(response.readEntity(String.class)); 
    }
    
    public static void deleteCliente(Cliente cliente){
        System.out.println("Delete");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8084/CrudRest");
        Response response = target.path("/cliente/"+cliente.getId()).request().delete();
        System.out.println(response.readEntity(String.class)); 
    }
}
    


