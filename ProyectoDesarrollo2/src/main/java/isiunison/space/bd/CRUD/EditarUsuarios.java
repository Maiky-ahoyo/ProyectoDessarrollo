package isiunison.space.bd.CRUD;

import isiunison.space.bd.pantallas.ModificarUsuario;
import isiunison.space.bd.utilerias.ConectorBD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditarUsuarios {
    private static Connection conexion;
    private static PreparedStatement sentenciaPreparada;
    private static ResultSet resultado;

    public static void editarUsuario(String usuarioNuevo, String passwordNuevo, String permisosNuevos,String usuario){
        String nPassword= String.valueOf(passwordNuevo.hashCode());
        try {
            conexion= ConectorBD.getInstance();
            String consulta="UPDATE usuarios SET usuario=?,password=?,permisos=? WHERE usuario=?";
            sentenciaPreparada=conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1,usuarioNuevo);
            sentenciaPreparada.setString(2,nPassword);
            sentenciaPreparada.setString(3,permisosNuevos);
            sentenciaPreparada.setString(4,usuario);
            sentenciaPreparada.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos actualizados");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al actualizar datos, intente de nuevo");
            System.out.println("Error: "+e);
        }
    }
    public static void getDatos(String usuario){
        String datos[]=new String[3];
        try {
            conexion=ConectorBD.getInstance();
            String consulta="SELECT * FROM usuarios WHERE usuario=?";
            sentenciaPreparada=conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1,usuario);
            resultado=sentenciaPreparada.executeQuery();
            if(resultado.next()){
                datos[0]=resultado.getString("usuario");
                datos[1]=resultado.getString("password");
                datos[2]=resultado.getString("permisos");
                ModificarUsuario.setDatos(datos);
            } else {
                JOptionPane.showMessageDialog(null,"No existe este usuario");
                ModificarUsuario.setDatos(null);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
    }
}
