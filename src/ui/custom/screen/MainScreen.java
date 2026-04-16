package ui.custom.screen;

import model.Space;
import service.BoardService;
import service.NotifierService;
import ui.custom.button.FinishGameButton;
import ui.custom.button.ResetButton;
import ui.custom.button.checkGameStatusButton;
import ui.custom.frame.MainFrame;
import ui.custom.input.NumberText;
import ui.custom.painel.MainPainel;
import ui.custom.painel.SudokuSector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static javax.swing.JOptionPane.*;
import static service.EventEnum.CLEAR_SPACE;

public class MainScreen {

    private final static Dimension dimension = new Dimension(600, 600);


    private final BoardService boardService;
    private final NotifierService notifierService;

    private JButton finishGameButton;
    private JButton checkGameStatusButton;
    private JButton resetButton;


    public MainScreen(final Map<String, String>gameConfig) {

        this.boardService = new BoardService(gameConfig);
        this.notifierService = new NotifierService();
    }

    public void buildMainScreen(){
        JPanel mainPainel = new MainPainel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPainel);

        for (int r = 0; r < 9; r+=3) {
            var endRow = r + 2;
            for (int c = 0; c < 9; c += 3) {
                var endCol = c + 2;
                var spaces = getSpacesFromSector(boardService.getSpaces(), c, endCol, r, endRow );
                JPanel sector = generateSection(spaces);
                mainPainel.add(sector);

            }
        }

        addResetButton(mainPainel);
        addCheckGameStatusButton(mainPainel);
        addFinishGameButton(mainPainel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private List<Space> getSpacesFromSector(final List<List<Space>> spaces,
                                            final int initCol, final int endCol,
                                            final int initRow, final int endRow){
        List<Space> spaceSector = new ArrayList<>();
        for (int r = initRow; r <= endRow; r++) {
            for (int c = initCol; c <= endCol; c++){
                spaceSector.add(spaces.get(c).get(r));
            }
        }
        return spaceSector;
    }


    private JPanel generateSection(final List<Space> spaces){
        List<NumberText> fields = new ArrayList<>(spaces.stream().map(NumberText::new).toList());
        fields.forEach(t -> notifierService.subscibe(CLEAR_SPACE, t));
        return new SudokuSector(fields);
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

         checkGameStatusButton = new checkGameStatusButton(e -> {
            var hasErrors = boardService.hasErrors();
            var gameStatus = boardService.getStatus();
            var messege = switch (gameStatus){
                case NON_STARTED -> "O jogo não foi iniciado";
                case INCOMPLETE -> "O jogo está incompleto";
                case COMPLETE -> "O jogo está completo";
            };
            messege += hasErrors ? " e contém erros" : " e não contém erros";
            showMessageDialog(null, messege);
        });
        mainPainel.add(MainScreen.this.checkGameStatusButton);
    }

    private void addResetButton(JPanel mainPainel) {
        resetButton = new ResetButton(e ->{
            var dialogResult = showConfirmDialog(
            null,
                    "Deseja realmente reiniciar o Jogo?",
                    "Limpar o jogo",
                    YES_NO_OPTION,
                    QUESTION_MESSAGE
            );
            if (dialogResult == 0){
                boardService.reset();
                notifierService.notify(CLEAR_SPACE);
            }
        });


        mainPainel.add(resetButton);
    }

}
