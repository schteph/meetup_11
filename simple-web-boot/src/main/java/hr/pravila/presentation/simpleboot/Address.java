package hr.pravila.presentation.simpleboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author stjep
 */
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
@Entity
@Table(name = "ADDRESS")
public class Address {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CITY")
    @NotNull
    @Size(min = 1, max = 20)
    private String city;

    @Column(name = "ZIP_CODE")
    @Size(min = 1, max = 10)
    private String zipCode;
    
    @Column(name = "STREET_NAME")
    @Size(min = 1, max = 20)
    private String streetName;
    
    @Column(name = "STREET_NUMBER")
    @Size(min = 1, max = 20)
    private String streetNumber;
}
