package com.casestudy.webapp.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class CreateGameFormBean {

    private Integer id;

    @Length(max = 100, message = "Game name must be less than 100 characters.")
    @NotEmpty(message = "Game name is required.")
    private String gameName;

    @Pattern(regexp = "[A-Za-z0-9]+", message = "Game name must contain only letters, numbers, and spaces.")
    @Length(max = 50, message = "Abbreviation must be less than 50 characters.")
    @NotEmpty(message = "Abbreviation is required.")
    private String abbr;

    private MultipartFile upload;

    private Integer approved;

    @Length(max = 2000, message = "First name must be less than 2000 characters.")
    private String ruleset;

    private Integer releaseYear;

}
