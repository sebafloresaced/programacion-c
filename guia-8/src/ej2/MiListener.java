package ej2;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MiListener implements DocumentListener {
    private VentanaBuscaminas ventana;

    public MiListener(VentanaBuscaminas ventana) {
        this.ventana = ventana;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        ventana.validarCampos();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        ventana.validarCampos();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        ventana.validarCampos();
    }
}