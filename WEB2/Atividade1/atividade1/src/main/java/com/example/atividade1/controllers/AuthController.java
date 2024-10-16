package com.example.atividade1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.example.atividade1.models.ProfessorModel;
import com.example.atividade1.models.TokenModel;
import com.example.atividade1.services.ProfessorService;
import com.example.atividade1.services.TokenService;




import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;



/* @Controller
@RequestMapping("/auth")
public class AuthController {

    @Value("${resend.api.key}")
    private String resendApiKey;

    @Value("${resend.api.url}")
    private String resendApiUrl;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private TokenService tokenService;

    private final String RESEND_API_KEY = resendApiKey;
    private final String RESEND_API_URL = resendApiUrl;

    @PostMapping("/login")
    public String login(@RequestParam String email) {
        ProfessorModel professor = professorService.findByEmail(email);
        if (professor != null) {
            // Crear el token y asociarlo al profesor
            TokenModel token = tokenService.createToken(professor);
            String link = "http://localhost:8080/auth/verify?token=" + token.getToken();

            // Preparar y enviar el correo electrónico a través de Resend
            sendEmail(email, "Tu enlace mágico", "Haz clic en el siguiente enlace para iniciar sesión: " + link);
            return "Se ha enviado un enlace mágico a tu correo.";
        }
        return "Email no encontrado.";
    }

    @GetMapping("/verify")
    public String verify(@RequestParam String token) {
        TokenModel validToken = tokenService.validateToken(token);
        if (validToken != null) {
            return "Inicio de sesión exitoso. Bienvenido " + validToken.getProfessor().getNome();
        }
        return "Token inválido o expirado.";
    }

    private void sendEmail(String to, String subject, String body) {
        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + resendApiKey);
        headers.set("Content-Type", "application/json");
    
        String requestBody = String.format(
                "{\"from\":\"noreply@cristopher.paiva.me\",\"to\":\"%s\",\"subject\":\"%s\",\"text\":\"%s\"}",
                to, subject, body
        );
    
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
    
        ResponseEntity<String> response = restTemplate.exchange(
                resendApiUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );
    
        // Manejar la respuesta según sea necesario
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Correo enviado exitosamente.");
        } else {
            System.out.println("Error al enviar el correo: " + response.getBody());
        }
    }
} */


/*@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public String login(@RequestParam String email) {
        ProfessorModel professor = professorService.findByEmail(email);
        if (professor != null) {
            // Crear el token y asociarlo al profesor
            TokenModel token = tokenService.createToken(professor);
            String link = "http://localhost:8080/auth/verify?token=" + token.getToken();

            // Preparar y enviar el correo electrónico
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Tu enlace mágico");
            message.setText("Haz clic en el siguiente enlace para iniciar sesión: " + link);
            mailSender.send(message);
            return "Se ha enviado un enlace mágico a tu correo.";
        }
        return "Email no encontrado.";
    }

    @GetMapping("/verify")
    public String verify(@RequestParam String token) {
        TokenModel validToken = tokenService.validateToken(token);
        if (validToken != null) {
            // Aquí puedes iniciar la sesión del usuario, por ejemplo, generando un JWT o creando una sesión
            return "Inicio de sesión exitoso. Bienvenido " + validToken.getProfessor().getNome();
        }
        return "Token inválido o expirado.";
    }
}*/
