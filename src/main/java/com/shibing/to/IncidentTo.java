package com.shibing.to;

import com.shibing.util.validation.NoHtml;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Value
@Data
@EqualsAndHashCode(callSuper = true)
public class IncidentTo extends BaseTo{

    @NotBlank
    @Size(min = 2, max = 120)
    @NoHtml
    String description;

    @NotNull
    String title;

    @NotNull
    LocalDate localDate;

    public IncidentTo(Integer id, LocalDate localDate, String description, String title) {
        super(id);
        this.description = description;
        this.title = title;
        this.localDate = localDate;
    }
}
