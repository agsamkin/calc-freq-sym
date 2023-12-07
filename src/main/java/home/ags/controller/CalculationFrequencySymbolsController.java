package home.ags.controller;

import home.ags.dto.InputStringDto;
import home.ags.service.CalculationFrequencySymbolsService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CalculationFrequencySymbolsController {
    private final CalculationFrequencySymbolsService calculateFrequencySymbols;

    @PostMapping(path = "/frequency")
    public String frequency(@RequestBody @Valid InputStringDto input)  {
        return calculateFrequencySymbols.calculateFrequencyOfSymbols(input);
    }
}
