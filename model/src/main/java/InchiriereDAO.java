import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InchiriereDAO {
    public boolean addInchiriere(Inchiriere inchiriere) {
        String sql = "INSERT INTO inchiriere(carte_id, cititor_id, data_inchiriere, data_estim_return) VALUES(?, ?, ?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            // Conversia `java.util.Date` în `java.sql.Date`
            java.sql.Date sqlDataInchiriere = new java.sql.Date(inchiriere.getData_inchiriere().getTime());
            java.sql.Date sqlDataEstimReturn = new java.sql.Date(inchiriere.getData_estim_return().getTime());

            preparedStatement.setInt(1, inchiriere.getCarte_id());
            preparedStatement.setInt(2, inchiriere.getCititor_id());

            preparedStatement.setDate(3, sqlDataInchiriere);
            preparedStatement.setDate(4, sqlDataEstimReturn);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Inchiriere> showinchirieri() {
        List<Inchiriere> inchirieri = new ArrayList<>();
        String sql = "SELECT i.id_inchiriere, i.carte_id, c.denumire||' de '||c.autor as Carte, i.cititor_id, ci.nume||' '||ci.prenume as Cititor, ci.nr_tel, ci.adresa, i.data_inchiriere, i.data_estim_return" +
                " FROM public.inchiriere as i inner join public.carte as c on i.carte_id = c.id_carte " +
                " inner join public.cititor as ci on i.cititor_id = ci.id_cititor;";

        try(Connection conn = DataBaseConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql) ){

            while (resultSet.next()) {
                Inchiriere inchiriere = new Inchiriere(
                        resultSet.getInt("id_inchiriere"),
                        resultSet.getInt("carte_id"),
                        resultSet.getInt("cititor_id"),
                        resultSet.getDate("data_inchiriere"),
                        resultSet.getDate("data_estim_return"),

                        resultSet.getString("Carte"),
                        resultSet.getString("Cititor"),
                        resultSet.getString("nr_tel"),
                        resultSet.getString("adresa")
                );
                inchirieri.add(inchiriere);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return inchirieri;
    }
}
