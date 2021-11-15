
package DAO;

import static Conexion.Conexion.close;
import static Conexion.Conexion.getConnection;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HabitacionDAOImpl implements IHabitacionDAO{

    private Connection conexionTransaccional;
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    
    @Override
    public List<String> obtenerTiposDeHabitaciones() throws SQLException{
        List<String> tiposHabitaciones = new ArrayList <>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT nombre FROM tipodehabitacion");
            rs = stmt.executeQuery();
            while(rs.next()){
                tiposHabitaciones.add(rs.getString("nombre"));
            }
        } finally{
            try {
                close(stmt);
                close(rs);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return tiposHabitaciones;
    }

    @Override
    public int obtenerIdTipoHabitacion(String tipoHabitacion) throws SQLException{
        int id = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT id FROM tipodehabitacion WHERE nombre = ?");
            stmt.setString(1,tipoHabitacion);
            rs = stmt.executeQuery();
            while(rs.next())
                id = rs.getInt("id");
        } finally{
            try {
                close(stmt);
                close(rs);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return id;
    }
    
    @Override
    public Map <Integer ,String> obtenerHabitaciones(int idTipoHabitacion) throws SQLException{
        Map <Integer, String> habitaciones = new HashMap<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT id, nro FROM habitacion WHERE idTipoHabitacion = ? ");
            stmt.setInt(1,idTipoHabitacion);
            rs = stmt.executeQuery();
            while(rs.next()){
                habitaciones.put(rs.getInt("id"), rs.getString("nro"));
            }
            
        } finally{
            try {
                close(stmt);
                close(rs);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return habitaciones;
    }
}