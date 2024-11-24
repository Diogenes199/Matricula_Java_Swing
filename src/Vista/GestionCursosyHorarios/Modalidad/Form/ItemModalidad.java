package Vista.GestionCursosyHorarios.Modalidad.Form;

import Controlador.Controladores.ModalidadControlador;
import Modelo.Entidades.Modalidad;
import Vista.GestionCursosyHorarios.Modalidad.ModelsAdapter.ModalidadTableModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ItemModalidad extends javax.swing.JInternalFrame {

    private ModalidadControlador controlador = new ModalidadControlador();
    private ModalidadTableModel tableModel;

    private int valor;
    
    public ItemModalidad() {
        initComponents();
        tableModel = new ModalidadTableModel(controlador);
        tblModalidad.setModel(tableModel);
        ObtenerTodos();
        panelModalidad.setEditable(false);
        panelModalidad.setModalidad(null);
        rbTodos.setSelected(true);
        txt_Buscado.requestFocus();
        valor = 0;

        this.tblModalidad.getSelectionModel().addListSelectionListener(e
                -> {
            activarBotonesCRUD(tblModalidad.getSelectedRow() != -1 && tblModalidad.getColumnCount() > 1);
            txt_Buscado.setText(tblModalidad.getColumnCount() > 1 ? "" : txt_Buscado.getText());
        });
    }
    
     private void activarBotonesCRUD(boolean activo) {
        this.btn_Borrar.setEnabled(activo);
        this.btn_Editar.setEnabled(activo);
        this.btn_Cancelar.setEnabled(activo);
        this.btn_Nuevo.setEnabled(!activo);
    }

    private void activarBotonesGuardar(boolean activo) {
        this.btn_Cancelar.setEnabled(activo);
        this.btn_Guardar.setEnabled(activo);
        this.btn_Borrar.setEnabled(!activo);

    }

    private void ObtenerTodos() {
        tableModel.getAll();
        tableModel.centrarContenido(tblModalidad);
        tableModel.ajustarTamanioColumnas(tblModalidad);
        tableModel.fireTableDataChanged();
    }

    private Modalidad getSelection() {
        String id = tblModalidad.getValueAt(tblModalidad.getSelectedRow(), 0).toString();
        return controlador.getOne(id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_Cancelar = new javax.swing.JButton();
        btn_Nuevo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_Borrar = new javax.swing.JButton();
        btn_Editar = new javax.swing.JButton();
        btn_Guardar = new javax.swing.JButton();
        panelModalidad = new Vista.GestionCursosyHorarios.Modalidad.Form.PanelModalidad();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblModalidad = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btn_pdf = new javax.swing.JButton();
        btn_excel = new javax.swing.JButton();
        btn_txt = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_Buscado = new javax.swing.JTextField();
        rbCodigo = new javax.swing.JRadioButton();
        btn_Buscar = new javax.swing.JButton();
        rbTodos = new javax.swing.JRadioButton();
        rbModalidad = new javax.swing.JRadioButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sans Serif", 1, 13))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btn_Nuevo))
                    .addComponent(btn_Cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Nuevo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Borrar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Borrar)
                    .addComponent(btn_Editar)
                    .addComponent(btn_Guardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tblModalidad.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblModalidad);

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        btn_pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Export/pdf_.png"))); // NOI18N
        btn_pdf.setBorderPainted(false);
        btn_pdf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_pdf.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pdfActionPerformed(evt);
            }
        });

        btn_excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Export/microsoft-excel.png"))); // NOI18N
        btn_excel.setBorderPainted(false);
        btn_excel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_excel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excelActionPerformed(evt);
            }
        });

        btn_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Export/archivo-csv.png"))); // NOI18N
        btn_txt.setBorderPainted(false);
        btn_txt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_txt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_txtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_pdf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_excel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_txt)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel2.setText("Buscar:");

        txt_Buscado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_BuscadoMousePressed(evt);
            }
        });

        buttonGroup1.add(rbCodigo);
        rbCodigo.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        rbCodigo.setText("Codigo");
        rbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCodigoActionPerformed(evt);
            }
        });

        btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/Crud/search.png"))); // NOI18N
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbTodos);
        rbTodos.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        rbTodos.setText("Todos");
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbModalidad);
        rbModalidad.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        rbModalidad.setText("Modalidad");
        rbModalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbModalidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Buscado, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(rbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbModalidad)
                        .addGap(50, 50, 50)
                        .addComponent(rbTodos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Buscado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCodigo)
                    .addComponent(rbTodos)
                    .addComponent(rbModalidad)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        panelModalidad.setModalidad(null);
        panelModalidad.dataLoad();
        activarBotonesGuardar(false);
        activarBotonesCRUD(false);
        tblModalidad.clearSelection();
        panelModalidad.setEditable(false);
        btn_Nuevo.setEnabled(true);
        txt_Buscado.setEnabled(true);
        txt_Buscado.requestFocus();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NuevoActionPerformed

        panelModalidad.setEditable(true);
        panelModalidad.setModalidad(null);
        panelModalidad.dataLoad();
        panelModalidad.setCod(controlador.newCode());
        activarBotonesCRUD(false);
        btn_Nuevo.setEnabled(false);
        activarBotonesGuardar(true);
    }//GEN-LAST:event_btn_NuevoActionPerformed

    private void btn_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BorrarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar el Curso (" + tblModalidad.getValueAt(tblModalidad.getSelectedRow(), 1).toString() + ")?", "BORRAR CURSO ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            String id = tblModalidad.getValueAt(tblModalidad.getSelectedRow(), 0).toString();
            controlador.delete(id);
            ObtenerTodos();
            tblModalidad.clearSelection();

            activarBotonesCRUD(false);
            activarBotonesGuardar(false);
        }
    }//GEN-LAST:event_btn_BorrarActionPerformed

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed

        activarBotonesGuardar(true);
        panelModalidad.setEditable(true);
        panelModalidad.setModalidad(getSelection());
        panelModalidad.dataLoad();
        txt_Buscado.setEnabled(false);
    }//GEN-LAST:event_btn_EditarActionPerformed

    private void btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarActionPerformed

        String ruta = "src/Logos/Message/";
        String message = "";
        boolean estado = false;
        panelModalidad.dataSave();
        Modalidad existe = controlador.getOne(panelModalidad.getCod());
        Modalidad modalidad = panelModalidad.getModalidad();
        if (existe != null) {
            estado = controlador.update(modalidad);
            message = estado ? "Usuario Actualizado con exito" : "Espera (*)";

        }
        if (existe == null) {
            estado = controlador.create(modalidad);
            message = estado ? "Usuario Insertado con exito" : "Rellenar los espacios requeridos (*)";
        }

        String image = estado ? "exito.png" : "error.png";
        ImageIcon icon = new ImageIcon(ruta + image);

        JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE, icon);
        if (estado) {
            panelModalidad.setModalidad(null);
            panelModalidad.setEditable(false);
            panelModalidad.dataLoad();
            ObtenerTodos();
            activarBotonesGuardar(false);
            activarBotonesCRUD(false);
            txt_Buscado.setEnabled(estado);
        }
    }//GEN-LAST:event_btn_GuardarActionPerformed

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

    private void txt_BuscadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_BuscadoMousePressed
        if (txt_Buscado.isEnabled()) {
            tblModalidad.clearSelection();
        }
    }//GEN-LAST:event_txt_BuscadoMousePressed

    private void rbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCodigoActionPerformed
        valor = 1;
    }//GEN-LAST:event_rbCodigoActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        if (txt_Buscado.isEnabled()) {
            String textoBuscado = txt_Buscado.getText().trim();
            ModalidadTableModel tablita = new ModalidadTableModel(controlador);
            switch (valor) {
                case 0 -> tablita.getAll();
                case 1 -> tablita.getOne(textoBuscado);
                case 2 -> tablita.getModalidades(textoBuscado);
                default -> {
                }
            }

            tblModalidad.setModel(tablita);
            tablita.centrarContenido(tblModalidad);
        }
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        valor = 0;
        tblModalidad.setModel(tableModel);
        ObtenerTodos();
        txt_Buscado.setText("");
        txt_Buscado.requestFocus();
    }//GEN-LAST:event_rbTodosActionPerformed

    private void rbModalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbModalidadActionPerformed
        valor = 2;
    }//GEN-LAST:event_rbModalidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Borrar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JButton btn_Nuevo;
    private javax.swing.JButton btn_excel;
    private javax.swing.JButton btn_pdf;
    private javax.swing.JButton btn_txt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private Vista.GestionCursosyHorarios.Modalidad.Form.PanelModalidad panelModalidad;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbModalidad;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tblModalidad;
    private javax.swing.JTextField txt_Buscado;
    // End of variables declaration//GEN-END:variables
}
