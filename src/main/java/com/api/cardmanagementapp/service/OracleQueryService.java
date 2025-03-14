package com.api.cardmanagementapp.service;

import com.api.cardmanagementapp.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OracleQueryService {

    private final JdbcTemplate oracleJdbcTemplate;

    @Autowired
    public OracleQueryService(@Qualifier("oracleJdbcTemplate") JdbcTemplate oracleJdbcTemplate) {
        this.oracleJdbcTemplate = oracleJdbcTemplate;
    }

    public List<Client> getClientData() {
        String sql = "SELECT id, client_number, reg_number FROM client";
        return oracleJdbcTemplate.query(sql, (rs, rowNum) ->
                new Client(
                        rs.getLong("id"),
                        rs.getString("client_number"),
                        rs.getString("reg_number")
                )
        );
    }

    public Client getClientById(Long id) {
        String sql = "SELECT id, client_number, reg_number FROM client WHERE id = ?";
        return oracleJdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Client(
                        rs.getLong("id"),
                        rs.getString("client_number"),
                        rs.getString("reg_number")
                )
        );
    }
}