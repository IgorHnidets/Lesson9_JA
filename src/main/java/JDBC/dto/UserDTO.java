package JDBC.dto;

import JDBC.entiti.User;
import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstname();
        this.lastName = user.getLastname();
        this.email = user.getEmail();
    }
}
