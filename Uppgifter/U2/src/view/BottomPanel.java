package view;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {
    private FrameOne frameOne;

    public BottomPanel(FrameOne frameOne){
        this.frameOne = frameOne;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("kan populate denna panelen med olika saker, t.ex spelares tur, om mysterium aktiverats etc"));
    }
}
