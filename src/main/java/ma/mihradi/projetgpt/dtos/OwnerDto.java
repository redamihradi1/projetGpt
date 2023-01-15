package ma.mihradi.projetgpt.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class OwnerDto {
        private String fullName;
        private String email;
        private String password;
        private String address;
        private String phoneNumber;
}
