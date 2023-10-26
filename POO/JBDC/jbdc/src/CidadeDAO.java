import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO {
  public List<EstadoCidade> findCidades() {
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rst = null;
    //String sql = "SELECT * FROM	cidade";
    //String sql2 = "SELECT * FROM	cidade WHERE id % 2 = 0";
    String sql3 = "SELECT * FROM	cidade WHERE nome LIKE 'A%'";
    List<EstadoCidade> cidades = new ArrayList<EstadoCidade>();

    try {
      conn = ConnectionFactory.createConnectionToMySQL();
      pstm = conn.prepareStatement(sql3);
      rst = pstm.executeQuery();

      while (rst.next()) {
        EstadoCidade cidade = new EstadoCidade();
        cidade.setId(rst.getInt("id"));
        cidade.setNome(rst.getString("nome"));
        cidade.setEstado(rst.getInt("estado"));
        cidades.add(cidade);

      }

    } catch (SQLException e) {
      e.printStackTrace();
      e.getErrorCode();
    } finally {
      try {
        if (rst != null) {
          rst.close();
        }
        if (pstm != null) {
          pstm.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return cidades;
  }
}
