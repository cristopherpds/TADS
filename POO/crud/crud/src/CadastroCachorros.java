import java.util.ArrayList;
import javax.swing.*;

public class CadastroCachorros extends javax.swing.JFrame {
    
    ArrayList<Cachorro> listaCachorros = new ArrayList<>();
    int contadorId = 1;
    
    public CadastroCachorros() {
        initComponents();
    }

    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtFNome = new javax.swing.JTextField();
        lblIdade = new javax.swing.JLabel();
        txtFIdade = new javax.swing.JTextField();
        lblRaca = new javax.swing.JLabel();
        txtFRaca = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        txtAreaListarCachorros = new javax.swing.JTextArea();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNome.setText("Nome:");

        lblIdade.setText("Idade:");

        lblRaca.setText("Raça:");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        txtAreaListarCachorros.setColumns(20);
        txtAreaListarCachorros.setRows(5);
        scrollPane.setViewportView(txtAreaListarCachorros);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblIdade)
                            .addComponent(lblRaca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFNome)
                            .addComponent(txtFIdade)
                            .addComponent(txtFRaca)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdade)
                    .addComponent(txtFIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRaca)
                    .addComponent(txtFRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAlterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        String nome = txtFNome.getText();
        int idade = Integer.parseInt(txtFIdade.getText());
        String raca = txtFRaca.getText();
        
        Cachorro cachorro = new Cachorro(contadorId, nome, idade, raca);
        listaCachorros.add(cachorro);
        contadorId++;
        
        atualizarListaCachorros();
        
        txtFNome.setText("");
        txtFIdade.setText("");
        txtFRaca.setText("");
    }                                                 

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {                                                
        String idString = JOptionPane.showInputDialog("Digite o ID do cachorro que deseja excluir:");
        int id = Integer.parseInt(idString);
        
        for (Cachorro cachorro : listaCachorros) {
            if (cachorro.getId() == id) {
                listaCachorros.remove(cachorro);
                break;
            }
        }
        
        atualizarListaCachorros();
    }                                               

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {                                                
        String idString = JOptionPane.showInputDialog("Digite o ID do cachorro que deseja alterar:");
        int id = Integer.parseInt(idString);
        
        for (Cachorro cachorro : listaCachorros) {
            if (cachorro.getId() == id) {
                String nome = JOptionPane.showInputDialog("Digite o novo nome:");
                int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova idade:"));
                String raca = JOptionPane.showInputDialog("Digite a nova raça:");
                
                cachorro.setNome(nome);
                cachorro.setIdade(idade);
                cachorro.setRaca(raca);
                
                break;
            }
        }
        
        atualizarListaCachorros();
    }                                               

    private void atualizarListaCachorros() {
        txtAreaListarCachorros.setText("");
        
        for (Cachorro cachorro : listaCachorros) {
            txtAreaListarCachorros.append(cachorro.toString() + "\n");
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCachorros().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRaca;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextArea txtAreaListarCachorros;
    private javax.swing.JTextField txtFIdade;
    private javax.swing.JTextField txtFNome;
    private javax.swing.JTextField txtFRaca;
    
}