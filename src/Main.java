import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws SQLException {

		System.out.println("DESBLOQUEADOR MULTIFAR LIGADO");

		while (true) {
			
			String cnpj = JOptionPane.showInputDialog(
					"DESBLOQUEADOR MULTIFAR \n \n1. Este programa deve ser usado apenas por pessoas autorizadas."
							+ "\n2. Estagiários não devem utilizar, pois se trata de acesso em ambiente de produção."
							+ "\n3. Este sistema realiza apenas o DESBLOQUEIO, sem função de BLOQUEIO."
							+ "\n4. Qualquer dúvida/problema entrar em contato com Vitor Damasceno. \n \n"
							+ "Digite o CNPJ com TODOS os símbolos corretamente (Ex: 00.000.000/0000-00)");
			
			Connection connection = new ConnectionFactory().getConnection();
			
			if (cnpj == null) {
				connection.close();
				System.exit(0);
			}

			PreparedStatement stmt_select = connection.prepareStatement("select cnpj from Company where CNPJ = ?");
			stmt_select.setString(1, cnpj);

			ResultSet rs = stmt_select.executeQuery();
			String resultselect = null;
			while (rs.next()) {
				resultselect = rs.getString("cnpj");
			}

			if (resultselect != null) {
				String update = "update Company SET STATUS=0, MSGTYPE='', STATUSMSG='' where CNPJ = ?";
				PreparedStatement stmt_update = connection.prepareStatement(update);
				stmt_update.setString(1, cnpj);
				stmt_update.execute();

				JOptionPane.showMessageDialog(null, cnpj + " DESBLOQUEADO");

				stmt_update.close();

			}
			if (resultselect == null) {
				JOptionPane.showMessageDialog(null, cnpj + " NAO ENCONTRADO");
			}
			rs.close();
			stmt_select.close();

			connection.close();
		}
	}
}