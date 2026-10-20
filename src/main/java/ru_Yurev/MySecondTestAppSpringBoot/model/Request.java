package ru_Yurev.MySecondTestAppSpringBoot.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @NotBlank(message = "UID не может быть пустым")
    @Size(max = 32, message = "UID не должен превышать 32 символа")
    private String uid;

    @NotBlank(message = "Operation UID не может быть пустым")
    @Size(max = 32, message = "Operation UID не должен превышать 32 символа")
    private String operationUid;

    private String systemName;

    @NotBlank(message = "System Time не может быть пустым")
    private String systemTime;

    private String source;

    @NotNull(message = "Communication ID не может быть null")
    @Min(value = 1, message = "Communication ID должен быть не меньше 1")
    @Max(value = 100000, message = "Communication ID должен быть не больше 100000")
    private int communicationId;

    private int templateId;

    private int productCode;

    private int smsCode;

}