import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCal {

    private static ViewCal view;
    private static ModelCal model;

    ControllerCal(ViewCal viewCal, ModelCal modelCal) {

        view = viewCal;
        model = modelCal;
        viewCal.setVisible(true);

    }

    static class igualListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String operador;

            try {

                operador = view.getData().getText();

                if (!operador.equalsIgnoreCase("0")) {
                    model.calcular(operador);

                    view.getData().setText(String.valueOf(model.getResult()));
                } else {
                    view.getData().setText(String.valueOf(model.getResult()));
                }

            } catch(NumberFormatException ex) {
                ex.printStackTrace();
            }

        }

    }

    static class ACListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            view.getData().setText("");
            model.borrarMemoria();
        }

    }

    static class PowListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operador = view.getData().getText();

            if (!operador.equalsIgnoreCase("0")) {
                model.potencia2(operador);
                view.getData().setText(String.valueOf(model.getResult()));
            }
        }
    }

    static class PercentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operador = view.getData().getText();

            if (!operador.equalsIgnoreCase("0")) {
                model.porcentaje(operador);
                view.getData().setText(String.valueOf(model.getResult()));
            }
        }
    }


    static class SqrtListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operador = view.getData().getText();

            if (!operador.equalsIgnoreCase("0")) {
                model.raizCuadrada(operador);
                view.getData().setText(String.valueOf(model.getResult()));
            }
        }
    }

    static class OperatorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operador = view.getData().getText();

            if (operador.length() > 0 && !operador.substring(operador.length()-1).contains(e.getActionCommand())) {
                    view.getData().setText(operador + e.getActionCommand());
            }
        }
    }


}
