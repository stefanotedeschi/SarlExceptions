package it.unito.di.sarlexceptions.examples.atm;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ATMGUI {

    private ATMFrame frame;

    private String amountString;
    private int amountInt;

    public void setup() {
        frame = new ATMFrame();
        frame.setVisible(true);
    }

    void ok(ActionEvent ev) {
        amountString = frame.getText();
    }

    public void enableInput() {
        frame.enableInput();
    }

    public void disableInput() {
        frame.disableInput();
    }

    public void giveMoney() {
        frame.giveMoney(amountInt);
    }

    public void finishWithdraw() {
        frame.finish();
        amountString = "";
        amountInt = 0;
    }

    public void failWithdraw() {
        frame.fail();
    }

    public void closeATM() {
        frame.dispose();
    }

    class ATMFrame extends JFrame {

        private JLabel label;
        private JButton okButton;
        private JTextField text;
        private JLabel status;

        public ATMFrame() {
            setTitle("SARL ATM ");
            setSize(400, 130);
            JPanel panel = new JPanel();
            setContentPane(panel);
            okButton = new JButton("Send");
            okButton.setSize(80, 50);
            text = new JTextField(20);
            text.setEditable(false);
            label = new JLabel("Amount:");
            status = new JLabel("Status: READY FOR NEXT CLIENT");
            okButton.setEnabled(false);
            panel.add(label);
            panel.add(text);
            panel.add(okButton);
            panel.add(status);
        }

        void enableInput() {
            text.setEditable(true);
            text.requestFocusInWindow();
            text.setText("");
            okButton.setEnabled(true);
            status.setText("Status: INSERT AMOUNT");
        }

        void disableInput() {
            text.setEditable(false);
            okButton.setEnabled(false);
            status.setText("Status: PARSING AMOUNT...");
        }

        String getText() {
            return text.getText();
        }

        void giveMoney(int amount) {
            status.setText("Status: PLEASE WITHDRAW " + amount + "\u20ac WITHIN 10 SECONDS");
        }

        void finish() {
            status.setText("Status: WITHDRAWAL COMPLETED");
        }

        void fail() {
            status.setText("Status: TRY LATER");
        }

    }

}
