package home.ags.service.impl;

import home.ags.dto.InputStringDto;
import home.ags.service.CalculationFrequencySymbolsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalculationFrequencySymbolsServiceImpl implements CalculationFrequencySymbolsService {

    @Override
    public String calculateFrequencyOfSymbols(InputStringDto input) {
        String text = input.getText();

        Map<Character, Integer> freq = new HashMap<>();
        char[] chars = text.toCharArray();

        for (char ch : chars) {
            int count = freq.getOrDefault(ch, 0);
            freq.put(ch, ++count);
        }

        String output = freq.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer> comparingByValue().reversed())
                .map(e -> "\"" + e.getKey() + "\": " + e.getValue())
                .collect(Collectors.joining(", "));

        return output;
    }

}
