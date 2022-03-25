package uz.pdp.apelsin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.apelsin.entity.template.AbsNameEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer extends AbsNameEntity {

    @Column(nullable = false)
    private String address;

    private String country;

    @Column(nullable = false)
    private String phone;
}
