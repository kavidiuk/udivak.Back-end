/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capstone.udivak.security.model;

/**
 *
 * @author eddie
 */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder//?
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    private String username;
    
    private String password;
}
