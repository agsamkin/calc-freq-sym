package home.ags.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureMockMvc
@SpringBootTest
public class CalculationFrequencySymbolsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void inputStringMustNotBeEmpty() throws Exception {
        final String request = "/calc?&input=";
        String response = mockMvc.perform(get(request)).andReturn()
                .getResponse().getContentAsString();
        assertThat(response, containsString("Input string must not be empty"));
    }

    @Test
    void inputStringCannotBeLongerThan20Characters() throws Exception {
        final String request = "/calc?&input=abbcccddddeeeeeffffff";
        String response = mockMvc.perform(get(request)).andReturn()
                .getResponse().getContentAsString();
        assertThat(response, containsString("Input string cannot be longer than 20 characters"));
    }

    @Test
    void inputStringMustContainOnlyLatinLetters1() throws Exception {
        final String request = "/calc?&input=a1bb";
        String response = mockMvc.perform(get(request)).andReturn()
                .getResponse().getContentAsString();
        assertThat(response, containsString("Input string must contain only latin letters"));
    }

    @Test
    void inputStringMustContainOnlyLatinLetters2() throws Exception {
        final String request = "/calc?&input=a*bb";
        String response = mockMvc.perform(get(request)).andReturn()
                .getResponse().getContentAsString();
        assertThat(response, containsString("Input string must contain only latin letters"));
    }

    @Test
    void inputStringMustContainOnlyLatinLetters3() throws Exception {
        final String request = "/calc?&input=aЙbb";
        String response = mockMvc.perform(get(request)).andReturn()
                .getResponse().getContentAsString();
        assertThat(response, containsString("Input string must contain only latin letters"));
    }

    @Test
    void testNormalInputString1() throws Exception {
        final String request = "/calc?&input=abb";
        String response = mockMvc.perform(get(request)).andReturn()
                .getResponse().getContentAsString();
        assertThat(response, containsString("\"b\": 2, \"a\": 1"));
    }

    @Test
    void testNormalInputString2() throws Exception {
        final String request = "/calc?&input=aab";
        String response = mockMvc.perform(get(request)).andReturn()
                .getResponse().getContentAsString();
        assertThat(response, containsString("\"a\": 2, \"b\": 1"));
    }
}
