package net.sovliv.jsontestapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Company {
    @Column(name = "company_name")
    private String name;
    private String catchPhrase;
    private String bs;
}
