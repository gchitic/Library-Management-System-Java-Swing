import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CititorDAO {
    public boolean addCititor(Cititor cititor) {
        String sql = "INSERT INTO cititor(nume, prenume, nr_tel, adresa) VALUES(?, ?, ?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, cititor.getNume());
            preparedStatement.setString(2, cititor.getPrenume());
            preparedStatement.setString(3, cititor.getNr_tel());
            preparedStatement.setString(4, cititor.getAdresa());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Cititor> showReaders() {
        List<Cititor> cititori = new ArrayList<>();
        String sql = "SELECT * FROM cititor";
        try(Connection conn = DataBaseConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql) ){

            while (resultSet.next()) {
                Cititor cititor = new Cititor(
                        resultSet.getInt("id_cititor"),
                        resultSet.getString("nume"),
                        resultSet.getString("prenume"),
                        resultSet.getString("nr_tel"),
                        resultSet.getString("adresa")
                );

                cititori.add(cititor);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return cititori;
    }

    public void updateReader(Cititor cititor) {
        String sql = "UPDATE cititor SET nume = ?, prenume = ?, nr_tel = ?, adresa = ? WHERE id_cititor = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, cititor.getNume());
            preparedStatement.setString(2, cititor.getPrenume());
            preparedStatement.setString(3, cititor.getNr_tel());
            preparedStatement.setString(4, cititor.getAdresa());
            preparedStatement.setInt(5, cititor.getId_cititor());
            preparedStatement.executeUpdate();

            System.out.println("Cititor actualizat cu succes.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReader(int id) {
        String sql = "DELETE FROM cititor WHERE id_cititor = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Cititor șters cu succes.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
