package isiunison.space.bd.pantallas;

import isiunison.space.bd.CRUD.EditarUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarUsuario extends JFrame implements ActionListener {
    private JButton bVolver,bGuardar,bBuscar;
    private JLabel lModificar,lViejo,lNuevo,lVUsuario,lVPassword,lVPermisos,lNUsuario,lNPassword,lNPermisos,lPedir,lPedirUsuario,lPedirPassword;
    private JTextField tModificar,tVUsuario,tVPermisos,tNUsuario,tNPassword;
    private static JTextField tPedirUsuario;
    private JPasswordField tVPassword;
    private static JPasswordField tPedirPassword;
    private JComboBox cNPermisos;
    private Font fuente1,fuente2;
    private JPanel pModificar;
    private static String nPermisos,clase;
    private static String[] datos = new String[3];

    public static void setDatos(String[] datos) {
        ModificarUsuario.datos = datos;
    }

    public static void setnPermisos(String nPermisos) {
        ModificarUsuario.nPermisos = nPermisos;
    }

    public static void setClase(String clase) {
        ModificarUsuario.clase = clase;
    }

    public ModificarUsuario(){
        setLayout(new BorderLayout());
        setTitle("Modificar Usuario");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(680, 820);
        setLocationRelativeTo(null);
        setResizable(false);

        fuente1=new Font("Arabella",Font.ITALIC,24);

        bVolver =new JButton("Volver");
        bVolver.setFont(fuente1);
        bVolver.setBounds(275,10,110,30);
        bVolver.addActionListener(this);
        add(bVolver);

        fuente2=new Font("Verdana",Font.ITALIC,16);

        pModificar =new JPanel();
        pModificar.setLayout(null);
        add(pModificar,BorderLayout.CENTER);

        lModificar =new JLabel("Inserte el usuario a modificar:");
        lModificar.setFont(fuente2);
        lModificar.setBounds(90,70,250,20);
        pModificar.add(lModificar);

        tModificar =new JTextField();
        setBusqueda();
        tModificar.setFont(fuente2);
        tModificar.setBounds(350,67,220,30);
        pModificar.add(tModificar);

        bBuscar=new JButton("Buscar");
        bBuscar.setFont(fuente2);
        bBuscar.setBounds(280,125,100,25);
        bBuscar.addActionListener(this);
        pModificar.add(bBuscar);

        lViejo =new JLabel("Viejo Usuario");
        lViejo.setFont(fuente2);
        lViejo.setBounds(120,180,150,20);
        pModificar.add(lViejo);

        lVUsuario =new JLabel("Viejo correo");
        lVUsuario.setFont(fuente2);
        lVUsuario.setBounds(125,240,200,20);
        pModificar.add(lVUsuario);

        tVUsuario =new JTextField();
        tVUsuario.disable();
        tVUsuario.setFont(fuente2);
        tVUsuario.setBounds(70,290,220,30);
        pModificar.add(tVUsuario);

        lVPassword =new JLabel("Vieja contraseña");
        lVPassword.setFont(fuente2);
        lVPassword.setBounds(110,350,210,20);
        pModificar.add(lVPassword);

        tVPassword =new JPasswordField();
        tVPassword.disable();
        tVPassword.setFont(fuente2);
        tVPassword.setBounds(70,400,220,30);
        pModificar.add(tVPassword);

        lVPermisos =new JLabel("Viejos permisos");
        lVPermisos.setFont(fuente2);
        lVPermisos.setBounds(115,460,210,20);
        pModificar.add(lVPermisos);

        tVPermisos =new JTextField();
        tVPermisos.disable();
        tVPermisos.setFont(fuente2);
        tVPermisos.setBounds(70,510,220,30);
        pModificar.add(tVPermisos);

        lNuevo=new JLabel("Nuevo Usuario");
        lNuevo.setFont(fuente2);
        lNuevo.setBounds(420,180,150,20);
        pModificar.add(lNuevo);

        lNUsuario=new JLabel("Inserte nuevo usuario");
        lNUsuario.setFont(fuente2);
        lNUsuario.setBounds(395,240,200,20);
        pModificar.add(lNUsuario);

        tNUsuario=new JTextField();
        tNUsuario.setFont(fuente2);
        tNUsuario.setBounds(370,290,220,30);
        pModificar.add(tNUsuario);

        lNPassword=new JLabel("Inserte nueva contraseña");
        lNPassword.setFont(fuente2);
        lNPassword.setBounds(375,350,210,20);
        pModificar.add(lNPassword);

        tNPassword=new JTextField();
        tNPassword.setFont(fuente2);
        tNPassword.setBounds(370,400,220,30);
        pModificar.add(tNPassword);

        lNPermisos=new JLabel("Seleccione los permisos");
        lNPermisos.setFont(fuente2);
        lNPermisos.setBounds(380,460,210,20);
        pModificar.add(lNPermisos);

        cNPermisos=new JComboBox<>();
        cNPermisos.setFont(fuente2);
        cNPermisos.setBounds(400,510,150,30);
        setCNPermisos();
        cNPermisos.setSelectedItem(null);
        cNPermisos.addActionListener(this);
        pModificar.add(cNPermisos);

        lPedir=new JLabel("Ingrese sus datos");
        lPedir.setFont(fuente2);
        lPedir.setBounds(265,570,210,20);
        pModificar.add(lPedir);

        lPedirUsuario=new JLabel("Usuario:");
        lPedirUsuario.setFont(fuente2);
        lPedirUsuario.setBounds(187,625,70,20);
        pModificar.add(lPedirUsuario);

        tPedirUsuario=new JTextField();
        tPedirUsuario.setFont(fuente2);
        tPedirUsuario.setBounds(267,623,220,30);
        pModificar.add(tPedirUsuario);

        lPedirPassword=new JLabel("Password:");
        lPedirPassword.setFont(fuente2);
        lPedirPassword.setBounds(182,675,85,20);
        pModificar.add(lPedirPassword);

        tPedirPassword=new JPasswordField();
        tPedirPassword.setFont(fuente2);
        tPedirPassword.setBounds(277,673,220,30);
        pModificar.add(tPedirPassword);

        bGuardar =new JButton("Guardar");
        bGuardar.setFont(fuente2);
        bGuardar.setBounds(280,730,100,25);
        bGuardar.addActionListener(this);
        pModificar.add(bGuardar);

        setVisible(true);
    }
    private void setCNPermisos(){
        switch (Login.getPermisos()){
            case "administrador":
                cNPermisos.addItem("usuario");
                cNPermisos.addItem("manager");
                break;
            case "manager":
                cNPermisos.addItem("usuario");
                break;
            case "usuario":
                cNPermisos.addItem("usuario");
                break;
        }
    }

    private void setBusqueda(){
        String permiso="usuario";
        if(Login.getPermisos().hashCode()==permiso.hashCode()){
            tModificar.setText(Login.getUsuario());
            tModificar.disable();
        }
    }

    private static boolean verificarUsuarios(){
        int usuarioEscrito=tPedirUsuario.getText().hashCode();
        int passwordEscrito=String.valueOf(tPedirPassword.getPassword()).hashCode();
        if((!(usuarioEscrito==0)) || (!(passwordEscrito==0))){
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"Por favor ingrese datos");
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== bVolver){
            switch (clase){
                case "class isiunison.space.bd.pantallas.Administrador":
                    dispose();
                    Administrador a=new Administrador();
                    break;
                case "class isiunison.space.bd.pantallas.Manager":
                    dispose();
                    Manager m=new Manager();
                    break;
                case "class isiunison.space.bd.pantallas.Usuario":
                    dispose();
                    Usuario u=new Usuario();
                    break;
            }
        }
        if(e.getSource()==bBuscar){
            if(!(tModificar.getText().hashCode()==0)){
                EditarUsuarios.getDatos(tModificar.getText());
                try {
                    switch (clase){
                        case "class isiunison.space.bd.pantallas.Administrador":
                            if(datos[2].hashCode()=="administrador".hashCode()){
                                JOptionPane.showMessageDialog(null,"No cuenta con los permisos para modificar los datos a este usuario");
                            } else {
                                tVUsuario.setText(datos[0]);
                                tVPassword.setText(datos[1]);
                                tVPermisos.setText(datos[2]);
                            }
                            break;
                        case "class isiunison.space.bd.pantallas.Manager":
                            if(datos[2].hashCode()=="administrador".hashCode() || datos[2].hashCode()=="manager".hashCode()){
                                JOptionPane.showMessageDialog(null,"No cuenta con los permisos para modificar los datos a este usuario");
                            } else {
                                tVUsuario.setText(datos[0]);
                                tVPassword.setText(datos[1]);
                                tVPermisos.setText(datos[2]);
                            }
                            break;
                        case "class isiunison.space.bd.pantallas.Usuario":
                            tVUsuario.setText(datos[0]);
                            tVPassword.setText(datos[1]);
                            tVPermisos.setText(datos[2]);
                            break;
                    }
                } catch (Exception ignored) {
                }
            } else {
                JOptionPane.showMessageDialog(null,"Introduzca un usuario");
            }
        }
        if(e.getSource()==cNPermisos){
            setnPermisos((String)cNPermisos.getSelectedItem());
        }
        if(e.getSource()==bGuardar){
            if(verificarUsuarios()==true){
                EditarUsuarios.editarUsuario(tNUsuario.getText(),tNPassword.getText(),(String)cNPermisos.getSelectedItem(),datos[0]);
            } else {
                JOptionPane.showMessageDialog(null,"Por favor revise que sus datos sean correctos");
            }
        }
    }
}