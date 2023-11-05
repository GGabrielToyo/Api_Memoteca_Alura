package alura.memoteca.api.pensamento;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPensamento(
        @NotBlank
        String conteudo,
        @NotBlank
        String autoria,
        @NotNull
        Modelo modelo,
        @NotNull
        Boolean favorito) { }
