package pro.sky.kutin.recipesapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.kutin.recipesapp.dto.InfoDTO;

import java.time.LocalDate;

@RestController
@RequestMapping("/")
public class InfoController {
    private static final InfoDTO INFO_DTO = new InfoDTO(
            "Алексей Кутин",
            "Приложение для сайта рецептов",
            LocalDate.of(2023, 2, 26),
            "Приложение для управления рецептами приготовления");

    @GetMapping
    public String hello() {
        return "Application is started";
    }

    @GetMapping("/info")
    public InfoDTO info() {
        return INFO_DTO;
//        return "<p>Алексей Кутин</p>" +
//                "<p>Приложение для сайта рецептов</p>" +
//                "<p>Дата создания: 26.02.2023</p>" +
//                "<p>Проект написан на языке Java с использованием фреймворка Spring</p>";
    }
}
