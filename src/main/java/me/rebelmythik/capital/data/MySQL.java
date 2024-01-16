package me.rebelmythik.capital.data;

import co.aikar.idb.DB;
import co.aikar.idb.Database;
import co.aikar.idb.DatabaseOptions;
import co.aikar.idb.PooledDatabaseOptions;
import me.rebelmythik.capital.Capital;
import org.bukkit.entity.Player;

import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class MySQL implements me.rebelmythik.capital.data.Database {
    private Capital plugin;

    public MySQL(Capital plugin) {
        this.plugin = plugin;

        connect();
        register();
    }

    public void connect() {
        co.aikar.idb.Database databaseManager = PooledDatabaseOptions
                .builder()
                .options(
                        DatabaseOptions
                                .builder()
                                .mysql(
                                        plugin.getConfig().getString("MySQL.username", "root"),
                                        plugin.getConfig().getString("MySQL.password", ""),
                                        plugin.getConfig().getString("MySQL.database", "capital"),
                                        plugin.getConfig().getString("MySQL.host", "localhost:3306")
                                )
                                .build()
                ).createHikariDatabase();

        DB.setGlobalDatabase(databaseManager);

    }

    public void register() {

        try {

            // Table for normal info
            DB.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS capital_account ("
                    + "uuid VARCHAR(36) PRIMARY KEY,"
                    + "username VARCHAR(255) NOT NULL,"
                    + "balance DECIMAL(18, 2) NOT NULL"
            );

            // Table for Logs
            DB.executeUpdate("CREATE TABLE IF NOT EXISTS capital_logs ("
                    + "log_id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "uuid CARCHAR(36),"
                    + "username VARCHAR(255) NOT NULL,"
                    + "log_text TEXT,"
                    + "log_date DATE,"
                    + "FOREIGN KEY (uuid) REFERENCES player_account(uuid))"
            );

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public String getBalance(Player player) {
        return getBalance(player.getUniqueId());
    }


    // Not Done
    public String getBalance(UUID uniqueId) {
        return null;
    }

}
