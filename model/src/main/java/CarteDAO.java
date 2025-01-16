import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarteDAO {
    public boolean addCarte(Carte carte) {
        String sql = "INSERT INTO carte(denumire, autor, editura, domeniul, an_aparitie) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, carte.getDenumire());
            preparedStatement.setString(2, carte.getAutor());
            preparedStatement.setString(3, carte.getEditura());
            preparedStatement.setString(4, carte.getDomeniul());
            preparedStatement.setInt(5, carte.getAn_aparitie());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<Carte> showBooks() {
        List<Carte> carti = new ArrayList<>();
        String sql = "SELECT * FROM carte";
        try(Connection conn = DataBaseConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql) ){

            while (resultSet.next()) {
                Carte carte =new Carte(
                        resultSet.getInt("id_carte"),
                        resultSet.getString("denumire"),
                        resultSet.getString("autor"),
                        resultSet.getString("editura"),
                        resultSet.getString("domeniul"),
                        resultSet.getInt("an_aparitie")
                );
                carti.add(carte);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return carti;
    }

    public void updateBooks(Carte carte) {
        String sql = "UPDATE carte SET denumire = ?, autor = ?, editura = ?, domeniul = ?, an_aparitie = ? WHERE id_carte = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1,carte.getDenumire());
            preparedStatement.setString(2,carte.getAutor());
            preparedStatement.setString(3,carte.getEditura());
            preparedStatement.setString(4,carte.getDomeniul());
            preparedStatement.setInt(5, carte.getAn_aparitie());
            preparedStatement.setInt(6, carte.getId_carte());
            preparedStatement.executeUpdate();

            System.out.println("Carte actualizata cu succes.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int id) {
        String sql = "DELETE FROM carte WHERE id_carte = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Carte ștearsa cu succes.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
