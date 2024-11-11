package Vista.Menu;
import Vista.GestionUsuario.Usuario.ItemUsuario;
import Vista.Personalizado.ImageDesktop;
import javax.swing.*;


public class MenuForm extends JFrame {

    public MenuForm() {
        initComponents();
        setTitle("Menu Principal");       
        this.EscritorioPane.setBorder(new ImageDesktop());
        this.setExtendedState(MenuForm.MAXIMIZED_BOTH);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        EscritorioPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        itemUsuario = new javax.swing.JMenuItem();
        itemRol = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuAcademico = new javax.swing.JMenu();
        itemEstudiante = new javax.swing.JMenuItem();
        itemDocumento = new javax.swing.JMenuItem();
        menuCursoHora = new javax.swing.JMenu();
        itemCurso = new javax.swing.JMenuItem();
        itemModalidad = new javax.swing.JMenuItem();
        itemHorario = new javax.swing.JMenuItem();
        menuMatricula = new javax.swing.JMenu();
        itemMatricula = new javax.swing.JMenuItem();
        itemComprobante = new javax.swing.JMenuItem();
        menuPago = new javax.swing.JMenu();
        itemPago = new javax.swing.JMenuItem();
        menuReporte = new javax.swing.JMenu();
        itemReporteEstudiante = new javax.swing.JMenuItem();
        itemReporteAbandono = new javax.swing.JMenuItem();
        itemReporteCurso = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout EscritorioPaneLayout = new javax.swing.GroupLayout(EscritorioPane);
        EscritorioPane.setLayout(EscritorioPaneLayout);
        EscritorioPaneLayout.setHorizontalGroup(
            EscritorioPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1114, Short.MAX_VALUE)
        );
        EscritorioPaneLayout.setVerticalGroup(
            EscritorioPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setForeground(new java.awt.Color(0, 102, 255));

        menuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Usuario/admin.png"))); // NOI18N
        menuUsuario.setText("Usuario");
        menuUsuario.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N

        itemUsuario.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        itemUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Usuario/user.png"))); // NOI18N
        itemUsuario.setText("Usuario");
        itemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(itemUsuario);

        itemRol.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        itemRol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Usuario/rol.png"))); // NOI18N
        itemRol.setText("Rol");
        itemRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRolActionPerformed(evt);
            }
        });
        menuUsuario.add(itemRol);
        menuUsuario.add(jSeparator1);

        jMenuBar1.add(menuUsuario);

        menuAcademico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Academico/academico.png"))); // NOI18N
        menuAcademico.setText("Academico");
        menuAcademico.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N

        itemEstudiante.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        itemEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Academico/estudiante.png"))); // NOI18N
        itemEstudiante.setText("Estudiante");
        menuAcademico.add(itemEstudiante);

        itemDocumento.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        itemDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Academico/documento.png"))); // NOI18N
        itemDocumento.setText("Tipo Documento");
        itemDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDocumentoActionPerformed(evt);
            }
        });
        menuAcademico.add(itemDocumento);

        jMenuBar1.add(menuAcademico);

        menuCursoHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/CursoyHorario/cursoHorario.png"))); // NOI18N
        menuCursoHora.setText("Cursos y Horarios");
        menuCursoHora.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N

        itemCurso.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        itemCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/CursoyHorario/curso.png"))); // NOI18N
        itemCurso.setText("Curso");
        menuCursoHora.add(itemCurso);

        itemModalidad.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        itemModalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/CursoyHorario/modalidad.png"))); // NOI18N
        itemModalidad.setText("Modalidad");
        itemModalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModalidadActionPerformed(evt);
            }
        });
        menuCursoHora.add(itemModalidad);

        itemHorario.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        itemHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/CursoyHorario/horario.png"))); // NOI18N
        itemHorario.setText("Horario");
        menuCursoHora.add(itemHorario);

        jMenuBar1.add(menuCursoHora);

        menuMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Matricula/matricula_logo.png"))); // NOI18N
        menuMatricula.setText("Matricula");
        menuMatricula.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N

        itemMatricula.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        itemMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Matricula/matricula.png"))); // NOI18N
        itemMatricula.setText("Matricula");
        menuMatricula.add(itemMatricula);

        itemComprobante.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        itemComprobante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Matricula/comprobante.png"))); // NOI18N
        itemComprobante.setText("Comprobante");
        menuMatricula.add(itemComprobante);

        jMenuBar1.add(menuMatricula);

        menuPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Pago/pago_logo.png"))); // NOI18N
        menuPago.setText("Pago");
        menuPago.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N

        itemPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Pago/pago.png"))); // NOI18N
        itemPago.setText("Pago");
        menuPago.add(itemPago);

        jMenuBar1.add(menuPago);

        menuReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Reporte/reporte.png"))); // NOI18N
        menuReporte.setText("Reporte");
        menuReporte.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N

        itemReporteEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Reporte/reporteEstudiante.png"))); // NOI18N
        itemReporteEstudiante.setText("Reporte de Demografía de Estudiantes");
        menuReporte.add(itemReporteEstudiante);

        itemReporteAbandono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Reporte/reporteAbandono.png"))); // NOI18N
        itemReporteAbandono.setText("Reporte de Retención y Abandono");
        menuReporte.add(itemReporteAbandono);

        itemReporteCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Reporte/reporteCurso.png"))); // NOI18N
        itemReporteCurso.setText("Reporte de Ingresos por Curso");
        menuReporte.add(itemReporteCurso);

        jMenuBar1.add(menuReporte);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EscritorioPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EscritorioPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUsuarioActionPerformed
       for (JInternalFrame frame : EscritorioPane.getAllFrames()) {
        if (frame instanceof ItemUsuario) { 
            frame.dispose();  
            break;
        }
    }          
            ItemUsuario item = new ItemUsuario();
            EscritorioPane.add(item);  
            EscritorioPane.revalidate(); 
            EscritorioPane.repaint();  
            int x = (EscritorioPane.getWidth() - item.getWidth()) / 2;
            int y = (EscritorioPane.getHeight() - item.getHeight()) / 2;
            item.setLocation(x, y); 
            item.setVisible(true);   
    }//GEN-LAST:event_itemUsuarioActionPerformed

    private void itemRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRolActionPerformed
        
    }//GEN-LAST:event_itemRolActionPerformed

    private void itemModalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModalidadActionPerformed
        
    }//GEN-LAST:event_itemModalidadActionPerformed

    private void itemDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDocumentoActionPerformed
        
    }//GEN-LAST:event_itemDocumentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane EscritorioPane;
    private javax.swing.JMenuItem itemComprobante;
    private javax.swing.JMenuItem itemCurso;
    private javax.swing.JMenuItem itemDocumento;
    private javax.swing.JMenuItem itemEstudiante;
    private javax.swing.JMenuItem itemHorario;
    private javax.swing.JMenuItem itemMatricula;
    private javax.swing.JMenuItem itemModalidad;
    private javax.swing.JMenuItem itemPago;
    private javax.swing.JMenuItem itemReporteAbandono;
    private javax.swing.JMenuItem itemReporteCurso;
    private javax.swing.JMenuItem itemReporteEstudiante;
    private javax.swing.JMenuItem itemRol;
    private javax.swing.JMenuItem itemUsuario;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu menuAcademico;
    private javax.swing.JMenu menuCursoHora;
    private javax.swing.JMenu menuMatricula;
    private javax.swing.JMenu menuPago;
    private javax.swing.JMenu menuReporte;
    private javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables
}
