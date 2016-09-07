package com.stockgrabber;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StockGrabberTray {

	private static final String LABEL_START = "Start recording";
	private static final String LABEL_STOP = "Stop recording";
	
	private MenuItem startStopItem;
	private StockSettings stockRecorder;
	private StockSimulator stockSimulator;
	private TrayIcon trayIcon;
	
	private boolean recording;
	private Recorder recorder;
	
	public StockGrabberTray() throws AWTException {

		stockSimulator = new StockSimulator();
		stockRecorder = new StockSettings();
		recording = false;

		if (SystemTray.isSupported()) {
			
			SystemTray tray = SystemTray.getSystemTray();
			Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/stockgrabber/media-record.png"));

			//show simulator
			PopupMenu popup = new PopupMenu();
			MenuItem stockItem = new MenuItem("Simulador");
			stockItem.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					stockSimulator.setVisible(true);
				}
			});
			popup.add(stockItem);

			//show recorder config
			MenuItem configItem = new MenuItem("Configurações");
			configItem.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					stockRecorder.setVisible(true);
					stockRecorder.reload();
				}
			});
			popup.add(configItem);
			
			//start/stop
			startStopItem = new MenuItem();
			startStopItem.setLabel(LABEL_START);
			startStopItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					toggleRecord(!recording);
				}
			});
			popup.add(startStopItem);

			//exit
			MenuItem exitItem = new MenuItem("Exit");
			exitItem.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			popup.add(exitItem);
			
			trayIcon = new TrayIcon(image, "StockGrabber", popup);
			trayIcon.setImageAutoSize(true);
			trayIcon.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(e.getButton()==MouseEvent.BUTTON1 && e.getClickCount()>=2) {
						stockSimulator.setVisible(true);
					}
				}
			});
			recorder = new Recorder(trayIcon);

			tray.add(trayIcon);

			//start recording if set so
			toggleRecord(Configuration.getStartRecording());
				
		} else {
			System.err.println("System tray is currently not supported.");
		}
	}

	private void toggleRecord(boolean recordingMode) {
		if(recordingMode) {
			recording = true;
			recorder.start(Configuration.getStocksList(), Configuration.getPeriod(), Configuration.getTargetDir());
			startStopItem.setLabel(LABEL_STOP);
		} else {
			recording = false;
			recorder.stop();
			startStopItem.setLabel(LABEL_START);
		}
	}
	
	/**
	 * @param args
	 *            the command line arguments
	 * @throws AWTException 
	 */
	public static void main(String[] args) throws AWTException {
		StockGrabberTray main = new StockGrabberTray();
	}

	public static void centerWindow(Window frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)((screenSize.width - frame.getWidth())/2), (int)((screenSize.height - frame.getHeight())/2));
	}
}
