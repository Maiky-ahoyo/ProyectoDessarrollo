package isiunison.space.bd.pantallas;

import isiunison.space.bd.CRUD.AgregarUsuarios;
import isiunison.space.bd.CRUD.EliminarUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static isiunison.space.bd.pantallas.Login.getPassword;

public class Administrador extends JFrame implements ActionListener {
    private JButton bLogin,bSalir,bAgregar,bEliminar,bModificar;
    private JLabel lNuevo,lEliminar,lNUsuario,lNPassword,lNPermisos,lEUsuario,lEPassword,lEPermisos;
    private JTextField tNUsuario,tNPassword,tEUsuario;
    private static JPasswordField tEPassword;
    private JComboBox cNPermisos,cEPermisos;
    private Font fuente1,fuente2;
    private JPanel pAdministrador;
    public String nPermisos,ePermisos;
    private String[] opciones={"Si","No"};

    public void setnPermisos(String nPermisos) {
        this.nPermisos = nPermisos;
    }

    public void setePermisos(String ePermisos) {
        this.ePermisos = ePermisos;
    }

    public Administrador() {
        setLayout(new BorderLayout());
        setTitle("Administrador");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        fuente1=new Font("Arabella",Font.ITALIC,24);

        bLogin=new JButton("Login");
        bLogin.setFont(fuente1);
        bLogin.setBounds(10,10,100,30);
        bLogin.addActionListener(this);
        add(bLogin);

        bModificar=new JButton("Modificar");
        bModificar.setFont(fuente1);
        bModificar.setBounds(325,10,150,30);
        bModificar.addActionListener(this);
        add(bModificar);

        bSalir=new JButton("Salir");
        bSalir.setFont(fuente1);
        bSalir.setBounds(685,10,90,30);
        bSalir.addActionListener(this);
        add(bSalir);

        fuente2=new Font("Verdana",Font.ITALIC,16);

        pAdministrador=new JPanel();
        pAdministrador.setLayout(null);
        add(pAdministrador,BorderLayout.CENTER);

        lNuevo=new JLabel("Nuevo Usuario");
        lNuevo.setFont(fuente2);
        lNuevo.setBounds(120,70,150,20);
        pAdministrador.add(lNuevo);

        lNUsuario=new JLabel("Inserte nuevo usuario");
        lNUsuario.setFont(fuente2);
        lNUsuario.setBounds(95,130,200,20);
        pAdministrador.add(lNUsuario);

        tNUsuario=new JTextField();
        tNUsuario.setFont(fuente2);
        tNUsuario.setBounds(70,180,220,30);
        pAdministrador.add(tNUsuario);

        lNPassword=new JLabel("Inserte nueva contraseña");
        lNPassword.setFont(fuente2);
        lNPassword.setBounds(75,240,210,20);
        pAdministrador.add(lNPassword);

        tNPassword=new JTextField();
        tNPassword.setFont(fuente2);
        tNPassword.setBounds(70,290,220,30);
        pAdministrador.add(tNPassword);

        lNPermisos=new JLabel("Seleccione los permisos");
        lNPermisos.setFont(fuente2);
        lNPermisos.setBounds(80,350,210,20);
        pAdministrador.add(lNPermisos);

        cNPermisos=new JComboBox<>();
        cNPermisos.setFont(fuente2);
        cNPermisos.setBounds(100,395,150,30);
        cNPermisos.addItem("usuario");
        cNPermisos.addItem("manager");
        cNPermisos.setSelectedItem(null);
        cNPermisos.addActionListener(this);
        pAdministrador.add(cNPermisos);

        bAgregar=new JButton("Agregar");
        bAgregar.setFont(fuente2);
        bAgregar.setBounds(120,450,100,25);
        bAgregar.addActionListener(this);
        pAdministrador.add(bAgregar);

        lEliminar=new JLabel("Eliminar Usuario");
        lEliminar.setFont(fuente2);
        lEliminar.setBounds(470,70,200,20);
        pAdministrador.add(lEliminar);

        lEUsuario=new JLabel("Inserte usuario a eliminar");
        lEUsuario.setFont(fuente2);
        lEUsuario.setBounds(435,130,400,20);
        pAdministrador.add(lEUsuario);

        tEUsuario=new JTextField();
        tEUsuario.setFont(fuente2);
        tEUsuario.setBounds(430,190,220,30);
        pAdministrador.add(tEUsuario);

        lEPassword=new JLabel("Inserte la contraseña del administrador");
        lEPassword.setFont(fuente2);
        lEPassword.setBounds(385,240,500,20);
        pAdministrador.add(lEPassword);

        tEPassword=new JPasswordField();
        tEPassword.setFont(fuente2);
        tEPassword.setBounds(430,290,220,30);
        pAdministrador.add(tEPassword);

        lEPermisos=new JLabel("Inserte los permisos del usuario a eliminar");
        lEPermisos.setFont(fuente2);
        lEPermisos.setBounds(370,350,500,20);
        pAdministrador.add(lEPermisos);

        cEPermisos=new JComboBox<>();
        cEPermisos.setFont(fuente2);
        cEPermisos.setBounds(465,395,150,30);
        cEPermisos.addItem("usuario");
        cEPermisos.addItem("manager");
        cEPermisos.setSelectedItem(null);
        cEPermisos.addActionListener(this);
        pAdministrador.add(cEPermisos);

        bEliminar=new JButton("Eliminar");
        bEliminar.setFont(fuente2);
        bEliminar.setBounds(485,450,105,25);
        bEliminar.addActionListener(this);
        pAdministrador.add(bEliminar);

        setVisible(true);
    }

    private static boolean compararPassword(){
        int passwordObtenido=getPassword().hashCode();
        int passwordEscrito=String.valueOf(tEPassword.getPassword()).hashCode();
        if(passwordObtenido==passwordEscrito){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bLogin){
            dispose();
            Login l=new Login();
        }
        if(e.getSource()==bSalir){
            System.exit(0);
        }
        if(e.getSource()==bModificar){
            ModificarUsuario.setClase(String.valueOf(getClass()));
            dispose();
            ModificarUsuario mu=new ModificarUsuario();
        }
        if(e.getSource()==cNPermisos){
            setnPermisos((String)cNPermisos.getSelectedItem());
        }
        if(e.getSource()==cEPermisos){
            setePermisos((String)cEPermisos.getSelectedItem());
        }
        if(e.getSource()==bAgregar){
            if(!(nPermisos==null)){
                AgregarUsuarios a=new AgregarUsuarios();
                a.registroUsuario(tNUsuario.getText(),tNPassword.getText(),nPermisos);
            } else {
                JOptionPane.showMessageDialog(null,"Seleccione los permisos del usuario");
            }
        }
        if(e.getSource()==bEliminar){
            if(!(cEPermisos.getSelectedItem()==null)){
                if(compararPassword()==true){
                    int opcion=JOptionPane.showOptionDialog(null,"¿Seguro que quieres eliminar este usuario?","Eliminar usuario",0,2,null,opciones,null);
                    if(opcion==0){
                        EliminarUsuarios eu=new EliminarUsuarios();
                        eu.eliminarUsuario(tEUsuario.getText(),ePermisos);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Revise su contraseña");
                }
            } else {
                JOptionPane.showMessageDialog(null,"Por favor, seleccione los permisos");
            }
        }
    }
}
