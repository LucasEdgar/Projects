/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package tela;

import entidade.Pessoa;
import entidade.Cidade;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import persistencia.HibernateUtil;

/**
 *
 * @author jaimedias
 */
public class PessoaTela extends javax.swing.JDialog {

    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> listaPessoas = new ArrayList<>();
    private List<Cidade> listaCidades = new ArrayList<>();

    public PessoaTela(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
//chama o método que vai montar a tabela de pessoas e exibir os pessoas salvos no banco.
        montaTabela();
//chama o método que valida os campos da tela.
        validaCampos("inicio");
        montaComboCidade();
    }

    public void montaComboCidade() {
        listaCidades = HibernateUtil.getSession().createQuery("from Cidade order by nome").list();
        cCidade.removeAllItems();
        for (Cidade cid : listaCidades) {
            cCidade.addItem(cid.getNome());
        }
    }

    public void validaCampos(String operacao) {
        if (operacao.equals("inicio")) {
            cNome.setEnabled(false);
            cCidade.setEnabled(false);
            cCpf.setEnabled(false);
            cRg.setEnabled(false);
            cTelefone.setEnabled(false);
            cEndereco.setEnabled(false);
            cNumero.setEnabled(false);
            btNovo.setEnabled(true);
            btAlterar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSair.setEnabled(true);
        } else if (operacao.equals("novo")) {
            cNome.setEnabled(true);
            cCidade.setEnabled(true);
            cCpf.setEnabled(true);
            cRg.setEnabled(true);
            cTelefone.setEnabled(true);
            cEndereco.setEnabled(true);
            cNumero.setEnabled(true);
            btNovo.setEnabled(false);
            btAlterar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(true);
            btCancelar.setEnabled(true);
            btSair.setEnabled(false);
        } else if (operacao.equals("selecionado")) {
            cNome.setEnabled(false);
            cCidade.setEnabled(false);
            cCpf.setEnabled(false);
            cRg.setEnabled(false);
            cTelefone.setEnabled(false);
            cEndereco.setEnabled(false);
            cNumero.setEnabled(false);
            btNovo.setEnabled(true);
            btAlterar.setEnabled(true);
            btExcluir.setEnabled(true);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSair.setEnabled(true);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cCodigo = new javax.swing.JTextField();
        cNome = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        cCidade = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cCpf = new javax.swing.JTextField();
        cRg = new javax.swing.JTextField();
        cTelefone = new javax.swing.JTextField();
        cEndereco = new javax.swing.JTextField();
        cNumero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cFiltro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Cliente");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
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
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jLabel2.setText("Código:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Cidade:");

        cCodigo.setEditable(false);
        cCodigo.setText(" ");
        cCodigo.setEnabled(false);

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        cCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("CPF:");

        jLabel6.setText("RG:");

        jLabel7.setText("Telefone:");

        jLabel8.setText("Endereço:");

        jLabel9.setText("Numero:");

        cCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCpfActionPerformed(evt);
            }
        });

        cRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cRgActionPerformed(evt);
            }
        });

        cTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTelefoneActionPerformed(evt);
            }
        });

        cEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cEnderecoActionPerformed(evt);
            }
        });

        cNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNumeroActionPerformed(evt);
            }
        });

        jLabel10.setText("Filtro:");

        cFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cFiltroActionPerformed(evt);
            }
        });
        cFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cFiltroKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cFiltroKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cFiltroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cFiltro))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cNome, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cRg, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cEndereco)
                                            .addComponent(cNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cCidade, 0, 348, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btSalvar)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btNovo, btSair, btSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(cTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(cEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar)
                    .addComponent(btSair))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        pessoa.setNome(cNome.getText());
        pessoa.setCpf(cCpf.getText());
        pessoa.setRg(cRg.getText());
        pessoa.setTelefone(cTelefone.getText());
        pessoa.setEndereco(cEndereco.getText());
        pessoa.setNumero(cNumero.getText());
        pessoa.setCidade(listaCidades.get(cCidade.getSelectedIndex()));

        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().merge(pessoa);
        HibernateUtil.commitTransaction();
        HibernateUtil.closeSession();

        limparCampos();
        montaTabela();
        validaCampos("inicio");
    }//GEN-LAST:event_btSalvarActionPerformed

    public void limparCampos() {

        cCodigo.setText("");
        cNome.setText("");
        cCpf.setText("");
        cRg.setText("");
        cTelefone.setText("");
        cEndereco.setText("");
        cNumero.setText("");
        cCidade.setSelectedItem(null);
    }


    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        pessoa = new Pessoa();
        limparCampos();
        validaCampos("novo");
        montaComboCidade();
    }//GEN-LAST:event_btNovoActionPerformed


    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked

        pessoa = listaPessoas.get(tabela.getSelectedRow());
        cCodigo.setText(pessoa.getId().toString());
        cNome.setText(pessoa.getNome());
        cCpf.setText(pessoa.getCpf());
        cRg.setText(pessoa.getRg());
        cTelefone.setText(pessoa.getTelefone());
        cEndereco.setText(pessoa.getEndereco());
        cNumero.setText(pessoa.getNumero());
        cCidade.setSelectedItem(pessoa.getCidade().getNome());
        validaCampos("selecionado");

    }//GEN-LAST:event_tabelaMouseClicked


    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().delete(pessoa);
        HibernateUtil.commitTransaction();
        HibernateUtil.closeSession();

        limparCampos();
        montaTabela();
        validaCampos("inicio");

        // TODO add your handling code here:
    }//GEN-LAST:event_btExcluirActionPerformed

