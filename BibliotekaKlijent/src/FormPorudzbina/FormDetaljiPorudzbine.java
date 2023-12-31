/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormPorudzbina;

import kontroler.KlijentKontroler;
import domeni.Knjiga;
import domeni.Kupac;
import domeni.Porudzbina;
import domeni.StavkaPorudzbine;
import forme.MainForm;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modeli.TableModelStavke;

/**
 *
 * @author Elez
 */
public class FormDetaljiPorudzbine extends javax.swing.JDialog {

    private Porudzbina p;
    double cena;
    double popust;
    double konacnaCena;

    public FormDetaljiPorudzbine(JDialog parent, boolean modal, Porudzbina p) {
        super(parent, modal);
        initComponents();
        this.p = p;
        setLocationRelativeTo(null);
        setTitle("Detalji porudzbine");
        srediFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAdresa = new javax.swing.JTextField();
        txtDatumIsporuke = new javax.swing.JFormattedTextField();
        txtCena = new javax.swing.JTextField();
        txtPopust = new javax.swing.JTextField();
        txtKonacnaCena = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbKupac = new javax.swing.JComboBox();
        cmbGrad = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbKnjiga = new javax.swing.JComboBox();
        txtKolicina = new javax.swing.JTextField();
        txtCenaStavke = new javax.swing.JTextField();
        btnDodajStavku = new javax.swing.JButton();
        btnObrisiStavku = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        btnOtkazi = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalji porudzbine"));

        jLabel1.setText("Grad:");

        jLabel2.setText("Adresa:");

        jLabel3.setText("Datum isporuke:");

        jLabel4.setText("Cena (din):");

        jLabel5.setText("Popust:");

        jLabel6.setText("Konacna cena (din):");

        txtDatumIsporuke.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));

        txtPopust.setText("0%");

        jLabel7.setText("Kupac:");

        cmbKupac.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbKupac.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbKupacItemStateChanged(evt);
            }
        });

        cmbGrad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beograd", "Nis", "Novi Sad", "Subotica", "Kraljevo", "Zrenjanin" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Stavke porudzbine"));

        jLabel8.setText("Knjiga:");

        jLabel9.setText("Kolicina:");

        jLabel10.setText("Cena stavke:");

        cmbKnjiga.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbKnjiga.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbKnjigaItemStateChanged(evt);
            }
        });

        txtKolicina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKolicinaKeyReleased(evt);
            }
        });

        btnDodajStavku.setText("Dodaj stavku");
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
            }
        });

        btnObrisiStavku.setText("Obrisi stavku");
        btnObrisiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiStavkuActionPerformed(evt);
            }
        });

        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblStavke);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(btnObrisiStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbKnjiga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtKolicina)
                                    .addComponent(txtCenaStavke))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbKnjiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCenaStavke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajStavku)
                    .addComponent(btnObrisiStavku))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi porudzbinu");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni porudzbinu");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAdresa)
                            .addComponent(txtDatumIsporuke)
                            .addComponent(txtCena)
                            .addComponent(txtPopust)
                            .addComponent(txtKonacnaCena)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbGrad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbKupac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(6, 6, 6))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbKupac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDatumIsporuke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPopust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKonacnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOtkazi)
                    .addComponent(btnObrisi)
                    .addComponent(btnIzmeni))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da "
                + "obrisete ovu porudzbinu?", "Konfirmacija", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            try {
                KlijentKontroler.getInstance().deletePorudzbina(p);
                FormPretragaPorudzbine fp = (FormPretragaPorudzbine) getParent();
                fp.refreshTable();
                JOptionPane.showMessageDialog(this, "Uspesno obrisana porudzbina.");
                this.dispose();
            } catch (Exception ex) {
                Logger.getLogger(FormDetaljiPorudzbine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed

        if (txtAdresa.getText().isEmpty() || txtDatumIsporuke.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!");
            return;
        }

        try {
            String grad = (String) cmbGrad.getSelectedItem();
            String adresa = txtAdresa.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datumIsporuke = sdf.parse(txtDatumIsporuke.getText());
            TableModelStavke tm = (TableModelStavke) tblStavke.getModel();

            p.setCena(cena);
            p.setKonacnaCena(konacnaCena);
            p.setGrad(grad);
            p.setAdresa(adresa);
            p.setDatumIsporuke(datumIsporuke);
            p.setStavkePorudzbine(tm.getLista());

            KlijentKontroler.getInstance().updatePorudzbina(p);
            FormPretragaPorudzbine fp = (FormPretragaPorudzbine) getParent();
            fp.refreshTable();
            JOptionPane.showMessageDialog(this, "Uspesno izmenjena porudzbina.");
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FormDetaljiPorudzbine.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void cmbKupacItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbKupacItemStateChanged

        if (cmbKupac.getSelectedItem() != null && !txtCena.getText().isEmpty()) {
            izracunajKonacnuCenu();
        }
    }//GEN-LAST:event_cmbKupacItemStateChanged

    private void cmbKnjigaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbKnjigaItemStateChanged

        if (cmbKnjiga.getSelectedItem() != null) {
            if (txtKolicina.getText().isEmpty()) {
                txtCenaStavke.setText("");
                return;
            }

            Knjiga knjiga = (Knjiga) cmbKnjiga.getSelectedItem();
            int kolicina = Integer.parseInt(txtKolicina.getText());

            txtCenaStavke.setText(String.valueOf(knjiga.getCenaKnjige() * kolicina));
        }
    }//GEN-LAST:event_cmbKnjigaItemStateChanged

    private void txtKolicinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKolicinaKeyReleased

        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {

            if (txtKolicina.getText().isEmpty()) {
                txtCenaStavke.setText("");
                return;
            }

            Knjiga knjiga = (Knjiga) cmbKnjiga.getSelectedItem();
            int kolicina = Integer.parseInt(txtKolicina.getText());

            txtCenaStavke.setText(String.valueOf(knjiga.getCenaKnjige() * kolicina));

        } else {

            txtCenaStavke.setText("");
            txtKolicina.setText("");

        }
    }//GEN-LAST:event_txtKolicinaKeyReleased

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed

        if (txtKolicina.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Kolicina mora biti popunjena!");
            return;
        }

        Knjiga knjiga = (Knjiga) cmbKnjiga.getSelectedItem();
        int kolicina = Integer.parseInt(txtKolicina.getText());
        double cena = Double.parseDouble(txtCenaStavke.getText());

        StavkaPorudzbine stavkaPorudzbine = new StavkaPorudzbine(p, -1, kolicina, cena, knjiga);

        TableModelStavke tm = (TableModelStavke) tblStavke.getModel();
        tm.dodajStavku(stavkaPorudzbine);

        this.cena = tm.vratiCenu();

        txtCena.setText(String.valueOf(this.cena));
        izracunajKonacnuCenu();
    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void btnObrisiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiStavkuActionPerformed

        int row = tblStavke.getSelectedRow();

        if (row >= 0) {
            TableModelStavke tm = (TableModelStavke) tblStavke.getModel();
            tm.obrisiStavku(row);

            cena = tm.vratiCenu();

            txtCena.setText(String.valueOf(cena));
            izracunajKonacnuCenu();
        }
    }//GEN-LAST:event_btnObrisiStavkuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JComboBox<String> cmbGrad;
    private javax.swing.JComboBox cmbKnjiga;
    private javax.swing.JComboBox cmbKupac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtCenaStavke;
    private javax.swing.JFormattedTextField txtDatumIsporuke;
    private javax.swing.JTextField txtKolicina;
    private javax.swing.JTextField txtKonacnaCena;
    private javax.swing.JTextField txtPopust;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {

        txtPopust.setEditable(false);
        cmbKupac.setEnabled(false);
        txtCena.setEditable(false);
        txtKonacnaCena.setEditable(false);
        txtCenaStavke.setEditable(false);
        
        cmbKupac.getModel().setSelectedItem(p.getKupac());
        txtAdresa.setText(p.getAdresa());
        cmbGrad.getModel().setSelectedItem(p.getGrad());
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        txtDatumIsporuke.setText(sdf.format(p.getDatumIsporuke()));
        txtCena.setText(String.valueOf(p.getCena()));
        txtKonacnaCena.setText(String.valueOf(p.getKonacnaCena()));
        txtPopust.setText(String.valueOf(p.getPopust()));
        
        
        cena = p.getCena();
        popust = p.getPopust();
        konacnaCena = p.getKonacnaCena();
        popuniKnjige();
        tblStavke.setModel(new TableModelStavke(p));

        if (!p.getDatumIsporuke().after(new Date())) {
            cmbGrad.setEnabled(false);
            txtAdresa.setEditable(false);
            txtDatumIsporuke.setEditable(false);
            txtKolicina.setEditable(false);
            txtKolicina.setEditable(false);
            btnDodajStavku.setEnabled(false);
            btnObrisiStavku.setEnabled(false);
            btnIzmeni.setEnabled(false);
            btnObrisi.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Ova porudzbina je isporucena, ne mozete je "
                    + "editovati!");
        }

    }

    private void izracunajKonacnuCenu() {
        Kupac kupac = (Kupac) cmbKupac.getSelectedItem();

        if (kupac.getTipKupca().equals("FREE")) {
            txtPopust.setText("0%");
            popust = 0;
        }

        if (kupac.getTipKupca().equals("PREMIUM")) {
            txtPopust.setText("10%");
            popust = 10;
        }

        if (kupac.getTipKupca().equals("ULTRA")) {
            txtPopust.setText("20%");
            popust = 20;
        }

        double cena = Double.parseDouble(txtCena.getText());

        txtKonacnaCena.setText(String.valueOf(cena * (1 - (popust / 100))));

        konacnaCena = cena * (1 - (popust / 100));
    }

    private void popuniKnjige() {
        try {
            ArrayList<Knjiga> knjige = KlijentKontroler.getInstance().getAllKnjiga();

            cmbKnjiga.removeAllItems();

            for (Knjiga knjiga : knjige) {
                cmbKnjiga.addItem(knjiga);
            }

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
