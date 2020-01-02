package com.example.library.infra;

import com.example.library.domain.lending.ReturnEventRepository;
import com.example.library.infra.dto.ReturnEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class ReturnEventRepositoryImpl implements ReturnEventRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<ReturnEvent> findAll() {
        return Collections.emptyList();
    }

    @Override
    public List<ReturnEvent> find(String isbn, String userId) {
        String sql = "SELECT isbn, user_id, return_date FROM return_event " +
                "where isbn = ? " +
                "AND user_id = ? ";

        PreparedStatementCreatorFactory pscFactory = new PreparedStatementCreatorFactory(sql);
        pscFactory.addParameter(new SqlParameter(Types.VARCHAR));
        pscFactory.addParameter(new SqlParameter(Types.VARCHAR));
        PreparedStatementCreator psc = pscFactory.newPreparedStatementCreator(
                Arrays.asList(isbn, userId)
        );
        BeanPropertyRowMapper<ReturnEvent> rowMapper = new BeanPropertyRowMapper<>(ReturnEvent.class);

        return jdbcTemplate.query(psc, rowMapper);
    }
}
