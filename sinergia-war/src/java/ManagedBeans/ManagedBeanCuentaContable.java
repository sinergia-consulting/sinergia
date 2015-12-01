/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import bc.CuentaFacadeLocal;
import be.Cuenta;
import be.Cuentanodo;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author argos
 */
@ManagedBean
@SessionScoped
public class ManagedBeanCuentaContable implements Serializable {

    @EJB
    private CuentaFacadeLocal cuentaFacade;
    private Cuenta objeto;
    private Cuenta objetoSeleccionado;
    private List<Cuenta> lista;
    private TreeNode root;

    public ManagedBeanCuentaContable() {
        objeto = new Cuenta();
        objetoSeleccionado = new Cuenta();
        lista = new LinkedList<>();
    }

    public TreeNode getRoot() {

        TreeNode root = new DefaultTreeNode(new Cuenta(0), null);

        for (Cuenta c : cuentaFacade.Cuenta_listaNivel(2)) {
            TreeNode nivel01 = new DefaultTreeNode(c, root);
            for (Cuentanodo cn : c.getCuentanodoList1()) {
                new DefaultTreeNode(cn, nivel01);
            }

        }
        /*
         TreeNode documents = new DefaultTreeNode(new Cuenta(1), root);
         TreeNode pictures = new DefaultTreeNode(new Cuenta(2), root);
         TreeNode movies = new DefaultTreeNode(new Cuenta(3), root);
         
         TreeNode work = new DefaultTreeNode(new Cuenta(4), documents);
         TreeNode primefaces = new DefaultTreeNode(new Cuenta(5), documents);
         
         //Documents
         TreeNode expenses = new DefaultTreeNode("document",new Cuenta(6), work);
         TreeNode resume = new DefaultTreeNode("document", new Cuenta(7), work);
         TreeNode refdoc = new DefaultTreeNode("document", new Cuenta(8), primefaces);
         
         //Pictures
         TreeNode barca = new DefaultTreeNode("picture", new Cuenta(9), pictures);
         TreeNode primelogo = new DefaultTreeNode("picture", new Cuenta(10), pictures);
         TreeNode optimus = new DefaultTreeNode("picture", new Cuenta(11), pictures);
         
         //Movies
         TreeNode pacino = new DefaultTreeNode( new Cuenta(12), movies);
         TreeNode deniro = new DefaultTreeNode(new Cuenta(13), movies);
         
         TreeNode scarface = new DefaultTreeNode("mp3", new Cuenta(14), pacino);
         TreeNode carlitosWay = new DefaultTreeNode("mp3",new Cuenta(15), pacino);
         
         TreeNode goodfellas = new DefaultTreeNode("mp3", new Cuenta(16), deniro);
         TreeNode untouchables = new DefaultTreeNode("mp3",new Cuenta(17), deniro);
         */

        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public Cuenta getObjeto() {
        return objeto;
    }

    public void setObjeto(Cuenta objeto) {
        this.objeto = objeto;
    }

    public Cuenta getObjetoSeleccionado() {
        return objetoSeleccionado;
    }

    public void setObjetoSeleccionado(Cuenta objetoSeleccionado) {
        this.objetoSeleccionado = objetoSeleccionado;
    }

    public List<Cuenta> getLista() {
        return lista;
    }

    public List<Cuenta> getListaNivel02() {
        lista = new LinkedList<>();
        try {
            lista = cuentaFacade.Cuenta_listaNivel(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void setLista(List<Cuenta> lista) {
        this.lista = lista;
    }

    public Cuenta getObjeto(int id) {
        Cuenta objetoBuscar = new Cuenta(id);
        return cuentaFacade.find(objetoBuscar.getPkId());
    }

    public List<Cuenta> filtrado(String consulta) {
        System.out.println(" entramos a filtrar con : " + consulta);
        List<Cuenta> resultadoCuenta = new LinkedList<>();

        try {
            for (Cuenta c : cuentaFacade.Cuenta_lista_consulta(consulta)) {
                resultadoCuenta.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultadoCuenta;
    }

    public void onItemSelect(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
    }
}
