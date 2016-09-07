package com.stockgrabber;

import java.awt.TrayIcon;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class Recorder {

	private Timer timer;
	private TrayIcon trayIcon;
	private static String user;
	
	public Recorder(TrayIcon trayIcon) {
		this.trayIcon = trayIcon;
	}

	public void start(final List<String> stocks, float period, final String targetDir) {
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				//record each stock
				for (String stock : stocks) {
					try {
						grabStockYahoo(stock, targetDir);
					} catch (Exception e) {
						e.printStackTrace();
						trayIcon.displayMessage("Erro na obtenção do valor das ações", e.getMessage(), TrayIcon.MessageType.ERROR);
					}
				}
			}
		}, 0L, (long)(period*60*1000));
		
		trayIcon.displayMessage("Recording", "Recording " + Configuration.getStocks() + " each " + Configuration.getPeriod() + " minutes", TrayIcon.MessageType.INFO);
		trayIcon.setToolTip("StockGrabber - Recording");
	}
	
	public void stop() {
		if(timer!=null) {
			timer.cancel();
			trayIcon.displayMessage("Stopped recording", "Right click the tray icon and select Simulação para analisar os dados gravados", TrayIcon.MessageType.INFO);
			trayIcon.setToolTip("StockGrabber");
		}
	}

	
	private void grabStockYahoo(String stock, String targetDir) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParseException {
	    // Create a URLConnection object for a URL
        URL url = new URL("http://br.finance.yahoo.com/d/quotes.csv?s="+stock.toUpperCase()+".SA&f=sl1d1t1c1ohgv&e=.csv");
        
        //set proxy if needed
        setupProxy();
        
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        String body;
        
        try {
            body = getString(conn.getInputStream());
        	
        } catch (UnknownHostException e) {
        	String proxy = JOptionPane.showInputDialog("Http proxy server (proxyhost:port):", Configuration.getProxy());
        	Configuration.saveProxy(proxy);
        	setupProxy();
        	
            body = getString(conn.getInputStream());
        }

        System.out.println("Saving stock to disk...");

        //save to disk
		File tDir = new File(targetDir);
		if(!tDir.exists()) {
			tDir.mkdir();
		}
		File file = new File(tDir, stock.toUpperCase() + ".csv");
		FileWriter fw = new FileWriter(file, true);
		try {
			body = body.replaceAll("\"+", "");
			String[] f = body.split(",");
			
			//format time
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern("h:mma");
			Date time = sdf.parse(f[3]);
			sdf.applyPattern("HHmm");
			String t = sdf.format(time);
			
			fw.write(f[2] + "," + t + "," + f[1] + "," + f[8]);
		} finally {
			fw.close();
		}
	}

/*	private void grabStockInertia(String stock, String targetDir) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParseException {
		String url = "http://br.invertia.com/empresas/detalle.aspx?idtel=RV030"+stock.toUpperCase();
		WebClient webClient = new WebClient();
		HtmlPage homePage = (HtmlPage)webClient.getPage(url);
		String body = homePage.getWebResponse().getContentAsString();
		try {
			//get quote (date, time, value, volume)
			String[] quote = getStockQuoteInertia(body);
			
			//save to disk
			File tDir = new File(targetDir);
			if(!tDir.exists()) {
				tDir.mkdir();
			}
			File file = new File(tDir, stock.toUpperCase() + ".csv");
			FileWriter fw = new FileWriter(file, true);
			try {
				//date, time, value, volume
				fw.write("\n" + quote[0] + "," + quote[1] + "," + quote[2] + "," + quote[3]);
			} finally {
				fw.close();
			}
		} catch (NoSuchFieldException e) {
			trayIcon.displayMessage("Erro ao obter preço das ações", e.getMessage(), TrayIcon.MessageType.ERROR);
		}
	}
	public static String[] getStockQuoteInertia(String pageBody) throws NoSuchFieldException {
		String[] result = new String[4];
		
		pageBody = pageBody.replaceAll("&nbsp;", "");
		pageBody = pageBody.replaceAll("\\p{Space}+", " ");
		pageBody = pageBody.replaceAll("\n", "");
		
		//use regex to search for stock price
		Pattern pricePattern = Pattern.compile("<span class=\\\"texto06\\\">[0-9[,.]]*</span>?");
		Matcher m = pricePattern.matcher(pageBody);
		if(m.find()) {
			result[2] = getValue(pageBody.substring(m.start(), m.end()));
			result[2] = result[2].replaceAll(",", ".");
		}
		m.find();
		m.find();
		if(m.find()) {
			result[3] = getValue(pageBody.substring(m.start(), m.end()));
		} else {
			throw new NoSuchFieldException("Stock quote not found in page");
		}
		
		return result;
	}
	private static String getValue(String spanFragment) {
		return spanFragment.substring(22, spanFragment.length()-7);
	}*/
