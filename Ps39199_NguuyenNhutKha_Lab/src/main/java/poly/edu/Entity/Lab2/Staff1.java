package poly.edu.Entity.Lab2;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;
import lombok.Builder.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Staff1 {
    private String id;
    private String fullName;

    @Default
    private String photo = "photo.jpg";

    @Default
    private Boolean gender = false;

    @Default
    @DateTimeFormat(
    pattern="MM/dd/yyyy")
    private Date birthday = new Date();

    @Default
    private double salary =12345.6789;

    @Builder.Default
    private Integer level = 0;
}
