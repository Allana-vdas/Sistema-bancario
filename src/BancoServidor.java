//parte de Felipe fazer aqui

private static class GerenciadorCliente implements Runnable {
    private Socket conexao;

    public GerenciadorCliente(Socket conexao) {
        this.conexao = conexao;
    }

    @Override
    public void run() {
        try (
                BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
                PrintWriter saida = new PrintWriter(conexao.getOutputStream(), true)
        ) {
            String dados;
            while ((dados = entrada.readLine()) != null) {
                String[] partes = dados.split(";");
                int opcao = Integer.parseInt(partes[0]);
                String conta = partes.length > 1 ? partes[1] : "";
                double valor = partes.length > 2 ? Double.parseDouble(partes[2]) : 0.0;

                String resposta = "erro;Ação inválida";

//parte de Nauanne fazer aqui