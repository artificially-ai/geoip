package nl.ekholabs.microservices.geoip.controller;

import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.ekholabs.microservices.geoip.model.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class GeoIpControllerTest {

  private static final Logger LOGGER = Logger.getLogger(GeoIpControllerTest.class.getName());

  @Autowired
  private MockMvc mvc;

  @Test
  public void checkIpNotAllowed() throws Exception {
    RequestBuilder request = post("/checkIp")
        .contentType(APPLICATION_JSON_UTF8_VALUE)
        .content("    {\n"
          + "      \"ip\" : \"54.239.36.155\",\n"
          + "      \"countriesAllowed\" : [\"Netherlands\", \"England\"]\n"
          + "    }");

    final String contentAsString = mvc.perform(request)
        .andExpect(status()
            .isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();


    final ObjectMapper mapper = new ObjectMapper();
    final Response response = mapper.readValue(contentAsString.getBytes(), Response.class);

    assertFalse(response.isAllowed());

    LOGGER.info(contentAsString);
  }

  @Test
  public void checkIpAllowed() throws Exception {
    RequestBuilder request = post("/checkIp")
        .contentType(APPLICATION_JSON_UTF8_VALUE)
        .content("    {\n"
            + "      \"ip\" : \"77.163.214.250\",\n"
            + "      \"countriesAllowed\" : [\"Netherlands\", \"England\"]\n"
            + "    }");

    final String contentAsString = mvc.perform(request)
        .andExpect(status()
            .isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();


    final ObjectMapper mapper = new ObjectMapper();
    final Response response = mapper.readValue(contentAsString.getBytes(), Response.class);

    assertTrue(response.isAllowed());

    LOGGER.info(contentAsString);
  }
}