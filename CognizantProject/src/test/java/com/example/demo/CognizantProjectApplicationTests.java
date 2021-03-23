package com.example.demo;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.model.Cognizant;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.model.Response;

@SpringBootTest
class CognizantProjectApplicationTests {
	private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;//to interact with our controller
    ObjectMapper om = new ObjectMapper();//reading and writing JSON, either to and from basic POJOs
    @Before
    private void setUp() { //intializing mock mvc before the MicroServicesApp041220ApplicationTests class for that @before annotation
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        
    }
    public void addEmpTest() throws Exception {
    Cognizant emp1 = new Cognizant();
    emp1.setcName("Ram");
    emp1.setDept("IT");
    String jsonReq = om.writeValueAsString(emp1);//to convert emp1 object into string
    MvcResult result = mockMvc.perform(post("/api/cog/addEmp")
                            .content(jsonReq)
                            .content(org.springframework.http.MediaType.APPLICATION_JSON_VALUE))
                            .andExpect(status().isOk()).andReturn();
    String resContent = result.getResponse().getContentAsString();
    Response response = om.readValue(resContent, Response.class);//convert from string to object
    org.junit.Assert.assertTrue(response.isStatus()==Boolean.TRUE);
    
    }
    public void getEmpTest() throws Exception {
        
        
        MvcResult result = mockMvc.perform(get("/api/cog/getEmp")
                                .content(org.springframework.http.MediaType.APPLICATION_JSON_VALUE))
                                .andExpect(status().isOk()).andReturn();
        String resContent = result.getResponse().getContentAsString();
        Response response = om.readValue(resContent, Response.class);//convert from string to object
        org.junit.Assert.assertTrue(response.isStatus()==Boolean.TRUE);
        
        }

 
	
}
