package cinema.sql;

import org.postgresql.ds.PGConnectionPoolDataSource;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.text.MessageFormat;

public class DatabaseTools {

    public static DataSource initDataSourcePostgreSQL(
            String host,
            int port,
            String dbname,
            String user,
            String password
    ) {
        var dataSource = new PGSimpleDataSource();
        var url = MessageFormat.format(
                "jdbc:postgresql://{0}:{1,number,#}/{2}",
                host, port, dbname);
        dataSource.setURL(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }
}
