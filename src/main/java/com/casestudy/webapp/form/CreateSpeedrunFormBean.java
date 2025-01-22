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
public class CreateSpeedrunFormBean {

    private Integer id;

    private Integer userId;

    private Integer speedrunId;

    @NotEmpty(message = "Speedrun time is required.")
    private String speedrunTime;

    private String dateSubmitted;

    private String videoUrl;

    private Integer approved;
}
