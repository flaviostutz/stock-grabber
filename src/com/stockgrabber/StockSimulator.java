package com.stockgrabber;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Collections;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class StockSimulator extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTable dataTable = null;

	private JScrollPane jScrollPane = null;

	private JButton loadButton = null;

	private JButton calculateButton = null;

	private JLabel jLabel = null;

	private JTextField startCompra = null;

	private JLabel jLabel1 = null;

	private JTextField stopVenda = null;

	private JLabel jLabel2 = null;

	private JTextField custoCompra = null;

	private JLabel jLabel3 = null;

	private JTextField custoVenda = null;

	private JPanel jPanel = null;

	private JLabel jLabel4 = null;

	private JLabel jLabel6 = null;

	private JTextField capitalInicial = null;

	private JLabel jLabel7 = null;

	private JLabel jLabel8 = null;

	private JLabel capitalFinal = null;

	private JLabel custos = null;

	private JLabel rendimentoLiquido = null;

	private JLabel jLabel10 = null;

	private JLabel varLiquida = null;

	private JButton invertLines = null;

	private JLabel jLabel5 = null;

	private JLabel rawVar = null;

	private JButton openGraph = null;

	private JPanel jPanel1 = null;

	private JTextField smoothFactor = null;

	private JRadioButton mediaMovel = null;

	private JRadioButton smooth = null;

	private JTabbedPane estrategia = null;

	private JPanel inversao = null;

	private JRadioButton dayIntraday = null;

	private JPanel agulhada = null;  //  @jve:decl-index=0:visual-constraint="615,63"

	/**
	 * This is the default constructor
	 */
	public StockSimulator() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setSize(550, 492);
		this.setContentPane(getJContentPane());
		this.setTitle("StockGrabber");
		this.setVisible(false);
		StockGrabberTray.centerWindow(this);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
			gridBagConstraints51.gridx = 4;
			gridBagConstraints51.gridheight = 2;
			gridBagConstraints51.fill = GridBagConstraints.BOTH;
			gridBagConstraints51.ipadx = 0;
			gridBagConstraints51.insets = new Insets(5, 0, 0, 5);
			gridBagConstraints51.weighty = 1.0;
			gridBagConstraints51.weightx = 1.0;
			gridBagConstraints51.gridy = 0;
			GridBagConstraints gridBagConstraints110 = new GridBagConstraints();
			gridBagConstraints110.gridx = 0;
			gridBagConstraints110.insets = new Insets(5, 0, 0, 0);
			gridBagConstraints110.gridwidth = 1;
			gridBagConstraints110.weightx = 1.0;
			gridBagConstraints110.gridy = 0;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 1;
			gridBagConstraints13.insets = new Insets(5, 0, 0, 0);
			gridBagConstraints13.gridwidth = 1;
			gridBagConstraints13.weightx = 1.0;
			gridBagConstraints13.gridy = 0;
			jLabel6 = new JLabel();
			jLabel6.setText("Capital inicial:");
			jLabel6.setFont(new Font("Dialog", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 3;
			gridBagConstraints11.fill = GridBagConstraints.BOTH;
			gridBagConstraints11.gridwidth = 2;
			gridBagConstraints11.insets = new Insets(9, 0, 5, 5);
			gridBagConstraints11.weighty = 0.0;
			gridBagConstraints11.gridy = 14;
			jLabel3 = new JLabel();
			jLabel3.setText("Custo por venda:");
			jLabel3.setFont(new Font("Dialog", Font.PLAIN, 12));
			jLabel2 = new JLabel();
			jLabel2.setText("Custo por compra:");
			jLabel2.setFont(new Font("Dialog", Font.PLAIN, 12));
			jLabel1 = new JLabel();
			jLabel1.setText("Var. venda:");
			jLabel1.setFont(new Font("Dialog", Font.PLAIN, 10));
			jLabel = new JLabel();
			jLabel.setText("Var. compra:");
			jLabel.setFont(new Font("Dialog", Font.PLAIN, 10));
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 4;
			gridBagConstraints5.anchor = GridBagConstraints.CENTER;
			gridBagConstraints5.insets = new Insets(5, 0, 0, 5);
			gridBagConstraints5.weightx = 0.0;
			gridBagConstraints5.fill = GridBagConstraints.NONE;
			gridBagConstraints5.gridheight = 1;
			gridBagConstraints5.gridy = 12;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 2;
			gridBagConstraints4.anchor = GridBagConstraints.CENTER;
			gridBagConstraints4.insets = new Insets(5, 0, 0, 0);
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.gridy = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.BOTH;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.weighty = 1.0;
			gridBagConstraints3.gridwidth = 3;
			gridBagConstraints3.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints3.gridheight = 14;
			gridBagConstraints3.gridx = 0;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getJScrollPane(), gridBagConstraints3);
			jContentPane.add(getLoadButton(), gridBagConstraints4);
			jContentPane.add(getCalculateButton(), gridBagConstraints5);
			jContentPane.add(getJPanel(), gridBagConstraints11);
			jContentPane.add(getInvertLines(), gridBagConstraints13);
			jContentPane.add(getOpenGraph(), gridBagConstraints110);
			jContentPane.add(getJPanel1(), gridBagConstraints51);
		}
		return jContentPane;
	}

	/**
	 * This method initializes dataTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getDataTable() {
		if (dataTable == null) {
			dataTable = new JTable();
		}
		return dataTable;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getDataTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes loadButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getLoadButton() {
		if (loadButton == null) {
			loadButton = new JButton();
			loadButton.setText("Abrir arquivo...");
			loadButton.setFont(new Font("Dialog", Font.PLAIN, 12));
			loadButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					int returnVal = fc.showOpenDialog(StockSimulator.this);
					
					//load file
			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            File file = fc.getSelectedFile();
			            try {
			            	
							FileReader fr = new FileReader(file);
							BufferedReader br = new BufferedReader(fr);
							
							DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Data","Hora","Preço","Volume","M","Preço ref."},0);
							dataTable.setModel(tableModel);

							String line;
							while((line=br.readLine())!=null) {
								StringTokenizer st = new StringTokenizer(line, ",");
								try {
									String date = st.nextToken();
									String time = st.nextToken();
									float price = Float.parseFloat(st.nextToken());
									float volume = Float.parseFloat(st.nextToken());
									tableModel.addRow(new Object[]{date, time, price, volume, null});
								} catch (Exception e1) {
									System.err.println("Erro ao ler linha \""+ line + "\"");
									continue;
								}

							}
							
						} catch (Exception e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(StockSimulator.this, "Não foi possível ler os dados do arquivo", "Abertura de arquivo", JOptionPane.ERROR_MESSAGE);
						}
			        }
				}
			});
		}
		return loadButton;
	}

	/**
	 * This method initializes calculateButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCalculateButton() {
		if (calculateButton == null) {
			calculateButton = new JButton();
			calculateButton.setText("Calcular");
			calculateButton.setFont(new Font("Dialog", Font.PLAIN, 12));
			calculateButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Thread t = new Thread(new Runnable() {
						public void run() {
							StockSimulator.this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
							try {
								//prepare data
								float custoCompraF = Float.parseFloat(custoCompra.getText());
								float custoVendaF = Float.parseFloat(custoVenda.getText());
								float capitalInicialF = Float.parseFloat(capitalInicial.getText());
								
								//totalizações
								int qtdeVendas=0;
								float priceUltimaCompra = 0;
								float custoTotal = 0;
								float capitalAtual = capitalInicialF;
								
								//calculate!
								boolean in = false;
								Statistics stats = new Statistics(Integer.parseInt(smoothFactor.getText()));

								float fundo=Float.MAX_VALUE, topo=Float.MIN_VALUE;
								
								TableModel model = dataTable.getModel();
								
								int minSel = dataTable.getSelectionModel().getMinSelectionIndex();
								int maxSel = dataTable.getSelectionModel().getMaxSelectionIndex();
								if(minSel==-1 
									|| maxSel==-1
									|| (maxSel-minSel)<=1) {
									minSel = 0;
									maxSel = model.getRowCount()-1;
								}
								
								String lastDay = "";
								
								for(int i=minSel; i<maxSel; i++) {
									float price = (Float.parseFloat(model.getValueAt(i, 2).toString()));
									float refValue = price;

									stats.addValor(price);
									
									//substituir o preço pela média caso selecionado
									if(mediaMovel.isSelected()) {
										refValue = stats.getMedia();
									}
									if(smooth.isSelected()) {
										refValue = stats.getRegression();
									}
									
									//skip first item in selection
									if(i==minSel) {
										topo = refValue;
										fundo = refValue;
										continue;
									}
									
									if(capitalAtual<=0) continue;//you are broke!
									
									//ENTRAR NA INDICACAO DO DIA E SAIR NO INTRADAY
									if(dayIntraday.isSelected()) {
										//utilizar somente o primeiro valor de cada dia para decidir sobre entrada
										if(!in) {
											String cday = (String)model.getValueAt(i, 0);
											if(!cday.equals(lastDay)) {
												lastDay = cday;
											} else {
												continue;
											}
										}
									}
									
									float varCompra = Float.parseFloat(startCompra.getText())/100;
									float varVenda = Float.parseFloat(stopVenda.getText())/100;
									boolean changedPosition = false;
									
									if(refValue<fundo) {
										fundo = refValue;
									}
									if(refValue>topo) {
										topo = refValue;
									}

									//comprar?
									if(!in) {
										float varSubida = (refValue/fundo)-1;
										if(varSubida>=varCompra) {
											in = true;
											changedPosition = true;
											model.setValueAt("E", i, 4);
											fundo = refValue;
											topo = refValue;
	
											priceUltimaCompra = price;
											
											float custo = custoBovespa(capitalAtual) + custoCompraF;
											custoTotal += custo;
											capitalAtual -= custo;
											
											System.out.println("COMPRADO: price="+ price + ";capitalAtual="+capitalAtual);
										}
										
										
									//vender?
									} else {
										float varQueda = 1-(refValue/topo);
										boolean sell = false;
										if(varQueda>=varVenda) {
											sell = true;
										}
										
										//force sell if this is the last item in selection
										boolean lastRow = (i==maxSel-1);
										if(sell || lastRow) {
											in = false;
											changedPosition = true;
											
											float rendimento = (price/priceUltimaCompra) - 1;
											capitalAtual = (1+rendimento)*capitalAtual;
											
											model.setValueAt("S "+(rendimento*100), i, 4);
											fundo = refValue;
											topo = refValue;
											
											System.out.println("VENDIDO: price="+ price +";rendimento="+rendimento + "; capitalAtual="+capitalAtual);
											
											qtdeVendas++;
	
											float custo = custoBovespa(capitalAtual) + custoVendaF;
											custoTotal += custo;
											capitalAtual -= custo;
										}
									}

									//show reference value
									model.setValueAt(refValue, i, 5);
									
									if(!changedPosition) {
										model.setValueAt((in?"D":"F"), i, 4);
									}
									
									System.out.println("price="+ price + ";fundo="+fundo + ";topo="+topo + ";refValue=" + refValue);									
									
								}
								
								
								//update labels
								DecimalFormat df = new DecimalFormat();
								df.setMaximumFractionDigits(2);
								df.setMinimumFractionDigits(2);
								df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(new Locale("pt", "BR")));
								
								float varLiquidaF = (capitalAtual/capitalInicialF)-1;
								rendimentoLiquido.setText("R$ "+df.format(capitalInicialF*varLiquidaF));
								capitalFinal.setText("R$ "+df.format(capitalAtual));
								varLiquida.setText(df.format((varLiquidaF*100))+"%");
								custos.setText("R$ "+df.format(custoTotal));
								
								float firstPrice = (Float)model.getValueAt(minSel, 2);
								float lastPrice = (Float)model.getValueAt(maxSel, 2);
								rawVar.setText(df.format(((lastPrice/firstPrice)-1)*100) + "%");
							
							} catch (Exception e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(StockSimulator.this, e.getMessage(), "Problemas durante o cálculo", JOptionPane.ERROR_MESSAGE);
								
							} finally {
								StockSimulator.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
							}
						}
					});
					t.start();
				}
			});
		}
		return calculateButton;
	}

	public float custoBovespa(float capitalAtual) {
		//custos BOVESPA (tx liquidação + tx negociação)
		float bov = (float)(capitalAtual*((0.008+0.027)/100));
		//custos IR
		//isento caso realizadas menos de 20.000,00 em operações, e 15% senão
		return bov;
	}
	
	/**
	 * This method initializes startCompra	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getStartCompra() {
		if (startCompra == null) {
			startCompra = new JTextField();
			startCompra.setText("1");
			startCompra.setFont(new Font("Dialog", Font.PLAIN, 10));
		}
		return startCompra;
	}

	/**
	 * This method initializes stopVenda	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getStopVenda() {
		if (stopVenda == null) {
			stopVenda = new JTextField();
			stopVenda.setText("1");
			stopVenda.setFont(new Font("Dialog", Font.PLAIN, 10));
		}
		return stopVenda;
	}

	/**
	 * This method initializes custoCompra	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCustoCompra() {
		if (custoCompra == null) {
			custoCompra = new JTextField();
			custoCompra.setText("10");
		}
		return custoCompra;
	}

	/**
	 * This method initializes custoVenda	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCustoVenda() {
		if (custoVenda == null) {
			custoVenda = new JTextField();
			custoVenda.setText("10");
		}
		return custoVenda;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.gridx = 1;
			gridBagConstraints19.fill = GridBagConstraints.NONE;
			gridBagConstraints19.insets = new Insets(9, 7, 5, 0);
			gridBagConstraints19.gridy = 9;
			rawVar = new JLabel();
			rawVar.setText("");
			rawVar.setFont(new Font("Dialog", Font.PLAIN, 12));
			rawVar.setPreferredSize(new Dimension(100, 15));
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 0;
			gridBagConstraints18.insets = new Insets(9, 7, 5, 0);
			gridBagConstraints18.anchor = GridBagConstraints.EAST;
			gridBagConstraints18.gridy = 9;
			jLabel5 = new JLabel();
			jLabel5.setText("Sem operar:");
			jLabel5.setFont(new Font("Dialog", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints25 = new GridBagConstraints();
			gridBagConstraints25.gridx = 1;
			gridBagConstraints25.insets = new Insets(5, 7, 0, 0);
			gridBagConstraints25.gridy = 7;
			varLiquida = new JLabel();
			varLiquida.setText("");
			varLiquida.setPreferredSize(new Dimension(100, 15));
			varLiquida.setFont(new Font("Dialog", Font.BOLD, 12));
			GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
			gridBagConstraints24.gridx = 0;
			gridBagConstraints24.anchor = GridBagConstraints.EAST;
			gridBagConstraints24.insets = new Insets(5, 7, 0, 0);
			gridBagConstraints24.gridy = 7;
			jLabel10 = new JLabel();
			jLabel10.setText("Var. líquida:");
			jLabel10.setFont(new Font("Dialog", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
			gridBagConstraints23.gridx = 1;
			gridBagConstraints23.insets = new Insets(5, 7, 0, 0);
			gridBagConstraints23.gridy = 6;
			rendimentoLiquido = new JLabel();
			rendimentoLiquido.setText("");
			rendimentoLiquido.setPreferredSize(new Dimension(100, 15));
			rendimentoLiquido.setFont(new Font("Dialog", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.gridx = 1;
			gridBagConstraints22.insets = new Insets(5, 7, 0, 0);
			gridBagConstraints22.gridy = 8;
			custos = new JLabel();
			custos.setText("");
			custos.setPreferredSize(new Dimension(100, 15));
			custos.setFont(new Font("Dialog", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 1;
			gridBagConstraints21.insets = new Insets(5, 7, 0, 0);
			gridBagConstraints21.gridy = 5;
			capitalFinal = new JLabel();
			capitalFinal.setText("");
			capitalFinal.setPreferredSize(new Dimension(100, 15));
			capitalFinal.setFont(new Font("Dialog", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.gridx = 0;
			gridBagConstraints17.anchor = GridBagConstraints.EAST;
			gridBagConstraints17.insets = new Insets(5, 7, 0, 0);
			gridBagConstraints17.gridy = 6;
			jLabel8 = new JLabel();
			jLabel8.setText("Rend. líquido:");
			jLabel8.setFont(new Font("Dialog", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.gridx = 0;
			gridBagConstraints16.anchor = GridBagConstraints.EAST;
			gridBagConstraints16.insets = new Insets(5, 7, 0, 0);
			gridBagConstraints16.gridy = 5;
			jLabel7 = new JLabel();
			jLabel7.setText("Capital final:");
			jLabel7.setFont(new Font("Dialog", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 0;
			gridBagConstraints12.anchor = GridBagConstraints.EAST;
			gridBagConstraints12.insets = new Insets(5, 7, 0, 0);
			gridBagConstraints12.gridy = 8;
			jLabel4 = new JLabel();
			jLabel4.setText("Custos:");
			jLabel4.setFont(new Font("Dialog", Font.PLAIN, 12));
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.setBorder(BorderFactory.createTitledBorder(null, "Resultados", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.PLAIN, 12), new Color(51, 51, 51)));
			jPanel.add(jLabel4, gridBagConstraints12);
			jPanel.add(jLabel7, gridBagConstraints16);
			jPanel.add(jLabel8, gridBagConstraints17);
			jPanel.add(capitalFinal, gridBagConstraints21);
			jPanel.add(custos, gridBagConstraints22);
			jPanel.add(rendimentoLiquido, gridBagConstraints23);
			jPanel.add(jLabel10, gridBagConstraints24);
			jPanel.add(varLiquida, gridBagConstraints25);
			jPanel.add(jLabel5, gridBagConstraints18);
			jPanel.add(rawVar, gridBagConstraints19);
		}
		return jPanel;
	}

	/**
	 * This method initializes capitalInicial	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCapitalInicial() {
		if (capitalInicial == null) {
			capitalInicial = new JTextField();
			capitalInicial.setText("1000");
		}
		return capitalInicial;
	}

	/**
	 * This method initializes invertLines	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getInvertLines() {
		if (invertLines == null) {
			invertLines = new JButton();
			invertLines.setText("Inverter linhas");
			invertLines.setFont(new Font("Dialog", Font.PLAIN, 12));
			invertLines.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//reverse table lines
					DefaultTableModel tm = (DefaultTableModel)dataTable.getModel();
					Vector newRows = new Vector(tm.getDataVector());
					Collections.reverse(newRows);

					//remove old
					while(tm.getRowCount()>0) {
						tm.removeRow(0);
					}
					
					//add new order
					for (Object object : newRows) {
						Vector r = (Vector)object;
						tm.addRow(r);
					}
				}
			});
		}
		return invertLines;
	}
	
	private void showStockGraph() {
		TableModel model = dataTable.getModel();
		float lower = Float.MAX_VALUE;
		
		int minSel = dataTable.getSelectionModel().getMinSelectionIndex();
		int maxSel = dataTable.getSelectionModel().getMaxSelectionIndex();
		if(minSel==-1 
			|| maxSel==-1
			|| (maxSel-minSel)<=1) {
			minSel = 0;
			maxSel = model.getRowCount()-1;
		}

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		int size = (maxSel-minSel);
		int sum = (size/500) + 1;

		//add values
		for(int i=minSel; i<maxSel; i+=sum) {
			
			float value = (Float)model.getValueAt(i, 2);

			//show reference value (value used for decisions)
			Object v = model.getValueAt(i, 5);
			if(v!=null) {
				float refValue = (Float)v;
				dataset.addValue(refValue, "Referência", model.getValueAt(i, 0) + " " + model.getValueAt(i, 1));
			}
			
			//for visual purposes, there is always "Vendido" in background
			dataset.addValue(value, "Vendido", model.getValueAt(i, 0) + " " + model.getValueAt(i, 1));
			
			String o = (String)model.getValueAt(i, 4);
			if(o!=null && !o.startsWith("F")) {
				dataset.addValue(value, "Comprado", model.getValueAt(i, 0) + " " + model.getValueAt(i, 1));
			}
			
			if(value<lower) lower = value;
		}

		JFreeChart chart = ChartFactory.createLineChart("Stocks graph", "Data/Hora", "Valor",
													dataset, PlotOrientation.VERTICAL, true, true, true);

		chart.getCategoryPlot().getRangeAxis().setAutoRange(false);
		chart.getCategoryPlot().getRangeAxis().setLowerBound(lower-Math.abs(lower*0.1));
		
		ChartFrame frame1 = new ChartFrame("Stocks graph", chart);
		StockGrabberTray.centerWindow(frame1);
		frame1.setSize(620, 354);
		frame1.setVisible(true);
	}

	/**
	 * This method initializes openGraph	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getOpenGraph() {
		if (openGraph == null) {
			openGraph = new JButton();
			openGraph.setText("Gráfico");
			openGraph.setFont(new Font("Dialog", Font.PLAIN, 12));
			openGraph.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					showStockGraph();
				}
			});
		}
		return openGraph;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints52 = new GridBagConstraints();
			gridBagConstraints52.fill = GridBagConstraints.BOTH;
			gridBagConstraints52.gridy = 3;
			gridBagConstraints52.weightx = 1.0;
			gridBagConstraints52.weighty = 1.0;
			gridBagConstraints52.gridwidth = 2;
			gridBagConstraints52.gridx = 0;
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.gridx = 0;
			gridBagConstraints41.anchor = GridBagConstraints.WEST;
			gridBagConstraints41.insets = new Insets(0, 15, 0, 0);
			gridBagConstraints41.gridy = 3;
			GridBagConstraints gridBagConstraints210 = new GridBagConstraints();
			gridBagConstraints210.gridx = 0;
			gridBagConstraints210.anchor = GridBagConstraints.WEST;
			gridBagConstraints210.insets = new Insets(0, 15, 0, 0);
			gridBagConstraints210.gridy = 6;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints15.insets = new Insets(5, 0, 5, 5);
			gridBagConstraints15.gridheight = 1;
			gridBagConstraints15.gridwidth = 1;
			gridBagConstraints15.gridx = 1;
			gridBagConstraints15.gridy = 2;
			gridBagConstraints15.weightx = 0.0;
			gridBagConstraints15.weighty = 0.0;
			gridBagConstraints15.fill = GridBagConstraints.HORIZONTAL;
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.anchor = GridBagConstraints.EAST;
			gridBagConstraints14.gridx = 0;
			gridBagConstraints14.gridy = 2;
			gridBagConstraints14.insets = new Insets(5, 5, 5, 4);
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.anchor = GridBagConstraints.WEST;
			gridBagConstraints10.insets = new Insets(5, 0, 0, 5);
			gridBagConstraints10.gridx = 1;
			gridBagConstraints10.gridy = 1;
			gridBagConstraints10.weightx = 0.0;
			gridBagConstraints10.fill = GridBagConstraints.HORIZONTAL;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.anchor = GridBagConstraints.EAST;
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 1;
			gridBagConstraints2.weightx = 0.0;
			gridBagConstraints2.insets = new Insets(5, 5, 0, 4);
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.insets = new Insets(0, 0, 0, 5);
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.anchor = GridBagConstraints.EAST;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 0.0;
			gridBagConstraints.insets = new Insets(0, 5, 0, 4);
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Parâmetros", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.PLAIN, 12), new Color(51, 51, 51)));
			jPanel1.add(jLabel2, gridBagConstraints);
			jPanel1.add(getCustoCompra(), gridBagConstraints1);
			jPanel1.add(jLabel3, gridBagConstraints2);
			jPanel1.add(getCustoVenda(), gridBagConstraints10);
			jPanel1.add(jLabel6, gridBagConstraints14);
			jPanel1.add(getCapitalInicial(), gridBagConstraints15);
			jPanel1.add(getEstrategia(), gridBagConstraints52);
		}
		return jPanel1;
	}

	/**
	 * This method initializes smoothFactor	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getSmoothFactor() {
		if (smoothFactor == null) {
			smoothFactor = new JTextField();
			smoothFactor.setText("5");
			smoothFactor.setFont(new Font("Dialog", Font.PLAIN, 10));
			smoothFactor.setPreferredSize(new Dimension(21, 20));
		}
		return smoothFactor;
	}

	/**
	 * This method initializes mediaMovel	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getMediaMovel() {
		if (mediaMovel == null) {
			mediaMovel = new JRadioButton();
			mediaMovel.setText("média móvel");
			mediaMovel.setFont(new Font("Dialog", Font.PLAIN, 10));
		}
		return mediaMovel;
	}

	/**
	 * This method initializes smooth	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getSmooth() {
		if (smooth == null) {
			smooth = new JRadioButton();
			smooth.setText("regressão");
			smooth.setFont(new Font("Dialog", Font.PLAIN, 10));
		}
		return smooth;
	}

	/**
	 * This method initializes estrategia	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getEstrategia() {
		if (estrategia == null) {
			estrategia = new JTabbedPane();
			estrategia.setFont(new Font("Dialog", Font.PLAIN, 12));
			estrategia.addTab("Inversão", null, getInversao(), null);
		}
		return estrategia;
	}

	/**
	 * This method initializes inversao	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getInversao() {
		if (inversao == null) {
			GridBagConstraints gridBagConstraints28 = new GridBagConstraints();
			gridBagConstraints28.gridx = 0;
			gridBagConstraints28.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints28.anchor = GridBagConstraints.WEST;
			gridBagConstraints28.gridy = 3;
			GridBagConstraints gridBagConstraints27 = new GridBagConstraints();
			gridBagConstraints27.anchor = GridBagConstraints.WEST;
			gridBagConstraints27.insets = new Insets(5, 5, 0, 5);
			gridBagConstraints27.gridheight = 2;
			gridBagConstraints27.gridx = 1;
			gridBagConstraints27.gridy = 2;
			gridBagConstraints27.weightx = 1.0;
			gridBagConstraints27.fill = GridBagConstraints.NONE;
			GridBagConstraints gridBagConstraints26 = new GridBagConstraints();
			gridBagConstraints26.gridx = 0;
			gridBagConstraints26.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints26.anchor = GridBagConstraints.WEST;
			gridBagConstraints26.gridy = 4;
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.anchor = GridBagConstraints.WEST;
			gridBagConstraints20.gridx = 0;
			gridBagConstraints20.gridy = 2;
			gridBagConstraints20.insets = new Insets(5, 5, 0, 0);
			GridBagConstraints gridBagConstraints29 = new GridBagConstraints();
			gridBagConstraints29.anchor = GridBagConstraints.EAST;
			gridBagConstraints29.gridx = 0;
			gridBagConstraints29.gridy = 2;
			gridBagConstraints29.insets = new Insets(5, 5, 0, 0);
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.anchor = GridBagConstraints.WEST;
			gridBagConstraints9.insets = new Insets(5, 5, 0, 5);
			gridBagConstraints9.gridx = 1;
			gridBagConstraints9.gridy = 1;
			gridBagConstraints9.weightx = 1.0;
			gridBagConstraints9.fill = GridBagConstraints.BOTH;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.anchor = GridBagConstraints.EAST;
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.gridy = 1;
			gridBagConstraints8.weightx = 0.0;
			gridBagConstraints8.insets = new Insets(3, 5, 0, 0);
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.anchor = GridBagConstraints.WEST;
			gridBagConstraints7.insets = new Insets(5, 5, 0, 5);
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.gridy = 0;
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.fill = GridBagConstraints.BOTH;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.anchor = GridBagConstraints.EAST;
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridy = 0;
			gridBagConstraints6.weightx = 0.0;
			gridBagConstraints6.insets = new Insets(3, 5, 0, 0);
			inversao = new JPanel();
			inversao.setLayout(new GridBagLayout());
			inversao.add(jLabel, gridBagConstraints6);
			inversao.add(getStartCompra(), gridBagConstraints7);
			inversao.add(jLabel1, gridBagConstraints8);
			inversao.add(getStopVenda(), gridBagConstraints9);
			inversao.add(getMediaMovel(), gridBagConstraints20);
			inversao.add(getDayIntraday(), gridBagConstraints26);
			inversao.add(getSmoothFactor(), gridBagConstraints27);
			inversao.add(getSmooth(), gridBagConstraints28);
		}
		return inversao;
	}

	/**
	 * This method initializes dayIntraday	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getDayIntraday() {
		if (dayIntraday == null) {
			dayIntraday = new JRadioButton();
			dayIntraday.setText("day/intraday");
			dayIntraday.setFont(new Font("Dialog", Font.PLAIN, 10));
		}
		return dayIntraday;
	}

	/**
	 * This method initializes agulhada	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getAgulhada() {
		if (agulhada == null) {
			agulhada = new JPanel();
			agulhada.setLayout(new GridBagLayout());
			agulhada.setSize(new Dimension(139, 132));
		}
		return agulhada;
	}

	public static void main(String[] args) {
		StockSimulator sg = new StockSimulator();
		sg.setVisible(true);
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