// método do botão sair.
    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
// fecha a tela mas não mata a aplicação.
        dispose();
// Mata a aplicação, para de executar o sistema.
//        System.exit(1);
        // TODO add your handling code here:
    }//GEN-LAST:event_btSairActionPerformed

// método do botão cancelar
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
// limpar os campos da tela        
        limparCampos();
//valida os campos para o perfil inicio.
        validaCampos("inicio");
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

// método do botão alterar, que vai simplesmente liberar os campos da tela para o usuario editar.
    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
// chama o método valida campos para o perfil novo.
        validaCampos("novo");        // TODO add your handling code here:
    }//GEN-LAST:event_btAlterarActionPerformed

    private void cCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cCpfActionPerformed

    private void cRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cRgActionPerformed

    private void cTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cTelefoneActionPerformed

    private void cEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cEnderecoActionPerformed

    private void cNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cNumeroActionPerformed

    private void cFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cFiltroActionPerformed

    private void cFiltroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cFiltroKeyPressed


    }//GEN-LAST:event_cFiltroKeyPressed

    private void cFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cFiltroKeyTyped

        // TODO add your handling code here:
    }//GEN-LAST:event_cFiltroKeyTyped

    private void cFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cFiltroKeyReleased
        montaTabela();        // TODO add your handling code here:
    }//GEN-LAST:event_cFiltroKeyReleased

    public void montaTabela() {
        Query q = HibernateUtil.getSession().createQuery("from Pessoa where (lower(nome) like :filtro "
                + "or lower(cpf) like :filtro "
                + "or lower(rg) like :filtro "
                + "or lower(telefone) like :filtro "
                + "or lower(endereco) like :filtro "
                + "or lower(numero) like :filtro) ");
        q.setParameter("filtro", "%" + cFiltro.getText().toLowerCase() + "%");
        listaPessoas = q.list();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        modelo.addColumn("RG");
        modelo.addColumn("Telefone");
        modelo.addColumn("Endereço");
        modelo.addColumn("Numero");
        modelo.addColumn("Cidade");

        for (Pessoa pe : listaPessoas) {
            modelo.addRow(new Object[]{pe.getId(),
                pe.getNome(),
                pe.getCpf(),
                pe.getRg(),
                pe.getTelefone(),
                pe.getEndereco(),
                pe.getNumero(),
                pe.getCidade().getNome()});
        }
        tabela.setModel(modelo);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PessoaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PessoaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PessoaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PessoaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PessoaTela dialog = new PessoaTela(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cCidade;
    private javax.swing.JTextField cCodigo;
    private javax.swing.JTextField cCpf;
    private javax.swing.JTextField cEndereco;
    private javax.swing.JTextField cFiltro;
    private javax.swing.JTextField cNome;
    private javax.swing.JTextField cNumero;
    private javax.swing.JTextField cRg;
    private javax.swing.JTextField cTelefone;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}