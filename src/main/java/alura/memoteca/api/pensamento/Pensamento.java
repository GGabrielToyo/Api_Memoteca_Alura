package alura.memoteca.api.pensamento;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "pensamentos")
@Entity(name = "Pensamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pensamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conteudo;

    private String autoria;

    @Enumerated(EnumType.STRING)
    private Modelo modelo;

    private boolean favorito;

    public Pensamento (DadosCadastroPensamento pensamento) {
        this.conteudo = pensamento.conteudo();
        this.autoria = pensamento.autoria();
        this.modelo = pensamento.modelo();
        this.favorito = pensamento.favorito();

    }

    public void atualizarDados(DadosEditarPensamento dados) {
        if(dados.conteudo() != null) {
            this.conteudo = dados.conteudo();
        }

        if(dados.autoria() != null) {
            this.autoria = dados.autoria();
        }

        if(dados.modelo() != null) {
            this.modelo = dados.modelo();
        }

        if(dados.favorito() != null) {
            this.favorito = dados.favorito();
        }
    }

}
