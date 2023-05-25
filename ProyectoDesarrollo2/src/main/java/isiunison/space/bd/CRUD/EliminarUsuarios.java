package isiunison.space.bd.CRUD;

import isiunison.space.bd.utilerias.ConectorBD;

import javax.swing.*;
import java.sql.*;

public class EliminarUsuarios {

    private static Connection conexion;
    private static PreparedStatement sentenciaPreparada;

    public void eliminarUsuario(String usuario,String permisos){
        try {
            conexion=ConectorBD.getInstance();
            String consulta="DELETE FROM usuarios WHERE usuario=? && permisos=?";
            sentenciaPreparada=conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1,usuario);
            sentenciaPreparada.setString(2,permisos);
            int i=sentenciaPreparada.executeUpdate();
            if(i>0){
                JOptionPane.showMessageDialog(null,"Usuario eliminado");
            } else {
                JOptionPane.showMessageDialog(null,"El usuario no existe");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al eliminar, revise sus datos");
            System.out.println("Error: "+e);
        }
    }
}
