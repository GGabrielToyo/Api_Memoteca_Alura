package alura.memoteca.api.pensamento;

import jakarta.validation.constraints.NotNull;

public record DadosEditarPensamento(
        @NotNull
        Long id,
        String conteudo,
        String autoria,
        Modelo modelo,
        Boolean favorito
) {
}
