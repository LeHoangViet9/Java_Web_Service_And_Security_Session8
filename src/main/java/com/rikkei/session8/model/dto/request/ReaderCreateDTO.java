package com.rikkei.session8.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReaderCreateDTO {
//    email (@Email, @NotBlank).
//    fullName (@NotBlank).
//    phoneNumber (@Pattern cho số điện thoại VN).
//    address (@NotBlank).
//    avatarFile:
    @Email(message = "Email is not valid")
    private String email;
    @NotBlank(message = "Name cannot be blank")
    private String fullName;
    @NotBlank(message = "Phone cannot be blank")
    @Pattern(regexp = "^(0|\\+84)[0-9]{9}$")
    private String phone;
    @NotBlank(message = "Address cannot be blank")
    private String address;
    private MultipartFile avatar;
}
