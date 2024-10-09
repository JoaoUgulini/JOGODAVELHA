class Jogador {
    private String simboloAtual;

    public Jogador() {
        simboloAtual = "X";
    }

    public String getSimboloAtual() {
        return simboloAtual;
    }

    public void alternarJogador() {
        if (simboloAtual.equals("X")) {
            simboloAtual = "O";
        } else {
            simboloAtual = "X";
        }
    }
}
