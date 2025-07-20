import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class vendasVIEW extends JFrame {

    private JTable tabelaVendidos;
    private JButton btnFechar;

    public vendasVIEW() {
        setTitle("Produtos Vendidos");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Lista de Produtos Vendidos");
        lblTitulo.setBounds(150, 10, 250, 25);
        add(lblTitulo);

        tabelaVendidos = new JTable();
        tabelaVendidos.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nome", "Valor", "Status"}
        ));

        JScrollPane scroll = new JScrollPane(tabelaVendidos);
        scroll.setBounds(25, 50, 440, 200);
        add(scroll);

        btnFechar = new JButton("Fechar");
        btnFechar.setBounds(200, 260, 100, 30);
        add(btnFechar);

        btnFechar.addActionListener(e -> dispose());

        listarVendidos(); // Chamada do método ao abrir a tela
    }

    private void listarVendidos() {
        try {
            ProdutosDAO dao = new ProdutosDAO();
            ArrayList<ProdutosDTO> vendidos = dao.listarProdutosVendidos();

            DefaultTableModel model = (DefaultTableModel) tabelaVendidos.getModel();
            model.setRowCount(0); // limpa a tabela

            for (ProdutosDTO produto : vendidos) {
                model.addRow(new Object[]{
                        produto.getId(),
                        produto.getNome(),
                        produto.getValor(),
                        produto.getStatus()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos vendidos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new vendasVIEW().setVisible(true);
    }
}
