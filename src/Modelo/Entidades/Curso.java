package Modelo.Entidades;

public class Curso {
    private String id,curso;
    private double inscripcion,libro;

    public Curso() {
    }

    public Curso(String id, String curso, double inscripcion, double libro) {
        this.id = id;
        this.curso = curso;
        this.inscripcion = inscripcion;
        this.libro = libro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(double inscripcion) {
        this.inscripcion = inscripcion;
    }

    public double getLibro() {
        return libro;
    }

    public void setLibro(double libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", curso=" + curso + ", inscripcion=" + inscripcion + ", libro=" + libro + '}';
    }
    
    
}
