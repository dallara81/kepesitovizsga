package hu.nive.ujratervezes.kepesitovizsga.jurassic;

// Dr Ian Malcolmnak igaza volt: az élet utat tör.
// A Jurassic Parkban szabályozatlan körülmények között is szaporodnak a dinoszauruszok.
// Hogy fel lehessen mérni a probléma nagyságát, a gondozók összegyűjtötték egy adatbázisba,
// hogy a fajokból mennyi a hivatalos egyedszám, amennyinek lennie kéne,
// és ehhez képest a park kamerái és mozgásérzékelői hányat találtak.

import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class JurassicPark {

    private final DataSource dataSource;

    public JurassicPark(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> checkOverpopulation() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT breed FROM dinosaur WHERE expected < actual ORDER BY breed ASC;"
             )) {
            return getDinosaurs(statement);
        } catch (SQLException se) {
            throw new IllegalStateException("Unfortunately, something is wrong here.", se);
        }
    }

    private List<String> getDinosaurs(PreparedStatement statement) throws SQLException {
        List<String> result = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String name = resultSet.getString("breed");
                result.add(name);
            }
        }
        return result;
    }
}