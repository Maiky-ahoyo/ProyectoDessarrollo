package isiunison.space.bd.pantallas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static isiunison.space.bd.CRUD.LoginDatos.consultarUsuario;

public class Login extends JFrame implements ActionListener{
    private JButton boton1,boton2;
    private JLabel titulo,lPassword,lUsuario;
    private JTextField tUsuario;
    private JPasswordField tPassword;
    private Font fuente;
    private static String usuario,password,permisos;

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        Login.usuario = usuario;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Login.password = password;
    }

    public static String getPermisos() {
        return permisos;
    }

    public static void setPermisos(String permisos) {
        Login.permisos = permisos;
    }

    public Login() {
        setLayout(null);
        setTitle("Login");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 240);
        setLocationRelativeTo(null);
        setResizable(false);

        fuente=new Font("Arabella",Font.ITALIC,24);

        titulo=new JLabel("Inicio de Sesión");
        titulo.setFont(fuente);
        titulo.setBounds(115,30,215,20);
        add(titulo);

        lUsuario =new JLabel("Usuario:");
        lUsuario.setBounds(95,60,50,20);
        add(lUsuario);

        tUsuario =new JTextField();
        tUsuario.setBounds(155,60,150,20);
        add(tUsuario);

        lPassword=new JLabel("Contraseña:");
        lPassword.setBounds(85,90,80,20);
        add(lPassword);

        tPassword=new JPasswordField();
        tPassword.setBounds(165,90,150,20);
        add(tPassword);

        boton1=new JButton("Iniciar Sesión");
        boton1.setBounds(142,120,115,20);
        boton1.addActionListener(this);
        add(boton1);

        boton2=new JButton("Registrarse");
        boton2.setBounds(142,150,115,20);
        boton2.addActionListener(this);
        add(boton2);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1){
            setPermisos(null);
            consultarUsuario(tUsuario.getText(),String.valueOf(tPassword.getPassword()));
            if(!(permisos==null)){
                setUsuario(tUsuario.getText());
                setPassword(String.valueOf(tPassword.getPassword()));
                switch (permisos){
                    case "usuario":
                        dispose();
                        Usuario u=new Usuario();
                        break;
                    case "manager":
                        dispose();
                        Manager m=new Manager();
                        break;
                    case "administrador":
                        dispose();
                        Administrador a=new Administrador();
                        break;
                    default:
                        break;
                }
            }
        }
        if(e.getSource()==boton2){
            dispose();
            Registro r=new Registro();
        }
    }
}
