package Vista.GestionAcademico.Estudiante.Form;

import Controlador.Controladores.TipoDocumentoControlador;
import Modelo.Entidades.Cliente;
import Vista.GestionAcademico.TipoDocumento.ModelsAdapter.AdapterTipoDocumentoView;
import Vista.GestionAcademico.TipoDocumento.ModelsAdapter.TipoDocumentoComboModel;
import java.time.LocalDate;
import java.util.List;

public class PanelEstudiante extends javax.swing.JPanel {

    private Cliente estudiante;
    private boolean editable;
    private TipoDocumentoComboModel modelCombo;

    public PanelEstudiante() {
        initComponents();
        modelCombo = new TipoDocumentoComboModel(null);
    }

    public PanelEstudiante(TipoDocumentoControlador controlador) {
        initComponents();
        modelCombo = new TipoDocumentoComboModel(controlador);
        cmbDocumento.setModel(modelCombo);
    }

    public Cliente getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Cliente estudiante) {
        this.estudiante = estudiante;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        txtId.setEnabled(false);
        txtNombre.setEnabled(editable);
        txtPaterno.setEnabled(editable);
        txtMaterno.setEnabled(editable);
        cmbSexo.setEnabled(editable);
        fmtNacimiento.setEnabled(editable);
        cmbDocumento.setEnabled(editable);
        txtNumeroDocumento.setEnabled(editable);
        txtCelular1.setEnabled(editable);
        txtCelular2.setEnabled(editable);
        txtEmail.setEnabled(editable);
        txtUbigeo.setEnabled(editable);
        txtPais.setEnabled(editable);
        txtDepartamento.setEnabled(editable);
        txtProvincia.setEnabled(editable);
        txtDistrito.setEnabled(editable);

        if (editable) {
            txtNombre.requestFocus();
        }
    }
    
    public void setCod(String cod){
        txtId.setText(cod.trim());
    }
    
    public String getCod(){
      return  txtId.getText().trim();
    }


    public TipoDocumentoComboModel getModel() {
        return modelCombo;

    }
    
    public void setModel(TipoDocumentoComboModel modelCombo){
        this.modelCombo = modelCombo;
        cmbDocumento.setModel(modelCombo);
        modelCombo.updateCombo();
    }
    
    private AdapterTipoDocumentoView getAdapter(String value, List<AdapterTipoDocumentoView> roles) {
        for (AdapterTipoDocumentoView get : roles) {
            if (get.getDocumento().getDescripcion().equals(value)) {
                return get;
            }
        }
        return null;
    }
    
      public void dataLoad() {
        if (estudiante != null) {
            txtId.setText(estudiante.getId());
            txtNombre.setText(estudiante.getNombre());
            txtPaterno.setText(estudiante.getPaterno());
            txtMaterno.setText(estudiante.getMaterno());
            cmbSexo.setSelectedItem(estudiante.getSexo());
            fmtNacimiento.setText(estudiante.getFechaNacimiento().toString());
            
            List<AdapterTipoDocumentoView> getResult = modelCombo.getValue();
            AdapterTipoDocumentoView selected = getAdapter(estudiante.getDocumento().getDescripcion(),getResult );

            if (selected != null) {
                cmbDocumento.setSelectedItem(selected);
            }
            
            txtNumeroDocumento.setText(estudiante.getNumeroDocumento());
            txtCelular1.setText(estudiante.getCelular1());
            txtCelular2.setText(estudiante.getCelular2());
            txtEmail.setText(estudiante.getEmail());
            txtUbigeo.setText(estudiante.getUbigeo());
            txtPais.setText(estudiante.getPais());
            txtDepartamento.setText(estudiante.getDepartamento());
            txtProvincia.setText(estudiante.getProvincia());
            txtDistrito.setText(estudiante.getDistrito());

            
        } else {
            txtId.setText("");
            txtNombre.setText("");
            txtPaterno.setText("");
            txtMaterno.setText("");
            cmbSexo.setSelectedIndex(0);
            fmtNacimiento.setText("");
            cmbDocumento.setSelectedIndex(0);
            txtNumeroDocumento.setText("");
            txtCelular1.setText("");
            txtCelular2.setText("");
            txtEmail.setText("");
            txtUbigeo.setText("");
            txtPais.setText("");
            txtDepartamento.setText("");
            txtProvincia.setText("");
            txtDistrito.setText("");
        }
    }
    
      public void dataSave() {
    if (estudiante == null) {
        estudiante = new Cliente();
    }

    if (
        !txtId.getText().trim().isEmpty() &&
        !txtNombre.getText().trim().isEmpty() &&
        !txtPaterno.getText().trim().isEmpty() &&
        !txtMaterno.getText().trim().isEmpty() &&
        cmbSexo.getSelectedIndex() != 0 &&
        !fmtNacimiento.getText().trim().isEmpty() &&
        cmbDocumento.getSelectedIndex() != 0 &&
        !txtNumeroDocumento.getText().trim().isEmpty() &&
        !txtCelular1.getText().trim().isEmpty() &&
        !txtCelular2.getText().trim().isEmpty() &&
        !txtEmail.getText().trim().isEmpty() &&
        !txtUbigeo.getText().trim().isEmpty() &&
        !txtPais.getText().trim().isEmpty() &&
        !txtDepartamento.getText().trim().isEmpty() &&
        !txtProvincia.getText().trim().isEmpty() &&
        !txtDistrito.getText().trim().isEmpty()
    ) {
        estudiante.setId(txtId.getText());
        estudiante.setNombre(txtNombre.getText());
        estudiante.setPaterno(txtPaterno.getText());
        estudiante.setMaterno(txtMaterno.getText());
        estudiante.setSexo((String) cmbSexo.getSelectedItem());
        
        
        try {
            estudiante.setFechaNacimiento(LocalDate.parse(fmtNacimiento.getText().trim()));
        } catch (Exception e) {
            throw new IllegalArgumentException("La fecha ingresada no es válida.");
        }

        AdapterTipoDocumentoView documentoSeleccionado = (AdapterTipoDocumentoView) cmbDocumento.getSelectedItem();
        if (documentoSeleccionado != null) {
            estudiante.setDocumento(documentoSeleccionado.getDocumento());
        }
        
        estudiante.setNumeroDocumento(txtNumeroDocumento.getText());
        estudiante.setCelular1(txtCelular1.getText());
        estudiante.setCelular2(txtCelular2.getText());
        estudiante.setEmail(txtEmail.getText());
        estudiante.setUbigeo(txtUbigeo.getText());
        estudiante.setPais(txtPais.getText());
        estudiante.setDepartamento(txtDepartamento.getText());
        estudiante.setProvincia(txtProvincia.getText());
        estudiante.setDistrito(txtDistrito.getText());
    } else {
        estudiante = null;
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
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaterno = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUbigeo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        fmtNacimiento = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbDocumento = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtProvincia = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtDistrito = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCelular2 = new javax.swing.JTextField();
        txtNumeroDocumento = new javax.swing.JTextField();
        txtCelular1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Estudiante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sans Serif", 1, 14))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel1.setText("ID:");

        txtId.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detalles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sans Serif", 1, 13))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel2.setText("Nombre:*");

        txtNombre.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black, java.awt.Color.black));

        jLabel3.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel3.setText("Apellido Paterno :*");

        txtPaterno.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        txtPaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPaterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black, java.awt.Color.black));

        jLabel4.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel4.setText("Apellido Materno :*");

        txtMaterno.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        txtMaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black, java.awt.Color.black));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setToolTipText("");
        jSeparator1.setFont(new java.awt.Font("Sans Serif", 1, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel5.setText("Email: *");

        txtEmail.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black, java.awt.Color.black));

        jLabel6.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel6.setText("Ubigeo:*");

        txtUbigeo.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        txtUbigeo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUbigeo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black, java.awt.Color.black));

        jLabel7.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel7.setText("Pais:*");

        txtPais.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        txtPais.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black, java.awt.Color.black));

        jLabel8.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel8.setText("Sexo:*");

        cmbSexo.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SELECCIONE SEXO --", "Masculino", "Femenino", "39 tipos de gays" }));
        cmbSexo.setToolTipText("");
        cmbSexo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black, java.awt.Color.black));

        jLabel9.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel9.setText("Nacimiento:*");

        fmtNacimiento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black, java.awt.Color.black));
        fmtNacimiento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        fmtNacimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fmtNacimiento.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel10.setText("Tipo Documento:*");

        cmbDocumento.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        cmbDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black, java.awt.Color.black));

        jLabel11.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel11.setText("# Documento:*");

        jLabel12.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel12.setText("Departamento:");

        txtDepartamento.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        txtDepartamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDepartamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black, java.awt.Color.black));

        jLabel13.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel13.setText("Provincia:*");

        txtProvincia.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        txtProvincia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProvincia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black, java.awt.Color.black));

        jLabel14.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel14.setText("Distrito:");

        txtDistrito.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        txtDistrito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDistrito.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black, java.awt.Color.black));

        jLabel16.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel16.setText("Telefono Fijo:");

        jLabel17.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel17.setText("# Celular:");

        txtCelular2.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        txtCelular2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCelular2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black, java.awt.Color.black));

        txtNumeroDocumento.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        txtNumeroDocumento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black, java.awt.Color.black));

        txtCelular1.setFont(new java.awt.Font("Sans Serif", 1, 13)); // NOI18N
        txtCelular1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCelular1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black, java.awt.Color.black));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fmtNacimiento))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaterno)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCelular1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumeroDocumento)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(9, 9, 9)
                                .addComponent(txtPaterno)))
                        .addGap(12, 12, 12)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEmail)
                                .addComponent(txtUbigeo)
                                .addComponent(txtPais, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                            .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtProvincia))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDistrito)
                            .addComponent(txtCelular2))))
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUbigeo, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fmtNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCelular2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 255));

        jLabel15.setBackground(new java.awt.Color(0, 0, 255));
        jLabel15.setFont(new java.awt.Font("Sans Serif", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("MANEJO DE ESTUDIANTE ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<AdapterTipoDocumentoView> cmbDocumento;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JFormattedTextField fmtNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtCelular1;
    private javax.swing.JTextField txtCelular2;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtDistrito;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroDocumento;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JTextField txtProvincia;
    private javax.swing.JTextField txtUbigeo;
    // End of variables declaration//GEN-END:variables
}
