package com.waw.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
*
* * Kafka Consumer 로 전달 받을 가게 데이터 (Meta Data)
*
*  */
@Entity(name = "TB_KF_STORE")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {

    @Id
    private Long idx;

    @OneToMany(mappedBy = "store")
    private List<StoreProduct> StoreProducts = new ArrayList<>();

    private String storeName;
    private String phoneNumber;
}