/*	private void grabStockBovespa(String stock, String targetDir) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParseException {
		String url = "http://www.bovespa.com.br/Home/ExecutaAcaoExibirInformacaoAtivo.asp?CodigoAtivo="+stock.toUpperCase();
		WebClient webClient = new WebClient();
		HtmlPage homePage = (HtmlPage)webClient.getPage(url);
		HtmlElement valorDiv = homePage.getHtmlElementById("divPrecoAtivoValor");
		HtmlElement dataMovimentacaoAtivoDiv = homePage.getHtmlElementById("divDataMovimentacaoAtivo");
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		float valor = nf.parse(valorDiv.getFirstChild().asText()).floatValue();
		String dataMovimentacaoAtivo = dataMovimentacaoAtivoDiv.getFirstChild().asText();
		
		//save to disk
		File tDir = new File(targetDir);
		if(!tDir.exists()) {
			tDir.mkdir();
		}
		File file = new File(tDir, stock.toUpperCase() + ".csv");
		FileWriter fw = new FileWriter(file, true);
		DateFormat df = DateFormat.getTimeInstance(DateFormat.SHORT);
		try {
			fw.write("\n" + dataMovimentacaoAtivo + "," + df.format(new Date()) + "," + valor);
		} finally {
			fw.close();
		}
	}
*/

	private void setupProxy() {
        String proxy = Configuration.getProxy();
        if(proxy!=null) {
        	String[] host = proxy.split(":");
        	Properties systemSettings = System.getProperties();
        	systemSettings.put("http.proxyHost", host[0]);
        	systemSettings.put("http.proxyPort", host[1]);
        	System.setProperties(systemSettings);
        	Authenticator.setDefault(new MyAuthenticator());
        } else {
        	Properties systemSettings = System.getProperties();
        	System.setProperties(systemSettings);
        	Authenticator.setDefault(null);
        }
	}
	
    static class MyAuthenticator extends Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            // I haven't checked getRequestingScheme() here, since for NTLM
            // and Negotiate, the usrname and password are all the same.
            String proxy = Configuration.getProxy();
            if(proxy!=null) {
                System.err.println("Feeding username and password for '" + getRequestingHost() + ":" + getRequestingPort() + "'");
                user = JOptionPane.showInputDialog("Proxy user:", user);
                if(user==null) return null;
                String password = JOptionPane.showInputDialog("Proxy password (showed in screen):", null);
                if(password==null) return null;
                
	            return new PasswordAuthentication(user, password.toCharArray());
	            
            } else {
	            return null;
            }
        }
    }        	

	private String getString(InputStream is) throws IOException {
		OutputStream os = new ByteArrayOutputStream();
		readInputStreamIntoOutputStream(is, os);
		return os.toString();
	}
	private static void readInputStreamIntoOutputStream(InputStream is, OutputStream os) throws IOException {
		byte[] buffer = new byte[2048];
		int length = -1;
		while ((length = is.read(buffer))>0) {
			os.write(buffer, 0, length);
		}
	}
	
}
