/*
 * Copyright 2005 MH-Software-Entwicklung. All rights reserved.
 * Use is subject to license terms.
 */
package com.plaf.hifi;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;

import com.plaf.*;

/**
 * @author Michael Hagen
 */
public class HiFiPanelUI extends BasePanelUI {

    private static HiFiPanelUI panelUI = null;

    public static ComponentUI createUI(JComponent c) {
        if (panelUI == null) {
            panelUI = new HiFiPanelUI();
        }
        return panelUI;
    }

    public void update(Graphics g, JComponent c) {
        if (c.getBackground() instanceof ColorUIResource) {
            if (c.isOpaque()) {
                HiFiUtils.fillComponent(g, c);
            }
        } else {
            super.update(g, c);
        }
    }
}
