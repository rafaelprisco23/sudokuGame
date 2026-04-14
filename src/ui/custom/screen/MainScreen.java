package ui.custom.screen;

import service.BoardService;
import ui.custom.button.FinishGameButton;
import ui.custom.button.ResetButton;
import ui.custom.frame.MainFrame;
import ui.custom.painel.MainPainel;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;

public class MainScreen {

    private final static Dimension dimensio = new Dimension(600, 600);


    private final BoardService boardService;


    private JButton finishGameButton;
    private JButton checkGameStatusButton;
    private JButton resetButton;


    public MainScreen(final Map<String, String>gameConfig) {
        this.boardService = new BoardService(gameConfig);
    }

    public void buildMainScreen(){
        JPanel mainPainel = new MainPainel(dimensio);
        JFrame mainFrame = new MainFrame(dimensio, mainPainel);
        addResetButton(mainPainel);
        addCheckGameStatusButton(mainPainel);
        addFinishGameButton(mainPainel);


        mainFrame.revalidate();
        mainFrame.repaint();


    }

    private void addFinishGameButton(JPanel mainPainel) {
         finishGameButton = new FinishGameButton(e -> {
            if (boardService.gameIsFinished()){
                JOptionPane.showMessageDialog(null, "Parabéns, você concluiu o jogo");
                resetButton.setEnabled(false);
                checkGameStatusButton.setEnabled(false);
                finishGameButton.setEnabled(false);
            } else{
                JOptionPane.showMessageDialog(null, "sEU JOGO TEM ALGUMA INCONSISTENCIA");
            }
        });
        mainPainel.add(MainScreen.this.checkGameStatusButton);

    }

    private void addCheckGameStatusButton(JPanel mainPainel) {

         checkGameStatusButton = new FinishGameButton(e -> {
            var hasErrors = boardService.hasErrors();
            var gameStatus = boardService.getStatus();
            var messege = switch (gameStatus){
                case NON_STARTED -> "O jogo não foi iniciado";
                case INCOMPLETE -> "O jogo está incompleto";
                case COMPLETE -> "O jogo está completo";
            };
            messege += hasErrors ? " e contém erros" : " e não contém erros";
            JOptionPane.showMessageDialog(null, messege);
        });
        mainPainel.add(MainScreen.this.checkGameStatusButton);
    }

    private void addResetButton(JPanel mainPainel) {
        resetButton = new ResetButton(e ->{
            var dialogResult = JOptionPane.showConfirmDialog(
            null,
                    "Deseja realmente reiniciar o Jogo?",
                    "Limpar o jogo",
                    YES_NO_OPTION,
                    QUESTION_MESSAGE
            );
            if (dialogResult == 0){
                boardService.reset();
            }
        });


        mainPainel.add(resetButton);
    }

}
