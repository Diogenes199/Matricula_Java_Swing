package Vista.GestionAcademico.Estudiante.Form;

import Controlador.Controladores.ClienteControlador;
import Controlador.Controladores.TipoDocumentoControlador;
import Modelo.Entidades.Cliente;
import Vista.GestionAcademico.Estudiante.ModelsAdapter.ClienteTableModel;
import Vista.GestionAcademico.TipoDocumento.ModelsAdapter.TipoDocumentoComboModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ItemEstudiante extends javax.swing.JInternalFrame {
    
private TipoDocumentoControlador controladorTipo = new TipoDocumentoControlador();
private ClienteControlador controladorCli = new ClienteControlador();
private ClienteTableModel tableModel ;
private int valor;
    
    
    public ItemEstudiante() {
        initComponents();
         tableModel = new ClienteTableModel(controladorCli);
       tblEstudiante.setModel(tableModel);
       tableModel.getAll();
        panelEstudiante.setModel(new TipoDocumentoComboModel(controladorTipo));
       panelEstudiante.setEditable(false);
        panelEstudiante.setEstudiante(null);
        rbTodos.setSelected(true);
        valor = 0;
        TabPaneSelected(0);         
         this.tblEstudiante.getSelectionModel().addListSelectionListener(e ->
        {
            activarBotonesCRUD(tblEstudiante.getSelectedRow()!=-1 && tblEstudiante.getColumnCount() > 1);
        });
        
    }
    
      private void activarBotonesCRUD(boolean activo) {
        this.btn_Borrar.setEnabled(activo);
        this.btn_Editar.setEnabled(activo);
        this.btn_Cancelar.setEnabled(activo);
        this.btn_Cancelar1.setEnabled(activo);
        this.btn_Nuevo.setEnabled(!activo);
    }
      
    private void activarBotonesGuardar(boolean activo){
        this.btn_Guardar.setEnabled(activo);
        this.btn_Cancelar1.setEnabled(activo);
       }
    
     private void ObtenerTodos() {
      tableModel.getAll();
      tableModel.fireTableDataChanged();
    }
 
   
     private Cliente getSelection() {
        String id= tblEstudiante.getValueAt(tblEstudiante.getSelectedRow(),0).toString();
        return controladorCli.getOne(id);
    }

     
     private void TabPaneSelected(int tab){
         TabPane.setSelectedIndex(tab);
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_Cancelar = new javax.swing.JButton();
        btn_Nuevo = new javax.swing.JButton();
        btn_Borrar = new javax.swing.JButton();
        btn_Editar = new javax.swing.JButton();
        btn_Close = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_Buscado = new javax.swing.JTextField();
        rbCod = new javax.swing.JRadioButton();
        rbNombreA = new javax.swing.JRadioButton();
        rbTipoDocumento = new javax.swing.JRadioButton();
        btn_Buscar = new javax.swing.JButton();
        btn_excel = new javax.swing.JButton();
        btn_txt = new javax.swing.JButton();
        rbTodos = new javax.swing.JRadioButton();
        btn_pdf = new javax.swing.JButton();
        panel_tabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstudiante = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        panelEstudiante = new Vista.GestionAcademico.Estudiante.Form.PanelEstudiante();
        btn_Cancelar1 = new javax.swing.JButton();
        btn_Guardar = new javax.swing.JButton();

        btn_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Crud/cancel.png"))); // NOI18N
        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.setBorderPainted(false);
        btn_Cancelar.setContentAreaFilled(false);
        btn_Cancelar.setEnabled(false);
        btn_Cancelar.setFocusable(false);
        btn_Cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        btn_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Crud/new.png"))); // NOI18N
        btn_Nuevo.setText("Nuevo");
        btn_Nuevo.setBorderPainted(false);
        btn_Nuevo.setContentAreaFilled(false);
        btn_Nuevo.setFocusable(false);
        btn_Nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NuevoActionPerformed(evt);
            }
        });

        btn_Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Crud/clear.png"))); // NOI18N
        btn_Borrar.setText("Borrar");
        btn_Borrar.setBorderPainted(false);
        btn_Borrar.setContentAreaFilled(false);
        btn_Borrar.setEnabled(false);
        btn_Borrar.setFocusable(false);
        btn_Borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Borrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BorrarActionPerformed(evt);
            }
        });

        btn_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Crud/edit.png"))); // NOI18N
        btn_Editar.setText("Editar");
        btn_Editar.setBorderPainted(false);
        btn_Editar.setContentAreaFilled(false);
        btn_Editar.setEnabled(false);
        btn_Editar.setFocusable(false);
        btn_Editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditarActionPerformed(evt);
            }
        });

        btn_Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Crud/new.png"))); // NOI18N
        btn_Close.setText("Salir");
        btn_Close.setBorderPainted(false);
        btn_Close.setContentAreaFilled(false);
        btn_Close.setFocusable(false);
        btn_Close.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Close.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                .addComponent(btn_Nuevo)
                .addGap(93, 93, 93)
                .addComponent(btn_Editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Borrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Close)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Cancelar)
                    .addComponent(btn_Borrar)
                    .addComponent(btn_Editar)
                    .addComponent(btn_Nuevo)
                    .addComponent(btn_Close))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Buscar:");

        txt_Buscado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_BuscadoMousePressed(evt);
            }
        });

        rbCod.setText("Codigo");
        rbCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCodActionPerformed(evt);
            }
        });

        rbNombreA.setText("Nombre/Apellido");
        rbNombreA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNombreAActionPerformed(evt);
            }
        });

        rbTipoDocumento.setText("Rol");
        rbTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTipoDocumentoActionPerformed(evt);
            }
        });

        btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Crud/search.png"))); // NOI18N
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        btn_excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Export/excel.png"))); // NOI18N
        btn_excel.setBorderPainted(false);
        btn_excel.setContentAreaFilled(false);
        btn_excel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_excel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excelActionPerformed(evt);
            }
        });

        btn_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Export/csv.png"))); // NOI18N
        btn_txt.setBorderPainted(false);
        btn_txt.setContentAreaFilled(false);
        btn_txt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_txt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_txtActionPerformed(evt);
            }
        });

        rbTodos.setText("Todos");
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
            }
        });

        btn_pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Export/pdf.png"))); // NOI18N
        btn_pdf.setBorderPainted(false);
        btn_pdf.setContentAreaFilled(false);
        btn_pdf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_pdf.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pdfActionPerformed(evt);
            }
        });

        panel_tabla.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.black));

        tblEstudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblEstudiante);

        javax.swing.GroupLayout panel_tablaLayout = new javax.swing.GroupLayout(panel_tabla);
        panel_tabla.setLayout(panel_tablaLayout);
        panel_tablaLayout.setHorizontalGroup(
            panel_tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panel_tablaLayout.setVerticalGroup(
            panel_tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tablaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_Buscado, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rbCod, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbTodos)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_pdf)
                        .addGap(79, 79, 79))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(panel_tabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_Buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_Buscado)))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbCod)
                            .addComponent(rbNombreA)
                            .addComponent(rbTipoDocumento)
                            .addComponent(rbTodos)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_txt)
                            .addComponent(btn_excel)
                            .addComponent(btn_pdf))
                        .addGap(18, 18, 18)))
                .addGap(18, 18, 18)
                .addComponent(panel_tabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(88, 88, 88)))
                .addGap(11, 11, 11))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        TabPane.addTab("VIEW", jPanel1);

        btn_Cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Crud/cancel.png"))); // NOI18N
        btn_Cancelar1.setText("Cancelar");
        btn_Cancelar1.setBorderPainted(false);
        btn_Cancelar1.setContentAreaFilled(false);
        btn_Cancelar1.setEnabled(false);
        btn_Cancelar1.setFocusable(false);
        btn_Cancelar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Cancelar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cancelar1ActionPerformed(evt);
            }
        });

        btn_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Crud/Save.png"))); // NOI18N
        btn_Guardar.setText("Guardar");
        btn_Guardar.setBorderPainted(false);
        btn_Guardar.setContentAreaFilled(false);
        btn_Guardar.setEnabled(false);
        btn_Guardar.setFocusable(false);
        btn_Guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btn_Cancelar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(641, 641, 641))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(panelEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(64, 64, 64))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(panelEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Cancelar1)
                    .addComponent(btn_Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        TabPane.addTab("ESTUDIANTE", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(TabPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        tblEstudiante.clearSelection();
        txt_Buscado.requestFocus();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NuevoActionPerformed

       
        panelEstudiante.setEditable(true);
        panelEstudiante.setEstudiante(null);
        panelEstudiante.dataLoad();
        panelEstudiante.setCod(controladorCli.newCode());
        activarBotonesCRUD(false);
        btn_Nuevo.setEnabled(false);
        activarBotonesGuardar(true);
        TabPaneSelected(1);

    }//GEN-LAST:event_btn_NuevoActionPerformed

    private void btn_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BorrarActionPerformed
        if(JOptionPane.showConfirmDialog(null,"¿Seguro que quiere borrar este Usuario?","BORRAR USUARIO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
        {

            String id = tblEstudiante.getValueAt(tblEstudiante.getSelectedRow(),0).toString();
            controladorCli.delete(id);
            ObtenerTodos();
            tblEstudiante.clearSelection();

            activarBotonesCRUD(false);
            activarBotonesGuardar(false);

        }

    }//GEN-LAST:event_btn_BorrarActionPerformed

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed

        activarBotonesGuardar(true);
        panelEstudiante.setEditable(true);
        panelEstudiante.setEstudiante(getSelection());
        panelEstudiante.dataLoad();
        TabPaneSelected(1);

    }//GEN-LAST:event_btn_EditarActionPerformed

    private void btn_CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_CloseActionPerformed

    private void txt_BuscadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_BuscadoMousePressed
        tblEstudiante.clearSelection();
    }//GEN-LAST:event_txt_BuscadoMousePressed

    private void rbCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCodActionPerformed
        valor=1;
    }//GEN-LAST:event_rbCodActionPerformed

    private void rbNombreAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNombreAActionPerformed
        valor=2;
    }//GEN-LAST:event_rbNombreAActionPerformed

    private void rbTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTipoDocumentoActionPerformed
        valor=3;
    }//GEN-LAST:event_rbTipoDocumentoActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed

        String textoBuscado = txt_Buscado.getText().trim();
        ClienteTableModel tablita=new ClienteTableModel(controladorCli);
        switch (valor) {
            case 0:
            tablita.getAll();
            break;
            case 1:
            tablita.getOne(textoBuscado );
            break;
//            case 2:
//            tablita.findByNameAndLastName(textoBuscado);
//            break;
//            case 3:
//            tablita.findByRol(textoBuscado);
//            break;
            default:
            break;
        }
        tblEstudiante.setModel(tablita);

    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excelActionPerformed
        /*
        try {
            calculo=new Calculos();
            calculo.exportarExcel(tblUsuario,"Reporte_Cliente");
        } catch (IOException ex) {
            Utilidades.Mensaje("ERROR","No se creo el excel",0);
        }
        */
    }//GEN-LAST:event_btn_excelActionPerformed

    private void btn_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_txtActionPerformed
        /*
        try {
            calculo=new Calculos();
            calculo.exportarTxt(tblUsuario);
        } catch (IOException ex) {
            Utilidades.Mensaje("ERROR","Errorl",0);
        }
        */
    }//GEN-LAST:event_btn_txtActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        valor=0;
        ObtenerTodos();
        txt_Buscado.setText("");
        txt_Buscado.requestFocus();
    }//GEN-LAST:event_rbTodosActionPerformed

    private void btn_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pdfActionPerformed
        /*
        try {
            calculo = new Calculos();

            calculo.exportarPDF(tblUsuario,"EMPLEADO");
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(FrmEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }//GEN-LAST:event_btn_pdfActionPerformed

    private void btn_Cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cancelar1ActionPerformed
        panelEstudiante.setEstudiante(null);
        panelEstudiante.dataLoad();
        activarBotonesCRUD(false);
        activarBotonesGuardar(false);
        tblEstudiante.clearSelection();
        panelEstudiante.setEditable(false);
        btn_Nuevo.setEnabled(true);
        TabPaneSelected(0);
    }//GEN-LAST:event_btn_Cancelar1ActionPerformed

    private void btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarActionPerformed
      
        String ruta = "src/Logos/Message/";
        String message = "";
        boolean estado = false;
        panelEstudiante.dataSave();
        Cliente existe = controladorCli.getOne(panelEstudiante.getCod());
        Cliente insertar = panelEstudiante.getEstudiante();
        if(existe!=null )
        {
            estado = controladorCli.update(insertar);
            message = estado?"Cliente Actualizado con exito":"Espera (*)";

        }if(existe == null){
            estado = controladorCli.create(insertar);
            message = estado?"Cliente Insertado con exito":"Rellenar los espacios requeridos (*)";
        }

        String image =  estado?"exito.png":"error.png";
        ImageIcon icon = new ImageIcon(ruta + image);
        JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE, icon);
        if(estado){
            panelEstudiante.setEstudiante(null);
            panelEstudiante.setEditable(false);
            panelEstudiante.dataLoad();
            ObtenerTodos();
            activarBotonesCRUD(false);
            activarBotonesGuardar(false);
        }
    }//GEN-LAST:event_btn_GuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabPane;
    private javax.swing.JButton btn_Borrar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Cancelar1;
    private javax.swing.JButton btn_Close;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JButton btn_Nuevo;
    private javax.swing.JButton btn_excel;
    private javax.swing.JButton btn_pdf;
    private javax.swing.JButton btn_txt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private Vista.GestionAcademico.Estudiante.Form.PanelEstudiante panelEstudiante;
    private javax.swing.JPanel panel_tabla;
    private javax.swing.JRadioButton rbCod;
    private javax.swing.JRadioButton rbNombreA;
    private javax.swing.JRadioButton rbTipoDocumento;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tblEstudiante;
    private javax.swing.JTextField txt_Buscado;
    // End of variables declaration//GEN-END:variables
}
