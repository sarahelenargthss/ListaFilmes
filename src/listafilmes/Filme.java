package listafilmes;

public class Filme {
    
    private String titulo;
    private Filme proximo;

    public Filme() {
        
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Filme getProximo() {
        return proximo;
    }

    public void setProximo(Filme proximo) {
        this.proximo = proximo;
    }
    
}
