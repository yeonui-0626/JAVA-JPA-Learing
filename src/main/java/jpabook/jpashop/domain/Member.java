package jpabook.jpashop.domain;

import org.hibernate.type.descriptor.java.LocaleTypeDescriptor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{

    @Id @GeneratedValue
    @Column(name="MEMBER_ID") //MEMBER_ID : DB 칼럼 이름
    private Long id;
    private String name;


    @Embedded
    private Address address;


    @OneToMany(mappedBy = "member") // order 외래키로 지정된 변수명
    private List<Order> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
