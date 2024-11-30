package br.com.screenmatch.excecao;

public class ErroDeConversaoAnoException extends RuntimeException {
    private String mensagem;

    public ErroDeConversaoAnoException(String s) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
