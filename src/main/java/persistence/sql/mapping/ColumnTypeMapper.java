package persistence.sql.mapping;

import java.lang.reflect.Type;
import java.sql.Types;
import java.util.Map;

public class ColumnTypeMapper {

    private static ColumnTypeMapper INSTANCE = null;

    private final Map<Type, Integer> columnTypes = Map.of(
            String.class, Types.VARCHAR,
            Integer.class, Types.INTEGER,
            Long.class, Types.BIGINT);

    private ColumnTypeMapper() {}

    public static synchronized ColumnTypeMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ColumnTypeMapper();
        }

        return INSTANCE;
    }

    public int toSqlType(final Type classType) {
        return columnTypes.getOrDefault(classType, Types.VARCHAR);
    }

}