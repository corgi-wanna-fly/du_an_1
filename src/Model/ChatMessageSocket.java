/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.io.*;
import java.net.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 *
 * @author xuant
 */
public class ChatMessageSocket {

    private Socket socket;
    private JTextPane txpMessageBoard;
    private PrintWriter out;
    private BufferedReader reader;

    public ChatMessageSocket(Socket socket, JTextPane txpMessageBoard, boolean type) throws IOException {
        this.socket = socket;
        this.txpMessageBoard = txpMessageBoard;
        out = new PrintWriter(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        receive(type);
    }

    private void receive(boolean type) {
        StyledDocument doc = txpMessageBoard.getStyledDocument();
        Thread th = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String line = reader.readLine();
                        if (line != null) {
//                            doc.insertString(doc.getLength(), "\n" + line, null);
                            appendToPane(txpMessageBoard, line + "\n", (type?Color.blue:Color.red));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        th.start();
    }

    public void send(boolean type, String msg, String name) throws BadLocationException {
//        StyledDocument doc = txpMessageBoard.getStyledDocument();
//        doc.insertString(doc.getLength(), "\n" + name + ": " + msg, null);
        appendToPane(txpMessageBoard, name + ": " + msg + "\n", (type?Color.red:Color.blue));
        out.println(name + ": " + msg);
        out.flush();
    }

    public void close() {
        try {
            out.close();
            reader.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void appendToPane(JTextPane tp, String txt, Color clr) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, clr);
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Serif");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(txt);
    }

}
