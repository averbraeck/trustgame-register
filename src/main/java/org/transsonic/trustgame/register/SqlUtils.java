package org.transsonic.trustgame.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.transsonic.trustgame.data.trustgame.Tables;
import org.transsonic.trustgame.data.trustgame.tables.records.GameRecord;
import org.transsonic.trustgame.data.trustgame.tables.records.GameplayRecord;
import org.transsonic.trustgame.data.trustgame.tables.records.MissionRecord;
import org.transsonic.trustgame.data.trustgame.tables.records.UserRecord;

public final class SqlUtils {

    private SqlUtils() {
        // utility class
    }

    public static Connection dbConnection() throws SQLException, ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3306/trustgame";
        String dbUser = "trustgame";
        String dbPassword = "TG%s1naval%2105";

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    }

    public static GameplayRecord readGamePlayFromGamePlayId(final RegisterData data, final Integer gamePlayId) {
        DSLContext dslContext = DSL.using(data.getDataSource(), SQLDialect.MYSQL);
        return dslContext.selectFrom(Tables.GAMEPLAY).where(Tables.GAMEPLAY.ID.eq(gamePlayId)).fetchAny();
    }

    public static UserRecord readUserFromUserId(final RegisterData data, final Integer userId) {
        DSLContext dslContext = DSL.using(data.getDataSource(), SQLDialect.MYSQL);
        return dslContext.selectFrom(Tables.USER).where(Tables.USER.ID.eq(userId)).fetchAny();
    }

    public static MissionRecord readMissionFromGameId(final RegisterData data, final Integer gameId) {
        DSLContext dslContext = DSL.using(data.getDataSource(), SQLDialect.MYSQL);
        return dslContext.selectFrom(Tables.MISSION).where(Tables.MISSION.GAME_ID.eq(gameId)).fetchAny();
    }

    public static GameRecord readGameFromGameId(final RegisterData data, final Integer gameId) {
        DSLContext dslContext = DSL.using(data.getDataSource(), SQLDialect.MYSQL);
        return dslContext.selectFrom(Tables.GAME).where(Tables.GAME.ID.eq(gameId)).fetchAny();
    }

}
