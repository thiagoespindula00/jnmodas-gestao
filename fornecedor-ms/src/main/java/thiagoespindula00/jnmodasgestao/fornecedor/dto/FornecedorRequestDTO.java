package thiagoespindula00.jnmodasgestao.fornecedor.dto;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public record FornecedorRequestDTO(
        @NotBlank
        @CNPJ
        @Pattern(regexp = "\\d{14}")
        String cnpj,

        @Size(max = 100, min = 2)
        @NotBlank
        String nome,

        @Size(max = 255, min = 2)
        @NotBlank
        @Email
        String email,

        @Column(length = 15)
        @Size(max = 15, min = 15)
        @NotBlank
        String telefone,

        @Valid
        EnderecoRequestDTO endereco
) {
}
