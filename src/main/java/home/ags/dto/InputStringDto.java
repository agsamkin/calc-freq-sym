package home.ags.dto;

import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InputStringDto {
    @Size(min = 1, max = 300, message = "Text size should be between 1 and 300")
    private String text;
}
