package Vista.GestionCursosyHorarios.Curso;

import Modelo.Entidades.Curso;

public class PanelCurso extends javax.swing.JPanel {

    private Curso curso;
    private boolean editable;

    public PanelCurso() {
        initComponents();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        txtId.setEnabled(false);
        txtCurso.setEnabled(editable);
        txtInscripcion.setEnabled(editable);
        txtLibro.setEnabled(editable);
        if (editable) {
            txtCurso.requestFocus();
        }
    }

    public String getCod() {
        return txtId.getText().trim();
    }

    public void setCod(String cod) {
        txtId.setText(cod.trim());
    }

    public void dataLoad() {
        if (curso != null) {
            txtId.setText(curso.getId());
            txtCurso.setText(curso.getCurso());
            txtInscripcion.setText(curso.getInscripcion() + "");
            txtLibro.setText(curso.getLibro() + "");

        } else {
            txtId.setText("");
            txtCurso.setText("");
            txtInscripcion.setText("");
            txtLibro.setText("");
        }

    }

    public void dataSave() {
        if (curso == null) {
            curso = new Curso();
            
        }
         if (!txtInscripcion.getText().trim().isEmpty()
                && !txtLibro.getText().trim().isEmpty()
                && !txtCurso.getText().trim().isEmpty()) {
            curso.setId(txtId.getText().trim());
            curso.setCurso(txtCurso.getText().trim());
            double inscripcion = Double.parseDouble(txtInscripcion.getText());
            double libro = Double.parseDouble(txtLibro.getText());
            curso.setInscripcion(inscripcion);
            curso.setLibro(libro);
        }else{
             curso = null;
         }
         
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtInscripcion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLibro = new javax.swing.JTextField();

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        jLabel1.setText("ID :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        jLabel2.setText("Nombre: ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 22, -1, -1));
        jPanel3.add(txtCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 100, -1));

        jLabel3.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        jLabel3.setText("Costo Inscripcion:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 76, -1, -1));
        jPanel3.add(txtInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 100, -1));

        jLabel4.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        jLabel4.setText("Costo Libro: ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 124, -1, -1));
        jPanel3.add(txtLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 100, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtInscripcion;
    private javax.swing.JTextField txtLibro;
    // End of variables declaration//GEN-END:variables
}
