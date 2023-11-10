package alura.memoteca.api.pensamento;

public record DadosListagemPensamentos(

        Long id,
        String conteudo,
        String autoria,
        Modelo modelo,
        boolean favorito
) {
    public DadosListagemPensamentos(Pensamento pensamento) {
        this(pensamento.getId(), pensamento.getConteudo(), pensamento.getAutoria(), pensamento.getModelo(), pensamento.isFavorito());
    }

}
