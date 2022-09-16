package am.artyshok.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import am.artyshok.model.ReverseRequest;
import am.artyshok.service.StringService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest(controllers = StringController.class)
class StringControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private StringService service;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void givenValidRequest_whenCalled_thenOk() throws Exception {
    final String resultStr = "elpmaxe";
    final String initStr = "example";
    final ReverseRequest request = new ReverseRequest();
    request.setValue(initStr);
    //Expectations
    when(service.reverse(initStr)).thenReturn(resultStr);
    //Run test scenario
    final MvcResult result = mockMvc.perform(
            post("/api/reverse")
                .content(objectMapper.writeValueAsBytes(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();
    //Verify
    verify(service).reverse(anyString());
    //Assert
    assertThat(result.getResponse().getContentAsString()).isEqualTo(resultStr);
  }

  @Test
  void givenInvalidRequest_whenCalled_thenBadRequest() throws Exception {
    //Run test scenario
    mockMvc.perform(
            post("/api/reverse")
                .content(objectMapper.writeValueAsBytes(null))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andReturn();
  }
}