package persistence.sql.ddl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import persistence.domain.Person1;
import persistence.domain.Person2;
import persistence.domain.Person3;

import static org.assertj.core.api.Assertions.assertThat;

class QueryBuilderTest {

    @DisplayName("요구사항1, Person create ddl문 생성")
    @Test
    void persion_ddl_create1() {
        final QueryBuilder queryBuilder = new QueryBuilder();
        final Class<?> personClass = Person1.class;
        String expectedDDL = "create table person1 (id bigint not null, age integer, name varchar(255), primary key (id))";

        String actualDDL = queryBuilder.createDdl(personClass);

        assertThat(actualDDL).isEqualTo(expectedDDL);
    }

    @DisplayName("요구사항2, Person create ddl문 생성")
    @Test
    void persion_ddl_create2() {
        final QueryBuilder queryBuilder = new QueryBuilder();
        final Class<?> personClass = Person2.class;
        String expectedDDL = "create table person2 (id bigint generated by default as identity, old integer, email varchar(255) not null, nick_name varchar(255), primary key (id))";

        String actualDDL = queryBuilder.createDdl(personClass);

        assertThat(actualDDL).isEqualTo(expectedDDL);
    }

    @DisplayName("요구사항3, Person create ddl문 생성")
    @Test
    void persion_ddl_create3() {
        final QueryBuilder queryBuilder = new QueryBuilder();
        final Class<?> personClass = Person3.class;
        String expectedDDL = "create table users (id bigint generated by default as identity, old integer, email varchar(255) not null, nick_name varchar(255), primary key (id))";

        String actualDDL = queryBuilder.createDdl(personClass);

        assertThat(actualDDL).isEqualTo(expectedDDL);
    }

    @DisplayName("요구사항4, Person drop ddl문 생성")
    @Test
    void persion_ddl_drop() {
        final QueryBuilder queryBuilder = new QueryBuilder();
        final Class<?> personClass = Person3.class;
        String expectedDDL = "drop table if exists users CASCADE";

        String actualDDL = queryBuilder.dropDdl(personClass);

        assertThat(actualDDL).isEqualTo(expectedDDL);
    }

}