package br.com.quintinno.defensiumapi;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.quintinno.defensiumapi.controller.PessoaController;
import br.com.quintinno.defensiumapi.entity.PessoaEntity;
import br.com.quintinno.defensiumapi.service.PessoaService;
import br.com.quintinno.defensiumapi.tranfer.PessoaRequestTranfer;

@WebMvcTest(PessoaController.class)
public class PessoaControllerTest {

    @MockBean
    private PessoaService pessoaService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // @Test
    public void deveCriarPessoaComSucesso() throws Exception {

        PessoaRequestTranfer pessoaRequestTranfer = new PessoaRequestTranfer("Doilol Pepen Kikun Dorcene");
        PessoaEntity pessoaEntity = new PessoaEntity(pessoaRequestTranfer.getNome());

        when(pessoaService.create(pessoaRequestTranfer)).thenReturn(pessoaEntity);

        mockMvc.perform(
                post("/defensium/pessoa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pessoaRequestTranfer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Doilol Pepen Kikun Dorcene"));
    }

}
