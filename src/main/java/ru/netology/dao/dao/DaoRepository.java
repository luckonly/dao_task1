package ru.netology.dao.dao;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DaoRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String requestFile = "getProductsByCustomerName.sql";
    private String requestLine = read(requestFile);


    public DaoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<String> productsList(String name) {
        MapSqlParameterSource parameters = new MapSqlParameterSource("name", name);
        return namedParameterJdbcTemplate.queryForList(requestLine, parameters, String.class);
    }

    private static String read(String requestFile) {
        try (InputStream is = new ClassPathResource(requestFile).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
