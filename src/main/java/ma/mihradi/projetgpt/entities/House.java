package ma.mihradi.projetgpt.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String address;
    private String city;
    private String zipCode;
    private String country;
    private int numberOfRooms;
    private int numberOfBathrooms;
    private int numberOfBeds;
    private int sizeInSquareMeters;
    private double pricePerNight;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Owner owner;



}
