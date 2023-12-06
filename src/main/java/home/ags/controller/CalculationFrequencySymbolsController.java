package home.ags.controller;

import home.ags.service.CalculationFrequencySymbolsService;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.RequiredArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequiredArgsConstructor
@RestController
public class CalculationFrequencySymbolsController {
    private final CalculationFrequencySymbolsService calculateFrequencySymbols;

    @GetMapping(path = "/calc")
    public String calc(@RequestParam(name = "input")
                           @NotBlank(message = "Input string must not be empty")
                           @Size(max = 20, message = "Input string cannot be longer than 20 characters")
                           @Pattern(regexp = "[a-zA-Z]+", message = "Input string must contain only latin letters")
                           String input)  {
        return calculateFrequencySymbols.calculateFrequencyOfSymbols(input);
    }
}
