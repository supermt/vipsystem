package edu.uestc.msstudio.edu.uestc.msstudio.vipsystem.model;

import javax.persistence.*;

/**
 * Created by MT on 2017/5/3.
 */
@Entity
@Table(name = "user")
public class Userinfo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private VIPRank rank;

    private Long balance;

    private Long totalCount;

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

    public VIPRank getRank() {
        return rank;
    }

    public void setRank(VIPRank rank) {
        this.rank = rank;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

}
