package ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class checkGameStatusButton extends JButton {

    public checkGameStatusButton(final ActionListener actionListener){
        this.setText("Verificar jogo");
        this.addActionListener(actionListener);
    }

}
