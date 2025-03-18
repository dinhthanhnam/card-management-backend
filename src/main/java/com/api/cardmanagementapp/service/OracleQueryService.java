package com.api.cardmanagementapp.service;

import com.api.cardmanagementapp.model.Client;
import com.api.cardmanagementapp.model.PagedClientResponse;
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

    public PagedClientResponse getPagedClientData(int page, int size) {
        int offset = page * size;

        // Đếm tổng số bản ghi
        String countSql = "SELECT COUNT(*) FROM client";
        long totalElements = oracleJdbcTemplate.queryForObject(countSql, Long.class);

        // Lấy danh sách phân trang
        String sql = "SELECT id, short_name, client_number, reg_number FROM client " +
                "where AMND_STATE = 'A' " +
                "ORDER BY id DESC " +
                "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY"
                ;
        List<Client> clients = oracleJdbcTemplate.query(
                sql,
                new Object[]{offset, size},
                (rs, rowNum) -> new Client(
                        rs.getLong("id"),
                        rs.getString("short_name"),
                        rs.getString("client_number"),
                        rs.getString("reg_number")
                )
        );

        // Tạo response
        PagedClientResponse response = new PagedClientResponse();
        response.setClients(clients);
        response.setPage(page);
        response.setSize(size);
        response.setTotalElements(totalElements);
        response.setTotalPages((int) Math.ceil((double) totalElements / size));

        return response;
    }

    public Client getClientById(Long id) {
        String sql = "SELECT id, short_name, client_number, reg_number FROM client WHERE id = ?";
        return oracleJdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Client(
                        rs.getLong("id"),
                        rs.getString("short_name"),
                        rs.getString("client_number"),
                        rs.getString("reg_number")
                )
        );
    }
}