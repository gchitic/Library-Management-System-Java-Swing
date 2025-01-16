import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReturnareDAO {
    public boolean addReturnare(Returnare returnare) {
        String sql = "INSERT INTO returnare(inchiriere_id, data_return) VALUES(?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            // Conversia `java.util.Date` în `java.sql.Date`
            java.sql.Date sqlDataReturn = new java.sql.Date(returnare.getData_return().getTime());

            preparedStatement.setInt(1, returnare.getInchiriere_id());
            preparedStatement.setDate(2, sqlDataReturn);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Returnare> showReturnari() {
        List<Returnare> returnari = new ArrayList<>();
        String sql = "SELECT r.id_returnare, i.id_inchiriere, i.carte_id, c.denumire||' de '||c.autor as Carte, i.cititor_id, ci.nume||' '||ci.prenume as Cititor, ci.nr_tel, ci.adresa, i.data_inchiriere, i.data_estim_return, r.data_return  " +
                " FROM returnare r inner join inchiriere i on r.inchiriere_id=i.id_inchiriere " +
                "  inner join carte c on i.carte_id=c.id_carte " +
                "  inner join cititor ci on i.cititor_id=id_cititor";

        try(Connection conn = DataBaseConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql) ){

            while (resultSet.next()) {
                Returnare returnare = new Returnare(
                    resultSet.getInt("id_returnare"),
                        resultSet.getInt("id_inchiriere"),
                        resultSet.getDate("data_return"),
                        resultSet.getInt("carte_id"),
                        resultSet.getString("Carte"),
                        resultSet.getInt("cititor_id"),
                        resultSet.getString("Cititor"),
                        resultSet.getString("nr_tel"),
                        resultSet.getString("adresa"),
                        resultSet.getDate("data_inchiriere"),
                        resultSet.getDate("data_estim_return")
                );

                returnari.add(returnare);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return returnari;
    }
}
