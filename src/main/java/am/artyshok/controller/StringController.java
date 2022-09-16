package am.artyshok.controller;

import am.artyshok.model.ReverseRequest;
import am.artyshok.service.StringService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StringController {

  private final StringService service;

  public StringController(StringService service) {
    this.service = service;
  }

  @PostMapping("/reverse")
  public String reverse(@NonNull @RequestBody final ReverseRequest request) {
    return service.reverse(request.getValue());
  }
}
