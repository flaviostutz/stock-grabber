package com.stockgrabber;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;

public class StockSettings extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	private JTextField codigoAcao = null;

	private JLabel jLabel1 = null;

	private JTextField tempo = null;

	private JButton save = null;

	private JLabel jLabel2 = null;

	private JLabel jLabel3 = null;

	private JTextField targetDir = null;

	private JButton browse = null;

	private JCheckBox startRecording = null;

	/**
	 * This is the default constructor
	 */
	public StockSettings() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(263, 174);
		this.setContentPane(getJContentPane());
		this.setTitle("Captura BOVESPA");
		StockGrabberTray.centerWindow(this);
	}
	
	public void reload() {
		codigoAcao.setText(Configuration.getStocks());
		tempo.setText(Configuration.getPeriod()+"");
		targetDir.setText(Configuration.getTargetDir());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 0;
			gridBagConstraints12.gridwidth = 3;
			gridBagConstraints12.anchor = GridBagConstraints.EAST;
			gridBagConstraints12.insets = new Insets(0, 0, 0, 5);
			gridBagConstraints12.gridy = 4;
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 4;
			gridBagConstraints31.insets = new Insets(5, 0, 0, 5);
			gridBagConstraints31.fill = GridBagConstraints.NONE;
			gridBagConstraints31.gridy = 3;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints21.gridy = 3;
			gridBagConstraints21.weightx = 1.0;
			gridBagConstraints21.gridwidth = 2;
			gridBagConstraints21.insets = new Insets(5, 5, 0, 5);
			gridBagConstraints21.gridx = 1;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.insets = new Insets(5, 5, 0, 0);
			gridBagConstraints11.gridy = 3;
			jLabel3 = new JLabel();
			jLabel3.setText("Destino:");
			jLabel3.setFont(new Font("Dialog", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 2;
			gridBagConstraints5.insets = new Insets(5, 0, 0, 5);
			gridBagConstraints5.anchor = GridBagConstraints.WEST;
			gridBagConstraints5.gridy = 2;
			jLabel2 = new JLabel();
			jLabel2.setText("min");
			jLabel2.setFont(new Font("Dialog", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 4;
			gridBagConstraints4.insets = new Insets(5, 0, 5, 5);
			gridBagConstraints4.gridwidth = 1;
			gridBagConstraints4.anchor = GridBagConstraints.EAST;
			gridBagConstraints4.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints4.gridy = 4;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.gridy = 2;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.insets = new Insets(5, 5, 0, 5);
			gridBagConstraints3.gridx = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.anchor = GridBagConstraints.EAST;
			gridBagConstraints2.insets = new Insets(5, 5, 0, 0);
			gridBagConstraints2.gridy = 2;
			jLabel1 = new JLabel();
			jLabel1.setText("Tempo:");
			jLabel1.setFont(new Font("Dialog", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.insets = new Insets(0, 5, 0, 5);
			gridBagConstraints1.gridwidth = 4;
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.anchor = GridBagConstraints.EAST;
			gridBagConstraints.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints.gridy = 1;
			jLabel = new JLabel();
			jLabel.setText("Ações:");
			jLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.setBorder(BorderFactory.createTitledBorder(null, "Configurações de gravação", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.PLAIN, 12), new Color(51, 51, 51)));
			jContentPane.add(jLabel, gridBagConstraints);
			jContentPane.add(getCodigoAcao(), gridBagConstraints1);
			jContentPane.add(jLabel1, gridBagConstraints2);
			jContentPane.add(getTempo(), gridBagConstraints3);
			jContentPane.add(getSave(), gridBagConstraints4);
			jContentPane.add(jLabel2, gridBagConstraints5);
			jContentPane.add(jLabel3, gridBagConstraints11);
			jContentPane.add(getTargetDir(), gridBagConstraints21);
			jContentPane.add(getBrowse(), gridBagConstraints31);
			jContentPane.add(getStartRecording(), gridBagConstraints12);
		}
		return jContentPane;
	}

	/**
	 * This method initializes codigoAcao	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCodigoAcao() {
		if (codigoAcao == null) {
			codigoAcao = new JTextField();
			codigoAcao.setToolTipText("Código das ações separadas por vírgula");
		}
		return codigoAcao;
	}

	/**
	 * This method initializes tempo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTempo() {
		if (tempo == null) {
			tempo = new JTextField();
			tempo.setToolTipText("Tempo entre gravações");
		}
		return tempo;
	}

	/**
	 * This method initializes save	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSave() {
		if (save == null) {
			save = new JButton();
			save.setText("Salvar");
			save.setFont(new Font("Dialog", Font.PLAIN, 12));
			save.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Configuration.saveConfig(codigoAcao.getText(), Float.parseFloat(tempo.getText()), targetDir.getText(), startRecording.isSelected());
					setVisible(false);
				}
			});
		}
		return save;
	}

	/**
	 * This method initializes targetDir	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTargetDir() {
		if (targetDir == null) {
			targetDir = new JTextField();
			targetDir.setToolTipText("Diretório de destino das capturas");
		}
		return targetDir;
	}

	/**
	 * This method initializes browse	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBrowse() {
		if (browse == null) {
			browse = new JButton();
			browse.setText("Browse...");
			browse.setFont(new Font("Dialog", Font.PLAIN, 10));
			browse.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					fc.setDialogTitle("Selecione um diretório de destino");
					int returnVal = fc.showOpenDialog(StockSettings.this);
					
					//load file
			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            File file = fc.getSelectedFile();
						targetDir.setText(file.getAbsolutePath());
			        }
				}
			});
		}
		return browse;
	}

	/**
	 * This method initializes startRecording	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getStartRecording() {
		if (startRecording == null) {
			startRecording = new JCheckBox();
			startRecording.setText("Iniciar gravando");
			startRecording.setFont(new Font("Dialog", Font.PLAIN, 12));
			startRecording.setToolTipText("Iniciar o aplicativo em modo de gravação");
		}
		return startRecording;
	}

}  //  @jve:decl-index=0:visual-constraint="30,13"
