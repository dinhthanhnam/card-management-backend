package com.api.cardmanagementapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "clients")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false, unique = true)
    private String identityNumber;

    @Column
    private LocalDateTime dateOfBirth;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Contract> contracts;

    @Column
    private String reasonCode; // Mã lý do (có thể là lý do mở tài khoản, từ chối, v.v.)

    @Column
    private String reason; // Chi tiết lý do

    @Column
    private String clientTypeCode; // Mã loại khách hàng (Cá nhân, Doanh nghiệp, Đối tác, v.v.)

    @Column
    private String institutionCode; // Mã tổ chức khách hàng thuộc về

    @Column
    private String branch; // Chi nhánh giao dịch của khách hàng

    @Column
    private String clientCategory; // Phân loại khách hàng theo tiêu chí ngân hàng

    @Column
    private String productCategory; // Phân loại khách hàng theo sản phẩm đăng ký

    @Column
    private String companyName; // Nếu khách hàng là doanh nghiệp, đây là tên công ty

    @Column
    private String shortName; // Tên viết tắt của công ty hoặc biệt danh của khách hàng

    @Column
    private String clientNumber;
}
