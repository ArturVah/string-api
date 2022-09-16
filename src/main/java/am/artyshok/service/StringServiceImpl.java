package am.artyshok.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class StringServiceImpl implements StringService {

  @Override
  public String reverse(String value) {
    Assert.notNull(value, "Value of string cannot be null for reverse");
    return new StringBuilder(value).reverse().toString();
  }
}
