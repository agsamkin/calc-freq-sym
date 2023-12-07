package home.ags.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@AutoConfigureMockMvc
@SpringBootTest
public class CalculationFrequencySymbolsControllerTest {
    private static final String FREQUENCY_URL_PATH = "/frequency";
    private static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));


    @Autowired
    private MockMvc mockMvc;

    @Test
    void inputStringNotShouldBeEmpty() throws Exception {
        final String text0 = "{\"text\": \"\"}";
        String response = mockMvc.perform(
                post(FREQUENCY_URL_PATH)
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(text0))
                .andReturn()
                .getResponse().getContentAsString();
        assertThat(response, containsString("Text size should be between 1 and 300"));
    }

    @Test
    void inputStringMustBeLessThan300() throws Exception {
        final String text301 = "{\"text\": \"" +
                "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeee" +
                "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeee" +
                "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeee" +
                "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeee" +
                "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeee" +
                "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeef" +
                "\"}";
        String response = mockMvc.perform(
                        post(FREQUENCY_URL_PATH)
                                .contentType(APPLICATION_JSON_UTF8)
                                .content(text301))
                .andReturn()
                .getResponse().getContentAsString();
        assertThat(response, containsString("Text size should be between 1 and 300"));
    }

    @Test
    void testNormalInputString1() throws Exception {
        final String text = "{\"text\": \"abb\"}";
        String response = mockMvc.perform(
                        post(FREQUENCY_URL_PATH)
                                .contentType(APPLICATION_JSON_UTF8)
                                .content(text))
                .andReturn()
                .getResponse().getContentAsString();
        assertThat(response, containsString("\"b\": 2, \"a\": 1"));
    }

    @Test
    void testNormalInputString2() throws Exception {
        final String text = "{\"text\": \"aab\"}";
        String response = mockMvc.perform(
                        post(FREQUENCY_URL_PATH)
                                .contentType(APPLICATION_JSON_UTF8)
                                .content(text))
                .andReturn()
                .getResponse().getContentAsString();
        assertThat(response, containsString("\"a\": 2, \"b\": 1"));
    }

    @Test
    void testNormalInputString3() throws Exception {
        final String text = "{\"text\": \"122333\"}";
        String response = mockMvc.perform(
                        post(FREQUENCY_URL_PATH)
                                .contentType(APPLICATION_JSON_UTF8)
                                .content(text))
                .andReturn()
                .getResponse().getContentAsString();
        assertThat(response, containsString("\"3\": 3, \"2\": 2, \"1\": 1"));
    }

    @Test
    void testNormalInputString4() throws Exception {
        final String text = "{\"text\": \"a22\"}";
        String response = mockMvc.perform(
                        post(FREQUENCY_URL_PATH)
                                .contentType(APPLICATION_JSON_UTF8)
                                .content(text))
                .andReturn()
                .getResponse().getContentAsString();
        assertThat(response, containsString("\"2\": 2, \"a\": 1"));
    }
}
